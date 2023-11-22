package tech.lq0.providencraft.item.providenceOI.shirako;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;
import tech.lq0.providencraft.entity.projectile.DaifukuSyrupEntity;
import tech.lq0.providencraft.init.ItemRegistry;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import java.util.List;

public class MomoGun extends Item {
    public MomoGun() {
        super(new Properties().durability(1540));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player playerIn, InteractionHand pUsedHand) {
        ItemStack itemstack = playerIn.getItemInHand(pUsedHand);

        if (!pLevel.isClientSide) {
            boolean flag2 = playerIn.isCreative() || EnchantmentHelper.getTagEnchantmentLevel(Enchantments.INFINITY_ARROWS, itemstack) > 0;
            ItemStack ammo = this.findAmmo(playerIn);

            if (!ammo.isEmpty() || flag2) {
                if (ammo.isEmpty()) {
                    ammo = new ItemStack(ItemRegistry.DAIFUKU_SYRUP.get());
                }

                boolean flag1 = playerIn.isCreative() || (ammo.getItem() instanceof DaifukuSyrup &&
                        ((DaifukuSyrup) ammo.getItem()).isInfinite(itemstack));

                DaifukuSyrup syrup = (DaifukuSyrup) (ammo.getItem() instanceof DaifukuSyrup ? ammo.getItem() : ItemRegistry.DAIFUKU_SYRUP.get());

                DaifukuSyrupEntity syrupEntity = syrup.createArrow(pLevel, playerIn);
                syrupEntity.shootFromRotation(playerIn, playerIn.getXRot(), playerIn.getYRot(), 0.0F, 4.0F, 0.2F);

                itemstack.hurtAndBreak(1, playerIn, (playerEntity) -> playerEntity.broadcastBreakEvent(pUsedHand));
                pLevel.addFreshEntity(syrupEntity);

                if (!flag1 && !playerIn.isCreative()) {
                    ammo.shrink(1);

                    if (ammo.isEmpty()) {
                        playerIn.getInventory().removeItem(ammo);
                    }
                }

                playerIn.getCooldowns().addCooldown(itemstack.getItem(), 8);
                playerIn.startUsingItem(pUsedHand);
                return InteractionResultHolder.success(itemstack);
            } else {
                return InteractionResultHolder.fail(itemstack);
            }
        }
        return InteractionResultHolder.fail(itemstack);
    }

    protected ItemStack findAmmo(Player player) {
        if (this.check(player.getItemInHand(InteractionHand.OFF_HAND))) {
            return player.getItemInHand(InteractionHand.OFF_HAND);
        } else if (this.check(player.getItemInHand(InteractionHand.MAIN_HAND))) {
            return player.getItemInHand(InteractionHand.MAIN_HAND);
        } else {
            for (int i = 0; i < player.getInventory().getContainerSize(); ++i) {
                ItemStack itemstack = player.getInventory().getItem(i);
                if (this.check(itemstack)) {
                    return itemstack;
                }
            }
            return ItemStack.EMPTY;
        }
    }

    protected boolean check(ItemStack stack) {
        return stack.getItem() instanceof DaifukuSyrup;
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        tooltip.add(Component.translatable("des.providencraft.momo_gun.func").withStyle(ChatFormatting.AQUA));
        tooltip.add(Component.translatable("des.providencraft.momo_gun").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(tooltip, Livers.SHIRAKO);
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return enchantment == Enchantments.INFINITY_ARROWS || enchantment == Enchantments.MENDING || enchantment == Enchantments.UNBREAKING;
    }
}
