package net.rebix.luckyblocks.util.commands;

import net.rebix.luckyblocks.bockevent.BlockEvent;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DropCoommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender.hasPermission("luckyblocks.drop") && sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length == 0) {
                sender.sendMessage("/drop <block>");
                return true;
            }
            if (args.length == 1) {
                for (BlockEvent event : BlockEvent.events) {
                    if (event.getClass().getSimpleName().equals(args[0])) {
                        event.event(player.getLocation());
                        return true;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        List<String> list = new ArrayList<>();
        for(BlockEvent event : BlockEvent.events) {
            list.add(event.getClass().getSimpleName());
        }
        return list;
    }
}
