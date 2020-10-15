package io.github.mkko120.creative;

import io.github.mkko120.creative.Commands.*;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import java.io.File;
import java.util.Random;

/**
 * Main class of plugin.
 *
 * Responsible for commands, events, etc...
 * @author mkko120
 */

public final class Creative extends JavaPlugin {


    private static Creative instance;

    public static Creative getInstance(){
        return instance;
    }

    //Class responsible for doing things when plugin turned on.
    @Override
    public void onEnable() {

        //Config settings.
        instance = this;

        final FileConfiguration config = Creative.getInstance().getConfig();

        File file = new File("./creative/config.yml");
        boolean exists = file.exists();
        if (!(exists)) {
            instance.saveDefaultConfig();
            config.options().copyDefaults(true);
        }
        //End of config settings.

        //Executor for CenterCommand().
        getCommand("cvcenter").setExecutor(new CenterCommand());

        //Executor for FoodCommand().
        getCommand("cvfood").setExecutor(new FoodCommand());

        //Executor for BroadcastCommand()
        getCommand("cvbroadcast").setExecutor(new BroadcastCommand());

        //Executor for MsgCommand()
        getCommand("cvmessage").setExecutor(new MsgCommand());

        //Executor for MessageCommand()
        getCommand("cvqotd").setExecutor(new MessageCommand());

        //Executor for TeleportCommand()
        getCommand("cvteleport").setExecutor(new TeleportCommand());

        //Executor for TphereCommand()
        getCommand("cvteleporthere").setExecutor(new TphereCommand());

        //Executor for TpallCommand
        getCommand("cvteleportall").setExecutor(new TpallCommand());

        //Executor for WarpCommand
        getCommand("warp").setExecutor(new WarpCommand());

        //Executor for SetWarpCommand
        getCommand("setwarp").setExecutor(new SetwarpCommand());

        //Executor for DelWarpCommand
        getCommand("delwarp").setExecutor(new DelWarpCommand());

        //Executor for HomeCommand
        getCommand("home").setExecutor(new HomeCommand());

        BukkitScheduler scheduler = getServer().getScheduler();

        //Message randomized from list or static from String?
        boolean num = config.getBoolean("Is randomized?");

        //new scheduled task.
        if (num) {
            scheduler.scheduleSyncRepeatingTask(this, new Runnable() {

                //Scheduled task
                public void run() {
                    int rand = new Random().nextInt(config.getStringList("Message").size() - 1);
                    Bukkit.broadcastMessage(config.getStringList("Message").get(rand));
                }
                //Down here \/ time for executing task (in ticks)
            }, 0L, config.getLong("Ticks"));
        } else {

            //new scheduled task.
            scheduler.scheduleSyncRepeatingTask(this, new Runnable() {

                //Scheduled task
                public void run() {
                    Bukkit.broadcastMessage(config.getString("Message"));
                }
                //Down here \/ time for executing task (in ticks)
            }, 0L, config.getLong("Ticks"));


        }
        try {
            ConfigsManager.getInstance().loadWarps();
            ConfigsManager.getInstance().loadHomes();
        } catch (Exception error) {
            error.printStackTrace();
        }

    }


    }
