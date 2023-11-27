package tech.lq0.providencraft.loot;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import org.jetbrains.annotations.NotNull;
import tech.lq0.providencraft.init.LootModifierRegistry;

import java.lang.reflect.Field;
import java.util.Set;
import java.util.function.Supplier;

//From Vanilla-Boom
public class FishingModifier extends LootModifier {
    public static final Supplier<Codec<FishingModifier>> CODEC = Suppliers.memoize(() ->
            RecordCodecBuilder.create(inst -> codecStart(inst).and(
                    inst.group(Codec.STRING.fieldOf("table").xmap(LootModifierRegistry::getLootTableReference, LootModifierRegistry::getString).
                            forGetter(m -> m.lootTable), Codec.FLOAT.fieldOf("chance").forGetter(m -> m.chance)
                    )).apply(inst, FishingModifier::new)
            )
    );

    private static final Field LOOT_FIELD = ObfuscationReflectionHelper.findField(LootContext.class, "f_278466_");
    private final LootTableReference lootTable;
    private final float chance;

    public FishingModifier(LootItemCondition[] conditions, LootTableReference lootTable, float chance) {
        super(conditions);
        this.lootTable = lootTable;
        this.chance = chance;
    }

    @NotNull
    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        try {
            Set<LootTable> set = (Set<LootTable>) LOOT_FIELD.get(context);

            if (set.isEmpty() && context.getRandom().nextFloat() <= chance) {
                ObjectArrayList<ItemStack> loot = ObjectArrayList.of();
                lootTable.createItemStack(loot::add, context);

                return loot;
            } else {
                return generatedLoot;
            }
        } catch (IllegalArgumentException | IllegalAccessException e) {
            throw new RuntimeException("Could not access lootTables", e);
        }
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}
