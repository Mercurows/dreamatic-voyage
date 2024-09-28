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
    }

}
