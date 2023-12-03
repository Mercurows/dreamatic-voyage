package tech.lq0.providencraft.item.providenceOI.shirako;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;
import tech.lq0.providencraft.init.ItemRegistry;
import tech.lq0.providencraft.tools.ItemNBTTool;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import java.util.List;

public class MomoPhone extends Item {
    public static final String NBT_POS_X = "posX";
    public static final String NBT_POS_Y = "posY";
    public static final String NBT_POS_Z = "posZ";
    public static final String NBT_BINDING = "binding";
    public static final String NBT_DIMENSION = "dimension";

    public MomoPhone() {
        super(new Properties().fireResistant().durability(9).rarity(Rarity.UNCOMMON));
    }

//    @Override
//    public InteractionResultHolder<ItemStack> use(Level pLevel, Player playerIn, InteractionHand pUsedHand) {
//        ItemStack item = playerIn.getItemInHand(pUsedHand);
//        BlockPos pos = null;
//
//        float posX = ItemNBTTool.getFloat(item, NBT_POS_X, Float.NaN);
//        float posY = ItemNBTTool.getFloat(item, NBT_POS_Y, Float.NaN);
//        float posZ = ItemNBTTool.getFloat(item, NBT_POS_Z, Float.NaN);
//
//        if (!(Float.isNaN(posX) || Float.isNaN(posY) || Float.isNaN(posZ))) {
//            pos = new BlockPos((int) posX, (int) posY, (int) posZ);
//        }
//
//        if (item.getDamageValue() < item.getMaxDamage()) {
//            if (playerIn.isSteppingCarefully()) {
//                pos = playerIn.getOnPos();
//                ItemNBTTool.setFloat(item, NBT_POS_X, pos.getX() + 0.5F);
//
//                BlockState state = pLevel.getBlockState(pos);
//                if (state.getMaterial().blocksMovement()) {
//                    ItemNBTTool.setFloat(item, NBT_POS_Y, pos.getY());
//                } else {
//                    ItemNBTTool.setFloat(item, NBT_POS_Y, pos.getY() - 1);
//                }
//
//                ItemNBTTool.setFloat(item, NBT_POS_Z, pos.getZ() + 0.5F);
//
//                ItemNBTTool.setBoolean(item, NBT_BINDING, true);
//
//                playerIn.displayClientMessage(Component.translatable("des.providencraft.momo_phone.set_pos").withStyle(ChatFormatting.LIGHT_PURPLE), true);
//
//                playerIn.playSound(SoundEvents.ARROW_HIT_PLAYER, 1.0F, 1.0F);
//
//                return InteractionResultHolder.pass(item);
//            } else {
//                if (pLevel.isThundering() && pLevel.canSeeSky(playerIn.getOnPos())) {
//                    LightningBolt lightningBoltEntity = EntityType.LIGHTNING_BOLT.create(pLevel);
//                    assert lightningBoltEntity != null;
//                    lightningBoltEntity.setPos(Vec3.atBottomCenterOf(playerIn.getOnPos()));
//
//                    pLevel.addFreshEntity(lightningBoltEntity);
//                    playerIn.getCooldowns().addCooldown(item.getItem(), 200);
//                } else {
//                    if (pos == null) {
//                        playerIn.displayClientMessage(Component.translatable("des.providencraft.momo_phone.not_set_pos").withStyle(ChatFormatting.RED), true);
//                    } else {
//                        boolean isBlocked = false;
//                        BlockState state1 = pLevel.getBlockState(pos.offset(0, 1, 0));
//                        BlockState state2 = pLevel.getBlockState(pos.offset(0, 2, 0));
//                        if (state1.getMaterial().blocksMovement() || state2.getMaterial().blocksMovement()) {
//                            isBlocked = true;
//                        }
//                        if (!isBlocked) {
//                            boolean temp = false;
//                            for (int i = (int) posY; i >= 0; i--) {
//                                BlockState state = pLevel.getBlockState(new BlockPos((int) posX, i, (int) posZ));
//                                if (state.getMaterial().blocksMovement()) {
//                                    temp = true;
//                                    posY = i + 1;
//                                    break;
//                                }
//                            }
//                            isBlocked = !temp;
//                        }
//
//                        if (!isBlocked) {
//                            if (!pLevel.isClientSide) {
//                                playerIn.teleportToWithTicket(posX, posY, posZ);
//                            }
//                            playerIn.level().playSound(playerIn, new BlockPos((int) posX, (int) posY, (int) posZ), SoundEvents.CHORUS_FRUIT_TELEPORT, SoundSource.PLAYERS, 1.0F, 1.0F);
//
//                            if (!playerIn.isCreative()) {
//                                item.setDamageValue(item.getDamageValue() + 1);
//                            }
//                            playerIn.getCooldowns().addCooldown(item.getItem(), 200);
//                            if (item.getDamageValue() == item.getMaxDamage()) {
//                                ItemNBTTool.setBoolean(item, NBT_BINDING, false);
//                            }
//                        } else {
//                            if (!pLevel.isClientSide) {
//                                playerIn.displayClientMessage(Component.translatable("des.providencraft.momo_phone.tp_fail").withStyle(ChatFormatting.RED), true);
//                            }
//                        }
//                    }
//                }
//                return InteractionResultHolder.success(item);
//            }
//        }
//        return InteractionResultHolder.fail(item);
//    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if (!pLevel.isClientSide) {
            float posX = ItemNBTTool.getFloat(pStack, NBT_POS_X, Float.NaN);
            float posY = ItemNBTTool.getFloat(pStack, NBT_POS_Y, Float.NaN);
            float posZ = ItemNBTTool.getFloat(pStack, NBT_POS_Z, Float.NaN);

            if (!(Float.isNaN(posX) || Float.isNaN(posY) || Float.isNaN(posZ))) {
                if (pStack.getDamageValue() < pStack.getMaxDamage()) {
                    ItemNBTTool.setBoolean(pStack, NBT_BINDING, true);
                }
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.providencraft.momo_phone.func").withStyle(ChatFormatting.AQUA));
        pTooltipComponents.add(Component.translatable("des.providencraft.momo_phone_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.providencraft.momo_phone_2").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.providencraft.momo_phone.warn").withStyle(ChatFormatting.RED));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.SHIRAKO);
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return false;
    }

    @Override
    public boolean isValidRepairItem(ItemStack pStack, ItemStack pRepairCandidate) {
        return pRepairCandidate.getItem() == ItemRegistry.DAIFUKU_SYRUP.get();
    }
}
