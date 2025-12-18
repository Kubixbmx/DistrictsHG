package pl.sagi.districts;

import org.bukkit.plugin.java.JavaPlugin;

public class DistrictsPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("dystrykty").setExecutor(new DistrictCommand(new DistrictManager()));
        getServer().getPluginManager().registerEvents(new ChatListener(new DistrictManager()), this);
        getLogger().info("DistrictsHG wlaczone!");
    }
}
