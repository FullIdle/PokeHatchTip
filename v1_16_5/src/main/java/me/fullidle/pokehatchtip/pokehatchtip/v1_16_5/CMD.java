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
        if (sender instanceof Player) return false;
        plugin.reloadConfig();
        Species abomasnow = PixelmonSpecies.ABOMASNOW.getValueUnsafe();
        CompoundNBT nbt = PokemonFactory.create(abomasnow).writeToNBT(new CompoundNBT());
        String json = nbt.toString();
        sender.sendMessage(json);
        sender.sendMessage("§3以上是一只Abomasnow的Json数据,请按照格式去配置config.yml");
        sender.sendMessage("§aconfig.yml已重载");
        return false;
    }
}
