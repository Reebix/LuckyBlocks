package net.rebix.luckyblocks.bockevent;

import org.bukkit.Location;

import java.util.*;

public class BlockEvent {

    private final double chance;
    public static List<BlockEvent> events = new ArrayList<>();

    public BlockEvent(double chance) {
        this.chance = chance;
    }

    public static void runrandom(Location location) {
        int random = new Random().nextInt(10);
        Collections.shuffle(events);
        for (BlockEvent event : events) {
            if (random <= event.chance) {
                if(event.event(location)) break;
            }
        }
    }


    public boolean event(Location location) {
        return false;
    }
}
