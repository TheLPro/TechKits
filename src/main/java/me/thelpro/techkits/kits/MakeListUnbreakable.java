package me.thelpro.techkits.kits;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class MakeListUnbreakable {
    public static ArrayList<ItemStack> unbreakableAll(ArrayList<ItemStack> items) {

        ArrayList<ItemStack> unbItems = new ArrayList<ItemStack>();
        for (ItemStack i : items) {
            ItemMeta meta = i.getItemMeta();
            meta.spigot().setUnbreakable(true);
            i.setItemMeta(meta);
            unbItems.add(i);
        }
        return unbItems;
    }
}