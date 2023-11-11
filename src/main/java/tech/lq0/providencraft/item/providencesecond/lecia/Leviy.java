package tech.lq0.providencraft.item.providencesecond.lecia;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.item.UseAction;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.ItemRegistry;
import tech.lq0.providencraft.network.PdcNetwork;
import tech.lq0.providencraft.network.packet.LeviyLaunchPacket;
import tech.lq0.providencraft.render.special.LeviyRenderer;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class Leviy extends Item {
    public Leviy() {
        super(new Properties().group(ModGroup.itemgroup).rarity(Rarity.create("PROVIDENCRAFT_LEGENDARY", TextFormatting.GOLD)).maxStackSize(1));
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        TooltipTool.addDevelopingText(tooltip);
        tooltip.add((new TranslationTextComponent("des.providencraft.leviy_1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("des.providencraft.leviy_2")).mergeStyle(TextFormatting.GRAY).mergeStyle(TextFormatting.ITALIC));
        TooltipTool.addLiverInfo(tooltip, Livers.LECIA);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);

        if (handIn == Hand.MAIN_HAND) {
            playerIn.setActiveHand(handIn);
            return ActionResult.resultConsume(stack);
        } else {
            return ActionResult.resultFail(stack);
        }
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        if (entityLiving instanceof PlayerEntity) {
            PlayerEntity playerIn = (PlayerEntity) entityLiving;

            if (worldIn.isRemote) {
                // 命中方块再发请求
                if (!playerIn.getCooldownTracker().hasCooldown(ItemRegistry.LEVIY.get())) {
                    if (LeviyRenderer.lastHit) {
                        PdcNetwork.CHANNEL.sendToServer(new LeviyLaunchPacket((int) LeviyRenderer.lastX, (int) LeviyRenderer.lastY + 1, (int) LeviyRenderer.lastZ));
                    } else {
                        playerIn.sendStatusMessage(new TranslationTextComponent("des.providencraft.leviy.invalid_select").mergeStyle(TextFormatting.RED), true);
                    }
                }
            }

            playerIn.getCooldownTracker().setCooldown(ItemRegistry.LEVIY.get(), 400);
        }

        return stack;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 40;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.CROSSBOW;
    }
}
