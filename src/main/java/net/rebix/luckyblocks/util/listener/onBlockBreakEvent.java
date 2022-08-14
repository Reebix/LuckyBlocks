package net.rebix.luckyblocks.util.listener;

import net.rebix.luckyblocks.bockevent.BlockEvent;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

import java.util.Random;

public class onBlockBreakEvent implements Listener {

    @EventHandler
    public void onBlockBreakEvent(org.bukkit.event.block.BlockBreakEvent e) {
        if(e.getBlock().getType().equals(Material.SPONGE)) {
            Player player = e.getPlayer();
            e.setDropItems(false);

            Random r = new Random();
            if(r.nextInt(100) <= 10) {
                ItemStack potion = new ItemStack(Material.POTION, 1);
                PotionMeta potionMeta = (PotionMeta) potion.getItemMeta();
                potionMeta.setColor(org.bukkit.Color.RED);
                potionMeta.addCustomEffect(new PotionEffect(PotionEffectType.JUMP, 50000, 16), true);
                potion.setItemMeta(potionMeta);
                ItemMeta itemMeta = potion.getItemMeta();
                itemMeta.setDisplayName("§4§lPotion");
                itemMeta.setLocalizedName("potion");
                potion.setItemMeta(itemMeta);
                e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), potion);
            } else player.sendMessage("§aHEHEHEHA");
        }
        if(e.getBlock().getType().equals(Material.GRAY_STAINED_GLASS)) {

            BlockEvent.runrandom(e.getBlock().getLocation());
        }
    }
}
