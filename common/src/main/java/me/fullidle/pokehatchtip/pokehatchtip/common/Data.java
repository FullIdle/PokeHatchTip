package me.fullidle.pokehatchtip.pokehatchtip.common;

import com.google.gson.Gson;
import org.bukkit.plugin.Plugin;

import java.util.List;

public class Data {
    public static Plugin plugin;
    public static String tip;
    public static String componentDisplay;
    public static List<String> componentHover;
    public static Gson gson = new Gson();

    public static void reload(){
        tip = plugin.getConfig().getString("tip");
        componentDisplay = plugin.getConfig().getString("component.display");
        componentHover = plugin.getConfig().getStringList("component.hover");
    }
}
