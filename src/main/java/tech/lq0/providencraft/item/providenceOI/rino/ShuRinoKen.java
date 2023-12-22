package tech.lq0.providencraft.item.providenceOI.rino;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.jetbrains.annotations.Nullable;
import tech.lq0.providencraft.entity.projectile.ShuRinoKenEntity;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import java.util.List;

public class ShuRinoKen extends SwordItem {
    public ShuRinoKen() {
        super(Tiers.IRON, 1, -2.0f, new Properties().durability(406));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.providencraft.shu_rino_ken_1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("des.providencraft.shu_rino_ken_2").withStyle(ChatFormatting.GRAY));

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
            ShuRinoKenEntity shuRinoKenEntity = new ShuRinoKenEntity(worldIn, playerIn);
            shuRinoKenEntity.shootFromRotation(playerIn, playerIn.getXRot(), playerIn.getYRot(), 0.0f, 3.0f, 0.2f);
            worldIn.addFreshEntity(shuRinoKenEntity);

            //Second 2
            new Object() {
                private int ticks = 0;
                private float waitTicks;

                public void start(int waitTicks) {
                    this.waitTicks = waitTicks;
                    MinecraftForge.EVENT_BUS.register(this);
                }

                @SubscribeEvent
                public void tick(TickEvent.ServerTickEvent event) {
                    if (event.phase == TickEvent.Phase.END) {
                        this.ticks++;
                        if (this.ticks >= this.waitTicks) {
                            run();
                        }
                    }
                }

                private void run() {
                    ShuRinoKenEntity shuRinoKenEntity1 = new ShuRinoKenEntity(worldIn, playerIn);
                    shuRinoKenEntity1.shootFromRotation(playerIn, playerIn.getXRot(), playerIn.getYRot() - 4.0f, 0.0f, 3.0f, 0.2f);
                    worldIn.addFreshEntity(shuRinoKenEntity1);

                    ShuRinoKenEntity shuRinoKenEntity2 = new ShuRinoKenEntity(worldIn, playerIn);
                    shuRinoKenEntity2.shootFromRotation(playerIn, playerIn.getXRot(), playerIn.getYRot() + 4.0f, 0.0f, 3.0f, 0.2f);
                    worldIn.addFreshEntity(shuRinoKenEntity2);
                    MinecraftForge.EVENT_BUS.unregister(this);
                }
            }.start((int) 3);

            //Third 3
            new Object() {
                private int ticks = 0;
                private float waitTicks;

                public void start(int waitTicks) {
                    this.waitTicks = waitTicks;
                    MinecraftForge.EVENT_BUS.register(this);
                }

                @SubscribeEvent
                public void tick(TickEvent.ServerTickEvent event) {
                    if (event.phase == TickEvent.Phase.END) {
                        this.ticks++;
                        if (this.ticks >= this.waitTicks) {
                            run();
                        }
                    }
                }

                private void run() {
                    ShuRinoKenEntity shuRinoKenEntity1 = new ShuRinoKenEntity(worldIn, playerIn);
                    shuRinoKenEntity1.shootFromRotation(playerIn, playerIn.getXRot(), playerIn.getYRot() - 8.0f, 0.0f, 3.0f, 0.2f);
                    worldIn.addFreshEntity(shuRinoKenEntity1);

                    ShuRinoKenEntity shuRinoKenEntity2 = new ShuRinoKenEntity(worldIn, playerIn);
                    shuRinoKenEntity2.shootFromRotation(playerIn, playerIn.getXRot(), playerIn.getYRot() + 8.0f, 0.0f, 3.0f, 0.2f);
                    worldIn.addFreshEntity(shuRinoKenEntity2);

                    ShuRinoKenEntity shuRinoKenEntity3 = new ShuRinoKenEntity(worldIn, playerIn);
                    shuRinoKenEntity3.shootFromRotation(playerIn, playerIn.getXRot(), playerIn.getYRot(), 0.0f, 3.0f, 0.2f);
                    worldIn.addFreshEntity(shuRinoKenEntity3);
                    MinecraftForge.EVENT_BUS.unregister(this);
                }
            }.start((int) 6);

            //Fourth 2
            new Object() {
                private int ticks = 0;
                private float waitTicks;

                public void start(int waitTicks) {
                    this.waitTicks = waitTicks;
                    MinecraftForge.EVENT_BUS.register(this);
                }

                @SubscribeEvent
                public void tick(TickEvent.ServerTickEvent event) {
                    if (event.phase == TickEvent.Phase.END) {
                        this.ticks++;
                        if (this.ticks >= this.waitTicks) {
                            run();
                        }
                    }
                }

                private void run() {
                    ShuRinoKenEntity shuRinoKenEntity1 = new ShuRinoKenEntity(worldIn, playerIn);
                    shuRinoKenEntity1.shootFromRotation(playerIn, playerIn.getXRot(), playerIn.getYRot() - 4.0f, 0.0f, 3.0f, 0.2f);
                    worldIn.addFreshEntity(shuRinoKenEntity1);

                    ShuRinoKenEntity shuRinoKenEntity2 = new ShuRinoKenEntity(worldIn, playerIn);
                    shuRinoKenEntity2.shootFromRotation(playerIn, playerIn.getXRot(), playerIn.getYRot() + 4.0f, 0.0f, 3.0f, 0.2f);
                    worldIn.addFreshEntity(shuRinoKenEntity2);

                    MinecraftForge.EVENT_BUS.unregister(this);
                }
            }.start((int) 9);

            //Fifth 1
            new Object() {
                private int ticks = 0;
                private float waitTicks;

                public void start(int waitTicks) {
                    this.waitTicks = waitTicks;
                    MinecraftForge.EVENT_BUS.register(this);
                }

                @SubscribeEvent
                public void tick(TickEvent.ServerTickEvent event) {
                    if (event.phase == TickEvent.Phase.END) {
                        this.ticks++;
                        if (this.ticks >= this.waitTicks) {
                            run();
                        }
                    }
                }

                private void run() {
                    ShuRinoKenEntity shuRinoKenEntity = new ShuRinoKenEntity(worldIn, playerIn);
                    shuRinoKenEntity.shootFromRotation(playerIn, playerIn.getXRot(), playerIn.getYRot(), 0.0f, 3.0f, 0.2f);
                    worldIn.addFreshEntity(shuRinoKenEntity);

                    MinecraftForge.EVENT_BUS.unregister(this);
                }
            }.start((int) 12);

            item.hurtAndBreak(10, playerIn, (playerEntity) -> playerEntity.broadcastBreakEvent(handIn));
            playerIn.getCooldowns().addCooldown(item.getItem(), 30);
        }

        return InteractionResultHolder.success(item);
    }
}
