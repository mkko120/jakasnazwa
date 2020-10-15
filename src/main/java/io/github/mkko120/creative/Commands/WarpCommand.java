package io.github.mkko120.creative.Commands;

import io.github.mkko120.creative.CustomConfigCore.CustomConfig;
import io.github.mkko120.creative.Helper;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class WarpCommand implements CommandExecutor {
    /**
     *
     * Warp Command
     *
     * Responsible for teleporting to warps.
     * @author mkko120
     *
     **/

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        FileConfiguration cconf = CustomConfig.getWarpsCustomConfig();

        //Getting list of all warps.
        ArrayList warps = (ArrayList) cconf.getList("Warps");

        //Checking if sender is player.
        if (!(sender instanceof Player)) {
            sender.sendMessage(Helper.color("&cNie da sie wykonac tej komendy z konsolki :P"));
            return true;
        }



            if (args.length == 0) {
                //Printing available warps.
                sender.sendMessage(Helper.color("Dostepne warpy: "+ warps));

            }
            else {

                String name = args[0];
                if (args.length > 1) {

                    for (int i = 1;
                         i < args.length;
                         i++) {

                        name = name + " " + args[i];
                    }

                }
                //If there is no matching print info.
                if (!(cconf.isSet(name))) {
                    sender.sendMessage(Helper.color("&cNie ma takiego warpa!"));
                    return true;
                } else {

                    //get variables from list.
                    String w = cconf.getString(name + ".w");
                    double x = cconf.getDouble(name + ".x");
                    double y = cconf.getDouble(name + ".y");
                    double z = cconf.getDouble(name + ".z");
                    double yaw = cconf.getDouble(name + ".yaw");
                    double pitch = cconf.getDouble(name + ".pitch");
                    //teleport player to warp.
                    Player player = (Player) sender;
                    try {
                        player.teleport(new Location(Bukkit.getWorld(w), x, y, z,(float) yaw, (float) pitch));
                    } catch (Exception error) {
                        error.printStackTrace();
                    }
                    //send message to player
                    player.sendMessage(Helper.color("&bPrzeteleportowano do: " + "&l" + name + "&r" + "!"));
                }
            }
        return true;
    }
}
