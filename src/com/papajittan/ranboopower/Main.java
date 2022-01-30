package com.papajittan.ranboopower;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class Main extends JavaPlugin {
    public static Main instance;
    @Override
    public void onEnable(){
        instance = this;
        getServer().getConsoleSender().sendMessage(ChatColor.AQUA + this.getName() + " is ready!");
        Bukkit.getPluginManager().registerEvents(new Event(), this);
        Objects.requireNonNull(getCommand("ranboo")).setExecutor(new Command());
        Objects.requireNonNull(getCommand("ranboo")).setTabCompleter(new TapCom());
    }
}
