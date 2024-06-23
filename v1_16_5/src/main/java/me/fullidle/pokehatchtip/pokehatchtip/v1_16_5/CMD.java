package me.fullidle.pokehatchtip.pokehatchtip.v1_16_5;

import com.pixelmonmod.pixelmon.api.pokemon.PokemonFactory;
import com.pixelmonmod.pixelmon.api.pokemon.species.Species;
import com.pixelmonmod.pixelmon.api.registries.PixelmonSpecies;
import net.minecraft.nbt.CompoundNBT;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.fullidle.pokehatchtip.pokehatchtip.common.Data.plugin;

public class CMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!sender.isOp()) {
            sender.sendMessage("You do not have permission!");
            return false;
        }
        plugin.reloadConfig();
        sender.sendMessage("RELOADED!");
        return false;
    }
}
