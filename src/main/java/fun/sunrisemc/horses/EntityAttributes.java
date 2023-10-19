package fun.sunrisemc.horses;

import java.util.ArrayList;
import java.util.Iterator;

import org.bukkit.entity.ChestedHorse;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;

import net.md_5.bungee.api.ChatColor;

public class EntityAttributes {
    private ArrayList<String> list = new ArrayList<>();

    public Iterator<String> iterator() {
        return list.iterator();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    public void a(Entity entity) {
        if (entity.isInWater()) {
            list.add(ChatColor.DARK_AQUA + "Wet");
        }
        if (entity.isFrozen()) {
            list.add(ChatColor.WHITE + "Frozen");
        }
        if (entity.isDead()) {
            list.add(ChatColor.GRAY + "Dead");
        }
        if (!entity.isEmpty()) {
            list.add(ChatColor.GREEN + "Mounted");
        }
        if (entity.isInsideVehicle()) {
            list.add(ChatColor.WHITE + "Passenger");
        }
        if (entity.isGlowing()) {
            list.add(ChatColor.YELLOW + "Glowing");
        }
        if (entity.isInvulnerable()) {
            list.add(ChatColor.GRAY + "Invulnerable");
        }
        if (!entity.hasGravity()) {
            list.add(ChatColor.LIGHT_PURPLE + "Anti-Gravity");
        }
    }

    public void a(LivingEntity livingEntity) {
        if (livingEntity.isGliding()) {
            list.add(ChatColor.DARK_PURPLE + "Gliding");
        }
        if (livingEntity.isRiptiding()) {
            list.add(ChatColor.DARK_AQUA + "Riptiding");
        }
        if (livingEntity.isSwimming()) {
            list.add(ChatColor.AQUA + "Swimming");
        }
        if (livingEntity.isSleeping()) {
            list.add(ChatColor.DARK_GRAY + "Sleeping");
        }
        if (livingEntity.isClimbing()) {
            list.add(ChatColor.GOLD + "Climbing");
        }
        if (!livingEntity.hasAI()) {
            list.add(ChatColor.DARK_RED + "No AI");
        }
        if (livingEntity.canBreatheUnderwater()) {
            list.add(ChatColor.DARK_AQUA + "Gills");
        }
        if (livingEntity.isInvisible()) {
            list.add(ChatColor.GRAY + "Invisible");
        }
    }

    public void a(ChestedHorse chestedHorse) {
        if (chestedHorse.isCarryingChest()) {
            list.add(ChatColor.GOLD + "Chested");
        }
    }
}
