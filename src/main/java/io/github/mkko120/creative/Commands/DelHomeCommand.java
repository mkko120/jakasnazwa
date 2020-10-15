package io.github.mkko120.creative.Commands;

import io.github.mkko120.creative.Creative;
import io.github.mkko120.creative.CustomConfigCore.CustomConfig;
import io.github.mkko120.creative.Helper;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class DelHomeCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        FileConfiguration cconf = CustomConfig.getHomesCustomConfig();

        File homesConfigFile = new File(Creative.getInstance().getDataFolder(), "homes.yml");

            if (!(sender instanceof Player)) {
            sender.sendMessage(Helper.color("&4Nie da sie tak z konsolki :D"));
            return true;
        }

        String name = "";

        if (args.length == 1) {
            name = args[1];
        }

        for (int i = 0;
            i < args.length;
            i++) {
                name = name + args[i] + " ";
        }

        Player player = (Player) sender;
        String plrname = player.getDisplayName();
        Location location = player.getLocation();

        try {
            cconf.set(plrname + "." + name, null);
            cconf.save(homesConfigFile);
        } catch (Exception error) {
            error.printStackTrace();
        }
        return true;
    }



}
