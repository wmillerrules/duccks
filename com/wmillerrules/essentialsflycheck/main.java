/*    */ package com.wmillerrules.essentialsflycheck;
/*    */ 
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.configuration.file.FileConfiguration;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class main extends org.bukkit.plugin.java.JavaPlugin implements org.bukkit.event.Listener
/*    */ {
/*    */   public void onEnable()
/*    */   {
/* 12 */     System.out.println("Plugin enabled");
/*    */     
/* 14 */     FileConfiguration config = getConfig();
/* 15 */     saveDefaultConfig();
/* 16 */     config.addDefault("incorrect-usage", "&8[&3FlyCheck&8] &7Incorrect usage: &f/flycheck [player]");
/* 17 */     config.addDefault("not-online", "&8[&3FlyCheck&8] &7That player needs to be online to be checked!");
/* 18 */     config.addDefault("yes-access", "&8[&3FlyCheck&8] &f%player% &7has access to /fly!");
/* 19 */     config.addDefault("no-access", "&8[&3FlyCheck&8] &f%player% &7does not have access to /fly!");
/* 20 */     saveDefaultConfig();
/*    */   }
/*    */   
/*    */   public void onDisable() {
/* 24 */     System.out.println("Plugin disabled");
/*    */   }
/*    */   
/*    */   public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
/*    */   {
/* 29 */     Player player = (Player)sender;
/*    */     
/* 31 */     if ((player.hasPermission("flycheck.flycheck")) && (label.equalsIgnoreCase("flycheck")))
/*    */     {
/* 33 */       if (args.length == 0) {
/* 34 */         player.sendMessage(getConfig().getString("incorrect-usage").replace("&", "§"));
/*    */ 
/*    */ 
/*    */ 
/*    */       }
/* 39 */       else if (args.length == 1) {
/* 40 */         Player targetPlayer = player.getServer().getPlayer(args[0]);
/* 41 */         if (targetPlayer == null) {
/* 42 */           player.sendMessage(getConfig().getString("not-online").replace("&", "§"));
/*    */         }
/* 44 */         else if (targetPlayer.hasPermission("essentials.fly")) {
/* 45 */           player.sendMessage(getConfig().getString("yes-access").replace("&", "§").replace("%player%", targetPlayer.getName()));
/*    */         }
/* 47 */         else if (!targetPlayer.hasPermission("essentials.fly")) {
/* 48 */           player.sendMessage(getConfig().getString("no-access").replace("&", "§").replace("%player%", targetPlayer.getName()));
/*    */         }
/*    */       }
/*    */     }
/* 52 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Kraken Realms\plugins\EssentialsFlyCheck.jar!\com\wmillerrules\essentialsflycheck\main.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */