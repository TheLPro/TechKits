package me.thelpro.techkits.kits;

import me.thelpro.techkits.TechKits;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;

public class ShowKitShop {

    TechKits plugin = TechKits.plugin;
    FileConfiguration config = plugin.getConfig();

    static ArrayList<String> kits = new ArrayList<String>();
    static HashMap<String, ArrayList<ItemStack>> masterKit = new HashMap<String, ArrayList<ItemStack>>();
    static ArrayList<ItemStack> knight = new ArrayList<ItemStack>();
    static ArrayList<ItemStack> warrior = new ArrayList<ItemStack>();
    static ArrayList<ItemStack> slayer = new ArrayList<ItemStack>();

    public static void lists() {
        kits.add("Knight Kit");
        kits.add("Warrior Kit");

        knight.add(new ItemStack(Material.IRON_HELMET));
        knight.add(new ItemStack(Material.IRON_CHESTPLATE));
        knight.add(new ItemStack(Material.IRON_LEGGINGS));
        knight.add(new ItemStack(Material.IRON_BOOTS));
        knight.add(new ItemStack(Material.DIAMOND_SWORD));
        knight.add(new ItemStack(Material.COOKED_BEEF, 32));
        knight.add(new ItemStack(Material.GOLDEN_APPLE, 8));

        ItemStack ws = new ItemStack(Material.DIAMOND_SWORD);
        ws.addEnchantment(Enchantment.DAMAGE_ALL, 2);
        warrior.add(new ItemStack(Material.IRON_HELMET));
        warrior.add(new ItemStack(Material.DIAMOND_CHESTPLATE));
        warrior.add(new ItemStack(Material.DIAMOND_LEGGINGS));
        warrior.add(new ItemStack(Material.IRON_BOOTS));
        warrior.add(ws);
        warrior.add(new ItemStack(Material.COOKED_BEEF, 64));
        warrior.add(new ItemStack(Material.GOLDEN_APPLE, 16));
        warrior.add(new ItemStack(Material.GOLDEN_APPLE, 1, (short)1));

        ItemStack ss = new ItemStack(Material.DIAMOND_SWORD);
        ss.addEnchantment(Enchantment.DAMAGE_ALL, 4);

        masterKit.put(kits.get(0), knight);
        masterKit.put(kits.get(1), warrior);

    }

    public void showKitShop(Player player) {

        Inventory gui = Bukkit.createInventory(player, 26, ChatColor.translateAlternateColorCodes('&', config.getString("shop-title")));

        //gui.setItem(, new KitCreator(ChatColor.translateAlternateColorCodes('&', kits.get()), "", 0, , Material., 10).getKitItem());

        gui.setItem(10, new KitCreator(ChatColor.translateAlternateColorCodes('&', kits.get(0)), "&7Simple but strong default kit.", 0, MakeListUnbreakable.unbreakableAll(knight), Material.IRON_SWORD, 10).getKitItem());
        gui.setItem(12, new KitCreator(ChatColor.translateAlternateColorCodes('&', kits.get(1)), "&7Newer upgrade of the knight kit. \nYou can finally start &4killing&7 some enemies!", 0, MakeListUnbreakable.unbreakableAll(warrior), Material.IRON_CHESTPLATE, 5).getKitItem());



    }

    @EventHandler
    public void guiClick(InventoryClickEvent e) {
        if (e.getClickedInventory().getName().equals(ChatColor.translateAlternateColorCodes('&', config.getString("shop-title")))) {
            for (String obj : kits) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals(obj)) {
                    KitGiver.giveItems((Player) e.getWhoClicked(), masterKit.get(obj));
                }
            }
        }
        e.setCancelled(true);
    }
}