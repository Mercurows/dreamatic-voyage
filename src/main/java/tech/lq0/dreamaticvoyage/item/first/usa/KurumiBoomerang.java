package tech.lq0.dreamaticvoyage.item.first.usa;

import net.minecraft.ChatFormatting;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.client.models.item.KurumiBoomerangItemModel;
import tech.lq0.dreamaticvoyage.client.render.item.KurumiBoomerangItemRenderer;
import tech.lq0.dreamaticvoyage.entity.projectile.KurumiBoomerangEntity;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class KurumiBoomerang extends Item {

    public KurumiBoomerang() {
        super(new Properties());
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.kurumi_boomerang").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.USA);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack item = pPlayer.getItemInHand(pUsedHand);

        if (!pLevel.isClientSide()) {
            KurumiBoomerangEntity kurumiBoomerangEntity = new KurumiBoomerangEntity(pLevel, pPlayer);
            kurumiBoomerangEntity.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0f, 3.0f, 0.2f);

            if (pPlayer.isCreative()) {
                kurumiBoomerangEntity.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
            }

            pLevel.addFreshEntity(kurumiBoomerangEntity);
            item.shrink(1);
        }
        pPlayer.awardStat(Stats.ITEM_USED.get(this));

        return new InteractionResultHolder<>(InteractionResult.SUCCESS, item);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                return new KurumiBoomerangItemRenderer();
            }
        });
    }

    @Nullable
    @Override
    public EquipmentSlot getEquipmentSlot(ItemStack stack) {
        return EquipmentSlot.HEAD;
    }

    @SubscribeEvent
    public static void onModelBaked(ModelEvent.ModifyBakingResult event) {
        Map<ResourceLocation, BakedModel> modelRegistry = event.getModels();
        ModelResourceLocation location = new ModelResourceLocation(ItemRegistry.KURUMI_BOOMERANG.getId(), "inventory");
        BakedModel existingModel = modelRegistry.get(location);
        if (existingModel == null) {
            throw new RuntimeException();
        } else if (existingModel instanceof KurumiBoomerangItemModel) {
            throw new RuntimeException();
        } else {
            KurumiBoomerangItemModel model = new KurumiBoomerangItemModel(existingModel);
            event.getModels().put(location, model);
        }
    }
}
