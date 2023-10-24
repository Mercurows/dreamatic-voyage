package tech.lq0.providencraft.item.providencesecond.lecia;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.stats.Stats;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.ItemRegistry;
import tech.lq0.providencraft.tools.ItemNBTTool;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class Kuleboh extends Item {
    public static final String TAG_LOCKED = "locked";
    public static final String TAG_TOTEM_COUNT = "totem_count";
    public static final String TAG_NOW_COUNT = "now_count";

    private static final Food food = new Food.Builder().hunger(5).saturation(0.5f)
            .effect(() -> new EffectInstance(Effects.ABSORPTION, 600, 1), 1.0f)
            .setAlwaysEdible().build();

    public Kuleboh() {
        super(new Properties().group(ModGroup.itemgroup).maxStackSize(1).rarity(Rarity.UNCOMMON).food(food));
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("des.providencraft.kuleboh")).mergeStyle(TextFormatting.GRAY));
        TooltipTool.addLiverInfo(tooltip, Livers.LECIA);
    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (entityIn instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entityIn;

            if (!worldIn.isRemote) {
                ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player;
                int count = serverPlayer.getStats().getValue(Stats.ITEM_USED.get(Items.TOTEM_OF_UNDYING));

                if (itemSlot != 0) {
                    setLocked(stack, false);
                }

                //初始化并赋值
                if (!isLocked(stack)) {
                    setTotemCount(stack, count + 5);
                    setNowCount(stack, count);
                    setLocked(stack, true);
                } else {
                    if (itemSlot == 0) {
                        setNowCount(stack, count);

                        if (getNowCount(stack) >= getTotemCount(stack)) {
                            player.setItemStackToSlot(EquipmentSlotType.OFFHAND, new ItemStack(ItemRegistry.KULECIABOH.get()));
                        }
                    }
                }
            }
        }
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return oldStack != newStack && slotChanged;
    }

    public static void setTotemCount(ItemStack stack, int count) {
        ItemNBTTool.setInt(stack, TAG_TOTEM_COUNT, count);
    }

    public static int getTotemCount(ItemStack stack) {
        return ItemNBTTool.getInt(stack, TAG_TOTEM_COUNT, 0);
    }

    public static void setLocked(ItemStack stack, boolean flag) {
        ItemNBTTool.setBoolean(stack, TAG_LOCKED, flag);
    }

    public static boolean isLocked(ItemStack stack) {
        return ItemNBTTool.getBoolean(stack, TAG_LOCKED, false);
    }

    public static void setNowCount(ItemStack stack, int count) {
        ItemNBTTool.setInt(stack, TAG_NOW_COUNT, count);
    }

    public static int getNowCount(ItemStack stack) {
        return ItemNBTTool.getInt(stack, TAG_NOW_COUNT, 0);
    }
}
