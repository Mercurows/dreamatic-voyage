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

    public static final Rarity MAGICROS = Rarity.create("dreamaticvoyage_magicros", s -> {
        long time = System.currentTimeMillis();
        int step = (int) (time % 8000);

        int[][] colors = {
                {0xFF, 0xEC, 0xE7},
                {0xAD, 0xDB, 0xFF},
                {0xF5, 0xFF, 0xEA},
                {0xFF, 0xF7, 0xEA}
        };

        int segment = step / 2000;
        int rgb = getCurrentRgb(step, colors, segment);

        return Style.EMPTY.withColor(rgb);
    });

    private static int getCurrentRgb(int step, int[][] colors, int segment) {
        int localStep = step % 2000;

        int[] startColor = colors[segment % colors.length];
        int[] endColor = colors[(segment + 1) % colors.length];

        int finalR = (int) (startColor[0] + (endColor[0] - startColor[0]) * localStep / 2000f);
        int finalG = (int) (startColor[1] + (endColor[1] - startColor[1]) * localStep / 2000f);
        int finalB = (int) (startColor[2] + (endColor[2] - startColor[2]) * localStep / 2000f);

        return finalR * 65536 + finalG * 256 + finalB;
    }

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
