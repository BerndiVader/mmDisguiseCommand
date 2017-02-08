package com.gmail.berndivader.mmDisguiseCommand;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import io.lumine.xikage.mythicmobs.api.bukkit.events.MythicConditionLoadEvent;
import io.lumine.xikage.mythicmobs.skills.SkillCondition;

public class mmConditionsLoader implements Listener {
	
	@EventHandler
	public void mmRegisterConditions(MythicConditionLoadEvent e) {
		if (e.getConditionName().toLowerCase().equals("hasdisguise")) {
			e.getContainer();
			SkillCondition condition = new mmIsDisguisedCondition(e.getConfig().getLine(), e.getConfig());
			e.register(condition);
		}
	}
}
