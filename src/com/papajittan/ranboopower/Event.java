package com.papajittan.ranboopower;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class Event implements Listener {
    @EventHandler
    public void onBlockBreak(BlockBreakEvent Event){
        Player player = Event.getPlayer();
        String pname = player.getName();
        Material block = Event.getBlock().getType();
        PluginSupporter.RaNbOo data = PluginSupporter.GetRanboo(pname);
        if(data == null) return;
        String datas = data.CheckRanboo;
        if(Objects.equals(datas, "no")) return;
        if(Objects.equals(datas, "yes")){
            if(player.getInventory().getItemInMainHand().getType() == Material.AIR){
                Event.getBlock().getWorld().dropItemNaturally(Event.getBlock().getLocation(), new ItemStack(block));
                Event.setCancelled(true);
                Event.getBlock().setType(Material.AIR);
            }
        }
    }
}
