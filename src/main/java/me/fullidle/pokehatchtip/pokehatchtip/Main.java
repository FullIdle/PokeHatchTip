package me.fullidle.pokehatchtip.pokehatchtip;

import me.fullidle.ficore.ficore.common.SomeMethod;
import me.fullidle.pokehatchtip.pokehatchtip.common.Data;
import me.fullidle.pokehatchtip.pokehatchtip.v1_12_2.CMD;
import me.fullidle.pokehatchtip.pokehatchtip.v1_12_2.PlayerListener;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        Data.plugin = this;
        reloadConfig();
        Listener listener = null;
        CommandExecutor cmd = null;
        switch (SomeMethod.getMinecraftVersion()) {
            case "1.12.2":{
                listener = new PlayerListener();
                cmd = new CMD();
                break;
            }
            case "1.16.5":{
                listener = new me.fullidle.pokehatchtip.pokehatchtip.v1_16_5.PlayerListener();
                cmd = new me.fullidle.pokehatchtip.pokehatchtip.v1_16_5.CMD();
                break;
            }
        }
        if (listener == null){
            getLogger().info("§c插件不是适配你的服务端!");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }
        getCommand("pokehatchtip").setExecutor(cmd);
        Bukkit.getPluginManager().registerEvents(listener,this);
        getLogger().info("§a插件已载入!");
    }

    @Override
    public void reloadConfig() {
        saveDefaultConfig();
        super.reloadConfig();
        Data.reload();
    }
}