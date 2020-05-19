package riku.di.shop;

import java.util.*;
import org.bukkit.*;
import org.bukkit.enchantments.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;
import riku.di.Main;

public class Shop implements Listener {
	
	public static void openGUI(Player p) {
		final Inventory inv = Bukkit.createInventory((InventoryHolder)null, 54, "§0➤ §5WitherItems §dshop");
		
		ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta swordmeta = sword.getItemMeta();
        swordmeta.setDisplayName(new StringBuilder().append(ChatColor.DARK_PURPLE).append("Меч из сердца иссушителя").toString());
        swordmeta.setLore(Arrays.asList("§aЦена: §f" + Main.config.getInt("Sword.Price") + " монет"));
        sword.setItemMeta(swordmeta);
        inv.setItem(24, sword);
        
		ItemStack helm = new ItemStack(Material.DIAMOND_HELMET);
		ItemMeta helmmeta = sword.getItemMeta();
        helmmeta.setDisplayName(new StringBuilder().append(ChatColor.DARK_PURPLE).append("Шлем из сердца иссушителя").toString());
        helmmeta.setLore(Arrays.asList("§aЦена: §f" + Main.config.getInt("Helmet.Price") + " монет"));
        helm.setItemMeta(helmmeta);
        inv.setItem(20, helm);
	
		ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
		ItemMeta chestplatemeta = chestplate.getItemMeta();
        chestplatemeta.setDisplayName(new StringBuilder().append(ChatColor.DARK_PURPLE).append("Нагрудник из сердца иссушителя").toString());
        chestplatemeta.setLore(Arrays.asList("§aЦена: §f" + Main.config.getInt("Chestplate.Price") + " монет"));
        chestplate.setItemMeta(chestplatemeta);
        inv.setItem(21, chestplate);
        
		ItemStack leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
		ItemMeta leggingsmeta = chestplate.getItemMeta();
        leggingsmeta.setDisplayName(new StringBuilder().append(ChatColor.DARK_PURPLE).append("Поножи из сердца иссушителя").toString());
        leggingsmeta.setLore(Arrays.asList("§aЦена: §f" + Main.config.getInt("Leggings.Price") + " монет"));
        leggings.setItemMeta(leggingsmeta);
        inv.setItem(22, leggings);
        
		ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);
		ItemMeta bootsmeta = boots.getItemMeta();
        bootsmeta.setDisplayName(new StringBuilder().append(ChatColor.DARK_PURPLE).append("Ботинки из сердца иссушителя").toString());
        bootsmeta.setLore(Arrays.asList("§aЦена: §f" + Main.config.getInt("Boots.Price") + " монет"));
        boots.setItemMeta(bootsmeta);
        inv.setItem(23, boots);
        
		ItemStack bow = new ItemStack(Material.BOW);
		ItemMeta bowmeta = bow.getItemMeta();
        bowmeta.setDisplayName(new StringBuilder().append(ChatColor.DARK_PURPLE).append("Лук из сердца иссушителя").toString());
        bowmeta.setLore(Arrays.asList("§aЦена: §f" + Main.config.getInt("Bow.Price") + " монет"));
        bow.setItemMeta(bowmeta);
        inv.setItem(29, bow);
        
		ItemStack pickaxe = new ItemStack(Material.DIAMOND_PICKAXE);
		ItemMeta pickmeta = pickaxe.getItemMeta();
        pickmeta.setDisplayName(new StringBuilder().append(ChatColor.DARK_PURPLE).append("Кирка из сердца иссушителя").toString());
        pickmeta.setLore(Arrays.asList("§aЦена: §f" + Main.config.getInt("Pickaxe.Price") + " монет"));
        pickaxe.setItemMeta(pickmeta);
        inv.setItem(30, pickaxe);
        
		ItemStack axe = new ItemStack(Material.DIAMOND_AXE);
		ItemMeta axemeta = axe.getItemMeta();
        axemeta.setDisplayName(new StringBuilder().append(ChatColor.DARK_PURPLE).append("Топор из сердца иссушителя").toString());
        axemeta.setLore(Arrays.asList("§aЦена: §f" + Main.config.getInt("Axe.Price") + " монет"));
        axe.setItemMeta(axemeta);
        inv.setItem(31, axe);
        
		ItemStack shovel = new ItemStack(Material.DIAMOND_SPADE);
		ItemMeta shovelmeta = shovel.getItemMeta();
        shovelmeta.setDisplayName(new StringBuilder().append(ChatColor.DARK_PURPLE).append("Лопата из сердца иссушителя").toString());
        shovelmeta.setLore(Arrays.asList("§aЦена: §f" + Main.config.getInt("Shovel.Price") + " монет"));
        shovel.setItemMeta(shovelmeta);
        inv.setItem(32, shovel);
        
