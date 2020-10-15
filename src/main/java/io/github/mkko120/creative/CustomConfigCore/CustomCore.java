package io.github.mkko120.creative.CustomConfigCore;


import org.bukkit.configuration.file.YamlConfiguration;

public interface CustomCore {

    void save(YamlConfiguration conf, String confname);
    void load(YamlConfiguration conf, String confSection);

}

