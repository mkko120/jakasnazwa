package io.github.mkko120.creative.Commands;

import io.github.mkko120.creative.ConfigsManager;
import io.github.mkko120.creative.Creative;
import io.github.mkko120.creative.Helper;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class SetHomeCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        FileConfiguration cconf = ConfigsManager.getHomesCustomConfig();

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

        String w = location.getWorld().getName();
        double x = location.getX();
        double y = location.getY();
        double z = location.getZ();
        float yaw = location.getYaw();
        float pitch = location.getPitch();

        try {
            cconf.set(plrname + "." + name + ".w", w);
            cconf.set(plrname + "." + name + ".x", x);
            cconf.set(plrname + "." + name + ".y", y);
            cconf.set(plrname + "." + name + ".z", z);
            cconf.set(plrname + "." + name + ".yaw", yaw);
            cconf.set(plrname + "." + name + ".pitch", pitch);

            cconf.save(homesConfigFile);
        } catch (Exception error) {
            error.printStackTrace();
        }
        return true;
    }
}
