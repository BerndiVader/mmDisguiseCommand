package com.gmail.berndivader.mmDisguiseCommand.VolCode;

import java.util.UUID;

import org.bukkit.World;
import org.bukkit.entity.Entity;

public interface VolCode {

	public Entity getEntity(World world, UUID uuid);
	
}
