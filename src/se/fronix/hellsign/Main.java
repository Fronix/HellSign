package se.fronix.hellsign;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Server;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginLoader;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
		//Defined PlayerListener
		private final HellPlayerListener playerListener = new HellPlayerListener(this);
		//Defnied BlockListener
		private final HellBlockListener blockListener = new HellBlockListener(this);
		//Creating the HasMap
		public final HashMap<Player, ArrayList<Block>> basicUsers = new HashMap();
		//Create HasMap Debugee
		private final HashMap<Player, Boolean> debugees = new HashMap<Player, Boolean>();
		
		public Main(PluginLoader pluginLoader, Server instance, pluginDescriptionFile desc, File folder, File plugin, ClassLoader cLoader);
		
}

@Override
public void onEnable(){
	PluginManager pm = getServer().getPluginManager();
	pm.registerEvent(Event.Type.PLAYER_COMMAND_PREPROCESS, this.playerListener, Event.Priority.Normal, this);
	pm.registerEvent(Event.Type.BLOCK_PLACE, this.blockListener, Event.Priority.Normal, this);
	
	PluginDescriptionFile pdfFile = this.getDescription();
	System.out.println( pdfFile.getName() + " version " + pdfFile.getVersion() + "is enabled!");
	
}

@Override
public void onDisable(){
	//On Disable thingi
}

@Override
public void onLoad(){
	//On Load thingi
}
