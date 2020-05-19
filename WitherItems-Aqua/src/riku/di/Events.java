package riku.di;

import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.*;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import riku.di.Particle.ParticleEffect;
import riku.di.shop.Shop;

public class Events implements Listener
{
    @EventHandler
    public void onMoveLeggs(final PlayerMoveEvent e) {
        final Player p = e.getPlayer();
        try {
            if (p.getInventory().getLeggings().getItemMeta().getDisplayName().equalsIgnoreCase("§5§lПоножи из сердца иссушителя")) {
     	     ParticleEffect.SPELL_WITCH.display(0, 0 , 0, 0, 100, p.getLocation().add(0, 0.7, 0), 1);
        }
            if (p.getInventory().getBoots().getItemMeta().getDisplayName().equalsIgnoreCase("§5§lБотинки из сердца иссушителя")) {
     	     ParticleEffect.DRIP_LAVA.display(0, 0 , 0, 0, 100, p.getLocation().add(0, 2.1, 0), 1);
        }
      }
    catch (NullPointerException ex) {}
 }
    
    @EventHandler
    public void onHit(final EntityDamageEvent e) {
        final Entity en = e.getEntity();
        if (en instanceof Player) {
            final Player p = (Player)en;
            if (p.getInventory().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§5§lМеч из сердца иссушителя")) {
             ((LivingEntity) en).addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 75, 2));
        }
     }
  }
    
    @EventHandler
    public void onDMG(final EntityDamageEvent e) {
        final Entity en = e.getEntity();
        if (en instanceof Villager) {
            final Villager v = (Villager)en;
            if (v.getCustomName() != null && v.getCustomName().equalsIgnoreCase("§5§lWitherItems §d§lseller")) {
                e.setCancelled(true);
            }
        }
    }
    
    @EventHandler
    public void onInteract(final PlayerInteractEntityEvent e) {
        final Player p = e.getPlayer();
        try {
            if (e.getRightClicked().getType() == EntityType.VILLAGER) {
                final Villager v = (Villager)e.getRightClicked();
                if (v.getCustomName() != null && v.getCustomName().equalsIgnoreCase("§5§lWitherItems §d§lseller")) {
                    e.setCancelled(true);
                    Shop.openGUI(p);
                }
            }
        }
        catch (NullPointerException n) {
            n.printStackTrace();
        }
        catch (ClassCastException m) {
            m.printStackTrace();
        }
    }
}
