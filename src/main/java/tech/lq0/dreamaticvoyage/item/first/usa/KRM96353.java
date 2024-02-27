package tech.lq0.dreamaticvoyage.item.first.usa;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.client.models.armor.KRM96353Model;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;
import tech.lq0.dreamaticvoyage.tiers.ModArmorMaterial;
import tech.lq0.dreamaticvoyage.tools.ItemNBTTool;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class KRM96353 extends ArmorItem {
    public static final String TAG_FLY_ENERGY = "fly_energy";
    private static final List<String> players = Collections.synchronizedList(new ArrayList<>());

    public KRM96353() {
        super(ModArmorMaterial.PURIFIED_CRYSTAL, Type.CHESTPLATE, new Properties().rarity(Rarity.EPIC).setNoRepair().fireResistant());
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            @Override
            @OnlyIn(Dist.CLIENT)
            public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
                KRM96353Model<?> armorModel = new KRM96353Model<>(Minecraft.getInstance().getEntityModels().bakeLayer(KRM96353Model.LAYER_LOCATION));

                armorModel.crouching = livingEntity.isShiftKeyDown();
                armorModel.riding = original.riding;
                armorModel.young = livingEntity.isBaby();
                return armorModel;
            }
        });
    }

    @Override
    public @Nullable String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        return Utils.MOD_ID + ":textures/models/costume/krm_963_53.png";
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return false;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.krm_963_53").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.literal(""));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.krm_963_53.func").withStyle(ChatFormatting.WHITE));
        showFlyEnergy(pStack, pTooltipComponents);

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.USA);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (!worldIn.isClientSide && entityIn instanceof Player player) {
            if (itemSlot != 2) {
                if (player.tickCount % 30 == 0) {
                    setFlyEnergy(stack, getFlyEnergy(stack) + 1);
                }
            }
        }
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return slotChanged;
    }

    private void showFlyEnergy(ItemStack stack, List<Component> tooltip) {
        ChatFormatting textFormatting;
        if (getFlyEnergy(stack) >= 800) {
            textFormatting = ChatFormatting.GREEN;
        } else if (getFlyEnergy(stack) >= 500) {
            textFormatting = ChatFormatting.YELLOW;
        } else if (getFlyEnergy(stack) >= 200) {
            textFormatting = ChatFormatting.GOLD;
        } else {
            textFormatting = ChatFormatting.RED;
        }
        NumberFormat numberFormat = NumberFormat.getPercentInstance();
        numberFormat.setMaximumFractionDigits(1);
        numberFormat.setMinimumFractionDigits(1);
        double per = (double) getFlyEnergy(stack) / 1000;
        String percent = numberFormat.format(per);

        MutableComponent component = Component.literal("|").withStyle(textFormatting);

        for (int i = 0; i < getFlyEnergy(stack) / 20; i++) {
            component.append(Component.literal("|").withStyle(textFormatting));
        }
        component.append(Component.literal("").withStyle(ChatFormatting.RESET));
        for (int i = 0; i < 50 - getFlyEnergy(stack) / 20; i++) {
            component.append(Component.literal("|").withStyle(ChatFormatting.GRAY));
        }
        component.append(Component.literal("").withStyle(ChatFormatting.RESET));
        component.append(Component.literal(" ")).append(Component.literal(percent).withStyle(textFormatting));

        tooltip.add(component);
    }

    private static int getFlyEnergy(ItemStack stack) {
        return ItemNBTTool.getInt(stack, TAG_FLY_ENERGY, 1000);
    }

    private static void setFlyEnergy(ItemStack stack, int num) {
        ItemNBTTool.setInt(stack, TAG_FLY_ENERGY, Math.min(num, 1000));
    }

    private static boolean checkFly(Player player) {
        ItemStack itemStack = player.getItemBySlot(EquipmentSlot.CHEST);
        if (itemStack.getItem().equals(ItemRegistry.KRM_963_53.get())) {
            return getFlyEnergy(itemStack) > 0;
        }
        return false;
    }

    @SubscribeEvent
    public static void playerLoggedOut(PlayerEvent.PlayerLoggedOutEvent event) {
        String username = event.getEntity().getGameProfile().getName();
        players.remove(username + ":false");
        players.remove(username + ":true");
    }

    private static String playerToString(Player player) {
        return player.getGameProfile().getName() + ":" + player.level().isClientSide;
    }

    @SubscribeEvent
    public static void onLivingTick(LivingEvent.LivingTickEvent event) {
        LivingEntity livingEntity = event.getEntity();
        if (livingEntity instanceof Player player) {
            ItemStack itemStack = player.getItemBySlot(EquipmentSlot.CHEST);

            if (players.contains(playerToString(player))) {
                if (checkFly(player)) {
                    player.getAbilities().mayfly = true;

                    if (player.getAbilities().flying) {
                        if (getFlyEnergy(itemStack) > 0) {
                            if (player.tickCount % 20 == 0 && !player.isCreative()) {
                                setFlyEnergy(itemStack, Math.max(getFlyEnergy(itemStack) - 1, 0));
                            }
                        } else {
                            player.getAbilities().flying = false;
                        }
                    }
                } else {
                    if (!player.isSpectator() && !player.isCreative()) {
                        player.getAbilities().mayfly = false;
                        player.getAbilities().flying = false;
                        player.getAbilities().invulnerable = false;
                    }
                    players.remove(playerToString(player));
                }
            } else if (checkFly(player)) {
                players.add(playerToString(player));
                player.getAbilities().mayfly = true;
            }

            if (!player.getAbilities().flying) {
                if (player.tickCount % 30 == 0) {
                    setFlyEnergy(itemStack, getFlyEnergy(itemStack) + 1);
                }
            }
        }
    }
}
