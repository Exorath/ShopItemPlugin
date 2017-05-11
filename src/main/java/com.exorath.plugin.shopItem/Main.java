package com.exorath.plugin.shopItem;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by toonsev on 5/11/2017.
 */
public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new ItemHandler(new YamlConfigProvider(getConfig())), this);
    }
}
