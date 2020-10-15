package io.github.mkko120.creative.CustomConfigCore;

import io.github.mkko120.creative.ConfigsManager;
import io.github.mkko120.creative.Creative;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.HashMap;

public class CustomConfig {

    private static CustomConfig instance;

    private HashMap<String, String> confingurationMap;

    private static FileConfiguration warpsConf;

    private static FileConfiguration homesConf;

    public static FileConfiguration getWarpsCustomConfig() {
        return warpsConf;
    }

    public static FileConfiguration getHomesCustomConfig() {
        return homesConf;
    }

    public static CustomConfig getInstance() {
        return instance;
    }

    public static void save(String conf) {
        Creative.getInstance().saveResource(conf + ".yml", false);
    }

    public void loadHomes() {

        homesConf = ConfigsManager.getInstance().loadHomes();
    }

    public void loadWarps() {
        warpsConf = ConfigsManager.getInstance().loadWarps();
    }

}
