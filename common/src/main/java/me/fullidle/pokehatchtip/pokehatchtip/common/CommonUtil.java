package me.fullidle.pokehatchtip.pokehatchtip.common;

import com.google.gson.JsonObject;
import me.clip.placeholderapi.PlaceholderAPI;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Map;

import static me.fullidle.pokehatchtip.pokehatchtip.common.Data.*;

public class CommonUtil {
    public static void broadcastEggMessage(BaseComponent[] components){
        Bukkit.spigot().broadcast(components);
    }
    /*json是宝可梦的json数据*/
    public static BaseComponent[] getFormatComponent(Player player,String json) {
        JsonObject object = gson.fromJson(json, JsonObject.class);
        String str = "{component}";
        int l = tip.indexOf(str);

        ComponentBuilder start = new ComponentBuilder(replacePapi(tip.substring(0,l),player));
        ComponentBuilder hoverC = new ComponentBuilder(replacePapi(componentDisplay,player,object));
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < componentHover.size(); i++) {
            stringBuilder.append(replacePapi(componentHover.get(i),player,object));
            if (i != componentHover.size()-1){
                stringBuilder.append("\n");
            }
        }
        ComponentBuilder end = new ComponentBuilder(replacePapi(tip.substring(l+str.length()),player));

        hoverC.event(new HoverEvent(HoverEvent.Action.SHOW_TEXT,new ComponentBuilder(stringBuilder.toString()).create()));

        return start.append(hoverC.create()).append(end.create()).create();
    }

    public static String replacePapi(String s,Player player,JsonObject jsonObject){
        s = PlaceholderAPI.setPlaceholders(player, s)
                .replace("&", "§");
        for (Map.Entry<String, String> entry : papi.entrySet()) {
            String cs = "{" + entry.getKey() + "}";
            s = s.replace(cs,jsonObject.get(entry.getValue()).getAsString());
        }
        return s;
    }
    public static String replacePapi(String s,Player player){
        return PlaceholderAPI.setPlaceholders(player, s)
                .replace("&", "§");
    }
}
