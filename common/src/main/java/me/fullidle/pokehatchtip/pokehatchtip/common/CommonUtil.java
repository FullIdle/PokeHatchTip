package me.fullidle.pokehatchtip.pokehatchtip.common;

import me.clip.placeholderapi.PlaceholderAPI;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import static me.fullidle.pokehatchtip.pokehatchtip.common.Data.*;

public class CommonUtil {
    public static void broadcastEggMessage(BaseComponent[] components){
        Bukkit.spigot().broadcast(components);
    }
    /*json是宝可梦的json数据*/
    public static BaseComponent[] getFormatComponent(Player player,String nbt) {
        String str = "{component}";
        int l = tip.indexOf(str);

        ComponentBuilder start = new ComponentBuilder(replacePapi(tip.substring(0,l),player,nbt));
        ComponentBuilder hoverC = new ComponentBuilder(replacePapi(componentDisplay,player,nbt));
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < componentHover.size(); i++) {
            stringBuilder.append(replacePapi(componentHover.get(i),player,nbt));
            if (i != componentHover.size()-1){
                stringBuilder.append("\n");
            }
        }
        ComponentBuilder end = new ComponentBuilder(replacePapi(tip.substring(l+str.length()),player,nbt));

        hoverC.event(new HoverEvent(HoverEvent.Action.SHOW_TEXT,new ComponentBuilder(stringBuilder.toString()).create()));

        return start.append(hoverC.create()).append(end.create()).create();
    }
    public static String replacePapi(String s,Player player,String nbt){
        return PlaceholderAPI.setPlaceholders(player, s.replace("{pokemon}",nbt))
                .replace("&", "§");
    }
}
