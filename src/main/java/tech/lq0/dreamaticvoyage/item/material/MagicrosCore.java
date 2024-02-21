package tech.lq0.dreamaticvoyage.item.material;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BeaconBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;
import tech.lq0.dreamaticvoyage.tools.ItemNBTTool;

import java.lang.reflect.Field;
import java.util.List;

public class MagicrosCore extends Item {
    public static final String TAG_CHIRAM = "chiram";
    public static final String TAG_HAINE = "haine";
    public static final String TAG_KERORO = "keroro";
    public static final String TAG_EKIRA = "ekira";

    public MagicrosCore() {
        super(new Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant());
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.magicros_core_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.magicros_core_2").withStyle(ChatFormatting.GRAY));
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entityIn, int itemSlot, boolean isSelected) {
        boolean flagChiram = false;
        boolean flagHaine = false;
        boolean flagKeroro = false;
        boolean flagEkira = false;

        if (!level.isClientSide && entityIn instanceof Player player) {
            if (isSelected) {

                //倾澜核心判定
                if (player.isFallFlying() && !level.isRaining()) {
                    Vec3 vec = player.getDeltaMovement();
                    double speed = vec.x * vec.x + vec.y * vec.y + vec.z * vec.z;

                    if (speed > .15 && speed < .6 && player.hasEffect(MobEffects.REGENERATION)) {
                        flagChiram = true;
                    }
                }

                //灰音核心判定
                if (!player.getAbilities().flying) {
                    double posY = player.getY();

                    if (posY >= 192 && player.hasEffect(MobEffects.LEVITATION) && player.getAttributeValue(Attributes.ARMOR) >= 20) {
                        boolean flagAir = false;
                        long time = level.getDayTime() % 24000;

                        BlockPos pos = player.getOnPos();
                        if (level.getBlockState(pos).getBlock() instanceof AirBlock &&
                                level.getBlockState(pos.offset(0, -1, 0)).getBlock() instanceof AirBlock) {
                            flagAir = true;
                        }

                        if (time >= 0 && time <= 450 && flagAir) {
                            flagHaine = true;
                        }
                    }
                }

                //蛙吹核心判定
                if (level.isRaining() && player.isInWater()) {
                    boolean flagJump = false;

                    int count = 0;
                    for (MobEffectInstance effect : player.getActiveEffects()) {
                        if (!effect.getEffect().isBeneficial() && effect.getDuration() <= 400) {
                            count++;
                        }
                        if (effect.getDescriptionId().equals(MobEffects.JUMP.getDescriptionId())) {
                            if (effect.getAmplifier() >= 3) {
                                flagJump = true;
                            }
                        }
                    }

                    if (count >= 8 && flagJump) {
                        flagKeroro = true;
                    }
                }

                //星宫颜核心判定
                if (!level.isDay() && !level.isRaining()) {
                    BlockPos pos = player.getOnPos().offset(0, 1, 0);

                    int count = 0;

                    boolean flag1 = level.canSeeSky(pos);
                    boolean flag2 = player.hasEffect(MobEffects.GLOWING);
                    boolean flag3 = !player.getFoodData().needsFood();

                    for (int i = -5; i <= 5; i++) {
                        for (int q = -5; q <= 5; q++) {
                            if (level.getBlockState(pos.offset(i, 0, q)).is(Blocks.BEACON)) {
                                BlockEntity tileEntity = level.getBlockEntity(pos.offset(i, 0, q));
                                if (tileEntity instanceof BeaconBlockEntity) {
                                    Field levels = ObfuscationReflectionHelper.findField(BeaconBlockEntity.class, "f_58650_");
                                    try {
                                        int lvl = levels.getInt(tileEntity);

                                        if (lvl == 4) {
                                            count++;
                                        }
                                    } catch (IllegalAccessException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }
                    }

                    if (count >= 4 && flag1 && flag2 && flag3) {
                        flagEkira = true;
                    }
                }
            }

            if (flagChiram) {
                player.displayClientMessage(Component.translatable("des.dreamaticvoyage.magicros_core.chiram").withStyle(ChatFormatting.ITALIC).withStyle(Style.EMPTY.withColor(0xFFECE7)), true);
                ItemNBTTool.setInt(stack, TAG_CHIRAM, Math.min(ItemNBTTool.getInt(stack, TAG_CHIRAM, 0) + 1, 600));
            } else {
                ItemNBTTool.setInt(stack, TAG_CHIRAM, 0);
            }
            if (ItemNBTTool.getInt(stack, TAG_CHIRAM, 0) >= 600) {
                player.getInventory().setItem(itemSlot, new ItemStack(ItemRegistry.CHIRAM_CORE.get()));
            }

            if (flagHaine) {
                player.displayClientMessage(Component.translatable("des.dreamaticvoyage.magicros_core.haine").withStyle(ChatFormatting.ITALIC).withStyle(Style.EMPTY.withColor(0xADDBFF)), true);
                ItemNBTTool.setInt(stack, TAG_HAINE, Math.min(ItemNBTTool.getInt(stack, TAG_HAINE, 0) + 1, 400));
            } else {
                ItemNBTTool.setInt(stack, TAG_HAINE, 0);
            }
            if (ItemNBTTool.getInt(stack, TAG_HAINE, 0) >= 400) {
                player.getInventory().setItem(itemSlot, new ItemStack(ItemRegistry.HAINE_CORE.get()));
            }

            if (flagKeroro) {
                player.displayClientMessage(Component.translatable("des.dreamaticvoyage.magicros_core.keroro").withStyle(ChatFormatting.ITALIC).withStyle(Style.EMPTY.withColor(0xF5FFEA)), true);
                ItemNBTTool.setInt(stack, TAG_KERORO, Math.min(ItemNBTTool.getInt(stack, TAG_KERORO, 0) + 1, 300));
            } else {
                ItemNBTTool.setInt(stack, TAG_KERORO, 0);
            }
            if (ItemNBTTool.getInt(stack, TAG_KERORO, 0) >= 300) {
                player.getInventory().setItem(itemSlot, new ItemStack(ItemRegistry.KERORO_CORE.get()));
            }

            if (flagEkira) {
                player.displayClientMessage(Component.translatable("des.dreamaticvoyage.magicros_core.ekira").withStyle(ChatFormatting.ITALIC).withStyle(Style.EMPTY.withColor(0xFFF7EA)), true);
                ItemNBTTool.setInt(stack, TAG_EKIRA, Math.min(ItemNBTTool.getInt(stack, TAG_EKIRA, 0) + 1, 1200));
            } else {
                ItemNBTTool.setInt(stack, TAG_EKIRA, 0);
            }
            if (ItemNBTTool.getInt(stack, TAG_EKIRA, 0) >= 1200) {
                player.getInventory().setItem(itemSlot, new ItemStack(ItemRegistry.EKIRA_CORE.get()));
            }

        }
        super.inventoryTick(stack, level, entityIn, itemSlot, isSelected);
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return oldStack != newStack && slotChanged;
    }
}
