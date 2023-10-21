package fun.sunrisemc.horses.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.AnimalTamer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTameEvent;

import fun.sunrisemc.horses.EntityInfoMsg;
import fun.sunrisemc.horses.Plugin;

public class Tame implements Listener {
    private final Plugin plugin;

    public Tame(Plugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEntityTame(final EntityTameEvent event) {
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
            @Override
            public void run() {
                AnimalTamer owner = event.getOwner();
                if (!(owner instanceof Player)) return;
                Player player = (Player) owner;
                new EntityInfoMsg(player, event.getEntity(), "Tamed Animal");
            }
        }, 0);
    }
}
