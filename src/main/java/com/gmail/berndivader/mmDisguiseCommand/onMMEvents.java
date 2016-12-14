package com.gmail.berndivader.mmDisguiseCommand;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.AnimalTamer;
import org.bukkit.entity.Horse;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.vehicle.VehicleMoveEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import me.libraryaddict.disguise.DisguiseAPI;
import me.libraryaddict.disguise.LibsDisguises;
import me.libraryaddict.disguise.commands.LibsDisguisesCommand;
import me.libraryaddict.disguise.disguisetypes.Disguise;
import me.libraryaddict.disguise.disguisetypes.watchers.HorseWatcher;
import me.libraryaddict.disguise.events.DisguiseEvent;
import net.elseland.xikage.MythicMobs.MythicMobs;
import net.elseland.xikage.MythicMobs.Compatibility.LibsDisguisesSupport;
import net.elseland.xikage.MythicMobs.Mobs.ActiveMob;

@SuppressWarnings({ "deprecation", "unused" })
public class onMMEvents implements Listener {

	@EventHandler
	public void onRideHorseEvent (PlayerInteractAtEntityEvent e) {
		if (e.getHand().equals(EquipmentSlot.OFF_HAND)) {return;}
		if (!(e.getRightClicked() instanceof LivingEntity)) {return;}
		ActiveMob am = MythicMobs.plugin.getAPI().getMobAPI().getMythicMobInstance(e.getRightClicked());
		if (am==null || !am.getType().getConfig().getBoolean("isRideable", false)) {return;}
		Player p = e.getPlayer();
		AnimalTamer t = (AnimalTamer) p;
		Horse h = (Horse) am.getLivingEntity();
		h.setTamed(true);
		h.setOwner(t);
		new BukkitRunnable() {
			public void run() {
				h.getInventory().setSaddle(new ItemStack(Material.SADDLE,1));
				h.setPassenger(e.getPlayer());
				Bukkit.getServer().broadcastMessage(Boolean.toString(h.isTamed()));
				Bukkit.getServer().broadcastMessage(h.getInventory().getSaddle().toString());
				Bukkit.getServer().broadcastMessage(h.getOwner().toString());
				DisguiseAPI.getDisguise(h).setViewSelfDisguise(false);
			}
		}.runTaskLater(Main.getPlugin(), 2L);
	}
}
