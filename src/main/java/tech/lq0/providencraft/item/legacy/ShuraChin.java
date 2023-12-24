package tech.lq0.providencraft.item.legacy;

import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.level.Level;
import tech.lq0.providencraft.init.SoundRegistry;
import tech.lq0.providencraft.tools.ItemNBTTool;
import tech.lq0.providencraft.tools.RarityTool;

import java.util.List;

//@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ShuraChin extends SwordItem {
    public static final String TAG_INVOKE = "invoke";

    public ShuraChin() {
        super(Tiers.IRON, -2, -1.5f, new Properties().rarity(RarityTool.LEGACY).setNoRepair().durability(1442));
    }

//    @SubscribeEvent
//    public static void propertyOverrideRegistry(FMLClientSetupEvent event) {
//        event.enqueueWork(() ->
//                ItemModelsProperties.registerProperty(ItemRegistry.SHURA_CHIN.get(), new ResourceLocation(Utils.MOD_ID, "shurachin_invoke"),
//                        (stack, world, entity) -> ItemNBTTool.getBoolean(stack, TAG_INVOKE, false) ? 1.0F : 0.0F)
//        );
//    }

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

//    @Override
//    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot, ItemStack stack) {
//        Multimap<Attribute, AttributeModifier> map = super.getAttributeModifiers(equipmentSlot);
//        UUID uuid = new UUID(ItemRegistry.SHURA_CHIN.hashCode() + equipmentSlot.toString().hashCode(), 0);
//        if (equipmentSlot == EquipmentSlotType.MAINHAND) {
//            map = HashMultimap.create(map);
//            boolean flag = ItemNBTTool.getBoolean(stack, TAG_INVOKE, false);
//            map.put(Attributes.ATTACK_DAMAGE,
//                    new AttributeModifier(uuid, "shurachin modifier", flag ? 12.0f : 0.0f, AttributeModifier.Operation.ADDITION));
//            map.put(Attributes.ATTACK_KNOCKBACK,
//                    new AttributeModifier(uuid, "shurachin modifier", flag ? 0.3f : 0.0f, AttributeModifier.Operation.MULTIPLY_BASE));
//            map.put(Attributes.ARMOR,
//                    new AttributeModifier(uuid, "shurachin modifier", flag ? 0.0f : 8.0f, AttributeModifier.Operation.ADDITION));
//            map.put(Attributes.MOVEMENT_SPEED,
//                    new AttributeModifier(uuid, "shurachin modifier", flag ? 0.0f : 0.2f, AttributeModifier.Operation.MULTIPLY_BASE));
//        }
//        return map;
//    }

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
//
//    @Override
//    @ParametersAreNonnullByDefault
//    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
//        if (target instanceof SalmonEntity || target instanceof SquidEntity || target instanceof GuardianEntity ||
//                target instanceof CodEntity || target instanceof PufferfishEntity || target instanceof TropicalFishEntity ||
//                target instanceof ChickenEntity) {
//            //attacker.addPotionEffect(new EffectInstance(Effects.SATURATION, 20, 0));
//            if (attacker instanceof PlayerEntity) {
//                PlayerEntity player = (PlayerEntity) attacker;
//                player.getFoodStats().addStats(10, 10.0f);
//            }
//        }
//        return super.hitEntity(stack, target, attacker);
//    }
//
//    @Override
//    @ParametersAreNonnullByDefault
//    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
//        tooltip.add((new TranslationTextComponent("des.providencraft.ume.func")).mergeStyle(TextFormatting.AQUA));
//        tooltip.add((new TranslationTextComponent("des.providencraft.shurachin_1")).mergeStyle(TextFormatting.GRAY));
//        tooltip.add((new TranslationTextComponent("des.providencraft.shurachin_2")).mergeStyle(TextFormatting.GRAY).mergeStyle(TextFormatting.STRIKETHROUGH));
//        TooltipTool.addLiverInfo(tooltip, Livers.BENI);
//    }

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
