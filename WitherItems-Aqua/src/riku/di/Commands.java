package riku.di;

import org.bukkit.command.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import org.bukkit.*;
import riku.di.shop.Shop;

public class Commands implements CommandExecutor
{
    public Commands(final Main main) {}
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {   
    	if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Консоль не может использовать эту команду!");
        }
        
    	else if (args.length == 0) {
            if (!sender.hasPermission("witheritems.help")) {
                final Player p = (Player)sender;
                p.playSound(p.getLocation(), Sound.ANVIL_LAND, 1.0f, 1.0f);
                p.sendMessage(ChatColor.RED + "Извините, но у вас не достаточно прав для использования этой команды.");
            }
            else {
            sender.sendMessage("§9Помощь по плагину §5WitherItems §a2.0");
            sender.sendMessage("");
            sender.sendMessage("§f/wi give §7Выдать все вещи Иссушителя");
            sender.sendMessage("§f/wi shop §7Магазин вещей Иссушителя.");
            if (sender.isOp()) {
            	sender.sendMessage("§f/wi svillager §7Заспавнить продавца вещей Иссушителя");
            	sender.sendMessage("§f/wi rvillager §7Удалить продавца вещей Иссушителя");
            }
            sender.sendMessage("");
	        sender.sendMessage("§5WitherItems §ccoded by §0Riku");
	        
            return true;
            }
        }
    	else if (args[0].equalsIgnoreCase("svillager")) {
            if (sender.hasPermission("witheritems.villager")) {
                final Player p = (Player)sender;
                final Location loc = p.getLocation();
                final Villager v = (Villager)p.getWorld().spawnEntity(loc, EntityType.VILLAGER);
                v.setCustomName("§5§lWitherItems §d§lseller");
                v.setCustomNameVisible(true);
                v.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 356000, 356000, true, false));
                p.sendMessage("§f(§5!§f) Вы успешно заспавнили жителя.");
            }
            else 
            {
            	final Player p = (Player)sender;
                p.playSound(p.getLocation(), Sound.ANVIL_LAND, 1.0f, 1.0f);
                p.sendMessage(ChatColor.RED + "Извините, но у вас не достаточно прав для использования этой команды.");
            }
    	}
    	
        else if (args[0].equalsIgnoreCase("rvillager")) {
            if (sender.hasPermission("witheritems.villager")) {
                final Player p = (Player)sender;
                for (final Entity en : p.getNearbyEntities(3.0, 3.0, 3.0)) {
                    if (en != null && en instanceof Villager) {
                     en.remove();
                     p.sendMessage("§f(§5!§f) Житель был удалён. Если нет, подойдите к нему поближе!");
                    }
                }
            }
            else {
            	final Player p = (Player)sender;
                p.playSound(p.getLocation(), Sound.ANVIL_LAND, 1.0f, 1.0f);
                p.sendMessage(ChatColor.RED + "Извините, но у вас не достаточно прав для использования этой команды.");
            }
        }
	    	else if (args[0].equalsIgnoreCase("shop")) { 
	            if (!sender.hasPermission("witheritems.shop")) {
	                final Player p = (Player)sender;
	                p.playSound(p.getLocation(), Sound.ANVIL_LAND, 1.0f, 1.0f);
	                p.sendMessage(ChatColor.RED + "Извините, но у вас не достаточно прав для использования этой команды.");
	             }
	            else {
	            final Player p = (Player)sender;
	            Shop.openGUI(p);
	            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
	            return true;
	           }
	        }

    	else if (args[0].equalsIgnoreCase("give")) {
            if (!sender.hasPermission("witheritems.give")) {
                final Player p = (Player)sender;
                p.playSound(p.getLocation(), Sound.ANVIL_LAND, 1.0f, 1.0f);
                p.sendMessage(ChatColor.RED + "Извините, но у вас не достаточно прав для использования этой команды.");
           }
           else {
               final Player player = (Player)sender;
               player.sendMessage("§f(§5!§f) Вы успешно получили все вещи §5иссушителя§f.");
               
               ArrayList<String> lore = new ArrayList<String>();
               lore.add("§cКоренной владелец: §e" + sender.getName());
               
               final ItemStack bow = new ItemStack(Material.BOW, 1);
               final ItemMeta meta = bow.getItemMeta();
               meta.setDisplayName(new StringBuilder().append(ChatColor.DARK_PURPLE).append(ChatColor.BOLD).append("Лук из сердца иссушителя").toString());
               meta.setLore(lore);
               meta.spigot().setUnbreakable(true);
               bow.setItemMeta(meta);
               bow.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, Main.config.getInt("Bow.Infinity"));
               bow.addUnsafeEnchantment(Enchantment.ARROW_FIRE, Main.config.getInt("Bow.Fire"));
               bow.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, Main.config.getInt("Bow.Power"));
               bow.addUnsafeEnchantment(Enchantment.DURABILITY, Main.config.getInt("Bow.Durability"));
               player.getInventory().addItem(new ItemStack[] { bow });
               
               final ItemStack sword = new ItemStack(Material.DIAMOND_SWORD, 1);
               final ItemMeta metasword = sword.getItemMeta();
	           metasword.setDisplayName(new StringBuilder().append(ChatColor.DARK_PURPLE).append(ChatColor.BOLD).append("Меч из сердца иссушителя").toString());
               metasword.setLore(lore);
               metasword.spigot().setUnbreakable(true);
               sword.setItemMeta(metasword);
               sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, Main.config.getInt("Sword.Sharpness"));
               sword.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, Main.config.getInt("Sword.FireAspect"));
               sword.addUnsafeEnchantment(Enchantment.LOOT_BONUS_MOBS, Main.config.getInt("Sword.Looting"));
               sword.addUnsafeEnchantment(Enchantment.DURABILITY, Main.config.getInt("Sword.Durability"));
               player.getInventory().addItem(new ItemStack[] { sword });
               
               final ItemStack pickaxe = new ItemStack(Material.DIAMOND_PICKAXE, 1);
               final ItemMeta metapick = pickaxe.getItemMeta();
               metapick.setDisplayName(new StringBuilder().append(ChatColor.DARK_PURPLE).append(ChatColor.BOLD).append("Кирка из сердца иссушителя").toString());
               metapick.setLore(lore);
               metapick.spigot().setUnbreakable(true);
               pickaxe.setItemMeta(metapick);
               pickaxe.addUnsafeEnchantment(Enchantment.DIG_SPEED, Main.config.getInt("Pickaxe.Efficiency"));
               pickaxe.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, Main.config.getInt("Pickaxe.Luck"));
               pickaxe.addUnsafeEnchantment(Enchantment.DURABILITY, Main.config.getInt("Pickaxe.Durability"));
               player.getInventory().addItem(new ItemStack[] { pickaxe });
               
               final ItemStack axe = new ItemStack(Material.DIAMOND_AXE, 1);
               final ItemMeta metaaxe = axe.getItemMeta();
               metaaxe.setDisplayName(new StringBuilder().append(ChatColor.DARK_PURPLE).append(ChatColor.BOLD).append("Топор из сердца иссушителя").toString());
               metaaxe.setLore(lore);
               metaaxe.spigot().setUnbreakable(true);
               axe.setItemMeta(metaaxe);
               axe.addUnsafeEnchantment(Enchantment.DIG_SPEED, Main.config.getInt("Axe.Efficiency"));
               axe.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, Main.config.getInt("Axe.Luck"));
               axe.addUnsafeEnchantment(Enchantment.DURABILITY, Main.config.getInt("Axe.Durability"));
               player.getInventory().addItem(new ItemStack[] { axe });
               
               final ItemStack shovel = new ItemStack(Material.DIAMOND_SPADE, 1);
               final ItemMeta metashovel = shovel.getItemMeta();
               metashovel.setDisplayName(new StringBuilder().append(ChatColor.DARK_PURPLE).append(ChatColor.BOLD).append("Лопата из сердца иссушителя").toString());
               metashovel.setLore(lore);
               metashovel.spigot().setUnbreakable(true);
               shovel.setItemMeta(metashovel);
               shovel.addUnsafeEnchantment(Enchantment.DIG_SPEED, Main.config.getInt("Shovel.Efficiency"));
               shovel.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, Main.config.getInt("Shovel.Luck"));
               shovel.addUnsafeEnchantment(Enchantment.DURABILITY, Main.config.getInt("Shovel.Durability"));
               player.getInventory().addItem(new ItemStack[] { shovel });
               
               final ItemStack hoe = new ItemStack(Material.DIAMOND_HOE, 1);
               final ItemMeta metahoe = hoe.getItemMeta();
               metahoe.setDisplayName(new StringBuilder().append(ChatColor.DARK_PURPLE).append(ChatColor.BOLD).append("Мотыга из сердца иссушителя").toString());
               metahoe.setLore(lore);
               metahoe.spigot().setUnbreakable(true);
               hoe.setItemMeta(metahoe);
               hoe.addUnsafeEnchantment(Enchantment.DURABILITY, Main.config.getInt("Hoe.Durability"));
               player.getInventory().addItem(new ItemStack[] { hoe });
               
               final ItemStack helm = new ItemStack(Material.DIAMOND_HELMET, 1);
               final ItemMeta metahelm = helm.getItemMeta();
               metahelm.setDisplayName(new StringBuilder().append(ChatColor.DARK_PURPLE).append(ChatColor.BOLD).append("Шлем из сердца иссушителя").toString());
               metahelm.setLore(lore);
               metahelm.spigot().setUnbreakable(true);
               helm.setItemMeta(metahelm);
               helm.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, Main.config.getInt("Helmet.Protection"));
               helm.addUnsafeEnchantment(Enchantment.THORNS, Main.config.getInt("Helmet.Thorns"));
               helm.addUnsafeEnchantment(Enchantment.DURABILITY, Main.config.getInt("Helmet.Durability"));
               helm.addUnsafeEnchantment(Enchantment.WATER_WORKER, Main.config.getInt("Helmet.WaterWorker"));
               player.getInventory().addItem(new ItemStack[] { helm });
               
               final ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
               final ItemMeta metachestplate = chestplate.getItemMeta();
               metachestplate.setDisplayName(new StringBuilder().append(ChatColor.DARK_PURPLE).append(ChatColor.BOLD).append("Нагрудник из сердца иссушителя").toString());
               metachestplate.setLore(lore);
               metachestplate.spigot().setUnbreakable(true);
               chestplate.setItemMeta(metachestplate);
               chestplate.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, Main.config.getInt("Chestplate.Protection"));
               chestplate.addUnsafeEnchantment(Enchantment.THORNS, Main.config.getInt("Chestplate.Thorns"));
               chestplate.addUnsafeEnchantment(Enchantment.DURABILITY, Main.config.getInt("Chestplate.Durability"));
               chestplate.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, Main.config.getInt("Chestplate.FireProtect"));
               player.getInventory().addItem(new ItemStack[] { chestplate });
               
               final ItemStack leggs = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
               final ItemMeta metaleggs = leggs.getItemMeta();
               metaleggs.setDisplayName(new StringBuilder().append(ChatColor.DARK_PURPLE).append(ChatColor.BOLD).append("Поножи из сердца иссушителя").toString());
               metaleggs.setLore(lore);
               metaleggs.spigot().setUnbreakable(true);
               leggs.setItemMeta(metaleggs);
               leggs.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, Main.config.getInt("Leggings.Protection"));
               leggs.addUnsafeEnchantment(Enchantment.THORNS, Main.config.getInt("Leggings.Thorns"));
               leggs.addUnsafeEnchantment(Enchantment.DURABILITY, Main.config.getInt("Leggings.Durability"));
               leggs.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, Main.config.getInt("Leggings.ExplosionProtect"));
               player.getInventory().addItem(new ItemStack[] { leggs });
               
               final ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS, 1);
               final ItemMeta metaboots = boots.getItemMeta();
               metaboots.setDisplayName(new StringBuilder().append("§5§lБотинки из сердца иссушителя").toString());
               metaboots.setLore(lore);
               metaboots.spigot().setUnbreakable(true);
               boots.setItemMeta(metaboots);
               boots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, Main.config.getInt("Boots.Protection"));
               boots.addUnsafeEnchantment(Enchantment.THORNS, Main.config.getInt("Boots.Thorns"));
               boots.addUnsafeEnchantment(Enchantment.DURABILITY, Main.config.getInt("Boots.Durability"));
               boots.addUnsafeEnchantment(Enchantment.DEPTH_STRIDER, Main.config.getInt("Boots.DepthStrider"));
               player.getInventory().addItem(new ItemStack[] { boots });
           }
      }
      
		else {
            sender.sendMessage("§cНеизвестная команда, введите /wi для вызова помощи.");
		}
		return false;
		
  }
 }
