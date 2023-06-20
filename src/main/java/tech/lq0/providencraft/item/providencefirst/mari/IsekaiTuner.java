package tech.lq0.providencraft.item.providencefirst.mari;

import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.block.tile.MagicMirrorTileEntity;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.BlockRegistry;

import javax.annotation.Nullable;
import java.util.List;

public class IsekaiTuner extends Item {
    private static final String TAG = "isekaiBind";
    private static final String TAG_BIND_X = "x";
    private static final String TAG_BIND_Y = "y";
    private static final String TAG_BIND_Z = "z";
    private static final String TAG_BIND = "bind";

    public IsekaiTuner() {
        super(new Properties().maxStackSize(1).group(ModGroup.itemgroup));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new TranslationTextComponent("des.providencraft.isekai_tuner_1").mergeStyle(TextFormatting.GRAY));
        tooltip.add(new TranslationTextComponent("des.providencraft.isekai_tuner_2").mergeStyle(TextFormatting.GRAY));
        displayPosInfo(stack, tooltip);
    }

    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getPos();
        PlayerEntity playerentity = context.getPlayer();
        ItemStack stack = context.getItem();

        BlockState state = world.getBlockState(pos);

        if(!world.isRemote && state.getBlock() == BlockRegistry.MAGIC_MIRROR_BLOCK.get() && playerentity != null){
            if(playerentity.isSneaking()) {
                stack.getOrCreateChildTag(TAG).putInt(TAG_BIND_X, pos.getX());
                stack.getOrCreateChildTag(TAG).putInt(TAG_BIND_Y, pos.getY());
                stack.getOrCreateChildTag(TAG).putInt(TAG_BIND_Z, pos.getZ());
                stack.getOrCreateChildTag(TAG).putBoolean(TAG_BIND, true);

                return ActionResultType.SUCCESS;
            }else {
                int x = stack.getOrCreateChildTag(TAG).getInt(TAG_BIND_X);
                int y = stack.getOrCreateChildTag(TAG).getInt(TAG_BIND_Y);
                int z = stack.getOrCreateChildTag(TAG).getInt(TAG_BIND_Z);

                if (!stack.getOrCreateChildTag(TAG).getBoolean(TAG_BIND)) {
                    playerentity.sendStatusMessage(new TranslationTextComponent("des.providencraft.isekai_tuner.fail.null")
                            .mergeStyle(TextFormatting.WHITE), true);

                    return ActionResultType.FAIL;
                }

                BlockPos prevPos = new BlockPos(x, y, z);
                if (prevPos.equals(pos)) {
                    playerentity.sendStatusMessage(new TranslationTextComponent("des.providencraft.isekai_tuner.fail.same"), true);
                    return ActionResultType.FAIL;
                }

                MagicMirrorTileEntity tileEntity = (MagicMirrorTileEntity) world.getTileEntity(prevPos);
                if (tileEntity != null) {

                    tileEntity.setTeleportPos(pos);
                    playerentity.sendStatusMessage(new TranslationTextComponent("des.providencraft.isekai_tuner.success",
                            pos.getX(), pos.getY(), pos.getZ()), true);
                    stack.getOrCreateChildTag(TAG).putBoolean(TAG_BIND, false);
                }
            }
        }

        return super.onItemUse(context);
    }

    private static void displayPosInfo(ItemStack stack, List<ITextComponent> tooltip){
        int x = stack.getOrCreateChildTag(TAG).getInt(TAG_BIND_X);
        int y = stack.getOrCreateChildTag(TAG).getInt(TAG_BIND_Y);
        int z = stack.getOrCreateChildTag(TAG).getInt(TAG_BIND_Z);
        boolean flag = stack.getOrCreateChildTag(TAG).getBoolean(TAG_BIND);
        tooltip.add(new StringTextComponent("坐标为:" + x + "," + y + "," + z));
        tooltip.add(new StringTextComponent("是否绑定:" + flag));
    }
}
