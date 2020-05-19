package riku.di;

import org.bukkit.plugin.*; 
import org.bukkit.plugin.java.*;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import riku.di.shop.*;

import org.bukkit.event.*; 
import org.bukkit.command.*;
import org.bukkit.configuration.file.*;

import org.bukkit.*; 
import org.bukkit.enchantments.*;
import org.bukkit.inventory.*; 
import org.bukkit.inventory.meta.*;

public class Main extends JavaPlugin{
  
 public static FileConfiguration config;
 public static Economy econ = null;
 public static EconomyResponse r;
	
 @Override
    public void onEnable() {
        if (!setupEconomy() ) {
            getLogger().severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        config = getConfig();
        saveDefaultConfig();
        Bukkit.getConsoleSender().sendMessage("§6=========§8[ §5WitherItems §8]§6=========");
        Bukkit.getConsoleSender().sendMessage("§3Разработчик: §9Riku");
        Bukkit.getConsoleSender().sendMessage("§3Версия: §93.0");
        Bukkit.getConsoleSender().sendMessage("§dПатч: §5Wither");     
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("§5WitherItems §aвключен!");
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("§6=========§8[ §5WitherItems §8]§6=========");
        Bukkit.getPluginManager().registerEvents((Listener)new Events(), (Plugin)this);
        Bukkit.getPluginManager().registerEvents((Listener)new Shop(), (Plugin)this);
        this.getCommand("witheritems").setExecutor((CommandExecutor)new Commands(this));
        this.recipebow();
        this.recipes();
        this.recipepa();
        this.recipeaxe();
        this.recipeshovel();
        this.recipehoe();
        this.recipehelm();
        this.recipechestplate();
        this.recipeleggs();
        this.recipeboots();
    }
    
    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
       }
    
