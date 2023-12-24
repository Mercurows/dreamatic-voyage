package tech.lq0.providencraft.item.legacy;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.monster.Guardian;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.init.ItemRegistry;
import tech.lq0.providencraft.init.SoundRegistry;
import tech.lq0.providencraft.tools.ItemNBTTool;
import tech.lq0.providencraft.tools.RarityTool;
import tech.lq0.providencraft.tools.TooltipTool;

import java.util.List;
import java.util.UUID;

public class ShuraChin extends Item {
    public static final String TAG_INVOKE = "invoke";

    public ShuraChin() {
        super(new Properties().rarity(RarityTool.LEGACY).setNoRepair().durability(1442));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack stack = pPlayer.getItemInHand(pUsedHand);
        if (pUsedHand == InteractionHand.MAIN_HAND) {
            boolean flag = ItemNBTTool.getBoolean(stack, TAG_INVOKE, false);
            if (!flag) {
                List<LivingEntity> entities = pLevel.getEntitiesOfClass(LivingEntity.class, pPlayer.getBoundingBox().inflate(2.0D, 0.5D, 2.0D));

                entities.forEach(e -> {
                    if (e != pPlayer && !pPlayer.isAlliedTo(e) && !(e instanceof ArmorStand) && pPlayer.distanceToSqr(e) < 9) {
                        e.knockback(0.6F, Mth.sin(pPlayer.getYRot() * ((float) Math.PI / 180F)), -Mth.cos(pPlayer.getYRot() * ((float) Math.PI / 180F)));
                        e.hurt(pLevel.damageSources().playerAttack(pPlayer), 13);
                    }
                });
                pPlayer.sweepAttack();
                pPlayer.getCooldowns().addCooldown(stack.getItem(), 40);

                pLevel.playSound(pPlayer, pPlayer.getOnPos(), SoundRegistry.BLADE.get(), SoundSource.AMBIENT, 0.5f, 1f);
            }
            if (!pLevel.isClientSide) {
                ItemNBTTool.setBoolean(stack, TAG_INVOKE, !flag);
            }
        }
        return InteractionResultHolder.fail(stack);
    }

    private Multimap<Attribute, AttributeModifier> getModifiers(ItemStack stack) {
        UUID uuid = new UUID(ItemRegistry.SHURA_CHIN.hashCode(), 0);
        boolean flag = ItemNBTTool.getBoolean(stack, TAG_INVOKE, false);
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier",
                flag ? 12 : 0, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier",
                -1.5f, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ARMOR, new AttributeModifier(uuid, Utils.PDC_ATTRIBUTE_MODIFIER, flag ? 0 : 8, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_KNOCKBACK, new AttributeModifier(uuid, Utils.PDC_ATTRIBUTE_MODIFIER, flag ? 0.3 : 0, AttributeModifier.Operation.MULTIPLY_BASE));
        builder.put(Attributes.MOVEMENT_SPEED, new AttributeModifier(uuid, Utils.PDC_ATTRIBUTE_MODIFIER, flag ? 0.3 : 0, AttributeModifier.Operation.MULTIPLY_BASE));
        return builder.build();
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot equipmentSlot, ItemStack stack) {
        return equipmentSlot == EquipmentSlot.MAINHAND ? getModifiers(stack) : super.getAttributeModifiers(equipmentSlot, stack);
    }

//    @Override
//    @ParametersAreNonnullByDefault
//    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
//        if (!worldIn.isRemote && entityIn instanceof PlayerEntity) {
//            PlayerEntity player = (PlayerEntity) entityIn;
//            if (player.getHeldItemOffhand().getItem().equals(ItemRegistry.UME.get()) &&
//                    player.getHeldItemMainhand().getItem().equals(ItemRegistry.SHURA_CHIN.get())) {
//                player.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 300, 1, true, false));
//                player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 300, 1, true, false));
//            }
//        }
//    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        if (pTarget instanceof Salmon || pTarget instanceof Squid || pTarget instanceof Guardian ||
                pTarget instanceof Cod || pTarget instanceof Pufferfish || pTarget instanceof TropicalFish || pTarget instanceof Chicken) {
            if (pAttacker instanceof Player player) {
                player.getFoodData().eat(10, 0.5f);
            }
        }

        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.providencraft.ume.func").withStyle(ChatFormatting.AQUA));
        pTooltipComponents.add(Component.translatable("des.providencraft.shurachin_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.providencraft.shurachin_2").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));

        TooltipTool.addLegacyInfo(pTooltipComponents);
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return slotChanged && !oldStack.equals(newStack);
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return false;
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public int getEnchantmentValue(ItemStack stack) {
        return 20;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return enchantment.category == EnchantmentCategory.WEAPON || enchantment.category == EnchantmentCategory.BREAKABLE;
    }
}
