package tech.lq0.dreamaticvoyage.item.oi.ayu;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.capability.chaos.ChaosHelper;
import tech.lq0.dreamaticvoyage.tools.ItemNBTTool;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;

@SuppressWarnings({"FieldCanBeLocal", "unused"})
public class DelicateMirage extends Item {
    public static final String TAG_ATTACK = "attack";
    private final Multimap<Attribute, AttributeModifier> attributeModifiers;

    public DelicateMirage() {
        super(new Properties().rarity(Rarity.RARE).durability(480));
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", 1, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", -1, AttributeModifier.Operation.ADDITION));
        this.attributeModifiers = builder.build();
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.delicate_mirage").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.AYU);
    }

    private Multimap<Attribute, AttributeModifier> getModifiers(ItemStack stack) {
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier",
                ItemNBTTool.getInt(stack, TAG_ATTACK, 0), AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier",
                -1, AttributeModifier.Operation.ADDITION));
        return builder.build();
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot equipmentSlot, ItemStack stack) {
        return equipmentSlot == EquipmentSlot.MAINHAND ? getModifiers(stack) : super.getAttributeModifiers(equipmentSlot, stack);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (!worldIn.isClientSide && entityIn instanceof Player player) {
            int chaos = ChaosHelper.getChaos(player);

            ItemNBTTool.setInt(stack, TAG_ATTACK, Math.max(0, chaos / 10));
        }
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof Player player && !attacker.level().isClientSide) {

            int chaos = ChaosHelper.getChaos(player);
            double prob = Math.abs(chaos) * 0.01;
            double rand = Math.random();
            int level = Math.min(9, Math.abs(chaos) / 10);
            float damage = 50 - level * 5.0f;

            //混沌时，攻击生物有概率对自己造成伤害
            if (chaos >= 0) {
                if (rand < prob) {
                    player.hurt(player.level().damageSources().magic(), player.getHealth() * 0.1f);

                    ChaosHelper.setChaos(player, Math.max(0, ChaosHelper.getPureChaos(player) - 5));
                }
            }

            //清楚时，攻击生物有概率造成二次伤害
            if (chaos <= 0) {
                if (rand < prob) {
                    ChaosHelper.setChaos(player, Math.min(0, ChaosHelper.getPureChaos(player) + 5));

//                    new Object() {
//                        private int ticks = 0;
//                        private float waitTicks;
//
//                        public void start(int waitTicks) {
//                            this.waitTicks = waitTicks;
//                            MinecraftForge.EVENT_BUS.register(this);
//                        }
//
//                        @SubscribeEvent
//                        public void tick(TickEvent.ServerTickEvent event) {
//                            if (event.phase == TickEvent.Phase.END) {
//                                this.ticks++;
//                                if (this.ticks >= this.waitTicks) {
//                                    run();
//                                }
//                            }
//                        }
//
//                        private void run() {
//                            target.attackEntityFrom(DamageSource.causePlayerDamage(player), damage);
//
//                            MinecraftForge.EVENT_BUS.unregister(this);
//                        }
//                    }.start((int) 20);
                }
            }
        }

        stack.hurtAndBreak(1, attacker, (entity) -> entity.broadcastBreakEvent(EquipmentSlot.MAINHAND));
        return true;
    }

    public boolean canAttackBlock(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer) {
        return !pPlayer.isCreative();
    }

    public float getDestroySpeed(ItemStack pStack, BlockState pState) {
        if (pState.is(Blocks.COBWEB)) {
            return 15.0F;
        } else {
            return pState.is(BlockTags.SWORD_EFFICIENT) ? 1.5F : 1.0F;
        }
    }

    public boolean mineBlock(ItemStack pStack, Level pLevel, BlockState pState, BlockPos pPos, LivingEntity pEntityLiving) {
        return true;
    }

    public boolean isCorrectToolForDrops(BlockState pBlock) {
        return pBlock.is(Blocks.COBWEB);
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
        return 16;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return enchantment.category == EnchantmentCategory.WEAPON || enchantment.category == EnchantmentCategory.BREAKABLE;
    }

    @Override
    public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
        return repair.getItem() == Items.DIAMOND;
    }
}
