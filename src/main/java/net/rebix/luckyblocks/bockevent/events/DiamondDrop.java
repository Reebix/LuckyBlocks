package net.rebix.luckyblocks.bockevent.events;

import net.rebix.luckyblocks.bockevent.BlockEvent;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class DiamondDrop extends BlockEvent {

    public DiamondDrop() {
        super(50);
        events.add(this);

    }

        @Override
        public boolean event(Location location) {
            location.getWorld().dropItemNaturally(location, new ItemStack(Material.DIAMOND, 1));
            return true;
        }
}
