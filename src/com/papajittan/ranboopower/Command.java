package com.papajittan.ranboopower;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class Command implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, org.bukkit.command.Command command, String string, String[] args) {
            if(commandSender instanceof Player) {
                if (!commandSender.isOp()) {
                    commandSender.sendMessage(ChatColor.RED + "You need op to use this command!");
                    return true;
                }
            if(args.length <= 0){
                commandSender.sendMessage(ChatColor.GOLD + "/ranboo add <player name> to add the player Ranboo power!\n" +
                        "/ranboo remove <player name> to remove the player Ranboo power!");
                return true;
            }
            if(!PluginSupporter.isAddRemove(args[0])) {
                commandSender.sendMessage(ChatColor.RED + "Please enter add or remove in args[0]!");
                return true;
            }
            if(args[0].equalsIgnoreCase("add")) {
                if(Objects.requireNonNull(PluginSupporter.GetRanboo(args[1])).CheckRanboo) {
                    commandSender.sendMessage(ChatColor.RED + "This player already have Ranboo power!");
                    return true;
                }
                PluginSupporter.SetRanboo(args[1], true);
                commandSender.sendMessage(ChatColor.GOLD + "Successfully gave " + ChatColor.WHITE + args[0] + ChatColor.GOLD + " the Ranboo power!");
                Player tplayer = Bukkit.getPlayer(args[1]);
                if(tplayer == null) return true;
                tplayer.sendMessage(ChatColor.GOLD + "You have got the Ranboo power!");
                return true;
            }
            if(args[0].equalsIgnoreCase("remove")) {
                if (!Objects.requireNonNull(PluginSupporter.GetRanboo(args[1])).CheckRanboo) {
                    commandSender.sendMessage(ChatColor.RED + "The player don't even have Ranboo power!");
                    return true;
                }
                PluginSupporter.SetRanboo(args[1], false);
                commandSender.sendMessage(ChatColor.GOLD + "Successfully removed " + ChatColor.WHITE + args[0] + ChatColor.GOLD + " the Ranboo power!");
                Player tplayer = Bukkit.getPlayer(args[0]);
                if (tplayer == null) return true;
                tplayer.sendMessage(ChatColor.GOLD + "Your Ranboo power got removed!");
                return true;
            }
            }
        return true;
    }
}
