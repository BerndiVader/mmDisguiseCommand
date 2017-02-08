package com.gmail.berndivader.mmDisguiseCommand;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;

import com.gmail.berndivader.mmDisguiseCommand.VolCode.VolCode;

import me.libraryaddict.disguise.DisguiseAPI;

public class amUnDisguiseCommand implements CommandExecutor {

	private Entity e = null;
	private VolCode NMSUtil = Main.NMSUtil();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length < 1) return false;
		e = NMSUtil.getEntity(Bukkit.getWorld(args[1]), UUID.fromString(args[0]));
		if (e==null) return false;
		if (DisguiseAPI.isDisguised(e)) DisguiseAPI.undisguiseToAll(e);
		return true;
	}
}
