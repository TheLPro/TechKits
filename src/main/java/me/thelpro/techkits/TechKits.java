package me.thelpro.techkits;

import me.thelpro.techkits.kits.ShowKitShop;
import org.bukkit.plugin.java.JavaPlugin;

public final class TechKits extends JavaPlugin {

    public static TechKits plugin;

    @Override
    public void onEnable() {

        ShowKitShop.lists();

        plugin = this;

        reloadConfig();
        getConfig().options().copyDefaults(true);
        saveConfig();
        getConfig().set("shop-title", "&lKits");

    }
}