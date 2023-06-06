package com.example.WeatherPro.repository;

public enum Icons {
    Sunrise("https://help.apple.com/assets/640A52196275DE31D4371B5E/640A52226275DE31D4371B8B/sv_SE/78606be71a30b2e518815e252a93cbb1.png"),

    Sunset("https://help.apple.com/assets/640A52196275DE31D4371B5E/640A52226275DE31D4371B8B/sv_SE/791abf4ca2e11cf399b0d98c5e28598a.png"),

    ClearMostlyClear("https://help.apple.com/assets/640A52196275DE31D4371B5E/640A52226275DE31D4371B8B/sv_SE/575900edccbc7def167f7874c02aeb0b.png"),

    HalfClear("https://help.apple.com/assets/640A52196275DE31D4371B5E/640A52226275DE31D4371B8B/sv_SE/67aaf9dbe30989c25cbde6c6ec099213.png"),

    Haze("https://help.apple.com/assets/640A52196275DE31D4371B5E/640A52226275DE31D4371B8B/sv_SE/73ae8300a30e895e3739cd50ade0dfe1.png"),

    Fog("https://help.apple.com/assets/640A52196275DE31D4371B5E/640A52226275DE31D4371B8B/sv_SE/d35bb25d12281cd9ee5ce78a98cd2aa7.png"),

    Windy("https://help.apple.com/assets/640A52196275DE31D4371B5E/640A52226275DE31D4371B8B/sv_SE/ad9e41c68b6a2671d2bcd843be1baa86.png"),

    Cloudy("https://help.apple.com/assets/640A52196275DE31D4371B5E/640A52226275DE31D4371B8B/sv_SE/66117fab0f288a2867b340fa2fcde31b.png"),

    Thunder("https://help.apple.com/assets/640A52196275DE31D4371B5E/640A52226275DE31D4371B8B/sv_SE/efffb1e26f6de5bf5c8adbd872a2933a.png"),

    Rain("https://help.apple.com/assets/640A52196275DE31D4371B5E/640A52226275DE31D4371B8B/sv_SE/4417bf88c7bbcd8e24fb78ee6479b362.png"),

    HeavyRain("https://help.apple.com/assets/640A52196275DE31D4371B5E/640A52226275DE31D4371B8B/sv_SE/451d37e6cea3af4a568110863a1adcf7.png"),

    DrizzleFreezingDrizzle("https://help.apple.com/assets/640A52196275DE31D4371B5E/640A52226275DE31D4371B8B/sv_SE/a55fef55bbeb0762a8dd329b4b8ad342.png"),

    Snow("https://help.apple.com/assets/640A52196275DE31D4371B5E/640A52226275DE31D4371B8B/sv_SE/00171e3b54b97dee8c1a2f6a62272640.png"),

    HeavySnowfall("https://help.apple.com/assets/640A52196275DE31D4371B5E/640A52226275DE31D4371B8B/sv_SE/e95fb90fc5a4aac111be78770921beb1.png"),

    FreezingRain("https://help.apple.com/assets/640A52196275DE31D4371B5E/640A52226275DE31D4371B8B/sv_SE/9189cb49e806d1ebfeed24f33367143c.png"),

    ClearNight("https://help.apple.com/assets/640A52196275DE31D4371B5E/640A52226275DE31D4371B8B/sv_SE/1200cde3569cf69bd80e1ddabc0f15cd.png"),

    PartlyCloudyNight("https://help.apple.com/assets/640A52196275DE31D4371B5E/640A52226275DE31D4371B8B/sv_SE/17cc1a8a95028b89ba6988ee47eeab29.png"),

    DrizzleNight("https://help.apple.com/assets/640A52196275DE31D4371B5E/640A52226275DE31D4371B8B/sv_SE/d4b6596291c114305b64056bd92ccee3.png");
    private final String url;
    Icons(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
