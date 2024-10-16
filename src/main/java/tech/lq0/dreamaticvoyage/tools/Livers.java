package tech.lq0.dreamaticvoyage.tools;

public enum Livers {
    MITSUKI("mitsuki", "zero", "#F9E7E8", true),
    USA("usa", "zero", "#FFEDFE", true),
    MADOKA("madoka", "first", "#F4F0FF", true),
    MYANNA("myanna", "first", "#EAF6EE", false),
    NIINA("niina", "first", "#FCDEE3", true),
    UNIA("unia", "first", "#D2C5F9", true),
    AYELET("ayelet", "first", "#EDF4FF", true),
    MARI("mari", "first", "#F8F1F9", true),
    HAYA("haya", "first", "#F3EDFF", true),
    MUMU("mumu", "second", "#FFEEEA", true),
    LECIA("lecia", "second", "#E1EDFF", true),
    SATOU("satou", "second", "#E7D2E1", true),
    LUCIA("lucia", "second", "#F6F6F6", true),
    LOUISE("louise", "second", "#E8FFE7", true),
    CHIRAM("chiram", "magicros", "#FFECE7", true),
    HAINE("haine", "magicros", "#ADDBFF", true),
    KERORO("keroro", "magicros", "#F5FFEA", true),
    EKIRA("ekira", "magicros", "#FFF7EA", true),
    HIRU("hiru", "third", "#68B9F6", true),
    YUKI("yuki", "third", "#B4CEE3", false),
    LECIEL("leciel", "third", "#FCBBB1", false),
    CHOCO("choco", "fourth", "#A98880", true),
    HIFUMI("hifumi", "fourth", "#6B5B95", true),
    SANA("sana", "fourth", "#ABCDEF", true),
    SHIRAKO("shirako", "poi", "#F4ADB4", false),
    MIYA("miya", "poi", "#F9F0D8", true),
    AOI("aoi", "poi", "#EEEEEE", true),
    AYU("ayu", "poi", "#A9BBD9", false),
    YURI("yuri", "poi", "#F9C8DE", true),
    FUKAMIZU("fukamizu", "poi", "#E0D7F5", true),
    LUTAFIA("lutafia", "poi", "#6BD2B5", true),
    YESA("yesa", "poi", "#8EA6F2", true),
    ROKY("roky", "poi", "#E1849E", true),
    RINO("rino", "poi", "#CBE0DF", false),
    CCELIA("ccelia", "poi", "#CAD855", false),
    QIANYUN("qianyun", "connections", "#A33432", true);

    private final String name;
    private final String gen;
    private final String color;
    private final boolean active;

    Livers(String name, String gen, String color, boolean active) {
        this.name = name;
        this.gen = gen;
        this.color = color;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public String getGen() {
        return gen;
    }

    public String getColor() {
        return color;
    }

    public boolean isActive() {
        return active;
    }
}
