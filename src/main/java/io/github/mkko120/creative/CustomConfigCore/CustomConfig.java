package io.github.mkko120.creative.CustomConfigCore;

import io.github.mkko120.creative.ConfigsManager;
import io.github.mkko120.creative.Creative;

public class CustomConfig {

    private static CustomConfig instance;

    public static CustomConfig getInstance() {
        return instance;
    }

    public static void save(String conf) {
        Creative.getInstance().saveResource(conf + ".yml", false);
    }

    public void loadHomes() {
        ConfigsManager.getInstance().loadHomes();
    }

    public void loadWarps() {
        ConfigsManager.getInstance().loadWarps();
    }

}
