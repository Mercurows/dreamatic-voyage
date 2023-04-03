package tech.lq0.providencraft.item.providencesecond.louise;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.EffectRegistry;
import tech.lq0.providencraft.init.SoundRegistry;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class MagicBookMyannaPlus extends Item {
    public MagicBookMyannaPlus() {
        super(new Properties().group(ModGroup.itemgroup).maxStackSize(1).isImmuneToFire().rarity(Rarity.EPIC));
    }

    @Override
    @Nonnull
    @ParametersAreNonnullByDefault
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        ItemStack heldItem = player.getHeldItem(hand);
        if (!world.isRemote) {
            player.addPotionEffect(new EffectInstance(EffectRegistry.BLESS_OF_DARK_ELF.get(), 600, 4));
            player.addPotionEffect(new EffectInstance(Effects.REGENERATION, 600, 2));
            player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 600, 2));

            int random = (int) (Math.random() * 10 + 1);
            if (random <= 3) {
                player.addPotionEffect(new EffectInstance(EffectRegistry.CURSE_OF_SERPENT.get(), 600, 2));
                player.sendStatusMessage(new TranslationTextComponent("be_cursed").mergeStyle(TextFormatting.RED), true);
            }
        }

        player.getCooldownTracker().setCooldown(heldItem.getItem(), 3600);
        world.playSound(player, player.getPosition(),
                SoundRegistry.MYANNA.get(), SoundCategory.AMBIENT, 0.8f, 1.1f);

        return new ActionResult<>(ActionResultType.SUCCESS, heldItem);
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("des.providencraft.magic_book_myanna_plus.func")).mergeStyle(TextFormatting.AQUA));
        tooltip.add((new TranslationTextComponent("des.providencraft.magic_book_myanna_plus")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("des.providencraft.magic_book_myanna_plus.warn")).mergeStyle(TextFormatting.RED));
        TooltipTool.addLiverInfo(tooltip, Livers.LOUISE);
    }
}
