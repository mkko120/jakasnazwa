package io.github.mkko120.creative.Commands;

import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.Location;

/**
 * Teleport command.
 *
 * Teleports player to the middle of the world.
 * @author mkko120
 */

public class CenterCommand implements CommandExecutor {

    /**
     * Executes the given command, returning its success
     *
     * @param sender  Source of the command
     * @param command Command which was executed
     * @param s  Alias of the command which was used
     * @param args    Passed command arguments
     * @return true if a valid command, otherwise false
     */

    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Nie jestes graczem!");
        }
        else {

            // Player-containing variable.
            Player player = (Player) sender;

            // Location-containing variable.
            Location location = new Location(player.getWorld(), 0, 75, 0 );

            // Teleport player to location
            if (player.teleport(location)) {
                player.sendMessage("Zostales przeteleportowany!");
            }
            else {
                player.sendMessage("OOPS! Something went wrong!");
            }

        }

        return false;
    }
}
