package tech.lq0.providencraft.item.providencefourth.hifumi;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.living.LivingHealEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.ItemRegistry;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class UnfaithfulHeart extends Item {
    public UnfaithfulHeart() {
        super(new Properties().group(ModGroup.itemgroup).maxDamage(8).rarity(Rarity.UNCOMMON).defaultMaxDamage(2));
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        TooltipTool.addDevelopingText(tooltip);

        tooltip.add((new TranslationTextComponent("des.providencraft.unfaithful_heart_1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("des.providencraft.unfaithful_heart_2")).mergeStyle(TextFormatting.GRAY));
        TooltipTool.addLiverInfo(tooltip, Livers.HIFUMI);
    }

    @Override
    public int getRGBDurabilityForDisplay(ItemStack stack) {
        return 0x8f4fa5;
    }

    @SubscribeEvent
    public static void unfaithfulHeartHealEvent(LivingHealEvent event) {
        LivingEntity livingEntity = event.getEntityLiving();
        if (livingEntity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) livingEntity;

            if (!player.world.isRemote) {
                PlayerInventory inventory = player.inventory;

                for (ItemStack stack : inventory.mainInventory) {
                    if (stack.getItem() == ItemRegistry.UNFAITHFUL_HEART.get()) {
                        if (stack.getDamage() < stack.getMaxDamage()) {
                            event.setAmount(event.getAmount() * 2);

                            if (!player.abilities.isCreativeMode) {
                                stack.setDamage(stack.getDamage() + 1);
                            }
                            break;
                        }
                    }
                }
            }
        }
    }
}
