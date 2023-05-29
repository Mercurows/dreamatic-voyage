package tech.lq0.providencraft.item.providencesecond.louise;

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
import tech.lq0.providencraft.entity.projectile.WhiteAhogeEntity;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class MagicBookThrow extends Item {
    public MagicBookThrow() {
        super(new Properties().group(ModGroup.itemgroup).maxStackSize(1).maxDamage(120));
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("des.providencraft.magic_book_throw_1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("des.providencraft.magic_book_throw_2")).mergeStyle(TextFormatting.GRAY).mergeStyle(TextFormatting.ITALIC));
        TooltipTool.addLiverInfo(tooltip, Livers.LOUISE);
    }

    @Override
    @ParametersAreNonnullByDefault
    @Nonnull
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack item = playerIn.getHeldItem(handIn);
        if (!worldIn.isRemote()) {
            WhiteAhogeEntity whiteAhogeEntity1 = new WhiteAhogeEntity(worldIn, playerIn);
            WhiteAhogeEntity whiteAhogeEntity2 = new WhiteAhogeEntity(worldIn, playerIn);
            whiteAhogeEntity1.func_234612_a_(playerIn, playerIn.rotationPitch, playerIn.rotationYaw - 6.14f, 0.0f, 4.0f, 0f);
            whiteAhogeEntity2.func_234612_a_(playerIn, playerIn.rotationPitch, playerIn.rotationYaw + 6.14f, 0.0f, 4.0f, 0f);
            worldIn.addEntity(whiteAhogeEntity1);
            worldIn.addEntity(whiteAhogeEntity2);
            item.damageItem(1, playerIn, (playerEntity) -> playerEntity.sendBreakAnimation(handIn));
            playerIn.getCooldownTracker().setCooldown(item.getItem(), 30);
        }

        return new ActionResult<>(ActionResultType.SUCCESS, item);
    }
}
