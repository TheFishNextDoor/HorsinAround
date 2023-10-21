package fun.sunrisemc.horses;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

import fun.sunrisemc.horses.commands.EntityInfo;
import fun.sunrisemc.horses.events.Mount;
import fun.sunrisemc.horses.events.Tame;

public class Plugin extends JavaPlugin {
  private static final Logger LOGGER=Logger.getLogger("HorsinAround");

  public void onEnable() {
    getServer().getPluginManager().registerEvents(new Mount(this), this);
    getServer().getPluginManager().registerEvents(new Tame(this), this);
    getCommand("entityinfo").setExecutor(new EntityInfo());
    LOGGER.info("HorsinAround enabled");
  }

  public void onDisable() {
    LOGGER.info("HorsinAround disabled");
  }
}
