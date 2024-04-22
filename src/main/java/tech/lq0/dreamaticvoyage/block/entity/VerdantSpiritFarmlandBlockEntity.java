package tech.lq0.dreamaticvoyage.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.TallFlowerBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ForgeHooks;
import tech.lq0.dreamaticvoyage.init.BlockEntityRegistry;

import javax.annotation.Nullable;

public class VerdantSpiritFarmlandBlockEntity extends BlockEntity {
    private static final String TAG_TIME = "time";
    Double time = 0.0;

    public VerdantSpiritFarmlandBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(BlockEntityRegistry.VERDANT_SPIRIT_FARMLAND_BLOCK_ENTITY.get(), pPos, pBlockState);
    }

    @SuppressWarnings("unused")
    public static void tick(Level level, BlockPos pos, BlockState state, VerdantSpiritFarmlandBlockEntity self) {

        if (self.time < 400) {
            self.time += level.getGameRules().getRule(GameRules.RULE_RANDOMTICKING).get() / 3.0;
        } else {
            BlockState aboveState = level.getBlockState(pos.above());
            Block aboveBlock = aboveState.getBlock();

            if (aboveBlock instanceof TallFlowerBlock) {
                return;
            }

            if (aboveBlock instanceof BonemealableBlock growable) {
                if (growable.isValidBonemealTarget(level, pos.above(), aboveState, false) && ForgeHooks.onCropsGrowPre(level, pos.above(), aboveState, true)) {
                    if (!level.isClientSide) {
                        growable.performBonemeal((ServerLevel) level, level.random, pos.above(), aboveState);
                        level.levelEvent(2005, pos.above(), 0);
                    }
                    ForgeHooks.onCropsGrowPost(level, pos.above(), aboveState);
                }
            }
            self.time = 0.0;
        }
    }

    @Override
    public void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putDouble(TAG_TIME, time);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        time = pTag.getDouble(TAG_TIME);
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }
}
