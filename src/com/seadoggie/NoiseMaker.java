package com.seadoggie;

import org.bukkit.plugin.java.JavaPlugin;

public class NoiseMaker extends JavaPlugin {

    @Override
    public void onEnable() {

        this.getLogger().info("NOISE MAKER IS STARTING! (YES, I HAVE TO BE LOUD!)");

        // Register the events class with the plugin manager to receive events
        getServer().getPluginManager().registerEvents(new NoiseMakerListener(this), this);

        // This actually does literally nothing... idk why intellij wants it here...
        // super.onEnable();
    }
}
