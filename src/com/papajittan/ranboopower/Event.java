package com.papajittan.ranboopower;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class Event implements Listener {
    @EventHandler
    public void  onPlayerJoin(PlayerJoinEvent Event){
        Player player = Event.getPlayer();
        String pname = player.getName();
        if(PluginSupporter.GetRanboo(pname) == null){
            PluginSupporter.SetRanboo(pname, false);
        }
    }
    @EventHandler
    public void onBlockBreak(BlockBreakEvent Event){
        Player player = Event.getPlayer();
        String pname = player.getName();
        Material block = Event.getBlock().getType();
        PluginSupporter.RaNbOo data = PluginSupporter.GetRanboo(pname);
        if(data == null) return;
        Boolean datas = data.CheckRanboo;
        if(Objects.equals(datas, false)) return;
        if(Objects.equals(datas, true)){
            if(player.getInventory().getItemInMainHand().getType() == Material.AIR){
                Event.getBlock().getWorld().dropItemNaturally(Event.getBlock().getLocation(), new ItemStack(block));
                Event.setCancelled(true);
                Event.getBlock().setType(Material.AIR);
            }
        }
    }
}
