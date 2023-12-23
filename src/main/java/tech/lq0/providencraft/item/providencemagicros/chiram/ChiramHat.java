package tech.lq0.providencraft.item.providencemagicros.chiram;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class ChiramHat extends Item implements ICurioItem {
    public ChiramHat() {
        super(new Properties().stacksTo(1));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("des.providencraft.chiram_hat").withStyle(ChatFormatting.GRAY));

        TooltipTool.addLiverInfo(pTooltipComponents, Livers.CHIRAM);
    }

    @Override
    public boolean canEquip(SlotContext slotContext, ItemStack stack) {
        LivingEntity livingEntity = slotContext.entity();
        AtomicBoolean flag = new AtomicBoolean(true);
        CuriosApi.getCuriosInventory(livingEntity).ifPresent(c -> c.findFirstCurio(this).ifPresent(s -> flag.set(false)));

        return flag.get();
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        LivingEntity entity = slotContext.entity();
//        if (!entity.level().isClientSide) {
//            ((ServerLevel) entity.level()).sendParticles(ParticleTypes.CHERRY_LEAVES,
//                    entity.getX(), entity.getY(), entity.getZ(), 8, 2, 2, 2, 0.1);
//        }

        ICurioItem.super.curioTick(slotContext, stack);
    }
}
