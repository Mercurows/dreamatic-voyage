package tech.lq0.dreamaticvoyage.item.third.hiru;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
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
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.client.render.item.SecondaryCataclysmRenderer;
import tech.lq0.dreamaticvoyage.entity.projectile.HirenadeGGEntity;
import tech.lq0.dreamaticvoyage.init.SoundRegistry;
import tech.lq0.dreamaticvoyage.tools.ItemNBTTool;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;
import java.util.function.Consumer;

public class SecondaryCataclysm extends Item {
    public static final String TAG_AMMO = "Ammo";
    public static final int MAX_AMMO_SIZE = 8;
    private final Multimap<Attribute, AttributeModifier> defaultModifiers;

    public SecondaryCataclysm() {
        super(new Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant());
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", 9, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", -3.2, AttributeModifier.Operation.ADDITION));
        this.defaultModifiers = builder.build();
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot pEquipmentSlot) {
        return pEquipmentSlot == EquipmentSlot.MAINHAND ? this.defaultModifiers : super.getDefaultAttributeModifiers(pEquipmentSlot);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.secondary_cataclysm_1").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.secondary_cataclysm_2").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.secondary_cataclysm_3").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.HIRU);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand handIn) {
        ItemStack stack = player.getItemInHand(handIn);

        ItemStack ammo = this.findAmmo(player);

        if (ItemNBTTool.getInt(stack, TAG_AMMO, 0) < 6) {
            if (player.isSteppingCarefully()) {
                if (!ammo.isEmpty() || player.isCreative()) {
                    player.startUsingItem(handIn);
                }
                return InteractionResultHolder.consume(stack);
            }
        }

        if (!player.getCooldowns().isOnCooldown(stack.getItem()) && !player.isSteppingCarefully()) {
            if (player.isCreative() || ItemNBTTool.getInt(stack, TAG_AMMO, 0) > 0) {
                if (!world.isClientSide) {
                    HirenadeGGEntity hirenadeGG = new HirenadeGGEntity(world, player);
                    hirenadeGG.setOwner(player);
                    hirenadeGG.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0f, 2.4f, 0.0f);
                    world.addFreshEntity(hirenadeGG);

                    player.getCooldowns().addCooldown(stack.getItem(), 10);
                    if (!player.isCreative()) {
                        ItemNBTTool.setInt(stack, TAG_AMMO, ItemNBTTool.getInt(stack, TAG_AMMO, 0) - 1);
                    }
                } else {
                    player.playSound(SoundRegistry.GRENADE_SHOOT.get(), 0.9f, 1.0f);
                }

                return InteractionResultHolder.fail(stack);
            }
        }

        return InteractionResultHolder.fail(stack);
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 30;
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            @Override
            public HumanoidModel.@Nullable ArmPose getArmPose(LivingEntity entityLiving, InteractionHand hand, ItemStack itemStack) {
                return HumanoidModel.ArmPose.BOW_AND_ARROW;
            }

            @OnlyIn(Dist.CLIENT)
            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                return new SecondaryCataclysmRenderer();
            }
        });
    }

    @Override
    public boolean onEntitySwing(ItemStack stack, LivingEntity entity) {
        return true;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level worldIn, LivingEntity entityLiving) {
        if (!worldIn.isClientSide && entityLiving instanceof Player player) {
            boolean flag2 = ItemNBTTool.getInt(stack, TAG_AMMO, 0) < MAX_AMMO_SIZE;
            ItemStack ammo = this.findAmmo(player);

            if (player.isCreative()) {
                ItemNBTTool.setInt(stack, TAG_AMMO, MAX_AMMO_SIZE);
                return stack;
            }

            if (!ammo.isEmpty() || flag2) {
                int currentCount = ItemNBTTool.getInt(stack, TAG_AMMO, 0);
                int ammoCount = MAX_AMMO_SIZE - currentCount;

                if (ammo.isEmpty()) {
                    return stack;
                }

                boolean flag1 = ammo.getItem() instanceof HirenadeGG;

                if (flag1 && !player.isCreative()) {
                    if (ammo.getCount() >= ammoCount) {
                        ammo.shrink(ammoCount);
                        ItemNBTTool.setInt(stack, TAG_AMMO, MAX_AMMO_SIZE);
                    } else {
                        int count = ammo.getCount();
                        ammo.shrink(count);
                        ItemNBTTool.setInt(stack, TAG_AMMO, Math.min(currentCount + count, MAX_AMMO_SIZE));
                    }

                    if (ammo.isEmpty()) {
                        player.getInventory().removeItem(ammo);
                    }
                }
            }
        }

        return stack;
    }

    @Override
    public boolean canAttackBlock(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer) {
        return !pPlayer.isCreative();
    }

    protected ItemStack findAmmo(Player player) {
        if (this.check(player.getItemInHand(InteractionHand.OFF_HAND))) {
            return player.getItemInHand(InteractionHand.OFF_HAND);
        } else if (this.check(player.getItemInHand(InteractionHand.MAIN_HAND))) {
            return player.getItemInHand(InteractionHand.MAIN_HAND);
        } else {
            for (int i = 0; i < player.getInventory().getContainerSize(); ++i) {
                ItemStack itemstack = player.getInventory().getItem(i);
                if (this.check(itemstack)) {
                    return itemstack;
                }
            }
            return ItemStack.EMPTY;
        }
    }

    protected boolean check(ItemStack stack) {
        return stack.getItem() instanceof HirenadeGG;
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return slotChanged;
    }
}
