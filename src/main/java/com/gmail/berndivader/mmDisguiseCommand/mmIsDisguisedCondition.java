package com.gmail.berndivader.mmDisguiseCommand;

import org.bukkit.entity.Entity;

import io.lumine.xikage.mythicmobs.adapters.AbstractEntity;
import io.lumine.xikage.mythicmobs.adapters.bukkit.BukkitAdapter;
import io.lumine.xikage.mythicmobs.io.MythicLineConfig;
import io.lumine.xikage.mythicmobs.skills.SkillCondition;
import io.lumine.xikage.mythicmobs.skills.conditions.ConditionAction;
import io.lumine.xikage.mythicmobs.skills.conditions.IEntityCondition;
import me.libraryaddict.disguise.DisguiseAPI;
import me.libraryaddict.disguise.disguisetypes.Disguise;

public class mmIsDisguisedCondition extends SkillCondition implements IEntityCondition {
	
	private String type;
	
	public mmIsDisguisedCondition(String line, MythicLineConfig mlc) {
		super(line);
		String act = mlc.getString(new String[]{"condition","c"}, "TRUE").toUpperCase();
		this.type = mlc.getString(new String[]{"disguise","d"}, "ANY").toUpperCase();
		this.ACTION = ConditionAction.isAction(act) ? ConditionAction.valueOf(act) : ConditionAction.TRUE;
	}

	@Override
	public boolean check(AbstractEntity ae) {
		Entity caster = BukkitAdapter.adapt(ae);
		if (!DisguiseAPI.isDisguised(caster)) return false;
		if (this.type.toUpperCase().equals("ANY")) return true;
		Disguise disguise = DisguiseAPI.getDisguise(caster);
		if (disguise.getType().name().equals(this.type)) return true;
		return false;
	}
}
