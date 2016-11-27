package com.gmail.berndivader.mmDisguiseCommand;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	private static Plugin plugin;
	public static Plugin getPlugin() {return plugin;}
	@Override
	public void onEnable() {
		if (Bukkit.getServer().getPluginManager().getPlugin("LibsDisguises")!=null 
				&& Bukkit.getServer().getPluginManager().getPlugin("MythicMobs")!=null) {
			this.getCommand("advdisguise").setExecutor(new amDisguiseCommand());
		}
	}
	@Override
	public void onDisable() {
	}
}
