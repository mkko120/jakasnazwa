package io.github.mkko120.creative.Commands;

import io.github.mkko120.creative.Helper;
import org.bukkit.Bukkit;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class TpallCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            //If sender is not instance of player: cancel task.
            sender.sendMessage(Helper.color("&bNie mozna tak!"));
            return true;

        }

        switch (args.length) {

            case 0:

                //Preparing player variables.
                Player teleportedTpPlayers = (Player) Bukkit.getOnlinePlayers();
                Player targetTpPlayer = (Player) sender;

                //Teleporting all players to sender.
                teleportedTpPlayers.teleport(targetTpPlayer);

                //chat message.
                sender.sendMessage(Helper.color("&bPrzetelepotrowano wszystkich graczy do ciebie!"));
                break;

            case 1:

                String targetPlayerString = args[0];

                Player teleportedPlayers = (Player) Bukkit.getOnlinePlayers();
                Player targetPlayer = Bukkit.getPlayer(targetPlayerString);

                teleportedPlayers.teleport(targetPlayer);
                sender.sendMessage(Helper.color("&bPomyslnie teleportowano wszystkich graczy do " + targetPlayer + "!"));
                break;

            default:
                sender.sendMessage(Helper.color("&4Za duzo argumentow!"));
        }


        return true;
    }
}

