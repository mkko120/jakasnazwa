package io.github.mkko120.creative.Commands;

import io.github.mkko120.creative.Helper;
import org.bukkit.Bukkit;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class TeleportCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            //If sender is not a Player deny its actions.
            sender.sendMessage("nope");
            return true;
        }

        Player player = (Player) sender;

        switch (args.length) {

            case 0:
                //If there is no arguments then print usage of command.
                player.sendMessage(Helper.color("&eUzycie: &7<kogo> <doKogo>"));
                break;

            case 1:
                //Set variable to argument.
                String targetStr = args[0];
                //Set String to Player.
                Player targetPlayer = Bukkit.getPlayer(targetStr);

                //If Player is offline...
                if (targetStr == null || !targetPlayer.isOnline()) {
                    //...Print that player is offline.
                    player.sendMessage(Helper.color("&aGracz" + targetPlayer + " &ajest offline!"));
                    break;
                }

                //Teleport player to target.
                player.teleport(targetPlayer);
                //Print that command was successful.
                player.sendMessage(Helper.color("&aPrzeteleportowano!"));
                break;

            case 2:

                //Set args to variables.
                String teleportedStr = args[0];
                String teleportToStr = args[1];

                //set variables to Players.
                Player teleportedPlayer = Bukkit.getPlayer(teleportedStr);
                Player teleportToPlayer = Bukkit.getPlayer(teleportToStr);

                //If player is offline...
                if (teleportedPlayer == null || !teleportToPlayer.isOnline()){

                    //...Print that player is offline.
                    player.sendMessage(Helper.color("&cGracz" + teleportedStr + " jest offline!"));
                    break;
                }

                //If player is offline...
                if (teleportToPlayer == null || !teleportToPlayer.isOnline()){

                    //...Print that player is offline.
                    player.sendMessage(Helper.color("&cGracz" + teleportToStr + " jest offline!"));
                    break;
                }

                //Teleport targeted player to second player.
                teleportedPlayer.teleport(teleportToPlayer);

                //Print that command was successful.
                player.sendMessage(Helper.color("&aTeleportowano sie do gracza " + teleportToStr + "&a!"));
                break;

            default:
                //if there is more args print error.
                player.sendMessage(Helper.color("&cBlad! Zbyt wiele argumentow!"));
                break;
        }
        return true;
    }
}

