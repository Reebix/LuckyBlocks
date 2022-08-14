package net.rebix.luckyblocks;


import net.rebix.luckyblocks.util.Registry;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class Luckyblocks extends JavaPlugin {
    public static Luckyblocks instance;
    @Override
    public void onEnable() {
        instance = this;
        new Registry();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
