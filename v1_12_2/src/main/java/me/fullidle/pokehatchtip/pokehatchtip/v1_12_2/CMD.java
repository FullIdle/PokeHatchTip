package me.fullidle.pokehatchtip.pokehatchtip.v1_12_2;

import com.pixelmonmod.pixelmon.Pixelmon;
import com.pixelmonmod.pixelmon.enums.EnumSpecies;
import net.minecraft.nbt.NBTTagCompound;
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
        NBTTagCompound nbt = Pixelmon.pokemonFactory.create(EnumSpecies.Abomasnow).writeToNBT(new NBTTagCompound());
        String json = nbt.toString();
        sender.sendMessage(json);
        sender.sendMessage("§3以上是一只Abomasnow的Json数据,请按照格式去配置config.yml");
        return false;
    }

    public void test(){

    }

    public void test2(){

    }
}
