package tech.lq0.providencraft.item.providencemagicros.chiram;

import net.minecraft.world.item.ArmorItem;
import tech.lq0.providencraft.tiers.ModArmorMaterial;

public class FlatVegetableChestplate extends ArmorItem {
    public FlatVegetableChestplate() {
        super(ModArmorMaterial.CHIRAM, Type.CHESTPLATE, new Properties().durability(514).fireResistant());
    }

//    @OnlyIn(Dist.CLIENT)
//    @ParametersAreNonnullByDefault
//    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
//        tooltip.add((new TranslationTextComponent("des.providencraft.flat_vegetable_chestplate")).mergeStyle(TextFormatting.GRAY));
//        TooltipTool.addLiverInfo(tooltip, Livers.CHIRAM);
//    }
//
//    @Override
//    @ParametersAreNonnullByDefault
//    @Nonnull
//    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot) {
//        Multimap<Attribute, AttributeModifier> map = super.getAttributeModifiers(equipmentSlot);
//        UUID uuid = new UUID(ItemRegistry.FLAT_VEGETABLE_CHESTPLATE.hashCode() + equipmentSlot.toString().hashCode(), 0);
//        if (equipmentSlot == getEquipmentSlot()) {
//            map = HashMultimap.create(map);
//            map.put(Attributes.MOVEMENT_SPEED,
//                    new AttributeModifier(uuid, "flat vegetable chestplate modifier", -0.2f, AttributeModifier.Operation.MULTIPLY_BASE));
//        }
//        return map;
//    }
}
