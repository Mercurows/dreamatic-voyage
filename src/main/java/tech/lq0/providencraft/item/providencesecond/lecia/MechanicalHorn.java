package tech.lq0.providencraft.item.providencesecond.lecia;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.text.*;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.ItemRegistry;
import tech.lq0.providencraft.tools.ItemNBTTool;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class MechanicalHorn extends Item {
    public static final String TAG_TIME = "time";
    public static final String TAG_COUNT = "count";
    public static final String TAG_NETHER = "nether";
    public static final String TAG_END = "end";

    public MechanicalHorn() {
        super(new Properties().group(ModGroup.itemgroup));
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("des.providencraft.mechanical_horn_1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("des.providencraft.mechanical_horn_2")).mergeStyle(TextFormatting.GRAY).mergeStyle(TextFormatting.STRIKETHROUGH));
        TooltipTool.addLiverInfo(tooltip, Livers.LECIA);
    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (!worldIn.isRemote && entityIn instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entityIn;

            int time = getTagTime(stack);
            int count = getTagCount(stack);

            boolean nether = getTagNether(stack);
            boolean end = getTagEnd(stack);

            if (isSelected && stack.getCount() == 1) {
                if (count > 0) {
                    if (player.ticksExisted % 20 == 0) {
                        setTagTime(stack, ++time);
                    }
                }

                if (nether && end && count >= 5) {
                    player.replaceItemInInventory(itemSlot, new ItemStack(ItemRegistry.TURBULENCE_AMBER.get()));
                }
            } else {
                resetTags(stack);
                if (count >= 1) {
                    player.sendStatusMessage(new TranslationTextComponent("des.providencraft.mechanical_horn.fail").mergeStyle(TextFormatting.ITALIC).mergeStyle(TextFormatting.RED), true);
                }
            }

            if (time > 60) {
                resetTags(stack);
                player.sendStatusMessage(new TranslationTextComponent("des.providencraft.mechanical_horn.fail").mergeStyle(TextFormatting.ITALIC).mergeStyle(TextFormatting.RED), true);
            }

        }
    }

    @SubscribeEvent
    public static void traverseEvent(PlayerEvent.PlayerChangedDimensionEvent event) {
        PlayerEntity player = event.getPlayer();

        if (player == null) {
            return;
        }

        RegistryKey<World> keyFrom = event.getFrom();
        RegistryKey<World> keyTo = event.getTo();

        ItemStack stack = player.getHeldItemMainhand();
        if (stack.getItem() == ItemRegistry.MECHANICAL_HORN.get() && stack.getCount() == 1) {
            if (!player.world.isRemote) {
                setTagCount(stack, getTagCount(stack) + 1);

                if ((keyFrom == World.OVERWORLD && keyTo == World.THE_NETHER) || (keyFrom == World.THE_NETHER && keyTo == World.OVERWORLD)) {
                    setTagNether(stack, true);
                }

                if ((keyFrom == World.OVERWORLD && keyTo == World.THE_END) || (keyFrom == World.THE_END && keyTo == World.OVERWORLD)) {
                    setTagEnd(stack, true);
                }

                int count = getTagCount(stack);

                switch (count) {
                    case 1:
                        player.sendStatusMessage(new TranslationTextComponent("des.providencraft.mechanical_horn.count_1").mergeStyle(TextFormatting.ITALIC).mergeStyle(Style.EMPTY.setColor(Color.fromHex("#C0E7FE"))), true);
                        break;
                    case 2:
                        player.sendStatusMessage(new TranslationTextComponent("des.providencraft.mechanical_horn.count_2").mergeStyle(TextFormatting.ITALIC).mergeStyle(Style.EMPTY.setColor(Color.fromHex("#C0E7FE"))), true);
                        break;
                    case 3:
                        player.sendStatusMessage(new TranslationTextComponent("des.providencraft.mechanical_horn.count_3").mergeStyle(TextFormatting.ITALIC).mergeStyle(Style.EMPTY.setColor(Color.fromHex("#C0E7FE"))), true);
                        break;
                    case 4:
                        player.sendStatusMessage(new TranslationTextComponent("des.providencraft.mechanical_horn.count_4").mergeStyle(TextFormatting.ITALIC).mergeStyle(Style.EMPTY.setColor(Color.fromHex("#C0E7FE"))), true);
                        break;
                    default:
                        if (!getTagNether(stack)) {
                            player.sendStatusMessage(new TranslationTextComponent("des.providencraft.mechanical_horn.nether").mergeStyle(TextFormatting.ITALIC).mergeStyle(Style.EMPTY.setColor(Color.fromHex("#C0E7FE"))), true);
                        } else if (!getTagEnd(stack)) {
                            player.sendStatusMessage(new TranslationTextComponent("des.providencraft.mechanical_horn.end").mergeStyle(TextFormatting.ITALIC).mergeStyle(Style.EMPTY.setColor(Color.fromHex("#C0E7FE"))), true);
                        } else {
                            player.sendStatusMessage(new TranslationTextComponent("des.providencraft.mechanical_horn.count_5").mergeStyle(TextFormatting.ITALIC).mergeStyle(Style.EMPTY.setColor(Color.fromHex("#C0E7FE"))), true);
                        }
                        break;
                }
            }
        }

    }

    public static void resetTags(ItemStack stack) {
        setTagTime(stack, 0);
        setTagCount(stack, 0);
        setTagNether(stack, false);
        setTagEnd(stack, false);
    }

    public static void setTagTime(ItemStack stack, int time) {
        ItemNBTTool.setInt(stack, TAG_TIME, time);
    }

    public static int getTagTime(ItemStack stack) {
        return ItemNBTTool.getInt(stack, TAG_TIME, 0);
    }

    public static void setTagCount(ItemStack stack, int count) {
        ItemNBTTool.setInt(stack, TAG_COUNT, count);
    }

    public static int getTagCount(ItemStack stack) {
        return ItemNBTTool.getInt(stack, TAG_COUNT, 0);
    }

    public static void setTagNether(ItemStack stack, boolean nether) {
        ItemNBTTool.setBoolean(stack, TAG_NETHER, nether);
    }

    public static boolean getTagNether(ItemStack stack) {
        return ItemNBTTool.getBoolean(stack, TAG_NETHER, false);
    }

    public static void setTagEnd(ItemStack stack, boolean end) {
        ItemNBTTool.setBoolean(stack, TAG_END, end);
    }

    public static boolean getTagEnd(ItemStack stack) {
        return ItemNBTTool.getBoolean(stack, TAG_END, false);
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return oldStack != newStack && slotChanged;
    }

}
