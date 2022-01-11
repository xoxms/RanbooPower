package com.papajittan.ranboopower;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class PluginSupporter {
    public static void SetRanboo(String name, String yesorno){
        File file = new File(Main.instance.getDataFolder() + File.separator + name + ".yml");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception exception) {
                Bukkit.getServer().getConsoleSender().sendMessage(exception.getMessage());
            }
        }
        YamlConfiguration yml = new YamlConfiguration();
        yml.set("Ranboo", yesorno);
        try {
            yml.save(file);
        } catch (Exception exception) {
            Bukkit.getServer().getConsoleSender().sendMessage(exception.getMessage());
        }
    }
    public static RaNbOo GetRanboo(String name){
        File file = new File(Main.instance.getDataFolder() + File.separator + name + ".yml");
        if (!file.exists()) {
            return null;
        }

        YamlConfiguration yml = YamlConfiguration.loadConfiguration(file);
        RaNbOo ranboo = new RaNbOo();
        ranboo.CheckRanboo = yml.getString("Ranboo");
        return ranboo;
    }

    public static class RaNbOo {
        public String CheckRanboo;
    }
}

