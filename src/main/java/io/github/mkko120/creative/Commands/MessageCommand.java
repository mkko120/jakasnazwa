package io.github.mkko120.creative.Commands;

import io.github.mkko120.creative.Creative;
import org.bukkit.command.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.Random;


public class MessageCommand implements CommandExecutor {

    final FileConfiguration configuration = Creative.getInstance().getConfig();
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        //If sender isn't instance of player.
        if (!(sender instanceof Player)) {
            sender.sendMessage("hahah nie dla psa! Uzyj taj komendy jako plebs :P");
        } else {

            //Getting random message form config.
            int rand  = new Random().nextInt(configuration.getStringList("Messages").size()-1);

            sender.sendMessage(configuration.getStringList("Messages").get(rand));
        }
        return false;
    }
}
