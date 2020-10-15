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
import java.util.List;

public class SetwarpCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        File warpsConfigFile = new File(Creative.getInstance().getDataFolder(), "warps.yml");

        if (!(sender instanceof Player)) {
            sender.sendMessage(Helper.color("&cNie da sie tak z konsolki :P"));
            return true;
        }

        //Getting list of all warps.
        List<String> warps = (List<String>) ConfigsManager.getWarpsCustomConfig().getList("Warps");

            if (args[0].equals("")) {

                sender.sendMessage(Helper.color("&4Uzycie: /setwarp <nazwa warpa>"));

            }
            else {

                FileConfiguration cconf = ConfigsManager.getWarpsCustomConfig();

                String name = args[0];
                if (args.length > 1) {

                    for (int i = 1;
                         i < args.length;
                         i++) {

                        name = name + " " + args[i];


                    }

                }
                Player player = (Player) sender;

                Location location = player.getLocation();

                //creating hashmap of world
                String w = location.getWorld().getName();
                double x = location.getX();
                double y = location.getY();
                double z = location.getZ();
                float yaw = location.getYaw();
                float pitch = location.getPitch();

                try {
                    warps.add(name);
                    cconf.set(name + ".w", w);
                    cconf.set(name + ".x", x);
                    cconf.set(name + ".y", y);
                    cconf.set(name + ".z", z);
                    cconf.set(name + ".yaw", yaw);
                    cconf.set(name + ".p", pitch);
                    try {
                        cconf.save(warpsConfigFile);
                    } catch (Exception error){
                        error.printStackTrace();
                    }

                    player.sendMessage(Helper.color("&bPomyslnie ustawiono warpa " + "&l" + name + "&r" + "!"));
                } catch (Exception error) {
                    error.printStackTrace();
                }

            }





        return true;
    }
}
