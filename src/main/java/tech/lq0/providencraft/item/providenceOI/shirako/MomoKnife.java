package tech.lq0.providencraft.item.providenceOI.shirako;

import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import org.jetbrains.annotations.Nullable;
import tech.lq0.providencraft.energy.EscortCapabilityProvider;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import java.util.List;
import java.util.function.Supplier;

public class MomoKnife extends SwordItem {
    private final Supplier<Double> energyCapacity;

//    public static final String TAG_DAMAGE = "damage";
    public static final String TAG_TIME = "time";

    public MomoKnife() {
        super(Tiers.NETHERITE, 1, -1.0f, new Properties().durability(1231).rarity(Rarity.EPIC));

        this.energyCapacity = () -> 0.0;
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.providencraft.momo_knife").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.providencraft.momo_knife.func").withStyle(ChatFormatting.AQUA));
//        showDamage(pStack, pTooltipComponents, pLevel == null ? 0 : pLevel.getGameTime());

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.SHIRAKO);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack stack = pPlayer.getItemInHand(pUsedHand);
//        pPlayer.displayClientMessage(Component.literal(stack.getCapability(CapabilityEnergy.E)));

        return InteractionResultHolder.success(stack);
    }

    @Override
    public @Nullable ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag nbt) {
        return new EscortCapabilityProvider(stack, energyCapacity.get());
    }

    //    @Override
//    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
//        ItemStack stack = playerIn.getHeldItem(handIn);
//        playerIn.heal(getAllDamage(stack, playerIn.world.getGameTime()) * 0.5f);
//        setAllDamage(stack, 0.0f, playerIn.world.getGameTime());
//        return ActionResult.resultSuccess(stack);
//    }

//    private void showDamage(ItemStack stack, List<ITextComponent> tooltip, long time) {
//        float allDamage = getAllDamage(stack, time);
//        NumberFormat numberFormat = NumberFormat.getNumberInstance();
//        numberFormat.setMinimumFractionDigits(1);
//        numberFormat.setMaximumFractionDigits(1);
//        String damage = numberFormat.format(allDamage);
//
//        tooltip.add((new StringTextComponent("")));
//        tooltip.add((new TranslationTextComponent("des.providencraft.momo_knife.damage")).mergeStyle(TextFormatting.WHITE));
//        tooltip.add((new StringTextComponent(damage)).mergeStyle(TextFormatting.GREEN).mergeStyle(TextFormatting.BOLD));
//    }
//
//    @Override
//    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
//        int sharpLevel = EnchantmentHelper.getEnchantmentLevel(Enchantments.SHARPNESS, stack);
//        float maxDamage = 4.0f;
//        if (sharpLevel != 0) {
//            maxDamage = 4.0f + (0.5f * sharpLevel + 0.5f);
//        }
//
//        int random = (int) (Math.random() * (maxDamage * 10)) + 20;
//        float allDamage = getAllDamage(stack, attacker.world.getGameTime());
//        setAllDamage(stack, allDamage + random / 10.0f, attacker.world.getGameTime());
//
//        int lvl = -1;
//        if (target.isPotionActive(EffectRegistry.BLEEDING.get())) {
//            lvl = Objects.requireNonNull(target.getActivePotionEffect(EffectRegistry.BLEEDING.get())).getAmplifier();
//        }
//
//        target.addPotionEffect(new EffectInstance(EffectRegistry.BLEEDING.get(), 120, lvl > 2 ? 3 : lvl + 1));
//        return super.hitEntity(stack, target, attacker);
//    }
//
//    private static float getAllDamage(ItemStack stack, long time) {
//        long lastDamageTime = ItemNBTTool.getLong(stack, TAG_TIME, 9223372036854775807L);
//        float damage = ItemNBTTool.getFloat(stack, TAG_DAMAGE, 0.0f) - (time - lastDamageTime) * 0.1f;
//        if (damage < 0 || time <= lastDamageTime) {
//            damage = 0;
//        }
//        return damage;
//    }
//
//    private static void setAllDamage(ItemStack stack, float num, long time) {
//        ItemNBTTool.setFloat(stack, TAG_DAMAGE, Math.min(num, 100.0f));
//        ItemNBTTool.setLong(stack, TAG_TIME, time);
//    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return slotChanged;
    }
}
