package net.rebix.luckyblocks.bockevent.events;

import net.rebix.luckyblocks.bockevent.BlockEvent;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class KnockbackStick extends BlockEvent {
    public KnockbackStick() {
        super(30);
        events.add(this);
    }

    @Override
    public boolean event(Location location) {
        ItemStack stick = new ItemStack(Material.STICK, 1);
        ItemMeta meta = stick.getItemMeta();
        meta.setDisplayName("§bKnockback Stick");
        meta.addEnchant(Enchantment.KNOCKBACK, 10, true);
        stick.setItemMeta(meta);
        location.getWorld().dropItemNaturally(location, stick);
        return true;
    }
}
