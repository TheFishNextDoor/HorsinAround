package fun.sunrisemc.horses;

import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public abstract class PlayerMsg {
    private final Player player;

    public PlayerMsg(Player player) {
        this.player = player;
    }

    public void h1(String header) { // Bold Header
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&f&l" + header));
    }

    public void ul(String name) { // Unordered List
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&f" + name + "&r:"));
    }
    
    public void li(Object value) { // List Item
        if (value != null) player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&f  " + value));
    }

    public void lf(String name, Object value) { // Indented Field
        field("&f  " + name, value);
    }  

    public void field(String name, Object value) { // Field
        if (value == null) return;
        if (value instanceof Double) value = Utl.round((Double) value, 2);
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&f" + name + "&r: " + value));
    }

    public void ratiof(String name, Object value, Object max) { // Ratio Field
        field(name, value + "/" + max);
    }

    public void percentf(String name, double value, double max) { // Ratio Field
        double ratio = value / max;
        double percent = Utl.round(ratio * 100, 0);
        field(name, percent + "%");
    }
}
