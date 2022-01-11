package com.papajittan.ranboopower;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public static Main instance;
    @Override
    public void onEnable(){
        instance = this;
        getServer().getConsoleSender().sendMessage(ChatColor.AQUA + this.getName() + " is ready!");
        Bukkit.getPluginManager().registerEvents(new Event(), this);
        getCommand("ranbooadd").setExecutor(new Command());
        getCommand("ranbooremove").setExecutor(new Command());
    }
}
