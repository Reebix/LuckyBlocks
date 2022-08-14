package net.rebix.luckyblocks.util;

import net.rebix.luckyblocks.Luckyblocks;
import net.rebix.luckyblocks.bockevent.events.DiamondDrop;
import net.rebix.luckyblocks.bockevent.events.GolemSpawn;
import net.rebix.luckyblocks.bockevent.events.KnockbackStick;
import net.rebix.luckyblocks.util.commands.DropCoommand;
import net.rebix.luckyblocks.util.listener.onBlockBreakEvent;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;

import java.util.Objects;

public class Registry {

    public Registry() {
        registerEvent(new onBlockBreakEvent());

        registerCommand(new DropCoommand(), "drop");

        new GolemSpawn();
        new KnockbackStick();
        new DiamondDrop();

    }

    public static void registerCommand(CommandExecutor executor, String command) {
        Objects.requireNonNull(Luckyblocks.instance.getCommand(command)).setExecutor(executor);
    }

    public static void registerEvent(Listener listener) {
        Luckyblocks.instance.getServer().getPluginManager().registerEvents(listener, Luckyblocks.instance);
    }

}
