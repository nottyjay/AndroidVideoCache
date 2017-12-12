package com.danikula.videocache.sample;

public enum Video {

    ORANGE_1("http://video.caixians.com/59fbdf1cd6f0e.m3u8?pm3u8/0/expires/43200&e=1513061981&token=e-tu6RMb7xGD_KWdulvBTrgkfp884fLL569LVicz:0vpe9A1UVcu9NeGZMpcw3t5f6cg="),
    ORANGE_2(Config.ROOT + "orange2.mp4"),
    ORANGE_3(Config.ROOT + "orange3.mp4"),
    ORANGE_4(Config.ROOT + "orange4.mp4"),
    ORANGE_5(Config.ROOT + "orange5.mp4");

    public final String url;

    Video(String url) {
        this.url = url;
    }

    private class Config {
        private static final String ROOT = "https://raw.githubusercontent.com/danikula/AndroidVideoCache/master/files/";
    }
}
