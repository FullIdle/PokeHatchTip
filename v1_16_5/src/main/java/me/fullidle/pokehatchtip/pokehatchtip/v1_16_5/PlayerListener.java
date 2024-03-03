package me.fullidle.pokehatchtip.pokehatchtip.v1_16_5;

import com.pixelmonmod.pixelmon.api.events.EggHatchEvent;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import me.fullidle.ficore.ficore.common.api.event.ForgeEvent;
import me.fullidle.pokehatchtip.pokehatchtip.common.CommonUtil;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
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
        ServerPlayerEntity spe = e.getPlayer();
        Pokemon pokemon = e.getPokemon();
        Player player = Bukkit.getPlayer(spe.getUUID());
        String json = pokemon.writeToNBT(new CompoundNBT()).toString();
        CommonUtil.broadcastEggMessage(CommonUtil.getFormatComponent(player, json));
    }
}
