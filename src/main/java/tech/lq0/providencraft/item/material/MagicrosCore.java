package tech.lq0.providencraft.item.material;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MagicrosCore extends Item {
    public static final String TAG_CHIRAM = "chiram";
    public static final String TAG_HAINE = "haine";
    public static final String TAG_KERORO = "keroro";
    public static final String TAG_EKIRA = "ekira";

    public MagicrosCore() {
        super(new Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant());
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.providencraft.magicros_core_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.providencraft.magicros_core_2").withStyle(ChatFormatting.GRAY));
    }

//    @Override
//    public void inventoryTick(ItemStack stack, Level level, Entity entityIn, int itemSlot, boolean isSelected) {
//        boolean flagChiram = false;
//        boolean flagHaine = false;
//        boolean flagKeroro = false;
//        boolean flagEkira = false;
//
//        if (!level.isClientSide && entityIn instanceof Player player) {
//            if (isSelected) {
//
//                //倾澜核心判定
//                if (player.isElytraFlying() && !level.isRaining()) {
//                    Vector3d vec = player.getMotion();
//                    double speed = vec.x * vec.x + vec.y * vec.y + vec.z * vec.z;
//
//                    if (speed > .15 && speed < .6 && player.isPotionActive(Effects.REGENERATION)) {
//                        flagChiram = true;
//                    }
//                }
//
//                //灰音核心判定
//                if (!player.abilities.isFlying) {
//                    double posY = player.getPosY();
//
//                    if (posY >= 192 && player.isPotionActive(Effects.LEVITATION) && player.getAttributeValue(Attributes.ARMOR) >= 20) {
//                        boolean flagAir = false;
//                        long time = level.getDayTime() % 24000;
//
//                        BlockPos pos = player.getPosition();
//                        if (level.getBlockState(pos).getBlock() instanceof AirBlock &&
//                                level.getBlockState(pos.add(0, -1, 0)).getBlock() instanceof AirBlock) {
//                            flagAir = true;
//                        }
//
//
//                        if (time >= 0 && time <= 450 && flagAir) {
//                            flagHaine = true;
//                        }
//                    }
//                }
//
//                //蛙吹核心判定
//                if (level.isRaining() && player.isInWater()) {
//                    boolean flagJump = false;
//
//                    int count = 0;
//                    for (EffectInstance effect : player.getActivePotionEffects()) {
//                        if (!effect.getPotion().isBeneficial() && effect.getDuration() <= 400) {
//                            count++;
//                        }
//                        if (effect.getEffectName().equals(Effects.JUMP_BOOST.getName())) {
//                            if (effect.getAmplifier() >= 3) {
//                                flagJump = true;
//                            }
//                        }
//                    }
//
//                    if (count >= 8 && flagJump) {
//                        flagKeroro = true;
//                    }
//                }
//
//                //星宫颜核心判定
//                if (!level.isDaytime() && !level.isRaining()) {
//                    BlockPos pos = player.getPosition();
//                    int count = 0;
//
//                    boolean flag1 = level.canSeeSky(pos);
//                    boolean flag2 = player.isPotionActive(Effects.GLOWING);
//                    boolean flag3 = !player.getFoodStats().needFood();
//
//                    for (int i = -5; i <= 5; i++) {
//                        for (int q = -5; q <= 5; q++) {
//                            if (level.getBlockState(pos.add(i, 0, q)).isIn(Blocks.BEACON)) {
//                                TileEntity tileEntity = level.getTileEntity(pos.add(i, 0, q));
//                                if (tileEntity instanceof BeaconTileEntity) {
//                                    if (((BeaconTileEntity) tileEntity).getLevels() == 4) {
//                                        count++;
//                                    }
//                                }
//                            }
//                        }
//                    }
//
//                    if (count >= 4 && flag1 && flag2 && flag3) {
//                        flagEkira = true;
//                    }
//                }
//            }
//
//            if (flagChiram) {
//                player.sendStatusMessage(new TranslationTextComponent("des.providencraft.magicros_core.chiram").mergeStyle(TextFormatting.ITALIC).mergeStyle(Style.EMPTY.setColor(Color.fromHex("#FFECE7"))), true);
//                ItemNBTTool.setInt(stack, TAG_CHIRAM, Math.min(ItemNBTTool.getInt(stack, TAG_CHIRAM, 0) + 1, 600));
//            } else {
//                ItemNBTTool.setInt(stack, TAG_CHIRAM, 0);
//            }
//            if (ItemNBTTool.getInt(stack, TAG_CHIRAM, 0) >= 600) {
//                player.replaceItemInInventory(itemSlot, new ItemStack(ItemRegistry.CHIRAM_CORE.get()));
//            }
//
//            if (flagHaine) {
//                player.sendStatusMessage(new TranslationTextComponent("des.providencraft.magicros_core.haine").mergeStyle(TextFormatting.ITALIC).mergeStyle(Style.EMPTY.setColor(Color.fromHex("#ADDBFF"))), true);
//                ItemNBTTool.setInt(stack, TAG_HAINE, Math.min(ItemNBTTool.getInt(stack, TAG_HAINE, 0) + 1, 400));
//            } else {
//                ItemNBTTool.setInt(stack, TAG_HAINE, 0);
//            }
//            if (ItemNBTTool.getInt(stack, TAG_HAINE, 0) >= 400) {
//                player.replaceItemInInventory(itemSlot, new ItemStack(ItemRegistry.HAINE_CORE.get()));
//            }
//
//            if (flagKeroro) {
//                player.sendStatusMessage(new TranslationTextComponent("des.providencraft.magicros_core.keroro").mergeStyle(TextFormatting.ITALIC).mergeStyle(Style.EMPTY.setColor(Color.fromHex("#F5FFEA"))), true);
//                ItemNBTTool.setInt(stack, TAG_KERORO, Math.min(ItemNBTTool.getInt(stack, TAG_KERORO, 0) + 1, 300));
//            } else {
//                ItemNBTTool.setInt(stack, TAG_KERORO, 0);
//            }
//            if (ItemNBTTool.getInt(stack, TAG_KERORO, 0) >= 300) {
//                player.replaceItemInInventory(itemSlot, new ItemStack(ItemRegistry.KERORO_CORE.get()));
//            }
//
//            if (flagEkira) {
//                player.sendStatusMessage(new TranslationTextComponent("des.providencraft.magicros_core.ekira").mergeStyle(TextFormatting.ITALIC).mergeStyle(Style.EMPTY.setColor(Color.fromHex("#FFF7EA"))), true);
//                ItemNBTTool.setInt(stack, TAG_EKIRA, Math.min(ItemNBTTool.getInt(stack, TAG_EKIRA, 0) + 1, 1200));
//            } else {
//                ItemNBTTool.setInt(stack, TAG_EKIRA, 0);
//            }
//            if (ItemNBTTool.getInt(stack, TAG_EKIRA, 0) >= 1200) {
//                player.replaceItemInInventory(itemSlot, new ItemStack(ItemRegistry.EKIRA_CORE.get()));
//            }
//
//        }
//        super.inventoryTick(stack, level, entityIn, itemSlot, isSelected);
//    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return oldStack != newStack && slotChanged;
    }
}
