package me.fullidle.pokehatchtip.pokehatchtip.common;

import com.google.gson.Gson;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Data {
    public static Plugin plugin;
    public static Map<String,String> papi = new HashMap<>();
    public static String tip;
    public static String componentDisplay;
    public static List<String> componentHover;
    public static Gson gson = new Gson();

    public static void reload(){
        papi.clear();
        tip = plugin.getConfig().getString("tip");
        componentDisplay = plugin.getConfig().getString("component.display");
        componentHover = plugin.getConfig().getStringList("component.hover");
        ConfigurationSection papiCon = plugin.getConfig().getConfigurationSection("papi");
        for (String key : papiCon.getKeys(false)) {
            papi.put(key,papiCon.getString(key));
        }
    }
}
