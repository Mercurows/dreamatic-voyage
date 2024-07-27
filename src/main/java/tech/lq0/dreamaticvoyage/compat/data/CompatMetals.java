package tech.lq0.dreamaticvoyage.compat.data;

public enum CompatMetals {
    ZINC("zinc", CompatMods.CREATE),
    LEAD("lead", CompatMods.THERMAL, CompatMods.IMMERSIVEENGINEERING, CompatMods.MEKANISM),
    NICKEL("nickel", CompatMods.THERMAL),
    SILVER("silver", CompatMods.THERMAL, CompatMods.IMMERSIVEENGINEERING),
    TIN("tin", CompatMods.THERMAL, CompatMods.MEKANISM),
    ALUMINUM("aluminum", CompatMods.IMMERSIVEENGINEERING),
    OSMIUM("osmium", CompatMods.MEKANISM),
    URANIUM("uranium", CompatMods.MEKANISM, CompatMods.IMMERSIVEENGINEERING),
    ;

    private final String name;
    private final CompatMods[] mods;

    CompatMetals(String name, CompatMods... mods) {
        this.name = name;
        this.mods = mods;
    }

    public String getName() {
        return this.name;
    }

    public CompatMods[] getMods() {
        return this.mods;
    }

}
