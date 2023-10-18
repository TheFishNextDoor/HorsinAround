package fun.sunrisemc.horses;

import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class EntityInfoMsg {

    private final Player player;

    public EntityInfoMsg(Player player, Entity entity) {
        this.player = player;
        if (!(entity instanceof LivingEntity)) return;
    }

    public void Name(LivingEntity livingEntity) {
        send("Name", livingEntity.getCustomName());
    }

    public void Speed(LivingEntity livingEntity) {
        send("Speed", livingEntity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED));
    }
    
    private void send(String field, Object value) {
        if (value != null) player.sendMessage(ChatColor.WHITE + field + ChatColor.RESET + ": " + value.toString());
    }
}
