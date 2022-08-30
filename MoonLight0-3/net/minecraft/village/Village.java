/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Lists
 *  com.google.common.collect.Maps
 *  com.mojang.authlib.GameProfile
 *  javax.annotation.Nullable
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockDoor
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.monster.EntityIronGolem
 *  net.minecraft.entity.passive.EntityVillager
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.nbt.NBTBase
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.nbt.NBTTagList
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.village.Village$VillageAggressor
 *  net.minecraft.village.VillageDoorInfo
 *  net.minecraft.world.IBlockAccess
 *  net.minecraft.world.World
 *  net.minecraftforge.common.capabilities.Capability
 *  net.minecraftforge.common.capabilities.CapabilityDispatcher
 *  net.minecraftforge.common.capabilities.ICapabilitySerializable
 *  net.minecraftforge.event.ForgeEventFactory
 */
package net.minecraft.village;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mojang.authlib.GameProfile;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.village.Village;
import net.minecraft.village.VillageDoorInfo;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityDispatcher;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.event.ForgeEventFactory;

public class Village
implements ICapabilitySerializable<NBTTagCompound> {
    private World world;
    private final List<VillageDoorInfo> villageDoorInfoList = Lists.newArrayList();
    private BlockPos centerHelper = BlockPos.ORIGIN;
    private BlockPos center = BlockPos.ORIGIN;
    private int villageRadius;
    private int lastAddDoorTimestamp;
    private int tickCounter;
    private int numVillagers;
    private int noBreedTicks;
    private final Map<UUID, Integer> playerReputation = Maps.newHashMap();
    private final List<VillageAggressor> villageAgressors = Lists.newArrayList();
    private int numIronGolems;
    private CapabilityDispatcher capabilities;

    public Village() {
        this.capabilities = ForgeEventFactory.gatherCapabilities((Village)this);
    }

    public Village(World worldIn) {
        this.world = worldIn;
        this.capabilities = ForgeEventFactory.gatherCapabilities((Village)this);
    }

    public void setWorld(World worldIn) {
        this.world = worldIn;
    }

    public void tick(int tickCounterIn) {
        Vec3d vec3d;
        int i;
        this.tickCounter = tickCounterIn;
        this.removeDeadAndOutOfRangeDoors();
        this.removeDeadAndOldAgressors();
        if (tickCounterIn % 20 == 0) {
            this.updateNumVillagers();
        }
        if (tickCounterIn % 30 == 0) {
            this.updateNumIronGolems();
        }
        if (this.numIronGolems < (i = this.numVillagers / 10) && this.villageDoorInfoList.size() > 20 && this.world.rand.nextInt(7000) == 0 && (vec3d = this.findRandomSpawnPos(this.center, 2, 4, 2)) != null) {
            EntityIronGolem entityirongolem = new EntityIronGolem(this.world);
            entityirongolem.func_70107_b(vec3d.x, vec3d.y, vec3d.z);
            this.world.spawnEntity((Entity)entityirongolem);
            ++this.numIronGolems;
        }
    }

    private Vec3d findRandomSpawnPos(BlockPos pos, int x, int y, int z) {
        for (int i = 0; i < 10; ++i) {
            BlockPos blockpos = pos.add(this.world.rand.nextInt(16) - 8, this.world.rand.nextInt(6) - 3, this.world.rand.nextInt(16) - 8);
            if (!this.isBlockPosWithinSqVillageRadius(blockpos) || !this.isAreaClearAround(new BlockPos(x, y, z), blockpos)) continue;
            return new Vec3d((double)blockpos.func_177958_n(), (double)blockpos.func_177956_o(), (double)blockpos.func_177952_p());
        }
        return null;
    }

    private boolean isAreaClearAround(BlockPos blockSize, BlockPos blockLocation) {
        if (!this.world.getBlockState(blockLocation.down()).func_185896_q()) {
            return false;
        }
        int i = blockLocation.func_177958_n() - blockSize.func_177958_n() / 2;
        int j = blockLocation.func_177952_p() - blockSize.func_177952_p() / 2;
        for (int k = i; k < i + blockSize.func_177958_n(); ++k) {
            for (int l = blockLocation.func_177956_o(); l < blockLocation.func_177956_o() + blockSize.func_177956_o(); ++l) {
                for (int i1 = j; i1 < j + blockSize.func_177952_p(); ++i1) {
                    if (!this.world.getBlockState(new BlockPos(k, l, i1)).func_185915_l()) continue;
                    return false;
                }
            }
        }
        return true;
    }

    private void updateNumIronGolems() {
        List list = this.world.getEntitiesWithinAABB(EntityIronGolem.class, new AxisAlignedBB((double)(this.center.func_177958_n() - this.villageRadius), (double)(this.center.func_177956_o() - 4), (double)(this.center.func_177952_p() - this.villageRadius), (double)(this.center.func_177958_n() + this.villageRadius), (double)(this.center.func_177956_o() + 4), (double)(this.center.func_177952_p() + this.villageRadius)));
        this.numIronGolems = list.size();
    }

    private void updateNumVillagers() {
        List list = this.world.getEntitiesWithinAABB(EntityVillager.class, new AxisAlignedBB((double)(this.center.func_177958_n() - this.villageRadius), (double)(this.center.func_177956_o() - 4), (double)(this.center.func_177952_p() - this.villageRadius), (double)(this.center.func_177958_n() + this.villageRadius), (double)(this.center.func_177956_o() + 4), (double)(this.center.func_177952_p() + this.villageRadius)));
        this.numVillagers = list.size();
        if (this.numVillagers == 0) {
            this.playerReputation.clear();
        }
    }

    public BlockPos getCenter() {
        return this.center;
    }

    public int getVillageRadius() {
        return this.villageRadius;
    }

    public int getNumVillageDoors() {
        return this.villageDoorInfoList.size();
    }

    public int getTicksSinceLastDoorAdding() {
        return this.tickCounter - this.lastAddDoorTimestamp;
    }

    public int getNumVillagers() {
        return this.numVillagers;
    }

    public boolean isBlockPosWithinSqVillageRadius(BlockPos pos) {
        return this.center.func_177951_i((Vec3i)pos) < (double)(this.villageRadius * this.villageRadius);
    }

    public List<VillageDoorInfo> getVillageDoorInfoList() {
        return this.villageDoorInfoList;
    }

    public VillageDoorInfo getNearestDoor(BlockPos pos) {
        VillageDoorInfo villagedoorinfo = null;
        int i = Integer.MAX_VALUE;
        for (VillageDoorInfo villagedoorinfo1 : this.villageDoorInfoList) {
            int j = villagedoorinfo1.getDistanceToDoorBlockSq(pos);
            if (j >= i) continue;
            villagedoorinfo = villagedoorinfo1;
            i = j;
        }
        return villagedoorinfo;
    }

    public VillageDoorInfo getDoorInfo(BlockPos pos) {
        VillageDoorInfo villagedoorinfo = null;
        int i = Integer.MAX_VALUE;
        for (VillageDoorInfo villagedoorinfo1 : this.villageDoorInfoList) {
            EnumFacing enumfacing;
            BlockPos blockpos;
            int j = villagedoorinfo1.getDistanceToDoorBlockSq(pos);
            j = j > 256 ? (j *= 1000) : villagedoorinfo1.getDoorOpeningRestrictionCounter();
            if (j >= i || !this.world.getBlockState((blockpos = villagedoorinfo1.getDoorBlockPos()).offset(enumfacing = villagedoorinfo1.getInsideDirection(), 1)).getBlock().isPassable((IBlockAccess)this.world, blockpos.offset(enumfacing, 1)) || !this.world.getBlockState(blockpos.offset(enumfacing, -1)).getBlock().isPassable((IBlockAccess)this.world, blockpos.offset(enumfacing, -1)) || !this.world.getBlockState(blockpos.up().offset(enumfacing, 1)).getBlock().isPassable((IBlockAccess)this.world, blockpos.up().offset(enumfacing, 1)) || !this.world.getBlockState(blockpos.up().offset(enumfacing, -1)).getBlock().isPassable((IBlockAccess)this.world, blockpos.up().offset(enumfacing, -1))) continue;
            villagedoorinfo = villagedoorinfo1;
            i = j;
        }
        return villagedoorinfo;
    }

    @Nullable
    public VillageDoorInfo getExistedDoor(BlockPos doorBlock) {
        if (this.center.func_177951_i((Vec3i)doorBlock) > (double)(this.villageRadius * this.villageRadius)) {
            return null;
        }
        for (VillageDoorInfo villagedoorinfo : this.villageDoorInfoList) {
            if (villagedoorinfo.getDoorBlockPos().func_177958_n() != doorBlock.func_177958_n() || villagedoorinfo.getDoorBlockPos().func_177952_p() != doorBlock.func_177952_p() || Math.abs(villagedoorinfo.getDoorBlockPos().func_177956_o() - doorBlock.func_177956_o()) > 1) continue;
            return villagedoorinfo;
        }
        return null;
    }

    public void addVillageDoorInfo(VillageDoorInfo doorInfo) {
        this.villageDoorInfoList.add(doorInfo);
        this.centerHelper = this.centerHelper.add((Vec3i)doorInfo.getDoorBlockPos());
        this.updateVillageRadiusAndCenter();
        this.lastAddDoorTimestamp = doorInfo.getLastActivityTimestamp();
    }

    public boolean isAnnihilated() {
        return this.villageDoorInfoList.isEmpty();
    }

    public void addOrRenewAgressor(EntityLivingBase entitylivingbaseIn) {
        for (VillageAggressor village$villageaggressor : this.villageAgressors) {
            if (village$villageaggressor.agressor != entitylivingbaseIn) continue;
            village$villageaggressor.agressionTime = this.tickCounter;
            return;
        }
        this.villageAgressors.add(new VillageAggressor(this, entitylivingbaseIn, this.tickCounter));
    }

    @Nullable
    public EntityLivingBase findNearestVillageAggressor(EntityLivingBase entitylivingbaseIn) {
        double d0 = Double.MAX_VALUE;
        VillageAggressor village$villageaggressor = null;
        for (int i = 0; i < this.villageAgressors.size(); ++i) {
            VillageAggressor village$villageaggressor1 = this.villageAgressors.get(i);
            double d1 = village$villageaggressor1.agressor.func_70068_e((Entity)entitylivingbaseIn);
            if (!(d1 <= d0)) continue;
            village$villageaggressor = village$villageaggressor1;
            d0 = d1;
        }
        return village$villageaggressor == null ? null : village$villageaggressor.agressor;
    }

    public EntityPlayer getNearestTargetPlayer(EntityLivingBase villageDefender) {
        double d0 = Double.MAX_VALUE;
        EntityPlayer entityplayer = null;
        for (UUID s : this.playerReputation.keySet()) {
            double d1;
            EntityPlayer entityplayer1;
            if (!this.isPlayerReputationTooLow(s) || (entityplayer1 = this.world.getPlayerEntityByUUID(s)) == null || !((d1 = entityplayer1.func_70068_e((Entity)villageDefender)) <= d0)) continue;
            entityplayer = entityplayer1;
            d0 = d1;
        }
        return entityplayer;
    }

    private void removeDeadAndOldAgressors() {
        Iterator<VillageAggressor> iterator = this.villageAgressors.iterator();
        while (iterator.hasNext()) {
            VillageAggressor village$villageaggressor = iterator.next();
            if (village$villageaggressor.agressor.isEntityAlive() && Math.abs(this.tickCounter - village$villageaggressor.agressionTime) <= 300) continue;
            iterator.remove();
        }
    }

    private void removeDeadAndOutOfRangeDoors() {
        boolean flag = false;
        boolean flag1 = this.world.rand.nextInt(50) == 0;
        Iterator<VillageDoorInfo> iterator = this.villageDoorInfoList.iterator();
        while (iterator.hasNext()) {
            VillageDoorInfo villagedoorinfo = iterator.next();
            if (flag1) {
                villagedoorinfo.resetDoorOpeningRestrictionCounter();
            }
            if (!this.world.isBlockLoaded(villagedoorinfo.getDoorBlockPos()) || this.isWoodDoor(villagedoorinfo.getDoorBlockPos()) && Math.abs(this.tickCounter - villagedoorinfo.getLastActivityTimestamp()) <= 1200) continue;
            this.centerHelper = this.centerHelper.subtract((Vec3i)villagedoorinfo.getDoorBlockPos());
            flag = true;
            villagedoorinfo.setIsDetachedFromVillageFlag(true);
            iterator.remove();
        }
        if (flag) {
            this.updateVillageRadiusAndCenter();
        }
    }

    private boolean isWoodDoor(BlockPos pos) {
        IBlockState iblockstate = this.world.getBlockState(pos);
        Block block = iblockstate.getBlock();
        if (block instanceof BlockDoor) {
            return iblockstate.func_185904_a() == Material.WOOD;
        }
        return false;
    }

    private void updateVillageRadiusAndCenter() {
        int i = this.villageDoorInfoList.size();
        if (i == 0) {
            this.center = BlockPos.ORIGIN;
            this.villageRadius = 0;
        } else {
            this.center = new BlockPos(this.centerHelper.func_177958_n() / i, this.centerHelper.func_177956_o() / i, this.centerHelper.func_177952_p() / i);
            int j = 0;
            for (VillageDoorInfo villagedoorinfo : this.villageDoorInfoList) {
                j = Math.max(villagedoorinfo.getDistanceToDoorBlockSq(this.center), j);
            }
            this.villageRadius = Math.max(32, (int)Math.sqrt(j) + 1);
        }
    }

    @Deprecated
    public int getPlayerReputation(String playerName) {
        return this.getPlayerReputation(this.findUUID(playerName));
    }

    public int getPlayerReputation(UUID playerName) {
        Integer integer = this.playerReputation.get(playerName);
        return integer == null ? 0 : integer;
    }

    private UUID findUUID(String name) {
        if (this.world == null || this.world.getMinecraftServer() == null) {
            return EntityPlayer.getOfflineUUID((String)name);
        }
        GameProfile profile = this.world.getMinecraftServer().getPlayerProfileCache().getGameProfileForUsername(name);
        return profile == null ? EntityPlayer.getOfflineUUID((String)name) : profile.getId();
    }

    @Deprecated
    public int modifyPlayerReputation(String playerName, int reputation) {
        return this.modifyPlayerReputation(this.findUUID(playerName), reputation);
    }

    public int modifyPlayerReputation(UUID playerName, int reputation) {
        int i = this.getPlayerReputation(playerName);
        int j = MathHelper.clamp((int)(i + reputation), (int)-30, (int)10);
        this.playerReputation.put(playerName, j);
        return j;
    }

    @Deprecated
    public boolean isPlayerReputationTooLow(String playerName) {
        return this.isPlayerReputationTooLow(this.findUUID(playerName));
    }

    public boolean isPlayerReputationTooLow(UUID uuid) {
        return this.getPlayerReputation(uuid) <= -15;
    }

    public void readVillageDataFromNBT(NBTTagCompound compound) {
        this.numVillagers = compound.getInteger("PopSize");
        this.villageRadius = compound.getInteger("Radius");
        this.numIronGolems = compound.getInteger("Golems");
        this.lastAddDoorTimestamp = compound.getInteger("Stable");
        this.tickCounter = compound.getInteger("Tick");
        this.noBreedTicks = compound.getInteger("MTick");
        this.center = new BlockPos(compound.getInteger("CX"), compound.getInteger("CY"), compound.getInteger("CZ"));
        this.centerHelper = new BlockPos(compound.getInteger("ACX"), compound.getInteger("ACY"), compound.getInteger("ACZ"));
        NBTTagList nbttaglist = compound.getTagList("Doors", 10);
        for (int i = 0; i < nbttaglist.tagCount(); ++i) {
            NBTTagCompound nbttagcompound = nbttaglist.getCompoundTagAt(i);
            VillageDoorInfo villagedoorinfo = new VillageDoorInfo(new BlockPos(nbttagcompound.getInteger("X"), nbttagcompound.getInteger("Y"), nbttagcompound.getInteger("Z")), nbttagcompound.getInteger("IDX"), nbttagcompound.getInteger("IDZ"), nbttagcompound.getInteger("TS"));
            this.villageDoorInfoList.add(villagedoorinfo);
        }
        NBTTagList nbttaglist1 = compound.getTagList("Players", 10);
        for (int j = 0; j < nbttaglist1.tagCount(); ++j) {
            NBTTagCompound nbttagcompound1 = nbttaglist1.getCompoundTagAt(j);
            if (nbttagcompound1.hasKey("UUID")) {
                this.playerReputation.put(UUID.fromString(nbttagcompound1.getString("UUID")), nbttagcompound1.getInteger("S"));
                continue;
            }
            this.playerReputation.put(this.findUUID(nbttagcompound1.getString("Name")), nbttagcompound1.getInteger("S"));
        }
        if (this.capabilities != null && compound.hasKey("ForgeCaps")) {
            this.capabilities.deserializeNBT(compound.getCompoundTag("ForgeCaps"));
        }
    }

    public void writeVillageDataToNBT(NBTTagCompound compound) {
        compound.setInteger("PopSize", this.numVillagers);
        compound.setInteger("Radius", this.villageRadius);
        compound.setInteger("Golems", this.numIronGolems);
        compound.setInteger("Stable", this.lastAddDoorTimestamp);
        compound.setInteger("Tick", this.tickCounter);
        compound.setInteger("MTick", this.noBreedTicks);
        compound.setInteger("CX", this.center.func_177958_n());
        compound.setInteger("CY", this.center.func_177956_o());
        compound.setInteger("CZ", this.center.func_177952_p());
        compound.setInteger("ACX", this.centerHelper.func_177958_n());
        compound.setInteger("ACY", this.centerHelper.func_177956_o());
        compound.setInteger("ACZ", this.centerHelper.func_177952_p());
        NBTTagList nbttaglist = new NBTTagList();
        for (VillageDoorInfo villagedoorinfo : this.villageDoorInfoList) {
            NBTTagCompound nbttagcompound = new NBTTagCompound();
            nbttagcompound.setInteger("X", villagedoorinfo.getDoorBlockPos().func_177958_n());
            nbttagcompound.setInteger("Y", villagedoorinfo.getDoorBlockPos().func_177956_o());
            nbttagcompound.setInteger("Z", villagedoorinfo.getDoorBlockPos().func_177952_p());
            nbttagcompound.setInteger("IDX", villagedoorinfo.getInsideOffsetX());
            nbttagcompound.setInteger("IDZ", villagedoorinfo.getInsideOffsetZ());
            nbttagcompound.setInteger("TS", villagedoorinfo.getLastActivityTimestamp());
            nbttaglist.appendTag((NBTBase)nbttagcompound);
        }
        compound.setTag("Doors", (NBTBase)nbttaglist);
        NBTTagList nbttaglist1 = new NBTTagList();
        for (UUID s : this.playerReputation.keySet()) {
            NBTTagCompound nbttagcompound1 = new NBTTagCompound();
            try {
                nbttagcompound1.setString("UUID", s.toString());
                nbttagcompound1.setInteger("S", this.playerReputation.get(s).intValue());
                nbttaglist1.appendTag((NBTBase)nbttagcompound1);
            }
            catch (RuntimeException runtimeException) {}
        }
        compound.setTag("Players", (NBTBase)nbttaglist1);
        if (this.capabilities != null) {
            compound.setTag("ForgeCaps", (NBTBase)this.capabilities.serializeNBT());
        }
    }

    public void endMatingSeason() {
        this.noBreedTicks = this.tickCounter;
    }

    public boolean isMatingSeason() {
        return this.noBreedTicks == 0 || this.tickCounter - this.noBreedTicks >= 3600;
    }

    public void setDefaultPlayerReputation(int defaultReputation) {
        for (UUID s : this.playerReputation.keySet()) {
            this.modifyPlayerReputation(s, defaultReputation);
        }
    }

    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
        return this.capabilities == null ? false : this.capabilities.hasCapability(capability, facing);
    }

    @Nullable
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
        return (T)(this.capabilities == null ? null : this.capabilities.getCapability(capability, facing));
    }

    public void deserializeNBT(NBTTagCompound nbt) {
        this.readVillageDataFromNBT(nbt);
    }

    public NBTTagCompound serializeNBT() {
        NBTTagCompound ret = new NBTTagCompound();
        this.writeVillageDataToNBT(ret);
        return ret;
    }
}

