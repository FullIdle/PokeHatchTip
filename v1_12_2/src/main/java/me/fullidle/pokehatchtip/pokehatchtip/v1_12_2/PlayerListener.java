package me.fullidle.pokehatchtip.pokehatchtip.v1_12_2;

import com.pixelmonmod.pixelmon.api.events.EggHatchEvent;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import me.fullidle.ficore.ficore.common.api.event.ForgeEvent;
import me.fullidle.pokehatchtip.pokehatchtip.common.CommonUtil;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerListener implements Listener {
    @EventHandler
    public void onHatchEvent(ForgeEvent event){
        if (!(event.getForgeEvent() instanceof EggHatchEvent.Post)) {
            return;
        }
        EggHatchEvent e = (EggHatchEvent) event.getForgeEvent();
        EntityPlayerMP mp = e.getPlayer();
        Pokemon pokemon = e.getPokemon();
        Player player = Bukkit.getPlayer(mp.getUniqueID());
        String json = pokemon.writeToNBT(new NBTTagCompound()).toString();
        CommonUtil.broadcastEggMessage(CommonUtil.getFormatComponent(player, json));
    }
}
