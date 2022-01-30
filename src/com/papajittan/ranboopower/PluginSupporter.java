package com.august.pvpmanager;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class PluginSupporter {
    protected static void setPvP(String playername, boolean bool){
        File var10002 = Main.instance.getDataFolder();
        File f = new File(var10002 + File.separator + playername + ".yml");
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (Exception e) {
                Bukkit.getServer().getConsoleSender().sendMessage(e.getMessage());
            }
        }
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(f);
        yamlConfiguration.set("pvp", bool);
        try{
            yamlConfiguration.save(f);
        }catch (Exception e){
            Bukkit.getServer().getConsoleSender().sendMessage(e.getMessage());
        }
    }
    protected static PluginSupporter.Data getPvP(String playername){
        File var10002 = Main.instance.getDataFolder();
        File f = new File(var10002 + File.separator + playername + ".yml");
        if(!f.exists()){
            return null;
        }
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
        PluginSupporter.Data pvp = new PluginSupporter.Data();
        pvp.PvP = yml.getBoolean("pvp");
        return pvp;
    }
    protected static class Data{
        protected Boolean PvP;
    }
}
