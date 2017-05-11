package com.exorath.plugin.shopItem;

import org.bukkit.configuration.file.FileConfiguration;

/**
 * Created by toonsev on 5/11/2017.
 */
public class YamlConfigProvider {
    private FileConfiguration configuration;

    public YamlConfigProvider(FileConfiguration configuration) {
        this.configuration = configuration;
    }

    public Integer getSlot() {
        if (!configuration.contains("itemSlot"))
            return null;
        return configuration.getInt("itemSlot");
    }
}
