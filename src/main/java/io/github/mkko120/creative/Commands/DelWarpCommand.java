package io.github.mkko120.creative.Commands;

import io.github.mkko120.creative.Creative;
import io.github.mkko120.creative.CustomConfigCore.CustomConfig;
import io.github.mkko120.creative.Helper;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.List;

public class DelWarpCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        File warpsConfigFile = new File(Creative.getInstance().getDataFolder(), "warps.yml");


        if (!(sender instanceof Player)){
            sender.sendMessage(Helper.color("Nie da sie tak z konsolki!"));
            return true;
        }
        if (args[0].equals("")) {


            sender.sendMessage(Helper.color("&cWpisz nazwe warpa!"));

        } else {



            //Getting list of all warps.
            List<String> warps = (List<String>) CustomConfig.getWarpsCustomConfig().getList("Warps");

            Player player = (Player) sender;

            String name = args[0];
            if (args.length > 1) {

                for (int i = 1;
                     i < args.length;
                     i++) {

                    name = name + " " + args[i];


                }

            }
            if (!CustomConfig.getWarpsCustomConfig().isSet(name)) {
                sender.sendMessage(Helper.color("&cNie ma takiego warpa!"));
                return true;
            }

            try {

                warps.remove(name);
                CustomConfig.getWarpsCustomConfig().getConfigurationSection(name).set(name, null);

                try {
                    CustomConfig.getWarpsCustomConfig().save(warpsConfigFile);
                } catch (Exception error){
                    error.printStackTrace();
                }

                player.sendMessage(Helper.color("&bPomyslnie usunieto warpa " + "&l" + name + "&r" + "!"));

            } catch (NullPointerException error) {

                error.printStackTrace();

            }

            return true;

        }

        return true;
    }
}
