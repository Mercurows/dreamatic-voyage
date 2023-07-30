package tech.lq0.providencraft.item.providencethird.beni;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.capability.ChaosHelper;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.DamageSourceRegistry;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class LavaCake extends Item {
    private static final Food food = (new Food.Builder()).saturation(0.75f).hunger(20).build();

    public LavaCake() {
        super(new Properties().food(food).maxStackSize(1).group(ModGroup.itemgroup).rarity(Rarity.RARE));
    }

    @Override
    @ParametersAreNonnullByDefault
    @Nonnull
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        ItemStack itemStack = super.onItemUseFinish(stack, worldIn, entityLiving);
        if (entityLiving instanceof PlayerEntity && !worldIn.isRemote) {
            PlayerEntity player = (PlayerEntity) entityLiving;
            ChaosHelper.addChaos(player, 30);

            player.attackEntityFrom(DamageSourceRegistry.BENI_CAKE, 20.0f);
        }
        return itemStack;
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("des.providencraft.lava_cake")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("des.providencraft.lava_cake.warn")).mergeStyle(TextFormatting.RED));
        TooltipTool.addChaosInfo(tooltip, 30);
        TooltipTool.addLiverInfo(tooltip, Livers.BENI);
    }
}
