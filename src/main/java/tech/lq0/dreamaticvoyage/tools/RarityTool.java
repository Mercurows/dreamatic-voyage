package tech.lq0.dreamaticvoyage.tools;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.Rarity;

public class RarityTool {
    public static final Rarity LEGACY = Rarity.create("dreamaticvoyage_legacy", s -> {
        long time = System.currentTimeMillis();
        int step = (int) (time % 4000);

        int startR = 255;
        int startG = 98;
        int startB = 136;

        int endR = 200;
        int endG = 197;
        int endB = 196;

        int finalR;
        int finalG;
        int finalB;

        step = step > 2000 ? 4000 - step : step;
        finalR = (int) (startR + (endR - startR) * step / 2000f);
        finalG = (int) (startG + (endG - startG) * step / 2000f);
        finalB = (int) (startB + (endB - startB) * step / 2000f);
        int rgb = finalR * 65536 + finalG * 256 + finalB;

        return Style.EMPTY.withColor(rgb);
    });

    public static final Rarity LEGENDARY = Rarity.create("dreamaticvoyage_legendary", ChatFormatting.GOLD);

    public static final Rarity FICTIONAL = Rarity.create("dreamaticvoyage_fictional", s -> {
        long time = System.currentTimeMillis();
        int step = (int) (time % 4000);

        int startR = 30;
        int startG = 196;
        int startB = 183;

        int endR = 10;
        int endG = 31;
        int endB = 23;

        int finalR;
        int finalG;
        int finalB;

        step = step > 2000 ? 4000 - step : step;
        finalR = (int) (startR + (endR - startR) * step / 2000f);
        finalG = (int) (startG + (endG - startG) * step / 2000f);
        finalB = (int) (startB + (endB - startB) * step / 2000f);
        int rgb = finalR * 65536 + finalG * 256 + finalB;

        return Style.EMPTY.withColor(rgb);
    });

    public static final Rarity DONATE = Rarity.create("dreamaticvoyage_donate", s -> {
        long time = System.currentTimeMillis();
        int step = (int) (time % 4000);

        int startR = 199;
        int startG = 247;
        int startB = 255;

        int endR = 248;
        int endG = 224;
        int endB = 194;

        int finalR;
        int finalG;
        int finalB;

        step = step > 2000 ? 4000 - step : step;
        finalR = (int) (startR + (endR - startR) * step / 2000f);
        finalG = (int) (startG + (endG - startG) * step / 2000f);
        finalB = (int) (startB + (endB - startB) * step / 2000f);
        int rgb = finalR * 65536 + finalG * 256 + finalB;

        return Style.EMPTY.withColor(rgb);
    });

    public static final Rarity FUKAMI_TECH = Rarity.create("dreamaticvoyage_fukami_tech", s -> {
        long time = System.currentTimeMillis();
        int step = (int) (time % 4000);

        int startR = 224;
        int startG = 215;
        int startB = 245;

        int endR = 188;
        int endG = 150;
        int endB = 221;

        int finalR;
        int finalG;
        int finalB;

        step = step > 2000 ? 4000 - step : step;
        finalR = (int) (startR + (endR - startR) * step / 2000f);
        finalG = (int) (startG + (endG - startG) * step / 2000f);
        finalB = (int) (startB + (endB - startB) * step / 2000f);
        int rgb = finalR * 65536 + finalG * 256 + finalB;

        return Style.EMPTY.withColor(rgb);
    });
}
