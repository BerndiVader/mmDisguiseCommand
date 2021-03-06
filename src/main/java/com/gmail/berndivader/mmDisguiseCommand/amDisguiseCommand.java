package com.gmail.berndivader.mmDisguiseCommand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;

import com.gmail.berndivader.mmDisguiseCommand.VolCode.VolCode;

import me.libraryaddict.disguise.DisguiseAPI;
import me.libraryaddict.disguise.DisguiseConfig;
import me.libraryaddict.disguise.disguisetypes.Disguise;
import me.libraryaddict.disguise.disguisetypes.DisguiseType;
import me.libraryaddict.disguise.disguisetypes.watchers.LivingWatcher;

public class amDisguiseCommand extends BaseDisguiseCommand {
	
	private Entity e = null;
	private VolCode NMSUtil = Main.NMSUtil();
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        Disguise disguise;
        e = NMSUtil.getEntity(Bukkit.getWorld(args[1]), UUID.fromString(args[0]));
        if (e==null) return false;
        List<String> tmp = new ArrayList<String>(Arrays.asList(args));
        tmp.remove(0); tmp.remove(0); args = tmp.toArray(new String[0]);
        tmp=null;
        CommandSender cm = (CommandSender)e;
        try {
        	disguise = parseDisguise(cm, args, getPermissions(sender));
       	}
        catch (DisguiseParseException ex) {
        	if (ex.getMessage() != null) {Bukkit.getServer().getLogger().warning(ex.getMessage());}
        	return false;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        if (DisguiseConfig.isNameOfPlayerShownAboveDisguise()) {
            if (disguise.getWatcher() instanceof LivingWatcher) {
                disguise.getWatcher().setCustomName(e.getCustomName());
                if (DisguiseConfig.isNameAboveHeadAlwaysVisible()) {
                    disguise.getWatcher().setCustomNameVisible(true);
                }
            }
        }
        DisguiseAPI.disguiseToAll(e, disguise);
        return true;
    }
    @Override
    protected void sendCommandUsage(CommandSender sender, HashMap<DisguiseType, HashMap<ArrayList<String>, Boolean>> map) {
    	return;
    }

    public boolean dodisguise(Entity e, String cmd)
    {
    	String[] args = cmd.split(" ");
    	if (args==null) return false;
        Disguise disguise;
        try {
        	disguise = parseDisguise((CommandSender)e, args, getPermissions(Bukkit.getConsoleSender()));
       	}
        catch (DisguiseParseException ex) {
        	if (ex.getMessage() != null) {Bukkit.getServer().getLogger().warning(ex.getMessage());}
        	return false;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        if (DisguiseConfig.isNameOfPlayerShownAboveDisguise()) {
            if (disguise.getWatcher() instanceof LivingWatcher) {
                disguise.getWatcher().setCustomName(e.getCustomName());
                if (DisguiseConfig.isNameAboveHeadAlwaysVisible()) {
                    disguise.getWatcher().setCustomNameVisible(true);
                }
            }
        }
        DisguiseAPI.disguiseToAll(e, disguise);
        return true;
    }
}
