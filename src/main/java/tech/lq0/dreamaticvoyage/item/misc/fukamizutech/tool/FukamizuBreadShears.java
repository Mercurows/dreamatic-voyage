package tech.lq0.dreamaticvoyage.item.misc.fukamizutech.tool;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.dispenser.ShearsDispenseItemBehavior;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraftforge.common.IForgeShearable;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.Utils;

import java.util.List;
import java.util.Random;

public class FukamizuBreadShears extends ShearsItem {

    public FukamizuBreadShears() {
        super(new Properties().fireResistant().durability(404));
        DispenserBlock.registerBehavior(this, new ShearsDispenseItemBehavior());
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.fukamizu_bread_shears").withStyle(ChatFormatting.GRAY));
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity entity, InteractionHand hand) {
        if (entity instanceof Animal animal) {
            Level level = player.level();
            if (entity.level().isClientSide) {
                return InteractionResult.SUCCESS;
            }

            animal.hurt(level.damageSources().generic(), animal.getMaxHealth() * .5f);
            stack.hurtAndBreak(10, player, e -> e.broadcastBreakEvent(hand));

            if (entity instanceof IForgeShearable target) {
                BlockPos pos = BlockPos.containing(entity.position());
                if (target.isShearable(stack, entity.level(), pos)) {
                    List<ItemStack> drops = target.onSheared(player, stack, entity.level(), pos,
                            EnchantmentHelper.getTagEnchantmentLevel(Enchantments.BLOCK_FORTUNE, stack));
                    Random rand = new Random();
                    drops.forEach(d -> {
                        ItemEntity ent = entity.spawnAtLocation(d, 1.0F);
                        if (ent != null) {
                            ent.setDeltaMovement(ent.getDeltaMovement().add((rand.nextFloat() - rand.nextFloat()) * 0.1F, rand.nextFloat() * 0.05F, (rand.nextFloat() - rand.nextFloat()) * 0.1F));
                        }
                    });
                    stack.hurtAndBreak(1, player, e -> e.broadcastBreakEvent(hand));
                }
            }

            if (!animal.isDeadOrDying()) {
                assert player.getServer() != null;
                LootTable lootTable = player.getServer().getLootData().getLootTable(animal.getLootTable());
                LootParams.Builder builder = new LootParams.Builder((ServerLevel) level)
                        .withParameter(LootContextParams.THIS_ENTITY, animal)
                        .withParameter(LootContextParams.ORIGIN, animal.position())
                        .withParameter(LootContextParams.DAMAGE_SOURCE, level.damageSources().generic())
                        .withOptionalParameter(LootContextParams.KILLER_ENTITY, player)
                        .withOptionalParameter(LootContextParams.DIRECT_KILLER_ENTITY, player);
                builder = builder.withParameter(LootContextParams.LAST_DAMAGE_PLAYER, player).withLuck(player.getLuck());
                LootParams lootParams = builder.create(LootContextParamSets.ENTITY);
                lootTable.getRandomItems(lootParams, animal.getLootTableSeed(), animal::spawnAtLocation);

                return InteractionResult.SUCCESS;
            }
        }

        return InteractionResult.PASS;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return super.canApplyAtEnchantingTable(stack, enchantment) && enchantment != Enchantments.MENDING;
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> map = super.getAttributeModifiers(slot, stack);
        if (slot == EquipmentSlot.MAINHAND) {
            map = HashMultimap.create(map);
            map.put(Attributes.ATTACK_DAMAGE,
                    new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, Utils.MOD_ATTRIBUTE_MODIFIER, 2.0, AttributeModifier.Operation.ADDITION));
        }
        return map;
    }

}
