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
        var cmd = command.getName();
        if(cmd.equalsIgnoreCase("ranbooadd")){
            if(commandSender instanceof Player) {
                if (!commandSender.isOp()) {
                    commandSender.sendMessage(ChatColor.RED + "You need op to use this command!");
                    return true;
                }
            }
            if(args.length <= 0){
                commandSender.sendMessage(ChatColor.RED + "Please enter player name that you want to add!");
                return true;
            }
            PluginSupporter.SetRanboo(args[0], "yes");
            commandSender.sendMessage(ChatColor.GOLD + "Successfully gave " + ChatColor.WHITE + args[0] + ChatColor.GOLD + " the Ranboo power!");
            Player tplayer = Bukkit.getPlayer(args[0]);
            if(tplayer == null) return true;
            tplayer.sendMessage(ChatColor.GOLD + "You have got the Ranboo power!");
            return true;
        }
        if(cmd.equalsIgnoreCase("ranbooremove")){
            if(commandSender instanceof Player) {
                if (!commandSender.isOp()) {
                    commandSender.sendMessage(ChatColor.RED + "You need op to use this command!");
                    return true;
                }
            }
            if(args.length <= 0){
                commandSender.sendMessage(ChatColor.RED + "Please enter player name that you want to remove!");
                return true;
            }
            PluginSupporter.RaNbOo boo = PluginSupporter.GetRanboo(args[0]);
            if(boo == null){
                commandSender.sendMessage(ChatColor.RED + "The player don't even have Ranboo power!");
                return true;
            }
            String boos = boo.CheckRanboo;
            if(Objects.equals(boos, "no")){
                commandSender.sendMessage(ChatColor.RED + "The player don't even have Ranboo power!");
                return true;
            }
            PluginSupporter.SetRanboo(args[0], "no");
            commandSender.sendMessage(ChatColor.GOLD + "Successfully removed " + ChatColor.WHITE + args[0] + ChatColor.GOLD + " the Ranboo power!");
            Player tplayer = Bukkit.getPlayer(args[0]);
            if(tplayer == null) return true;
            tplayer.sendMessage(ChatColor.GOLD + "Your Ranboo power got removed!");
            return true;
        }
        return true;
        }
    }
