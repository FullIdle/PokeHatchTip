package me.fullidle.pokehatchtip.pokehatchtip.v1_12_2;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.fullidle.pokehatchtip.pokehatchtip.common.Data.plugin;

public class CMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) return false;
        plugin.reloadConfig();
        sender.sendMessage("RELOADED!");
        return false;
    }
}
