package me.thelpro.techkits.kits;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class KitCreator {
    
    String name;
    String lore;
    int cost;
    ArrayList<ItemStack> items;
    Material logo;
    int upd;

    public KitCreator(String name, String lore, int cost, ArrayList<ItemStack> items, Material logo, int upd) {
        this.name = name;
        this.lore = lore;
        this.cost = cost;
        this.items = items;
        this.logo = logo;
        this.upd = upd;
    }

    public String name() {
        return name;
    }

    public void name(String name) {
        this.name = name;
    }

    public String lore() {
        return lore;
    }

    public void lore(String lore) {
        this.lore = lore;
    }

    public int cost() {
        return cost;
    }

    public void cost(int cost) {
        this.cost = cost;
    }

    public ArrayList<ItemStack> items() {
        return items;
    }

    public void items(ArrayList<ItemStack> items) {
        this.items = items;
    }
    public Material logo() {return logo;}
    public void logo(Material logo) {this.logo = logo;}
    public int getUpd() {
        return upd;
    }

    public void setUpd(int upd) {
        this.upd = upd;
    }
    public ItemStack getKitItem() {

        ItemStack item = new ItemStack(this.logo);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name + "Kit"));
        List<String> lorelist = new ArrayList<String>();
        lorelist.add(lore);
        meta.setLore(lorelist);

        item.setItemMeta(meta);

        return item;

    }
}