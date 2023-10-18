package fun.sunrisemc.horses;

import java.util.logging.Logger;


import org.bukkit.plugin.java.JavaPlugin;

import fun.sunrisemc.horses.events.Mount;

public class Plugin extends JavaPlugin
{
  private static final Logger LOGGER=Logger.getLogger("horses");

  public void onEnable()
  {
    getServer().getPluginManager().registerEvents(new Mount(), this);
    LOGGER.info("horses enabled");
  }

  public void onDisable()
  {
    LOGGER.info("horses disabled");
  }
}
