package io.github.mkko120.creative;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigsManager {

    private static ConfigsManager instance;


    public static ConfigsManager getInstance() {
        return instance;
    }

    Creative cinstance = Creative.getInstance();

    public YamlConfiguration loadHomes(){

        YamlConfiguration homesConfig;
        File homes = new File(cinstance.getDataFolder(), "homes.yml");
        if (!homes.exists())
            cinstance.saveResource("homes.yml", false);
        homesConfig = new YamlConfiguration();
        try {
            homesConfig.load(homes);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
            return null;
        }
        return homesConfig;
    }

    public YamlConfiguration loadWarps() {
        YamlConfiguration warpsConfig;
        File warps = new File(cinstance.getDataFolder(), "warps.yml");
        if (!warps.exists())
            cinstance.saveResource("warps.yml", false);
        warpsConfig = new YamlConfiguration();
        try {
            warpsConfig.load(warps);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
            return null;
        }
        return warpsConfig;
    }



}
