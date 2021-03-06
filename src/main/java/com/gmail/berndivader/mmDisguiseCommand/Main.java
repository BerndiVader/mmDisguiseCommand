package com.gmail.berndivader.mmDisguiseCommand;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.gmail.berndivader.mmDisguiseCommand.VolCode.*;

public class Main extends JavaPlugin {
	
	public static int mmVer;
	private String strMMVer;
	private static Plugin plugin;
	private static VolCode NMSUtil;
	private static amDisguiseCommand amdisguise;
	public static Plugin getPlugin() {return plugin;}
	public static VolCode NMSUtil() {return NMSUtil;}
	public static amDisguiseCommand getdisuise() {return amdisguise;}
	
	@Override
	public void onEnable() {
		plugin = this;
		if (Bukkit.getServer().getPluginManager().getPlugin("LibsDisguises")!=null 
				&& Bukkit.getServer().getPluginManager().getPlugin("MythicMobs")!=null) {
			amdisguise = new amDisguiseCommand();
	    	strMMVer = Bukkit.getServer().getPluginManager().getPlugin("MythicMobs").getDescription().getVersion().replaceAll("[\\D]", "");
			mmVer = Integer.valueOf(strMMVer);
			if (getNMSUtil()) {
				this.getCommand("advdisguise").setExecutor(new amDisguiseCommand());
				this.getCommand("advundisguise").setExecutor(new amUnDisguiseCommand());
			}
			if (mmVer > 259 && mmVer <2511) {
				Bukkit.getServer().getPluginManager().registerEvents(new mmMechanicLoader(), this);
			} else {
				Bukkit.getServer().getPluginManager().registerEvents(new mmConditionsLoader(), this);
			}
		}
	}
	@Override
	public void onDisable() {
	}
	
	private boolean getNMSUtil() {
		String v;
		try {v = Bukkit.getServer().getClass().getPackage().getName().replace(".",  ",").split(",")[3];
		} catch (ArrayIndexOutOfBoundsException e) {return false;}
		if (v.equals("v1_8_R3") || v.equals("v1_8_R2")) {NMSUtil=new NMSUtil18();}
		else if (v.equals("v1_9_R1") 
				|| v.equals("v1_9_R2") 
				|| v.equals("v1_10_R1") 
				|| v.equals("v1_11_R1")
				|| v.equals("v1_12_R1")) {NMSUtil=new NMSUtil19();}
		return NMSUtil!=null;
	}
}
