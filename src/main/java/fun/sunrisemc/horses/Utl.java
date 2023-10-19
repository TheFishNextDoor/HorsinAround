package fun.sunrisemc.horses;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import org.bukkit.entity.Entity;

public class Utl {

    public static double round(double x, int places) {
        if (places < 0) throw new IllegalArgumentException();
        BigDecimal bd = BigDecimal.valueOf(x);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static String ticksToTime(int ticks) {
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
        return String.join(", ", list);
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
        String customName = entity.getCustomName();
        if (customName != null) return customName;
        return entity.getName();
    }
}
