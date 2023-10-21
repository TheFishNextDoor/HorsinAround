package fun.sunrisemc.horses;

import java.util.ArrayList;
import java.util.Iterator;

import org.bukkit.entity.Ageable;
import org.bukkit.entity.Breedable;
import org.bukkit.entity.Camel;
import org.bukkit.entity.ChestedHorse;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Parrot;
import org.bukkit.entity.Sittable;
import org.bukkit.entity.Strider;
import org.bukkit.entity.Wolf;
import org.bukkit.entity.minecart.ExplosiveMinecart;
import org.bukkit.entity.minecart.HopperMinecart;

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
        if (entity.isInWater()) list.add(ChatColor.DARK_AQUA + "Wet");
        if (entity.isFrozen()) list.add(ChatColor.WHITE + "Frozen");
        if (entity.isDead()) list.add(ChatColor.GRAY + "Dead");
        if (!entity.isEmpty()) list.add(ChatColor.GREEN + "Mounted");
        if (entity.isInsideVehicle()) list.add(ChatColor.GREEN + "Passenger");
        if (entity.isGlowing()) list.add(ChatColor.YELLOW + "Glowing");
        if (entity.isInvulnerable()) list.add(ChatColor.GRAY + "Invulnerable");
        if (!entity.hasGravity()) list.add(ChatColor.LIGHT_PURPLE + "Anti-Gravity");
    }

    public void a(Sittable sittable) {
        if (sittable.isSitting()) list.add(ChatColor.YELLOW + "Sitting");
    }

    public void a(ExplosiveMinecart explosiveMinecart) {
        if (explosiveMinecart.isIgnited()) list.add(ChatColor.DARK_RED + "IGNITED");
    }

    public void a(HopperMinecart hopperMinecart) {
        if (!hopperMinecart.isEnabled()) list.add(ChatColor.RED + "Disabled");
    }

    public void a(LivingEntity livingEntity) {
        if (livingEntity.isGliding()) list.add(ChatColor.DARK_PURPLE + "Gliding");
        if (livingEntity.isRiptiding()) list.add(ChatColor.DARK_AQUA + "Riptiding");
        if (livingEntity.isSwimming()) list.add(ChatColor.AQUA + "Swimming");
        if (livingEntity.isSleeping()) list.add(ChatColor.DARK_GRAY + "Sleeping");
        if (livingEntity.isClimbing()) list.add(ChatColor.GOLD + "Climbing");
        if (!livingEntity.hasAI()) list.add(ChatColor.DARK_RED + "No AI");
        if (livingEntity.canBreatheUnderwater()) list.add(ChatColor.DARK_AQUA + "Gills");
        if (livingEntity.isInvisible()) list.add(ChatColor.GRAY + "Invisible");
    }

    public void a(Mob mob) {
        if (!mob.isAware()) list.add(ChatColor.DARK_GRAY + "Unaware");
    }

    public void a(Ageable ageable) {
        if (!ageable.isAdult()) list.add(ChatColor.LIGHT_PURPLE + "Baby");
    }

    public void a(Breedable breedable) {
        if (breedable.canBreed()) list.add(ChatColor.YELLOW + "Breedable");
    }

    public void a(ChestedHorse chestedHorse) {
        if (chestedHorse.isCarryingChest()) list.add(ChatColor.GOLD + "Chested");
    }

    public void a(Camel camel) {
        if (camel.isDashing()) list.add(ChatColor.AQUA + "Dashing");
    }

    public void a(Wolf wolf) {
        if (wolf.isAngry()) list.add(ChatColor.DARK_RED + "Angry");
        if (wolf.isWet()) list.add(ChatColor.DARK_AQUA + "Wet Fur");
        if (wolf.isInterested()) list.add(ChatColor.YELLOW + "Interested");
    }

    public void a(Parrot parrot) {
        if (parrot.isDancing()) list.add(ChatColor.LIGHT_PURPLE + "Dancing");
    }

    public void a(Strider strider) {
        if (strider.isShivering()) list.add(ChatColor.BLUE + "Shivering");
    }
}
