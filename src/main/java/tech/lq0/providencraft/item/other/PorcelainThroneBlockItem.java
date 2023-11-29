package tech.lq0.providencraft.item.other;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import tech.lq0.providencraft.init.BlockRegistry;

public class PorcelainThroneBlockItem extends BlockItem {
    public PorcelainThroneBlockItem() {
        super(BlockRegistry.PORCELAIN_THRONE.get(), new Properties());
    }

    @Override
    public boolean canEquip(ItemStack stack, EquipmentSlot armorType, Entity entity) {
        return armorType == EquipmentSlot.HEAD;
    }
}
