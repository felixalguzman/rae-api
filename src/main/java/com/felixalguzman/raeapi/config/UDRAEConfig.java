package com.felixalguzman.raeapi.config;

public class UDRAEConfig {
    private int cacheDuration;
    private int offlineCacheDuration;
    private int cacheSize;
    private int connectTimeout;
    private String cacheFolderName;

    private UDRAEConfig() {
    }

    private UDRAEConfig(int cacheDuration, int offlineCacheDuration, int cacheSize,
                        int connectTimeout, String cacheFolderName) {
        this.cacheDuration = cacheDuration;
        this.offlineCacheDuration = offlineCacheDuration;
        this.cacheSize = cacheSize;
        this.connectTimeout = connectTimeout;
        this.cacheFolderName = cacheFolderName;
    }

    public static UDRAEConfig getDefaultUDRAEConfig() {
        return new UDRAEConfig.Builder().apply();
    }

    public int getCacheDuration() {
        return cacheDuration;
    }

    public int getOfflineCacheDuration() {
        return offlineCacheDuration;
    }

    public int getCacheSize() {
        return cacheSize;
    }

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public String getCacheFolderName() {
        return cacheFolderName;
    }

    public static class Builder {
        private int cacheDuration = 30; // 30 days
        private int offlineCacheDuration = 180; // 180 days
        private int cacheSize = 10_485_760; // 10 MiB
        private int connectTimeout = 15; // 15 seconds
        private String cacheFolderName = "udrae-cache";

        public Builder setCacheDuration(int cacheDuration) {
            this.cacheDuration = cacheDuration;
            return this;
        }

        public Builder setOfflineCacheDuration(int offlineCacheDuration) {
            this.offlineCacheDuration = offlineCacheDuration;
            return this;
        }

        public Builder setCacheSize(int cacheSize) {
            this.cacheSize = cacheSize;
            return this;
        }

        public Builder setConnectTimeout(int connectTimeout) {
            this.connectTimeout = connectTimeout;
            return this;
        }

        public Builder setCacheFolderName(String cacheFolderName) {
            this.cacheFolderName = cacheFolderName;
            return this;
        }

        public UDRAEConfig apply() {
            return new UDRAEConfig(cacheDuration, offlineCacheDuration, cacheSize,
                    connectTimeout, cacheFolderName);
        }
    }
}