		ItemStack hoe = new ItemStack(Material.DIAMOND_HOE);
		ItemMeta hoemeta = hoe.getItemMeta();
        hoemeta.setDisplayName(new StringBuilder().append(ChatColor.DARK_PURPLE).append("Мотыга из сердца иссушителя").toString());
        hoemeta.setLore(Arrays.asList("§aЦена: §f" + Main.config.getInt("Hoe.Price") + " монет"));
        hoe.setItemMeta(hoemeta);
        inv.setItem(33, hoe);
        
		@SuppressWarnings("deprecation")
		ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, DyeColor.PURPLE.getWoolData());	
		ItemMeta glassmeta = glass.getItemMeta();
        glassmeta.setDisplayName("§5 ");
        glass.setItemMeta(glassmeta);
        inv.setItem(0, glass);
        inv.setItem(1, glass);
        inv.setItem(2, glass);
        inv.setItem(3, glass);
        inv.setItem(5, glass);
        inv.setItem(6, glass);
        inv.setItem(7, glass);
        inv.setItem(8, glass);
        inv.setItem(9, glass);
        inv.setItem(17, glass);
        inv.setItem(18, glass);
        inv.setItem(26, glass);
        inv.setItem(27, glass);
        inv.setItem(35, glass);
        inv.setItem(36, glass);
        inv.setItem(44, glass);
        inv.setItem(45, glass);
        inv.setItem(46, glass);
        inv.setItem(47, glass);
        inv.setItem(48, glass);
        inv.setItem(50, glass);
        inv.setItem(51, glass);
        inv.setItem(52, glass);
        inv.setItem(53, glass);
        
		ItemStack history = new ItemStack(Material.BOOK, 1);	
		ItemMeta historymeta = history.getItemMeta();
        historymeta.setDisplayName("§eИстория");
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("§7По серверу ходят слухи, что эта броня была найдена в ином мире,");
        lore.add("§7прозваном его обитателями - Воксельрон, а создателя этой брони");
        lore.add("§7прозвали Воксель, ума не приложу кто это, но он каким-то образом смог");
        lore.add("§7сделать эту броню мощнее и вообще не ломающейся. Я в шоке от его возможностей!");   
        lore.add("§7Интересно всё же, кто он, вот бы встретится с ним..");
        historymeta.setLore(lore);
        history.setItemMeta(historymeta);
        inv.setItem(4, history);
        
        
		ItemStack exit = new ItemStack(Material.BARRIER);
		ItemMeta exitmeta = exit.getItemMeta();
        exitmeta.setDisplayName(new StringBuilder().append(ChatColor.RED).append("Выход").toString());
        exit.setItemMeta(exitmeta);
        inv.setItem(49, exit);
		
		p.openInventory(inv);
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
	 Player p = (Player) e.getWhoClicked();
     final ItemStack item = e.getCurrentItem();
	 
	 if (e.getInventory().getName().equalsIgnoreCase("§0➤ §5WitherItems §dshop")) {
		 e.setCancelled(true);
         if (item == null || !item.hasItemMeta()) {
             return;
         }
		 
		 if (e.getCurrentItem().getType() == Material.BARRIER) {
			 p.closeInventory();
		 }
		
		 else if (item.getItemMeta().getDisplayName().equals("§5Меч из сердца иссушителя")) {
			 
			 Main.r = Main.econ.withdrawPlayer(p.getName(), Main.config.getInt("Sword.Price"));
			 if (Main.r.transactionSuccess()) {
             p.sendMessage("§f(§5!§f) Вы успешно купили меч §5Иссушителя§f за §a" + Main.config.getInt("Sword.Price") + " монет");
			 
             ArrayList<String> lore = new ArrayList<String>();
             lore.add("§cКоренной владелец: §e" + p.getName());
             lore.add("§aСкрытые способности: §7Накладывает на противника эффект Иссушения.");
			 
             final ItemStack sword = new ItemStack(Material.DIAMOND_SWORD, 1);
             final ItemMeta metasword = sword.getItemMeta();
             metasword.setDisplayName(new StringBuilder().append(ChatColor.DARK_PURPLE).append(ChatColor.BOLD).append("Меч из сердца иссушителя").toString());
             metasword.setLore(lore);
             metasword.spigot().setUnbreakable(true);
             sword.setItemMeta(metasword);
             sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, Main.config.getInt("Sword.Sharpness"));
             sword.addUnsafeEnchantment(Enchantment.LOOT_BONUS_MOBS, Main.config.getInt("Sword.Looting"));
             sword.addUnsafeEnchantment(Enchantment.DURABILITY, Main.config.getInt("Sword.Durability"));
             p.getInventory().addItem(new ItemStack[] { sword });
             p.closeInventory();
             	
             return;
			 }
			 
		 }
		 else if (item.getItemMeta().getDisplayName().equals("§5Шлем из сердца иссушителя")) {
			 
			 Main.r = Main.econ.withdrawPlayer(p.getName(), Main.config.getInt("Helmet.Price"));
			 if (Main.r.transactionSuccess()) {
             p.sendMessage("§f(§5!§f) Вы успешно купили шлем §5Иссушителя§f за §a" + Main.config.getInt("Helmet.Price") + " монет");
			 
             ArrayList<String> lore = new ArrayList<String>();
             lore.add("§cКоренной владелец: §e" + p.getName());
			 
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
             p.getInventory().addItem(new ItemStack[] { helm });
             p.closeInventory();
             
             return;
			 }
		  } 
		 else if (item.getItemMeta().getDisplayName().equals("§5Нагрудник из сердца иссушителя")) {
			 
			 Main.r = Main.econ.withdrawPlayer(p.getName(), Main.config.getInt("Chestplate.Price"));
			 if (Main.r.transactionSuccess()) {
             p.sendMessage("§f(§5!§f) Вы успешно купили нагрудник §5Иссушителя§f за §a" + Main.config.getInt("Chestplate.Price") + " монет");
			 
             ArrayList<String> lore = new ArrayList<String>();
             lore.add("§cКоренной владелец: §e" + p.getName());
			 
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
             p.getInventory().addItem(new ItemStack[] { chestplate });
             p.closeInventory();
             	
             return;
			 }
		  } 
		 else if (item.getItemMeta().getDisplayName().equals("§5Поножи из сердца иссушителя")) {
			 
			 Main.r = Main.econ.withdrawPlayer(p.getName(), Main.config.getInt("Leggings.Price"));
			 if (Main.r.transactionSuccess()) {
             p.sendMessage("§f(§5!§f) Вы успешно купили поножи §5Иссушителя§f за §a" + Main.config.getInt("Leggings.Price") + " монет");
			 
             ArrayList<String> lore = new ArrayList<String>();
             lore.add("§cКоренной владелец: §e" + p.getName());
             lore.add("§aСкрытые способности: §7При движении оставляет эффект, названый иссушающим хвостом.");
			 
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
             p.getInventory().addItem(new ItemStack[] { leggs });
             p.closeInventory();
             	
             return;
			 }
		  } 
		 else if (item.getItemMeta().getDisplayName().equals("§5Ботинки из сердца иссушителя")) {
			 
			 Main.r = Main.econ.withdrawPlayer(p.getName(), Main.config.getInt("Boots.Price"));
			 if (Main.r.transactionSuccess()) {
             p.sendMessage("§f(§5!§f) Вы успешно купили ботинки §5Иссушителя§f за §a" + Main.config.getInt("Boots.Price") + " монет");
			 
             ArrayList<String> lore = new ArrayList<String>();
             lore.add("§cКоренной владелец: §e" + p.getName());
			 
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
             p.getInventory().addItem(new ItemStack[] { boots });
             p.closeInventory();
             	
             return;
			 }
		  }
		 else if (item.getItemMeta().getDisplayName().equals("§5Лук из сердца иссушителя")) {
			 
			 Main.r = Main.econ.withdrawPlayer(p.getName(), Main.config.getInt("Bow.Price"));
			 if (Main.r.transactionSuccess()) {
             p.sendMessage("§f(§5!§f) Вы успешно купили лук §5Иссушителя§f за §a" + Main.config.getInt("Bow.Price") + " монет");
			 
             ArrayList<String> lore = new ArrayList<String>();
             lore.add("§cКоренной владелец: §e" + p.getName());
			 
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
             p.getInventory().addItem(new ItemStack[] { bow });
             p.closeInventory();
             	
             return;
			 }
		  }
		 else if (item.getItemMeta().getDisplayName().equals("§5Кирка из сердца иссушителя")) {
			 
			 Main.r = Main.econ.withdrawPlayer(p.getName(), Main.config.getInt("Pickaxe.Price"));
			 if (Main.r.transactionSuccess()) {
             p.sendMessage("§f(§5!§f) Вы успешно купили лук §5Иссушителя§f за §a" + Main.config.getInt("Pickaxe.Price") + " монет");
			 
             ArrayList<String> lore = new ArrayList<String>();
             lore.add("§cКоренной владелец: §e" + p.getName());
			 
             final ItemStack pickaxe = new ItemStack(Material.DIAMOND_PICKAXE, 1);
             final ItemMeta metapick = pickaxe.getItemMeta();
             metapick.setDisplayName(new StringBuilder().append(ChatColor.DARK_PURPLE).append(ChatColor.BOLD).append("Кирка из сердца иссушителя").toString());
             metapick.setLore(lore);
             metapick.spigot().setUnbreakable(true);
             pickaxe.setItemMeta(metapick);
             pickaxe.addUnsafeEnchantment(Enchantment.DIG_SPEED, Main.config.getInt("Pickaxe.Efficiency"));
             pickaxe.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, Main.config.getInt("Pickaxe.Luck"));
             pickaxe.addUnsafeEnchantment(Enchantment.DURABILITY, Main.config.getInt("Pickaxe.Durability"));
             p.getInventory().addItem(new ItemStack[] { pickaxe });
             p.closeInventory();
             	
             return;
			 }
		  }
		 else if (item.getItemMeta().getDisplayName().equals("§5Топор из сердца иссушителя")) {
			 
			 Main.r = Main.econ.withdrawPlayer(p.getName(), Main.config.getInt("Axe.Price"));
			 if (Main.r.transactionSuccess()) {
             p.sendMessage("§f(§5!§f) Вы успешно купили топор §5Иссушителя§f за §a" + Main.config.getInt("Axe.Price") + " монет");
			 
             ArrayList<String> lore = new ArrayList<String>();
             lore.add("§cКоренной владелец: §e" + p.getName());
			 
             final ItemStack axe = new ItemStack(Material.DIAMOND_AXE, 1);
             final ItemMeta metaaxe = axe.getItemMeta();
             metaaxe.setDisplayName(new StringBuilder().append(ChatColor.DARK_PURPLE).append(ChatColor.BOLD).append("Топор из сердца иссушителя").toString());
             metaaxe.setLore(lore);
             metaaxe.spigot().setUnbreakable(true);
             axe.setItemMeta(metaaxe);
             axe.addUnsafeEnchantment(Enchantment.DIG_SPEED, Main.config.getInt("Axe.Efficiency"));
             axe.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, Main.config.getInt("Axe.Luck"));
             axe.addUnsafeEnchantment(Enchantment.DURABILITY, Main.config.getInt("Axe.Durability"));
             p.getInventory().addItem(new ItemStack[] { axe });
             p.closeInventory();
             	
             return;
			 }
		  }
		 else if (item.getItemMeta().getDisplayName().equals("§5Лопата из сердца иссушителя")) {
			 
			 Main.r = Main.econ.withdrawPlayer(p.getName(), Main.config.getInt("Shovel.Price"));
			 if (Main.r.transactionSuccess()) {
             p.sendMessage("§f(§5!§f) Вы успешно купили лопату §5Иссушителя§f за §a" + Main.config.getInt("Shovel.Price") + " монет");
			 
             ArrayList<String> lore = new ArrayList<String>();
             lore.add("§cКоренной владелец: §e" + p.getName());
			 
             final ItemStack shovel = new ItemStack(Material.DIAMOND_SPADE, 1);
             final ItemMeta metashovel = shovel.getItemMeta();
             metashovel.setDisplayName(new StringBuilder().append(ChatColor.DARK_PURPLE).append(ChatColor.BOLD).append("Лопата из сердца иссушителя").toString());
             metashovel.setLore(lore);
             metashovel.spigot().setUnbreakable(true);
             shovel.setItemMeta(metashovel);
             shovel.addUnsafeEnchantment(Enchantment.DIG_SPEED, Main.config.getInt("Shovel.Efficiency"));
             shovel.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, Main.config.getInt("Shovel.Luck"));
             shovel.addUnsafeEnchantment(Enchantment.DURABILITY, Main.config.getInt("Shovel.Durability"));
             p.getInventory().addItem(new ItemStack[] { shovel });
             p.closeInventory();
             	
             return;
			 }
		  }
		 else if (item.getItemMeta().getDisplayName().equals("§5Мотыга из сердца иссушителя")) {
			 
			 Main.r = Main.econ.withdrawPlayer(p.getName(), Main.config.getInt("Hoe.Price"));
			 if (Main.r.transactionSuccess()) {
             p.sendMessage("§f(§5!§f) Вы успешно купили мотыгу §5Иссушителя§f за §a" + Main.config.getInt("Hoe.Price") + " монет");
			 
             ArrayList<String> lore = new ArrayList<String>();
             lore.add("§cКоренной владелец: §e" + p.getName());
			 
             final ItemStack hoe = new ItemStack(Material.DIAMOND_HOE, 1);
             final ItemMeta metahoe = hoe.getItemMeta();
             metahoe.setDisplayName(new StringBuilder().append(ChatColor.DARK_PURPLE).append(ChatColor.BOLD).append("Мотыга из сердца иссушителя").toString());
             metahoe.setLore(lore);
             metahoe.spigot().setUnbreakable(true);
             hoe.setItemMeta(metahoe);
             hoe.addUnsafeEnchantment(Enchantment.DURABILITY, Main.config.getInt("Hoe.Durability"));
             p.getInventory().addItem(new ItemStack[] { hoe });
             p.closeInventory();
             	
             return;
			 }
		  }

		 
		 }
	 }
}
