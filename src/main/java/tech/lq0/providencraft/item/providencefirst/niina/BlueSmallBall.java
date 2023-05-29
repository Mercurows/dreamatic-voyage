package tech.lq0.providencraft.item.providencefirst.niina;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.entity.NiitCarEntity;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.EntityRegistry;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class BlueSmallBall extends Item {
    public BlueSmallBall() {
        super(new Properties().group(ModGroup.itemgroup));
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("des.providencraft.blue_small_ball_1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("des.providencraft.blue_small_ball_2")).mergeStyle(TextFormatting.GRAY));
        TooltipTool.addLiverInfo(tooltip, Livers.NIINA);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);

        NiitCarEntity niitCar = new NiitCarEntity(EntityRegistry.NIIT_CAR_ENTITY.get(), worldIn);
        niitCar.setPosition(playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ());
        worldIn.addEntity(niitCar);

        if (!playerIn.isCreative()) {
            stack.shrink(1);
            if (stack.isEmpty()) {
                playerIn.inventory.deleteStack(stack);
            }
        }

        return new ActionResult<>(ActionResultType.SUCCESS, stack);
    }
}
