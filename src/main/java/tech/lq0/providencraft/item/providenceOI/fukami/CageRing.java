package tech.lq0.providencraft.item.providenceOI.fukami;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeMod;
import org.jetbrains.annotations.Nullable;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.tools.ItemNBTTool;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

public class CageRing extends Item implements ICurioItem {
    public static final String TAG_STOP = "stopTime";
    public static final String TAG_POS = "currentPos";

    public CageRing() {
        super(new Properties().stacksTo(1).rarity(Rarity.UNCOMMON));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.providencraft.cage_ring").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.FUKAMI);
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        LivingEntity livingEntity = slotContext.entity();
        if (livingEntity instanceof Player player) {
            if (!player.level().isClientSide) {
                BlockPos pos = player.getOnPos();
                boolean flag = comparePos(stack, pos);
                if (flag) {
                    ItemNBTTool.setInt(stack, TAG_STOP, Math.min(40, ItemNBTTool.getInt(stack, TAG_STOP, 0) + 1));
                } else {
                    ItemNBTTool.setInt(stack, TAG_STOP, 0);
                }

                double distance = player.getAttributeValue(ForgeMod.ENTITY_REACH.get()) * 2;
                player.level().getEntitiesOfClass(LivingEntity.class, player.getBoundingBox().inflate(distance))
                        .stream().filter(e -> e != player && !e.isAlliedTo(player) && e.distanceTo(player) <= distance).forEach(entity -> entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 2, false, false)));

                this.setTagPos(stack, pos);

                if (slotContext.visible()) {
                    if (player.tickCount % 10 == 0) {
                        this.spawnCircleParticles(player, distance, (int) distance * 10);
                    }
                }
            }
        }
        ICurioItem.super.curioTick(slotContext, stack);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> map = ICurioItem.super.getAttributeModifiers(slotContext, uuid, stack);

        map = HashMultimap.create(map);
        map.put(Attributes.MOVEMENT_SPEED,
                new AttributeModifier(uuid, Utils.PDC_ATTRIBUTE_MODIFIER, -0.2f, AttributeModifier.Operation.MULTIPLY_BASE));
        if (ItemNBTTool.getInt(stack, TAG_STOP, 0) >= 40) {
            map.put(Attributes.ARMOR,
                    new AttributeModifier(uuid, Utils.PDC_ATTRIBUTE_MODIFIER, 10f, AttributeModifier.Operation.ADDITION));
            map.put(Attributes.ARMOR_TOUGHNESS,
                    new AttributeModifier(uuid, Utils.PDC_ATTRIBUTE_MODIFIER, 5f, AttributeModifier.Operation.ADDITION));
        }

        return map;
    }

    @Override
    public boolean canEquip(SlotContext slotContext, ItemStack stack) {
        LivingEntity livingEntity = slotContext.entity();
        AtomicBoolean flag = new AtomicBoolean(true);
        CuriosApi.getCuriosInventory(livingEntity).ifPresent(c -> c.findFirstCurio(this).ifPresent(s -> flag.set(false)));

        return flag.get();
    }

    private void setTagPos(ItemStack stack, BlockPos pos) {
        int[] position = new int[]{pos.getX(), pos.getY(), pos.getZ()};
        stack.getOrCreateTag().putIntArray(TAG_POS, position);
    }

    private BlockPos getTagPos(ItemStack stack) {
        if (stack.hasTag()) {
            assert stack.getTag() != null;
            if (!stack.getTag().contains(TAG_POS)) {
                return null;
            }

            int[] position = stack.getOrCreateTag().getIntArray(TAG_POS);
            return new BlockPos(position[0], position[1], position[2]);
        }

        return null;
    }

    private boolean comparePos(ItemStack stack, BlockPos pos) {
        if (getTagPos(stack) != null && pos != null) {
            return getTagPos(stack).equals(pos);
        } else {
            return false;
        }
    }

    private void spawnCircleParticles(Player player, double radius, int count) {
        ServerLevel level = (ServerLevel) player.level();
        Vec3 playerPos = player.position();
        double angleIncrement = 2 * Math.PI / count;

        for (int i = 0; i < count; ++i) {
            double angle = i * angleIncrement;
            double offsetX = radius * Math.cos(angle);
            double offsetZ = radius * Math.sin(angle);

            double offsetY = player.getEyeHeight();

            level.sendParticles(ParticleTypes.PORTAL, playerPos.x + offsetX, playerPos.y + offsetY, playerPos.z + offsetZ,
                    1, 0, 0, 0, 0);
        }
    }
}