    private void recipebow() {
        final ItemStack bow = new ItemStack(Material.BOW, 1);
        final ItemMeta meta = bow.getItemMeta();
        meta.setDisplayName(new StringBuilder().append(ChatColor.DARK_PURPLE).append(ChatColor.BOLD).append("Лук из сердца иссушителя").toString());

        bow.setItemMeta(meta);
        bow.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, Main.config.getInt("Bow.Infinity"));
        bow.addUnsafeEnchantment(Enchantment.ARROW_FIRE, Main.config.getInt("Bow.Fire"));
        bow.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, Main.config.getInt("Bow.Power"));
        bow.addUnsafeEnchantment(Enchantment.DURABILITY, Main.config.getInt("Bow.Durability"));
        final ShapedRecipe recipe = new ShapedRecipe(bow);
        recipe.shape(new String[] { "prs", "rns", "prs" });
        recipe.setIngredient('p', Material.BLAZE_POWDER);
        recipe.setIngredient('r', Material.BLAZE_ROD);
        recipe.setIngredient('s', Material.STRING);
        recipe.setIngredient('n', Material.NETHER_STAR);
        Bukkit.getServer().addRecipe((Recipe)recipe);
    }
	private void recipes() {
        final ItemStack sword = new ItemStack(Material.DIAMOND_SWORD, 1);
        final ItemMeta meta = sword.getItemMeta();
        meta.setDisplayName(new StringBuilder().append(ChatColor.DARK_PURPLE).append(ChatColor.BOLD).append("Меч из сердца иссушителя").toString());

        sword.setItemMeta(meta);
        sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, Main.config.getInt("Sword.Sharpness"));
        sword.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, Main.config.getInt("Sword.FireAspect"));
        sword.addUnsafeEnchantment(Enchantment.LOOT_BONUS_MOBS, Main.config.getInt("Sword.Looting"));
        sword.addUnsafeEnchantment(Enchantment.DURABILITY, Main.config.getInt("Sword.Durability"));
        final ShapedRecipe recipes = new ShapedRecipe(sword);
        recipes.shape(new String[] { " d ",
        		                     "bdb",
        		                     " n " });
        recipes.setIngredient('d', Material.DIAMOND);
        recipes.setIngredient('n', Material.NETHER_STAR);
        recipes.setIngredient('b', Material.BLAZE_POWDER);
        Bukkit.getServer().addRecipe((Recipe)recipes);
    }
	private void recipepa() {
        final ItemStack pickaxe = new ItemStack(Material.DIAMOND_PICKAXE, 1);
        final ItemMeta meta = pickaxe.getItemMeta();
        meta.setDisplayName(new StringBuilder().append(ChatColor.DARK_PURPLE).append(ChatColor.BOLD).append("Кирка из сердца иссушителя").toString());

        pickaxe.setItemMeta(meta);
        pickaxe.addUnsafeEnchantment(Enchantment.DIG_SPEED, Main.config.getInt("Pickaxe.Efficiency"));
        pickaxe.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, Main.config.getInt("Pickaxe.Luck"));
        pickaxe.addUnsafeEnchantment(Enchantment.DURABILITY, Main.config.getInt("Pickaxe.Durability"));
        final ShapedRecipe recipepa = new ShapedRecipe(pickaxe);
        recipepa.shape(new String[] {"ddd",
        		                     " b ",
        		                     " n " });
        recipepa.setIngredient('d', Material.DIAMOND);
        recipepa.setIngredient('n', Material.NETHER_STAR);
        recipepa.setIngredient('b', Material.BLAZE_ROD);
        Bukkit.getServer().addRecipe((Recipe)recipepa);
    }
	private void recipeaxe() {
        final ItemStack axe = new ItemStack(Material.DIAMOND_AXE, 1);
        final ItemMeta meta = axe.getItemMeta();
        meta.setDisplayName(new StringBuilder().append(ChatColor.DARK_PURPLE).append(ChatColor.BOLD).append("Топор из сердца иссушителя").toString());
        axe.setItemMeta(meta);
        axe.addUnsafeEnchantment(Enchantment.DIG_SPEED, Main.config.getInt("Axe.Efficiency"));
        axe.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, Main.config.getInt("Axe.Luck"));
        axe.addUnsafeEnchantment(Enchantment.DURABILITY, Main.config.getInt("Axe.Durability"));
        final ShapedRecipe recipeaxe = new ShapedRecipe(axe);
        recipeaxe.shape(new String[] {"dd ",
        		                      "db ",
        		                      " n " });
        recipeaxe.setIngredient('d', Material.DIAMOND);
        recipeaxe.setIngredient('n', Material.NETHER_STAR);
        recipeaxe.setIngredient('b', Material.BLAZE_ROD);
        Bukkit.getServer().addRecipe((Recipe)recipeaxe);
    }
	private void recipeshovel() {
        final ItemStack shovel = new ItemStack(Material.DIAMOND_SPADE, 1);
        final ItemMeta meta = shovel.getItemMeta();
        meta.setDisplayName(new StringBuilder().append(ChatColor.DARK_PURPLE).append(ChatColor.BOLD).append("Лопата из сердца иссушителя").toString());
        shovel.setItemMeta(meta);
        shovel.addUnsafeEnchantment(Enchantment.DIG_SPEED, Main.config.getInt("Shovel.Efficiency"));
        shovel.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, Main.config.getInt("Shovel.Luck"));
        shovel.addUnsafeEnchantment(Enchantment.DURABILITY, Main.config.getInt("Shovel.Durability"));
        final ShapedRecipe recipeshovel = new ShapedRecipe(shovel);
        recipeshovel.shape(new String[] {" d ",
        		                         " b ",
        		                         " n " });
        recipeshovel.setIngredient('d', Material.DIAMOND);
        recipeshovel.setIngredient('n', Material.NETHER_STAR);
        recipeshovel.setIngredient('b', Material.BLAZE_ROD);
        Bukkit.getServer().addRecipe((Recipe)recipeshovel);
    }
	private void recipehoe() {
        final ItemStack hoe = new ItemStack(Material.DIAMOND_HOE, 1);
        final ItemMeta meta = hoe.getItemMeta();
        meta.setDisplayName(new StringBuilder().append(ChatColor.DARK_PURPLE).append(ChatColor.BOLD).append("Мотыга из сердца иссушителя").toString());
        hoe.setItemMeta(meta);
        hoe.addUnsafeEnchantment(Enchantment.DURABILITY, Main.config.getInt("Hoe.Durability"));
        final ShapedRecipe recipehoe = new ShapedRecipe(hoe);
        recipehoe.shape(new String[] {   "dd ",
        		                         " b ",
        		                         " n " });
        recipehoe.setIngredient('d', Material.DIAMOND);
        recipehoe.setIngredient('n', Material.NETHER_STAR);
        recipehoe.setIngredient('b', Material.BLAZE_ROD);
        Bukkit.getServer().addRecipe((Recipe)recipehoe);
    }
	private void recipehelm() {
        final ItemStack helm = new ItemStack(Material.DIAMOND_HELMET, 1);
        final ItemMeta meta = helm.getItemMeta();
        meta.setDisplayName(new StringBuilder().append(ChatColor.DARK_PURPLE).append(ChatColor.BOLD).append("Шлем из сердца иссушителя").toString());
        helm.setItemMeta(meta);
        helm.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, Main.config.getInt("Helmet.Protection"));
        helm.addUnsafeEnchantment(Enchantment.THORNS, Main.config.getInt("Helmet.Thorns"));
        helm.addUnsafeEnchantment(Enchantment.DURABILITY, Main.config.getInt("Helmet.Durability"));
        helm.addUnsafeEnchantment(Enchantment.WATER_WORKER, Main.config.getInt("Helmet.WaterWorker"));
        final ShapedRecipe recipehelm = new ShapedRecipe(helm);
        recipehelm.shape(new String[] {  "ndn",
        		                         "d d",
        		                         "   " });
        recipehelm.setIngredient('d', Material.DIAMOND);
        recipehelm.setIngredient('n', Material.NETHER_STAR);
        Bukkit.getServer().addRecipe((Recipe)recipehelm);
    }
	private void recipechestplate() {
        final ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
        final ItemMeta meta = chestplate.getItemMeta();
        meta.setDisplayName(new StringBuilder().append(ChatColor.DARK_PURPLE).append(ChatColor.BOLD).append("Нагрудник из сердца иссушителя").toString());
        chestplate.setItemMeta(meta);
        chestplate.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, Main.config.getInt("Chestplate.Protection"));
        chestplate.addUnsafeEnchantment(Enchantment.THORNS, Main.config.getInt("Chestplate.Thorns"));
        chestplate.addUnsafeEnchantment(Enchantment.DURABILITY, Main.config.getInt("Chestplate.Durability"));
        chestplate.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, Main.config.getInt("Chestplate.FireProtect"));
        final ShapedRecipe recipechestplate = new ShapedRecipe(chestplate);
        recipechestplate.shape(new String[] {  "d d",
        		                               "dnd",
        		                               "ddd" });
        recipechestplate.setIngredient('d', Material.DIAMOND);
        recipechestplate.setIngredient('n', Material.NETHER_STAR);
        Bukkit.getServer().addRecipe((Recipe)recipechestplate);
    }
	private void recipeleggs() {
        final ItemStack leggs = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
        final ItemMeta meta = leggs.getItemMeta();
        meta.setDisplayName(new StringBuilder().append(ChatColor.DARK_PURPLE).append(ChatColor.BOLD).append("Поножи из сердца иссушителя").toString());
        leggs.setItemMeta(meta);
        leggs.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, Main.config.getInt("Leggings.Protection"));
        leggs.addUnsafeEnchantment(Enchantment.THORNS, Main.config.getInt("Leggings.Thorns"));
        leggs.addUnsafeEnchantment(Enchantment.DURABILITY, Main.config.getInt("Leggings.Durability"));
        leggs.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, Main.config.getInt("Leggings.ExplosionProtect"));
        final ShapedRecipe recipeleggs = new ShapedRecipe(leggs);
        recipeleggs.shape(new String[] {       "ndn",
        		                               "d d",
        		                               "d d" });
        recipeleggs.setIngredient('d', Material.DIAMOND);
        recipeleggs.setIngredient('n', Material.NETHER_STAR);
        Bukkit.getServer().addRecipe((Recipe)recipeleggs);
    }
	private void recipeboots() {
        final ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS, 1);
        final ItemMeta meta = boots.getItemMeta();
        meta.setDisplayName(new StringBuilder().append(ChatColor.DARK_PURPLE).append(ChatColor.BOLD).append("Ботинки из сердца иссушителя").toString());
        boots.setItemMeta(meta);
        boots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, Main.config.getInt("Boots.Protection"));
        boots.addUnsafeEnchantment(Enchantment.THORNS, Main.config.getInt("Boots.Thorns"));
        boots.addUnsafeEnchantment(Enchantment.DURABILITY, Main.config.getInt("Boots.Durability"));
        boots.addUnsafeEnchantment(Enchantment.DEPTH_STRIDER, Main.config.getInt("Boots.DepthStrider"));
        final ShapedRecipe recipeboots = new ShapedRecipe(boots);
        recipeboots.shape(new String[] {       "   ",
        		                               "d d",
        		                               "n n" });
        recipeboots.setIngredient('d', Material.DIAMOND);
        recipeboots.setIngredient('n', Material.NETHER_STAR);
        Bukkit.getServer().addRecipe((Recipe)recipeboots);
    }
   @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§6=========§8[ §5WitherItems §8]§6=========");
        Bukkit.getConsoleSender().sendMessage("§3Разработчик: §9Riku");
        Bukkit.getConsoleSender().sendMessage("§3Версия: §93.0");
        Bukkit.getConsoleSender().sendMessage("§dПатч: §5Wither");
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("§5WitherItems §cвыключен!");
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("§6=========§8[ §5WitherItems §8]§6=========");
    }
}
