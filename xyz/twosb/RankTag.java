package xyz.twosb;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.permission.Permission;
import xyz.twosb.commands.RankTagCommand;
import xyz.twosb.listeners.JoinListener;

public class RankTag extends JavaPlugin {

	
	private static Chat chat = null;
    private static Permission perms = null;
	
    @Override
    public void onEnable() {
    	System.out.println("RankTag Started!");
    	getServer().getPluginManager().registerEvents(new JoinListener(), this);
    	this.getCommand("ranktag").setExecutor(new RankTagCommand());
        setupPermissions();
        setupChat();
    }
    
    
    @Override
    public void onDisable() {
    	
    }

    
    public static void updateTag(Player p) {
    	String prefix = ChatColor.translateAlternateColorCodes('&', RankTag.getChat().getGroupPrefix(p.getWorld(), RankTag.getPermissions().getPrimaryGroup(p)) + "&f");
    	p.setPlayerListName(prefix + p.getName());
    }
    
    private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        perms = rsp.getProvider();
        System.out.println("RankTag bount to permissions");
        return perms != null;
    }
    
    private boolean setupChat() {
        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
        chat = rsp.getProvider();
        System.out.println("RankTag bount to chat");
        return chat != null;
    }
    
    public static Chat getChat() {
        return chat;
    }
    
    public static Permission getPermissions() {
        return perms;
    }
}