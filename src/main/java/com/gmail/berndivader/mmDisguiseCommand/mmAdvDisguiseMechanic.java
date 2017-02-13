package com.gmail.berndivader.mmDisguiseCommand;

import io.lumine.xikage.mythicmobs.adapters.AbstractEntity;
import io.lumine.xikage.mythicmobs.adapters.bukkit.BukkitAdapter;
import io.lumine.xikage.mythicmobs.io.MythicLineConfig;
import io.lumine.xikage.mythicmobs.skills.ITargetedEntitySkill;
import io.lumine.xikage.mythicmobs.skills.SkillMechanic;
import io.lumine.xikage.mythicmobs.skills.SkillMetadata;
import io.lumine.xikage.mythicmobs.skills.SkillString;
import io.lumine.xikage.mythicmobs.skills.mechanics.CustomMechanic;

public class mmAdvDisguiseMechanic extends SkillMechanic implements ITargetedEntitySkill {
	private amDisguiseCommand amdis=Main.getdisuise();
	private String cmd;

	public mmAdvDisguiseMechanic(CustomMechanic skill, MythicLineConfig mlc) {
		super(skill.getConfigLine(), mlc);
		this.ASYNC_SAFE = false;
		this.cmd = mlc.getString(new String[]{"command","cmd","c"},"creeper");
		this.cmd = this.cmd.substring(1, this.cmd.length()-1);
	}

	@Override
	public boolean castAtEntity(SkillMetadata data, AbstractEntity target) {
		if (target==null) return false;
        String c = SkillString.parseMobVariables(this.cmd, data.getCaster(), target, data.getTrigger());
		return amdis.dodisguise(BukkitAdapter.adapt(target), c);
	}
}
