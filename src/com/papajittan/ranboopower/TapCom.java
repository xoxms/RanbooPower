package com.papajittan.ranboopower;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class TapCom implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        if(strings.length == 1){
            List<String> args = new ArrayList<>();
            args.add("add");
            args.add("remove");
            return args;
        }
        return null;
    }
}
