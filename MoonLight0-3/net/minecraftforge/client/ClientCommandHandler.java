/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiChat
 *  net.minecraft.command.CommandException
 *  net.minecraft.command.CommandHandler
 *  net.minecraft.command.ICommand
 *  net.minecraft.command.ICommandSender
 *  net.minecraft.command.WrongUsageException
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.TextComponentTranslation
 *  net.minecraft.util.text.TextFormatting
 *  net.minecraftforge.client.IClientCommand
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.event.CommandEvent
 *  net.minecraftforge.fml.client.FMLClientHandler
 *  net.minecraftforge.fml.common.FMLLog
 *  net.minecraftforge.fml.common.eventhandler.Event
 */
package net.minecraftforge.client;

import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.command.CommandException;
import net.minecraft.command.CommandHandler;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.IClientCommand;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CommandEvent;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.eventhandler.Event;

public class ClientCommandHandler
extends CommandHandler {
    public static final ClientCommandHandler instance = new ClientCommandHandler();
    public String[] latestAutoComplete = null;

    public int executeCommand(ICommandSender sender, String message) {
        boolean usedSlash = (message = message.trim()).startsWith("/");
        if (usedSlash) {
            message = message.substring(1);
        }
        String[] temp = message.split(" ");
        String[] args = new String[temp.length - 1];
        String commandName = temp[0];
        System.arraycopy(temp, 1, args, 0, args.length);
        ICommand icommand = (ICommand)this.getCommands().get(commandName);
        try {
            if (icommand == null || !usedSlash && icommand instanceof IClientCommand && !((IClientCommand)icommand).allowUsageWithoutPrefix(sender, message)) {
                return 0;
            }
            if (icommand.checkPermission(this.getServer(), sender)) {
                CommandEvent event = new CommandEvent(icommand, sender, args);
                if (MinecraftForge.EVENT_BUS.post((Event)event)) {
                    if (event.getException() != null) {
                        throw event.getException();
                    }
                    return 0;
                }
                this.tryExecute(sender, args, icommand, message);
                return 1;
            }
            sender.sendMessage((ITextComponent)this.format(TextFormatting.RED, "commands.generic.permission", new Object[0]));
        }
        catch (WrongUsageException wue) {
            sender.sendMessage((ITextComponent)this.format(TextFormatting.RED, "commands.generic.usage", new Object[]{this.format(TextFormatting.RED, wue.getMessage(), wue.func_74844_a())}));
        }
        catch (CommandException ce) {
            sender.sendMessage((ITextComponent)this.format(TextFormatting.RED, ce.getMessage(), ce.getErrorObjects()));
        }
        catch (Throwable t) {
            sender.sendMessage((ITextComponent)this.format(TextFormatting.RED, "commands.generic.exception", new Object[0]));
            FMLLog.log.error("Command '{}' threw an exception:", (Object)message, (Object)t);
        }
        return -1;
    }

    private TextComponentTranslation format(TextFormatting color2, String str, Object ... args) {
        TextComponentTranslation ret = new TextComponentTranslation(str, args);
        ret.func_150256_b().setColor(color2);
        return ret;
    }

    public void autoComplete(String leftOfCursor) {
        this.latestAutoComplete = null;
        if (leftOfCursor.charAt(0) == '/') {
            List commands;
            leftOfCursor = leftOfCursor.substring(1);
            Minecraft mc = FMLClientHandler.instance().getClient();
            if (mc.currentScreen instanceof GuiChat && !(commands = this.getTabCompletions((ICommandSender)mc.player, leftOfCursor, mc.player.getPosition())).isEmpty()) {
                if (leftOfCursor.indexOf(32) == -1) {
                    for (int i = 0; i < commands.size(); ++i) {
                        commands.set(i, (Object)TextFormatting.GRAY + "/" + (String)commands.get(i) + (Object)TextFormatting.RESET);
                    }
                } else {
                    for (int i = 0; i < commands.size(); ++i) {
                        commands.set(i, (Object)TextFormatting.GRAY + (String)commands.get(i) + (Object)TextFormatting.RESET);
                    }
                }
                this.latestAutoComplete = commands.toArray(new String[commands.size()]);
            }
        }
    }

    protected MinecraftServer getServer() {
        return Minecraft.getMinecraft().getIntegratedServer();
    }
}

