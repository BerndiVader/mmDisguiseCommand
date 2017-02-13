package com.gmail.berndivader.mmDisguiseCommand;

import org.bukkit.entity.Entity;

import io.lumine.xikage.mythicmobs.adapters.AbstractEntity;
import io.lumine.xikage.mythicmobs.adapters.bukkit.BukkitAdapter;
import io.lumine.xikage.mythicmobs.io.MythicLineConfig;
import io.lumine.xikage.mythicmobs.skills.INoTargetSkill;
import io.lumine.xikage.mythicmobs.skills.ITargetedEntitySkill;
import io.lumine.xikage.mythicmobs.skills.SkillMechanic;
import io.lumine.xikage.mythicmobs.skills.SkillMetadata;
import io.lumine.xikage.mythicmobs.skills.mechanics.CustomMechanic;
import me.libraryaddict.disguise.DisguiseAPI;

public class mmAdvUnDisguiseMechanic extends SkillMechanic implements ITargetedEntitySkill, INoTargetSkill{

	public mmAdvUnDisguiseMechanic(CustomMechanic skill, MythicLineConfig mlc) {
		super(skill.getConfigLine(), mlc);
		this.ASYNC_SAFE=false;
	}

	@Override
	public boolean cast(SkillMetadata data) {
		unDiguise(data.getCaster().getEntity());
		return true;
	}

	@Override
	public boolean castAtEntity(SkillMetadata data, AbstractEntity t) {
		unDiguise(t);
		return true;
	}
	
	private void unDiguise(AbstractEntity ae) {
		Entity target = BukkitAdapter.adapt(ae);
		if (DisguiseAPI.isDisguised(target)) DisguiseAPI.undisguiseToAll(target);
	}

}
