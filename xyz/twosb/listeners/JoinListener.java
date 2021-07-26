package xyz.twosb.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import xyz.twosb.RankTag;

public class JoinListener implements Listener{
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event)
    {
    	RankTag.updateTag(event.getPlayer());
    	
   
    }
}
