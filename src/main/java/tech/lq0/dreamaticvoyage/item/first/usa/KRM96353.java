package tech.lq0.dreamaticvoyage.item.first.usa;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.client.models.armor.KRM96353Model;
import tech.lq0.dreamaticvoyage.tiers.ModArmorMaterial;

import java.util.function.Consumer;

public class KRM96353 extends ArmorItem {
    public KRM96353() {
        super(ModArmorMaterial.PURIFIED_CRYSTAL, Type.CHESTPLATE, new Properties().rarity(Rarity.EPIC).setNoRepair());
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
}
