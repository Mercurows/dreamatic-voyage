package tech.lq0.dreamaticvoyage.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.DamageTypeTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import tech.lq0.dreamaticvoyage.Utils;
import tech.lq0.dreamaticvoyage.init.DamageSourceRegistry;
import tech.lq0.dreamaticvoyage.tools.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModDamageTypeTagProvider extends DamageTypeTagsProvider {

    public ModDamageTypeTagProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, Utils.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.DamageTypes.CURSED_EXPLOSION).add(DamageTypes.EXPLOSION, DamageTypes.PLAYER_EXPLOSION)
                .addOptional(new ResourceLocation("superbwarfare", "projectile_boom"))
                .addOptional(new ResourceLocation("superbwarfare", "mine"))
                .addOptional(new ResourceLocation("superbwarfare", "cannon_fire"));
        this.tag(DamageTypeTags.IS_PROJECTILE).add(DamageSourceRegistry.BLOOD_CRYSTAL);
        this.tag(DamageTypeTags.BYPASSES_ARMOR).add(DamageSourceRegistry.LAVA_CAKE, DamageSourceRegistry.MARI_FOOD, DamageSourceRegistry.EMOTIONAL_DAMAGE,
                DamageSourceRegistry.LOTUS_POTATO, DamageSourceRegistry.LUNATIC_HOWL, DamageSourceRegistry.OVERLOAD, DamageSourceRegistry.BLEEDING,
                DamageSourceRegistry.BLEEDING, DamageSourceRegistry.LUNAR_ECLIPSE, DamageSourceRegistry.FUKAMIZU_BREAD, DamageSourceRegistry.BROWNIE_UZZA,
                DamageSourceRegistry.CHOCOAL_COOKIE, DamageSourceRegistry.LEVIY_BEAM_ABSOLUTE, DamageSourceRegistry.WITHER_ABSOLUTE);
        this.tag(DamageTypeTags.BYPASSES_EFFECTS).add(DamageSourceRegistry.EMOTIONAL_DAMAGE, DamageSourceRegistry.OVERLOAD, DamageSourceRegistry.BLEEDING,
                DamageSourceRegistry.LUNAR_ECLIPSE, DamageSourceRegistry.LEVIY_BEAM_ABSOLUTE, DamageSourceRegistry.WITHER_ABSOLUTE);
        this.tag(DamageTypeTags.BYPASSES_ENCHANTMENTS).add(DamageSourceRegistry.EMOTIONAL_DAMAGE, DamageSourceRegistry.OVERLOAD, DamageSourceRegistry.BLEEDING,
                DamageSourceRegistry.LUNAR_ECLIPSE, DamageSourceRegistry.LEVIY_BEAM_ABSOLUTE, DamageSourceRegistry.WITHER_ABSOLUTE);
        this.tag(DamageTypeTags.BYPASSES_RESISTANCE).add(DamageSourceRegistry.EMOTIONAL_DAMAGE, DamageSourceRegistry.OVERLOAD, DamageSourceRegistry.BLEEDING,
                DamageSourceRegistry.LUNAR_ECLIPSE, DamageSourceRegistry.LEVIY_BEAM_ABSOLUTE, DamageSourceRegistry.WITHER_ABSOLUTE);
        this.tag(ModTags.DamageTypes.IS_FOOD).add(DamageSourceRegistry.LAVA_CAKE, DamageSourceRegistry.MARI_FOOD, DamageSourceRegistry.LOTUS_POTATO,
                DamageSourceRegistry.FUKAMIZU_BREAD, DamageSourceRegistry.BROWNIE_UZZA, DamageSourceRegistry.CHOCOAL_COOKIE);
    }

}
