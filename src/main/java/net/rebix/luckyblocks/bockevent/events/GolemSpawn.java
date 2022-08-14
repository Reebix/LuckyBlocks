package net.rebix.luckyblocks.bockevent.events;

import net.rebix.luckyblocks.bockevent.BlockEvent;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.IronGolem;

public class GolemSpawn extends BlockEvent {
    public GolemSpawn() {
        super(100);
        events.add(this);
    }

    @Override
    public boolean event(Location location) {
        location.getWorld().spawnEntity(location, EntityType.IRON_GOLEM);
        return true;
    }
}
