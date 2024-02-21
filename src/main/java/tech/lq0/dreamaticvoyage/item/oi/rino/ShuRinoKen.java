package tech.lq0.dreamaticvoyage.item.oi.rino;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.entity.projectile.ShuRinoKenEntity;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import java.util.List;

public class ShuRinoKen extends SwordItem {
    public ShuRinoKen() {
        super(Tiers.IRON, 1, -2.0f, new Properties().durability(406));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.shu_rino_ken_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.shu_rino_ken_2").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.RINO);
    }

    @Override
    public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
        return repair.getItem() == Items.DIAMOND;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack item = playerIn.getItemInHand(handIn);
        if (!worldIn.isClientSide) {
            //First 1
            ShuRinoKenEntity shu1 = new ShuRinoKenEntity(worldIn, playerIn);
            shu1.shootFromRotation(playerIn, playerIn.getXRot(), playerIn.getYRot(), 0.0f, 3.0f, 0.2f);
            worldIn.addFreshEntity(shu1);

            //Second 2
            new Object() {
                private int ticks = 0;

                public void start() {
                    MinecraftForge.EVENT_BUS.register(this);
                }

                @SubscribeEvent
                public void tick(TickEvent.ServerTickEvent event) {
                    if (event.phase == TickEvent.Phase.END) {
                        this.ticks++;
                        if (this.ticks == 3) {
                            run1();
                        }
                        if (this.ticks == 6) {
                            run2();
                        }
                        if (this.ticks == 9) {
                            run3();
                        }
                        if (this.ticks == 12) {
                            run4();
                        }
                    }
                }

                private void run1() {
                    ShuRinoKenEntity shu2 = new ShuRinoKenEntity(worldIn, playerIn);
                    shu2.shootFromRotation(playerIn, playerIn.getXRot(), playerIn.getYRot() - 4.0f, 0.0f, 3.0f, 0.2f);
                    worldIn.addFreshEntity(shu2);

                    ShuRinoKenEntity shu3 = new ShuRinoKenEntity(worldIn, playerIn);
                    shu3.shootFromRotation(playerIn, playerIn.getXRot(), playerIn.getYRot() + 4.0f, 0.0f, 3.0f, 0.2f);
                    worldIn.addFreshEntity(shu3);
                }

                private void run2() {
                    ShuRinoKenEntity shu4 = new ShuRinoKenEntity(worldIn, playerIn);
                    shu4.shootFromRotation(playerIn, playerIn.getXRot(), playerIn.getYRot() - 8.0f, 0.0f, 3.0f, 0.2f);
                    worldIn.addFreshEntity(shu4);

                    ShuRinoKenEntity shu5 = new ShuRinoKenEntity(worldIn, playerIn);
                    shu5.shootFromRotation(playerIn, playerIn.getXRot(), playerIn.getYRot() + 8.0f, 0.0f, 3.0f, 0.2f);
                    worldIn.addFreshEntity(shu5);

                    ShuRinoKenEntity shu6 = new ShuRinoKenEntity(worldIn, playerIn);
                    shu6.shootFromRotation(playerIn, playerIn.getXRot(), playerIn.getYRot(), 0.0f, 3.0f, 0.2f);
                    worldIn.addFreshEntity(shu6);
                }

                private void run3() {
                    ShuRinoKenEntity shu7 = new ShuRinoKenEntity(worldIn, playerIn);
                    shu7.shootFromRotation(playerIn, playerIn.getXRot(), playerIn.getYRot() - 4.0f, 0.0f, 3.0f, 0.2f);
                    worldIn.addFreshEntity(shu7);

                    ShuRinoKenEntity shu8 = new ShuRinoKenEntity(worldIn, playerIn);
                    shu8.shootFromRotation(playerIn, playerIn.getXRot(), playerIn.getYRot() + 4.0f, 0.0f, 3.0f, 0.2f);
                    worldIn.addFreshEntity(shu8);
                }

                private void run4() {
                    ShuRinoKenEntity shu9 = new ShuRinoKenEntity(worldIn, playerIn);
                    shu9.shootFromRotation(playerIn, playerIn.getXRot(), playerIn.getYRot(), 0.0f, 3.0f, 0.2f);
                    worldIn.addFreshEntity(shu9);

                    MinecraftForge.EVENT_BUS.unregister(this);
                }
            }.start();

            item.hurtAndBreak(10, playerIn, (playerEntity) -> playerEntity.broadcastBreakEvent(handIn));
            playerIn.getCooldowns().addCooldown(item.getItem(), 30);
        }

        return InteractionResultHolder.success(item);
    }
}
