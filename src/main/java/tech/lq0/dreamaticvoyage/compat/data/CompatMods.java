package tech.lq0.dreamaticvoyage.compat.data;

public enum CompatMods {
    CREATE("create"),
    THERMAL("thermal"),
    MEKANISM("mekanism"),
    IMMERSIVEENGINEERING("immersiveengineering"),
    SUPERBWARFARE("superbwarfare"),
    ;

    private final String modId;

    CompatMods(String modId) {
        this.modId = modId;
    }

    public String getModId() {
        return this.modId;
    }

}
