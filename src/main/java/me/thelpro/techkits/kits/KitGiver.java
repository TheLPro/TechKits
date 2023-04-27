package me.thelpro.techkits.kits;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class KitGiver {

    private static boolean isArmor(final ItemStack itemStack) {
        if (itemStack == null)
            return false;
        final String typeNameString = itemStack.getType().name();
        return typeNameString.endsWith("_HELMET")
                || typeNameString.endsWith("_CHESTPLATE")
                || typeNameString.endsWith("_LEGGINGS")
                || typeNameString.endsWith("_BOOTS");
    }
    private static int type(ItemStack itemStack) {
        if (itemStack == null)
            return 99;
        String typeNameString = itemStack.getType().name();
        if (typeNameString.endsWith("_HELMET"))
            return 1;
        if (typeNameString.endsWith("_CHESTPLATE"))
            return 2;
        if (typeNameString.endsWith("_LEGGINGS"))
            return 3;
        if (typeNameString.endsWith("_BOOTS"))
            return 4;
        if (typeNameString.endsWith("_SWORD"))
            return 5;
        return 6;
    }

    public static void giveItems(Player player, ArrayList<ItemStack> items) {
        List<ItemStack> sublist = items.subList(4, items.size());
        player.getInventory().clear();
        for (ItemStack i : items) {
            if (isArmor(i)) {
                switch (type(i)) {
                    case 1:
                        player.getEquipment().setHelmet(items.get(0));
                    case 2:
                        player.getEquipment().setChestplate(items.get(1));
                    case 3:
                        player.getEquipment().setLeggings(items.get(2));
                    case 4:
                        player.getEquipment().setBoots(items.get(3));
                    case 5:
                        player.getInventory().addItem(items.get(4));
                    case 6:
                        for (ItemStack sub : sublist) {
                            player.getInventory().addItem(sub);
                        }
                }
            }
        }
    }
}