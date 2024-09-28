package tech.lq0.dreamaticvoyage.tools;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import tech.lq0.dreamaticvoyage.Utils;

public class ModTags {
    public static class Blocks {

        public static final TagKey<Block> HARANO = tag("harano");
        public static final TagKey<Block> FUKAMIZU_PLUM = tag("fukamizu_plum");
        public static final TagKey<Block> FUKAMIZU_MACHINE = tag("fukamizu_machine");
        public static final TagKey<Block> FUKAMIZU_BREAD = tag("fukamizu_bread");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(Utils.MOD_ID, name));
        }
    }

    public static class Items {
        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(Utils.MOD_ID, name));
        }
    }

    public static class DamageTypes {

        public static final TagKey<DamageType> CURSED_EXPLOSION = tag("cursed_explosion");

        private static TagKey<DamageType> tag(String name) {
            return TagKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(Utils.MOD_ID, name));
        }
    }
}
