package fun.sunrisemc.horses.commands;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import fun.sunrisemc.horses.EntityInfoMsg;
import fun.sunrisemc.horses.Utl;
import net.md_5.bungee.api.ChatColor;

public class EntityInfo implements CommandExecutor, TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return null;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!command.getName().equalsIgnoreCase("entityinfo")) return false;
        if (!sender.hasPermission(command.getPermission())) return false;
        if (!(sender instanceof Player)) return false;
        Player player = (Player) sender;
        Entity entity = Utl.rayTraceEntity(player);
        if (entity != null) new EntityInfoMsg(player, entity, "Entity Info");
        else player.sendMessage(ChatColor.RED + "You must be looking at an entity.");
        return true;
    }
}