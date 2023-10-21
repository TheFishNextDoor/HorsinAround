package fun.sunrisemc.horses.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Tameable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import fun.sunrisemc.horses.EntityInfoMsg;
import fun.sunrisemc.horses.Plugin;

public class Mount implements Listener {
    private final Plugin plugin;

    public Mount(Plugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onMount(final PlayerInteractEntityEvent event) {
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
            @Override
            public void run() {
                Player player = event.getPlayer();
                if (player ==  null) return;
                Entity entity = event.getRightClicked();
                if (entity instanceof Tameable && !((Tameable) entity).isTamed()) return;
                if (!entity.getPassengers().contains(player)) return;
                
                if (entity instanceof LivingEntity) new EntityInfoMsg(player, entity, "Mount");
                else new EntityInfoMsg(player, entity, "Vehicle");
            }
        }, 0);
    }
}