/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Lists
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.TextComponentString
 *  net.minecraft.util.text.TextFormatting
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package net.minecraft.client.gui;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(value=Side.CLIENT)
public class GuiUtilRenderComponents {
    public static String removeTextColorsIfConfigured(String text, boolean forceColor) {
        return !forceColor && !Minecraft.getMinecraft().gameSettings.chatColours ? TextFormatting.getTextWithoutFormattingCodes((String)text) : text;
    }

    public static List<ITextComponent> splitText(ITextComponent textComponent, int maxTextLenght, FontRenderer fontRendererIn, boolean p_178908_3_, boolean forceTextColor) {
        int i = 0;
        TextComponentString itextcomponent = new TextComponentString("");
        ArrayList list = Lists.newArrayList();
        ArrayList list1 = Lists.newArrayList((Iterable)textComponent);
        for (int j = 0; j < list1.size(); ++j) {
            String s4;
            ITextComponent itextcomponent1 = (ITextComponent)list1.get(j);
            String s = itextcomponent1.getUnformattedComponentText();
            boolean flag = false;
            if (s.contains("\n")) {
                int k = s.indexOf(10);
                String s1 = s.substring(k + 1);
                s = s.substring(0, k + 1);
                TextComponentString itextcomponent2 = new TextComponentString(s1);
                itextcomponent2.setStyle(itextcomponent1.getStyle().createShallowCopy());
                list1.add(j + 1, itextcomponent2);
                flag = true;
            }
            String s5 = (s4 = GuiUtilRenderComponents.removeTextColorsIfConfigured(itextcomponent1.getStyle().getFormattingCode() + s, forceTextColor)).endsWith("\n") ? s4.substring(0, s4.length() - 1) : s4;
            int i1 = fontRendererIn.getStringWidth(s5);
            TextComponentString textcomponentstring = new TextComponentString(s5);
            textcomponentstring.func_150255_a(itextcomponent1.getStyle().createShallowCopy());
            if (i + i1 > maxTextLenght) {
                String s3;
                String s2 = fontRendererIn.trimStringToWidth(s4, maxTextLenght - i, false);
                String string = s3 = s2.length() < s4.length() ? s4.substring(s2.length()) : null;
                if (s3 != null && !s3.isEmpty()) {
                    int l = s2.lastIndexOf(32);
                    if (l >= 0 && fontRendererIn.getStringWidth(s4.substring(0, l)) > 0) {
                        s2 = s4.substring(0, l);
                        if (p_178908_3_) {
                            ++l;
                        }
                        s3 = s4.substring(l);
                    } else if (i > 0 && !s4.contains(" ")) {
                        s2 = "";
                        s3 = s4;
                    }
                    s3 = FontRenderer.getFormatFromString((String)s2) + s3;
                    TextComponentString textcomponentstring1 = new TextComponentString(s3);
                    textcomponentstring1.func_150255_a(itextcomponent1.getStyle().createShallowCopy());
                    list1.add(j + 1, textcomponentstring1);
                }
                i1 = fontRendererIn.getStringWidth(s2);
                textcomponentstring = new TextComponentString(s2);
                textcomponentstring.func_150255_a(itextcomponent1.getStyle().createShallowCopy());
                flag = true;
            }
            if (i + i1 <= maxTextLenght) {
                i += i1;
                itextcomponent.appendSibling((ITextComponent)textcomponentstring);
            } else {
                flag = true;
            }
            if (!flag) continue;
            list.add(itextcomponent);
            i = 0;
            itextcomponent = new TextComponentString("");
        }
        list.add(itextcomponent);
        return list;
    }
}

