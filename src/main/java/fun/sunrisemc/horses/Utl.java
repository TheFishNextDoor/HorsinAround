package fun.sunrisemc.horses;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.function.Predicate;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.RayTraceResult;
import org.bukkit.util.Vector;

public class Utl {

    public static double round(double x, int places) {
        if (places < 0) throw new IllegalArgumentException();
        BigDecimal bd = BigDecimal.valueOf(x);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static String toTime(int ticks) {
        int days = ticks / 1728000;
        int hours = (ticks % 1728000) / 72000;
        int minutes = (ticks % 72000) / 1200;
        int seconds = (ticks % 1200) / 20;
        ArrayList<String> list = new ArrayList<>();
        if (days > 1) list.add(days + " days");
        else if (days == 1) list.add(days + " day");
        if (hours > 1) list.add(hours + " hours");
        else if (hours == 1) list.add(hours + " hour");
        if (minutes > 1) list.add(minutes + " minutes");
        else if (minutes == 1) list.add(minutes + " minute");
        if (seconds > 1) list.add(seconds + " seconds");
        else if (seconds == 1) list.add(seconds + " second");
        if (list.isEmpty()) return "0 seconds";
        return String.join(", ", list);
    }

    public static String toPercent(Float val) {
        return round(val * 100, 0) + "%";
    }

    public static String titleCase(String input) {
        input = input.replaceAll("_", " ");
        StringBuilder titleCase = new StringBuilder();
        boolean nextTitleCase = true;
        for (char c : input.toCharArray()) {
            if (Character.isSpaceChar(c)) {
                nextTitleCase = true;
            } else if (nextTitleCase) {
                c = Character.toUpperCase(c);
                nextTitleCase = false;
            } else {
                c = Character.toLowerCase(c);
            }
            titleCase.append(c);
        }
        return titleCase.toString();
    }

    public static String yn(boolean bool) {
        if (bool) return "Yes";
        return "No";
    }

    public static String id(Entity entity) {
        if (entity == null) return null;
        String customName = entity.getCustomName();
        if (customName != null) return customName;
        return entity.getName();
    }

    public static String id(ItemStack itemStack) {
        String name = null;
        if (itemStack == null) return name;
        if (itemStack.getType().isAir()) return name;
        if (itemStack.hasItemMeta()) name = itemStack.getItemMeta().getDisplayName();
        if (name == null) name = id(itemStack.getType());
        if (name == null) return null;
        Integer amount = itemStack.getAmount();
        if (amount > 1) name = amount.toString() + "x " + name;
        return name; 
    }

    public static String id(Material material) {
        if (material == null) return null;
        if (material.isAir()) return null;
        return titleCase(material.toString());
    }

    public static String id(BlockFace blockFace) {
        if (blockFace == null) return null;
        return titleCase(blockFace.toString());
    }

    public static String id(Block block) {
        if (block == null) return null;
        if (block.getType().isAir()) return null;
        String coords = id(block.getLocation());
        if (coords == null) return null;
        return id(block.getType()) + " at " + coords;
    }

    public static String id(Location location) {
        if (location == null) return null;
        return location.getBlockX() + ", " + location.getBlockY() + ", " + location.getBlockZ();
    }

    public static Entity rayTraceEntity(final Player player) {
        Location eyeLocation = player.getEyeLocation();
        Vector direction = eyeLocation.getDirection();
        direction.multiply(100);
        RayTraceResult result = player.getWorld().rayTraceEntities(eyeLocation, direction, 65, 0.1, new Predicate<org.bukkit.entity.Entity>() {
            @Override
            public boolean test(Entity entity) {
                return entity != player;
            }
        });
        if (result == null) return null;
        return result.getHitEntity();
    }

    public static double toSpeed(Vector velocity) {
        double x = velocity.getX();
        double y = velocity.getY();
        double z = velocity.getZ();
        return Math.sqrt(x * x + y * y + z * z);
    }
}
