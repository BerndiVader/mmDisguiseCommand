package com.gmail.berndivader.mmDisguiseCommand;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import io.lumine.xikage.mythicmobs.api.bukkit.events.MythicMechanicLoadEvent;
import io.lumine.xikage.mythicmobs.skills.SkillMechanic;

public class mmMechanicLoader implements Listener {
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void mmRegisterMechanics(MythicMechanicLoadEvent e) {
		if (e.getMechanicName().toLowerCase().equals("advdisguise")) {
			SkillMechanic skill = new mmAdvDisguiseMechanic(e.getHolder(), e.getConfig());
			e.register(skill);
		} else if (e.getMechanicName().toLowerCase().equals("advundisguise")) {
			SkillMechanic skill = new mmAdvUnDisguiseMechanic(e.getHolder(), e.getConfig());
			e.register(skill);
		}
	}
}
