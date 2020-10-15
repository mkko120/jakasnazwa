package io.github.mkko120.creative;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigsManager {

    private static ConfigsManager instance;

    public static ConfigsManager getInstance() {
        return instance;
    }

    private static FileConfiguration warpsConfig;

    private static FileConfiguration homesConfig;

    public static FileConfiguration getWarpsCustomConfig() {
        return warpsConfig;
    }

    public static FileConfiguration getHomesCustomConfig() {
        return homesConfig;
    }

    Creative cinstance = Creative.getInstance();

    public void loadHomes(){
        File homes = new File(cinstance.getDataFolder(), "homes.yml");
        if (!homes.exists())
            cinstance.saveResource("homes.yml", false);
        homesConfig = new YamlConfiguration();
        try {
            homesConfig.load(homes);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

    }

    public void loadWarps() {
        File warps = new File(cinstance.getDataFolder(), "warps.yml");
        if (!warps.exists())
            cinstance.saveResource("warps.yml", false);
        warpsConfig = new YamlConfiguration();
        try {
            warpsConfig.load(warps);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }



}
