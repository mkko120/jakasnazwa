package io.github.mkko120.creative.Commands;

import io.github.mkko120.creative.Helper;
import org.bukkit.Bukkit;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class TphereCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        //if sender is not a PLayer cancel task.
        if (!(sender instanceof Player)) {
            sender.sendMessage(Helper.color("&4Nie da sie tak!"));
            return true;
        }

        switch (args.length) {

            case 0:
                //if there is no arguments cancel task.
                sender.sendMessage(Helper.color("&4Podaj gracza!"));
                break;

            case 1:

                //Preparing variables.
                String teleportStr = args[0];

                Player teleportToPlayer = (Player) sender;
                Player teleportPlayer = Bukkit.getPlayer(teleportStr);

                //Teleporting Player to other player.
                teleportPlayer.teleport(teleportToPlayer);

                sender.sendMessage(Helper.color("&bPrzeteleportowano gracza " + teleportPlayer + " &bdo ciebie!"));
                break;


            default:
                //error if there is more arguments.
                sender.sendMessage(Helper.color("&4Za duzo argumentow!"));
                break;
        }

        return true;
    }
}