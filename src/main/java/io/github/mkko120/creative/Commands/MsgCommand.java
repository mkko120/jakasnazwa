package io.github.mkko120.creative.Commands;

import io.github.mkko120.creative.Helper;
import org.bukkit.Bukkit;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class MsgCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(Helper.color("&4Nie da sie tak z konsolki :>"));
            return true;
        } else {

            switch (args.length) {

                case 0:
                case 1:
                    sender.sendMessage(Helper.color("&4Uzycie: /msg <gracz> <wiadomosc>"));
                    break;
                case 2:

                    String msgToStr = args[0];
                    String msgTxtStr = args[1];

                    Player msgToPlayer = Bukkit.getPlayerExact(msgToStr);
                    Player msgSendPlayer = Bukkit.getPlayerExact(String.valueOf(sender));

                    if (msgToStr == null || !msgToPlayer.isOnline()){
                        sender.sendMessage(Helper.color("&cGracz" + msgToStr + " jest offline!"));
                        break;
                    } else {
                        msgToPlayer.sendMessage(Helper.color(msgSendPlayer + "&6 -> &r" + msgToPlayer + "&6: &8" + msgTxtStr));
                        break;
                    }
                default:
                    sender.sendMessage(Helper.color("&4Za duzo agrumentow!"));
                    break;
            }

        }

        return true;
    }
}