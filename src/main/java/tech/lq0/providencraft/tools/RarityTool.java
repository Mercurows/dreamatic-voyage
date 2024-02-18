package tech.lq0.providencraft.tools;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.Rarity;

public class RarityTool {
    public static final Rarity LEGACY = Rarity.create("providencraft_legacy", s -> {
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

    public static final Rarity LEGENDARY = Rarity.create("providencraft_legendary", ChatFormatting.GOLD);

    public static final Rarity APOCRYPHAL =  Rarity.create("providencraft_apocryphal", s -> {
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

    public static final Rarity DONATE =  Rarity.create("providencraft_donate", s -> {
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
}
