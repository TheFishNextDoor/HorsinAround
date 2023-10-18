package fun.sunrisemc.horses.events;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.AbstractHorse;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Tameable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import fun.sunrisemc.horses.Plugin;
import net.md_5.bungee.api.ChatColor;

public class Mount implements Listener {

    @EventHandler
    public void onMount(PlayerInteractEntityEvent event) {
        Player player = event.getPlayer();
        if (player ==  null) return;
        Entity entity = event.getRightClicked();
        if (!(entity instanceof Tameable)) return;
        Tameable tameable = (Tameable) entity;
        if (tameable.isTamed()) {
            player.sendMessage(ChatColor.WHITE + "" + ChatColor.BOLD + "Information");
            String customName = tameable.getCustomName();
            if (customName != null) player.sendMessage(ChatColor.WHITE + "Name: " + customName);
            player.sendMessage(ChatColor.WHITE + "Owner: " + tameable.getOwner().getName());
            

        }
        else {

        }
    }
}
