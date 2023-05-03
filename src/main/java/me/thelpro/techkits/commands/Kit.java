package me.thelpro.techkits.commands;

import me.thelpro.techkits.kits.ShowKitShop;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.*;

public class Kit implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        ShowKitShop.showKitShop((Player) sender);
        return true;
    }
}