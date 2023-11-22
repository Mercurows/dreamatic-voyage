package tech.lq0.providencraft.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.Merchant;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;
import tech.lq0.providencraft.client.gui.PointsStoreMenu;
import tech.lq0.providencraft.init.BlockEntityRegistry;
import tech.lq0.providencraft.init.ItemRegistry;

import java.util.Collections;
import java.util.OptionalInt;

public class PointsStoreBlockEntity extends BlockEntity implements Merchant {
    Player customer = null;
    MerchantOffers merchantOffers = null;

    public PointsStoreBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(BlockEntityRegistry.POINTS_STORE_BLOCK_ENTITY.get(), pPos, pBlockState);
    }

    @Override
    public void setTradingPlayer(@Nullable Player pTradingPlayer) {
        this.customer = pTradingPlayer;
    }

    @Nullable
    @Override
    public Player getTradingPlayer() {
        return this.customer;
    }

    @Override
    public MerchantOffers getOffers() {
        if (merchantOffers == null) {
            addOffers();
        }
        return merchantOffers;
    }

    @Nullable
    @Override
    public Level getLevel() {
        return this.level;
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void overrideOffers(MerchantOffers pOffers) {
        this.merchantOffers = pOffers;
    }

    public void openGui(Player player) {
        setTradingPlayer(player);
        Component name = Component.translatable("block.providencraft.points_store");
        this.openTradingScreen(player, name, 5);
    }

    @Override
    public void openTradingScreen(Player player, Component pDisplayName, int pLevel) {
        OptionalInt optionalint = player.openMenu(new SimpleMenuProvider((id, playerInventory, player2)
                -> new PointsStoreMenu(id, playerInventory, this), pDisplayName));
        if (optionalint.isPresent()) {
            MerchantOffers merchantoffers = this.getOffers();
            if (!merchantoffers.isEmpty()) {
                player.sendMerchantOffers(optionalint.getAsInt(), merchantoffers, pLevel, this.getVillagerXp(), this.showProgressBar(), this.canRestock());
            }
        }
    }

    @Override
    public void notifyTrade(MerchantOffer pOffer) {
        pOffer.resetUses();
    }

    @Override
    public void notifyTradeUpdated(ItemStack pStack) {
    }

    @Override
    public int getVillagerXp() {
        return 0;
    }

    @Override
    public void overrideXp(int pXp) {
    }

    @Override
    public boolean showProgressBar() {
        return false;
    }

    @Override
    public SoundEvent getNotifyTradeSound() {
        return null;
    }

    @Override
    public boolean isClientSide() {
        if (level != null) {
            return level.isClientSide;
        }
        return false;
    }

    private void addOffers() {
        merchantOffers = new MerchantOffers();
        Collections.addAll(merchantOffers, offers);
    }

    private static final MerchantOffer[] offers = {
            new MerchantOffer(getGoods(Items.EMERALD, 10), getPoints(1), 10000, 0, 0),
            new MerchantOffer(getPoints(64), getPremiumPoints(1), 10000, 0, 0),
            new MerchantOffer(getPremiumPoints(1), getPoints(64), 10000, 0, 0),
//            new MerchantOffer(getPoints(2), getGoods(ItemRegistry.GN_SOUL.get(), 1), 10000, 0, 0),
//            new MerchantOffer(getPoints(2), getGoods(ItemRegistry.GN_SPIRIT.get(), 1), 10000, 0, 0),
//            new MerchantOffer(getPoints(2), getGoods(ItemRegistry.EKIRA_PEARL.get(), 1), 10000, 0, 0),
            new MerchantOffer(getPoints(6), getGoods(ItemRegistry.PEACH_BEACH.get(), 1), 10000, 0, 0),
            new MerchantOffer(getPoints(6), getGoods(ItemRegistry.RABBIT_LYCHEE.get(), 8), 10000, 0, 0),
            new MerchantOffer(getPoints(6), getGoods(ItemRegistry.CRAFT_BEER_0322.get(), 1), 10000, 0, 0),
//            new MerchantOffer(getPoints(10), getGoods(ItemRegistry.MOON_CAKE.get(), 8), 10000, 0, 0),
//            new MerchantOffer(getPoints(18), getGoods(ItemRegistry.KURUMI_BOOMERANG.get(), 4), 10000, 0, 0),
//            new MerchantOffer(getPoints(18), getGoods(ItemRegistry.MAGIC_TEAPOT.get(), 1), 10000, 0, 0),
//            new MerchantOffer(getPoints(25), getGoods(ItemRegistry.MAGIC_MIRROR.get(), 1), 10000, 0, 0),
//            new MerchantOffer(getPoints(25), getGoods(ItemRegistry.GOOD_MAN_CARD.get(), 1), 10000, 0, 0),
//            new MerchantOffer(getPoints(28), getGoods(ItemRegistry.FOX_FAIRY_FAN.get(), 1), 10000, 0, 0),
//            new MerchantOffer(getPoints(35), getGoods(ItemRegistry.GRAVITY_RESTRAINT_DEVICE.get(), 1), 10000, 0, 0),
//            new MerchantOffer(getPoints(38), getGoods(ItemRegistry.KURUMI_HALO.get(), 1), 10000, 0, 0),
//            new MerchantOffer(getPoints(38), getGoods(ItemRegistry.JELLYFISH_SHELL.get(), 1), 10000, 0, 0),
//            new MerchantOffer(getPoints(38), getGoods(ItemRegistry.SATOU_CAMERA.get(), 1), 10000, 0, 0),
//            new MerchantOffer(getPoints(38), getGoods(ItemRegistry.CLARITY_AMULET.get(), 1), 10000, 0, 0),
//            new MerchantOffer(getPoints(58), getGoods(ItemRegistry.QIANYUN_HOE.get(), 1), 10000, 0, 0),
//            new MerchantOffer(getPremiumPoints(1), getPoints(4), getGoods(ItemRegistry.MOMO_GUN.get(), 1), 10000, 0, 0),
//            new MerchantOffer(getPremiumPoints(1), getPoints(4), getGoods(ItemRegistry.DUEL_WATER_GUN.get(), 1), 10000, 0, 0),
//            new MerchantOffer(getPremiumPoints(1), getPoints(4), getGoods(ItemRegistry.BLUE_SMALL_BALL.get(), 1), 10000, 0, 0),
//            new MerchantOffer(getPremiumPoints(1), getPoints(4), getGoods(ItemRegistry.FIAXE.get(), 1), 10000, 0, 0),
//            new MerchantOffer(getPremiumPoints(10), getPoints(8), getGoods(ItemRegistry.HAYA_SWORD.get(), 1), 10000, 0, 0),
//            new MerchantOffer(getPremiumPoints(10), getPoints(8), getGoods(ItemRegistry.LUNAR_ECLIPSE.get(), 1), 10000, 0, 0),
//            new MerchantOffer(getPremiumPoints(25), getGoods(ItemRegistry.KRM_963_53.get(), 1), 10000, 0, 0),
//            new MerchantOffer(getPoints(28), getGoods(ItemRegistry.FLUFF_BALL.get(), 1), 10000, 0, 0),
            new MerchantOffer(getPremiumPoints(64), getPremiumPoints(64), getGoods(ItemRegistry.FETUOZI.get(), 1), 10000, 0, 0),
//            new MerchantOffer(getPoints(28), getGoods(ItemRegistry.AUDIO_TAPE_HAINE_1.get(), 1), 10000, 0, 0),
//            new MerchantOffer(getPoints(28), getGoods(ItemRegistry.AUDIO_TAPE_HAINE_2.get(), 1), 10000, 0, 0),
//            new MerchantOffer(getPoints(28), getGoods(ItemRegistry.AUDIO_TAPE_HAINE_3.get(), 1), 10000, 0, 0),
//            new MerchantOffer(getPoints(28), getGoods(ItemRegistry.AUDIO_TAPE_CHIRAM_1.get(), 1),10000, 0, 0),
//            new MerchantOffer(getPoints(28), getGoods(ItemRegistry.AUDIO_TAPE_CHIRAM_2.get(), 1),10000, 0, 0),
//            new MerchantOffer(getPoints(28), getGoods(ItemRegistry.AUDIO_TAPE_CHIRAM_3.get(), 1),10000, 0, 0),
//            new MerchantOffer(getPoints(28), getGoods(ItemRegistry.AUDIO_TAPE_EKIRA_1.get(), 1), 10000, 0, 0),
//            new MerchantOffer(getPoints(28), getGoods(ItemRegistry.AUDIO_TAPE_EKIRA_2.get(), 1), 10000, 0, 0),
//            new MerchantOffer(getPoints(28), getGoods(ItemRegistry.AUDIO_TAPE_EKIRA_3.get(), 1), 10000, 0, 0),
//            new MerchantOffer(getPoints(28), getGoods(ItemRegistry.AUDIO_TAPE_KERORO_1.get(), 1),10000, 0, 0),
//            new MerchantOffer(getPoints(28), getGoods(ItemRegistry.AUDIO_TAPE_KERORO_2.get(), 1),10000, 0, 0),
//            new MerchantOffer(getPoints(28), getGoods(ItemRegistry.AUDIO_TAPE_KERORO_3.get(), 1),10000, 0, 0),
//            new MerchantOffer(getPoints(28), getGoods(ItemRegistry.AUDIO_TAPE_FUKAMIZU_1.get(), 1),10000, 0, 0),
//            new MerchantOffer(getPoints(28), getGoods(ItemRegistry.AUDIO_TAPE_FUKAMIZU_2.get(), 1),10000, 0, 0),
//            new MerchantOffer(getPoints(28), getGoods(ItemRegistry.AUDIO_TAPE_FUKAMIZU_3.get(), 1),10000, 0, 0),
//            new MerchantOffer(getPoints(28), getGoods(ItemRegistry.AUDIO_TAPE_FUKAMIZU_4.get(), 1),10000, 0, 0),
//            new MerchantOffer(getPoints(38), getGoods(ItemRegistry.AUDIO_TAPE_FUKAMIZU_5.get(), 1),10000, 0, 0),
//            new MerchantOffer(getPoints(38), getGoods(ItemRegistry.AUDIO_TAPE_FUKAMIZU_6.get(), 1),10000, 0, 0),
//            new MerchantOffer(getPoints(28), getGoods(ItemRegistry.AUDIO_TAPE_LOUISE_1.get(), 1),10000, 0, 0),
//            new MerchantOffer(getPoints(28), getGoods(ItemRegistry.AUDIO_TAPE_LOUISE_2.get(), 1),10000, 0, 0),
//            new MerchantOffer(getPoints(28), getGoods(ItemRegistry.AUDIO_TAPE_LOUISE_3.get(), 1),10000, 0, 0),
//            new MerchantOffer(getPoints(28), getGoods(ItemRegistry.AUDIO_TAPE_MADOKA_1.get(), 1),10000, 0, 0),
//            new MerchantOffer(getPoints(28), getGoods(ItemRegistry.AUDIO_TAPE_MADOKA_2.get(), 1),10000, 0, 0),
//            new MerchantOffer(getPoints(28), getGoods(ItemRegistry.AUDIO_TAPE_MADOKA_3.get(), 1),10000, 0, 0),
//            new MerchantOffer(getPoints(28), getGoods(ItemRegistry.AUDIO_TAPE_MUMU_1.get(), 1),10000, 0, 0),
//            new MerchantOffer(getPoints(28), getGoods(ItemRegistry.AUDIO_TAPE_MUMU_2.get(), 1),10000, 0, 0),
//            new MerchantOffer(getPoints(28), getGoods(ItemRegistry.AUDIO_TAPE_MUMU_3.get(), 1),10000, 0, 0),
//            new MerchantOffer(getPoints(28), getGoods(ItemRegistry.AUDIO_TAPE_QIANYUN_1.get(), 1),10000, 0, 0),
//            new MerchantOffer(getPoints(28), getGoods(ItemRegistry.AUDIO_TAPE_QIANYUN_2.get(), 1),10000, 0, 0),
//            new MerchantOffer(getPoints(28), getGoods(ItemRegistry.AUDIO_TAPE_QIANYUN_3.get(), 1),10000, 0, 0),
//            new MerchantOffer(getPoints(28), getGoods(ItemRegistry.AUDIO_TAPE_UNIA_1.get(), 1),10000, 0, 0),
//            new MerchantOffer(getPoints(28), getGoods(ItemRegistry.AUDIO_TAPE_UNIA_2.get(), 1),10000, 0, 0),
//            new MerchantOffer(getPoints(28), getGoods(ItemRegistry.AUDIO_TAPE_UNIA_3.get(), 1),10000, 0, 0),
//            new MerchantOffer(getPoints(28), getGoods(ItemRegistry.AUDIO_TAPE_USA_1.get(), 1), 10000, 0, 0),
//            new MerchantOffer(getPoints(28), getGoods(ItemRegistry.AUDIO_TAPE_USA_2.get(), 1), 10000, 0, 0),
//            new MerchantOffer(getPoints(28), getGoods(ItemRegistry.AUDIO_TAPE_USA_3.get(), 1), 10000, 0, 0)
    };

    private static ItemStack getPoints(int count) {
        ItemStack points = new ItemStack(ItemRegistry.PDC_POINT.get());
        if (count > 1) {
            points.grow(count - 1);
        }
        return points;
    }

    private static ItemStack getPremiumPoints(int count) {
        ItemStack points = new ItemStack(ItemRegistry.PREMIUM_PDC_POINT.get());
        if (count > 1) {
            points.grow(count - 1);
        }
        return points;
    }

    private static ItemStack getGoods(ItemLike item, int count) {
        ItemStack goods = new ItemStack(item);
        if (count > 1) {
            goods.grow(count - 1);
        }
        return goods;
    }
}
