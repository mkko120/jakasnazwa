package io.github.mkko120.creative.Commands;

import io.github.mkko120.creative.Helper;
import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Item command.
 * Command used for giving an item to a player.
 *
 * @author mkko120
 */

public class FoodCommand implements CommandExecutor {

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

            //Must be an argument if you sending this as console.
            //Set var target to the argument 0 as a Player

            switch (args.length) {

                case 0:
                    sender.sendMessage(Helper.color("&4Podaj Gracza!"));
                    break;

                case 1:
                    Player target = Bukkit.getPlayerExact(args[0]);

                    //Setting ItemStack to give some beef.
                    ItemStack stack = new ItemStack(Material.COOKED_BEEF, 16);

                    //Giving beef to player.
                    target.getInventory().addItem(stack);
                    break;
            }

            return true;
        }
        else {
            //Preparing some variables...
            Player player = (Player) sender;

            //Setting ItemStack to give some beef.
            ItemStack stack = new ItemStack(Material.COOKED_BEEF, 16);

            //Giving beef to player.
            player.getInventory().addItem(stack);
        }
        return true;
    }
}
