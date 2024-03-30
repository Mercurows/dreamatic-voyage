package tech.lq0.dreamaticvoyage.item.oi.miya;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.dreamaticvoyage.entity.projectile.TetrisIBlockEntity;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;
import tech.lq0.dreamaticvoyage.tools.ItemNBTTool;
import tech.lq0.dreamaticvoyage.tools.Livers;
import tech.lq0.dreamaticvoyage.tools.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class TetrisCat extends ShieldItem {
    public static final String TAG_TETRIS_ENERGY = "tetris_energy";
    public static final String TAG_TETRIS_BLOCK = "tetris_block";
    public TetrisCat(){
        super(new Properties().stacksTo(1).rarity(Rarity.EPIC));
    }

    @SubscribeEvent
    public static void TetrisPowerIncrease(LivingDamageEvent e){
        Entity entity = e.getSource().getEntity();
        LivingEntity target = e.getEntity();
        if (entity instanceof Player player&& !entity.level().isClientSide()){
            ItemStack offhand = player.getItemBySlot(EquipmentSlot.OFFHAND);
            ItemStack mainhand = player.getItemBySlot(EquipmentSlot.MAINHAND);
            if (!offhand.isEmpty() && offhand.getItem().equals(ItemRegistry.TETRIS_CAT.get()) && mainhand.getItem().equals(ItemRegistry.TAIL_PEN.get())){
                setTetrisEnergy(offhand, getTetrisEnergy(offhand) + Math.min(target.getHealth(), e.getAmount()));
            }
        }
    }

    private static float getTetrisEnergy(ItemStack stack) {
        return ItemNBTTool.getFloat(stack, TAG_TETRIS_ENERGY, 0.0f );
    }

    private static void setTetrisEnergy(ItemStack stack, float num) {
        ItemNBTTool.setFloat(stack, TAG_TETRIS_ENERGY, Math.min(num, 300.0f));
    }

    private static int getTetrisBlock(ItemStack stack) {
        return ItemNBTTool.getInt(stack, TAG_TETRIS_BLOCK, 0 );
    }

    private static void setTetrisBlock(ItemStack stack, int num) {
        ItemNBTTool.setInt(stack, TAG_TETRIS_BLOCK, num);
    }

//    @Override
    public boolean isShield(@Nullable LivingEntity entity) {
        if (entity != null) {
            if (entity instanceof Player player && !entity.level().isClientSide()) {
                ItemStack offhand = player.getItemBySlot(EquipmentSlot.OFFHAND);
                if (!offhand.isEmpty() && offhand.getItem().equals(ItemRegistry.TETRIS_CAT.get()) ){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand){
        ItemStack item = pPlayer.getItemInHand(pHand);
        if (isShield(pPlayer)) {
            pPlayer.startUsingItem(pHand);
            return InteractionResultHolder.consume(item);
        } else {
            if (getTetrisEnergy(item) >= 20){
                pLevel.playSound(null, pPlayer.getOnPos(), SoundEvents.SNOWBALL_THROW, SoundSource.NEUTRAL, 0.5F, 0.4F / (pLevel.random.nextFloat() * 0.4F + 0.8F));
                if( !pLevel.isClientSide()) {
                    TetrisIBlockEntity tetrisIBlockEntity = new TetrisIBlockEntity(pLevel, pPlayer);
                    tetrisIBlockEntity.shootFromRotation(pPlayer, pPlayer.getRotationVector().x, pPlayer.getRotationVector().y, 0.0f, 1.0f, 0.2f);
                    pLevel.addFreshEntity(tetrisIBlockEntity);
                    setTetrisBlock(item, (int) (Math.random() * 7));
                }
                setTetrisEnergy(item, Math.max(getTetrisEnergy(item) - 20, 0));
                pPlayer.getCooldowns().addCooldown(item.getItem(), 100);
                return new InteractionResultHolder<>(InteractionResult.SUCCESS, item);
            }
            return new InteractionResultHolder<>(InteractionResult.FAIL, item);
        }
    }
    @Override
    public void releaseUsing(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity, int pTimeCharged){
        if(!pLevel.isClientSide()){
            setTetrisBlock(pStack, (int)(Math.random()*7));
        }
    }

    @Override
    public void appendHoverText(ItemStack pStack, @org.jetbrains.annotations.Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced){
        TooltipTool.addDevelopingText(pTooltipComponents);

        //pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.tetris_cat_1").withStyle(ChatFormatting.GRAY));
        //pTooltipComponents.add(Component.translatable("des.dreamaticvoyage.tetris_cat_2").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));

        pTooltipComponents.add(Component.literal("Tetris energy: " + getTetrisEnergy(pStack)));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.MIYA);
    }


}
