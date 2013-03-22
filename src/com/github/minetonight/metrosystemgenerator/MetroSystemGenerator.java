package com.github.minetonight.metrosystemgenerator;

import java.util.logging.Level;

import org.bukkit.event.Event;
import org.bukkit.event.EventException;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldInitEvent;
import org.bukkit.plugin.EventExecutor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class MetroSystemGenerator extends JavaPlugin {
	
	
	/**
	 * add a populator to the default list so the default world is populated with my creations.
	 * from http://forums.bukkit.org/threads/chunkgenerators-blockpopulators-faq.22795/#post-415127
	 */
	public void onEnable(){
		PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvent(WorldInitEvent.class, new Listener (){}, EventPriority.NORMAL, new EventExecutor() {
			public void execute(Listener listener, Event event) throws EventException {
				WorldInitEvent initEvent = (WorldInitEvent) event;
				initEvent.getWorld().getPopulators().add(new MetroSystemPopulator());
				getLogger().log(Level.FINEST, "injected MertoPopulator");
			}
		}, this);
    }
}
