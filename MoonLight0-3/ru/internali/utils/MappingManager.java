/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 */
package ru.internali.utils;

import net.minecraft.client.Minecraft;

public class MappingManager {
    public static /* synthetic */ String fieldModelChanger;
    public static /* synthetic */ String funcOnUpdateWalkingPlayer;
    public static /* synthetic */ String fieldItemRenderer;
    public static /* synthetic */ String fieldRightClickDelayTimer;
    public static /* synthetic */ String fieldPosY;
    public static /* synthetic */ String fieldPosZ;
    public static /* synthetic */ String fieldHitVec;
    public static /* synthetic */ String fieldJumpTicks;
    public static /* synthetic */ String fieldCurrentGameType;
    public static /* synthetic */ String fieldSpeedInAir;
    public static /* synthetic */ String fieldPlayerController;
    public static /* synthetic */ String fieldRotationYaw1;
    public static /* synthetic */ String fieldIsImmuneToFire;
    public static /* synthetic */ String fieldRotationPitch1;
    public static /* synthetic */ String fieldSession;
    public static /* synthetic */ String fieldBlockHitDelay;
    public static /* synthetic */ String fieldPosX;
    public static /* synthetic */ String fieldIsRotating;
    public static /* synthetic */ String fieldTimer;
    public static /* synthetic */ String fieldTickLength;
    public static /* synthetic */ String funcGetPlayerInfo;
    public static /* synthetic */ String fieldRenderItem;
    public static /* synthetic */ String fieldTicksSinceLastSwing;
    public static /* synthetic */ String fieldConnection;
    public static /* synthetic */ String fieldRotationYaw;
    public static /* synthetic */ String fieldPlayerTextures;
    public static /* synthetic */ String fieldIsHittingBlock;
    public static /* synthetic */ String fieldWindowId;
    public static /* synthetic */ String fieldMoving;
    public static /* synthetic */ String fieldItemColors;
    public static /* synthetic */ String fieldIsInWeb;
    public static /* synthetic */ String fieldRotationPitch;
    public static /* synthetic */ String fieldCurrentBlockDamageMP;
    public static /* synthetic */ String fieldOnGround;
    public static /* synthetic */ String fieldFire;

    public MappingManager() {
        MappingManager llllIIlIIllIIIl;
    }

    static {
        fieldSession = MappingManager.isInstanceNotNull() ? "session" : "field_71449_j";
        fieldPosX = MappingManager.isInstanceNotNull() ? "x" : "field_149479_a";
        fieldPosY = MappingManager.isInstanceNotNull() ? "y" : "field_149477_b";
        fieldPosZ = MappingManager.isInstanceNotNull() ? "z" : "field_149478_c";
        fieldMoving = MappingManager.isInstanceNotNull() ? "moving" : "field_149480_h";
        fieldRotationYaw = MappingManager.isInstanceNotNull() ? "yaw" : "field_149476_e";
        fieldRotationPitch = MappingManager.isInstanceNotNull() ? "pitch" : "field_149473_f";
        fieldOnGround = MappingManager.isInstanceNotNull() ? "onGround" : "field_149474_g";
        fieldRotationYaw1 = MappingManager.isInstanceNotNull() ? "yaw" : "field_148936_d";
        fieldRotationPitch1 = MappingManager.isInstanceNotNull() ? "pitch" : "field_148937_e";
        fieldIsRotating = MappingManager.isInstanceNotNull() ? "rotating" : "field_149481_i";
        fieldRightClickDelayTimer = MappingManager.isInstanceNotNull() ? "rightClickDelayTimer" : "field_71467_ac";
        funcGetPlayerInfo = MappingManager.isInstanceNotNull() ? "getPlayerInfo" : "func_175155_b";
        fieldPlayerTextures = MappingManager.isInstanceNotNull() ? "playerTextures" : "field_187107_a";
        fieldCurrentGameType = MappingManager.isInstanceNotNull() ? "currentGameType" : "field_78779_k";
        fieldConnection = MappingManager.isInstanceNotNull() ? "connection" : "field_78774_b";
        fieldBlockHitDelay = MappingManager.isInstanceNotNull() ? "blockHitDelay" : "field_78781_i";
        fieldIsInWeb = MappingManager.isInstanceNotNull() ? "isInWeb" : "field_70134_J";
        fieldCurrentBlockDamageMP = MappingManager.isInstanceNotNull() ? "curBlockDamageMP" : "field_78770_f";
        fieldIsHittingBlock = MappingManager.isInstanceNotNull() ? "isHittingBlock" : "field_78778_j";
        funcOnUpdateWalkingPlayer = MappingManager.isInstanceNotNull() ? "onUpdateWalkingPlayer" : "func_175161_p";
        fieldFire = MappingManager.isInstanceNotNull() ? "fire" : "field_190534_ay";
        fieldIsImmuneToFire = MappingManager.isInstanceNotNull() ? "isImmuneToFire" : "field_70178_ae";
        fieldHitVec = MappingManager.isInstanceNotNull() ? "hitVec" : "field_179713_c";
        fieldPlayerController = MappingManager.isInstanceNotNull() ? "playerController" : "field_71442_b";
        fieldTimer = MappingManager.isInstanceNotNull() ? "timer" : "field_71428_T";
        fieldTickLength = MappingManager.isInstanceNotNull() ? "tickLength" : "field_194149_e";
        fieldWindowId = MappingManager.isInstanceNotNull() ? "windowId" : "field_149556_a";
        fieldTicksSinceLastSwing = MappingManager.isInstanceNotNull() ? "ticksSinceLastSwing" : "field_184617_aD";
        fieldItemColors = MappingManager.isInstanceNotNull() ? "itemColors" : "field_184128_aI";
        fieldModelChanger = MappingManager.isInstanceNotNull() ? "modelManager" : "field_175617_aL";
        fieldRenderItem = MappingManager.isInstanceNotNull() ? "renderItem" : "field_175621_X";
        fieldItemRenderer = MappingManager.isInstanceNotNull() ? "itemRenderer" : "field_73841_b";
        fieldJumpTicks = MappingManager.isInstanceNotNull() ? "jumpTicks" : "field_70773_bE";
        fieldSpeedInAir = MappingManager.isInstanceNotNull() ? "speedInAir" : "field_71102_ce";
    }

    public static boolean isInstanceNotNull() {
        try {
            return Minecraft.class.getDeclaredField("instance") != null;
        }
        catch (Exception llllIIlIIlIlllI) {
            return false;
        }
    }
}

