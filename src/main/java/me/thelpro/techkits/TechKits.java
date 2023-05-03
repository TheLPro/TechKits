package me.thelpro.techkits;

import me.thelpro.techkits.commands.Kit;
import me.thelpro.techkits.kits.ShowKitShop;
import org.bukkit.plugin.java.JavaPlugin;

public final class TechKits extends JavaPlugin {

    public static TechKits plugin;

    @Override
    public void onEnable() {

        ShowKitShop.lists();

        getServer().getPluginManager().registerEvents(new ShowKitShop(), this);
        getCommand("kit").setExecutor(new Kit());

        plugin = this;

        reloadConfig();
        getConfig().options().copyDefaults(true);
        saveConfig();
        getConfig().set("shop-title", "&lKits");

    }
}