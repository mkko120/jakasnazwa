package io.github.mkko120.creative.Commands;

import io.github.mkko120.creative.Helper;
import org.bukkit.Bukkit;
import org.bukkit.command.*;

public class BroadcastCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length >= 1) {


            String msg = "";
            for (int i = 0;
                 i< args.length;
                 i++) {

                //Getting message.
                msg = msg + args[i] + " ";
            }

            //Broadcasting message.
            Bukkit.broadcastMessage(Helper.color(" "));
            Bukkit.broadcastMessage(Helper.color("- &b" + msg));
            Bukkit.broadcastMessage(Helper.color(" "));

            return true;

        } else {
            sender.sendMessage(Helper.color("&4Usage: /bc <message>"));
        }


        return true;
    }
}
