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

import me.libraryaddict.disguise.DisguiseAPI;
import me.libraryaddict.disguise.DisguiseConfig;
import me.libraryaddict.disguise.disguisetypes.Disguise;
import me.libraryaddict.disguise.disguisetypes.DisguiseType;
import me.libraryaddict.disguise.disguisetypes.watchers.LivingWatcher;

public class amDisguiseCommand extends BaseDisguiseCommand {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        Disguise disguise;
        Entity e = NMSUtils.getEntity(Bukkit.getWorld(args[1]), UUID.fromString(args[0]));
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
        	return true;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return true;
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
}
