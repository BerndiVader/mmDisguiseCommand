# AdvLibsDisguise for MythicMobs 2.4.5 or higher & LibsDisguise 8.6.8 or higher

## Update 9.7.2017 - Gone up to LibsDisguise 9.4. Added Spigot 1.12 support

## Update 21.3.2017 - Gone up to 9.2 LibsDisguise. Now supports templates ie saved skins. Enjoy! For this you need atleast Spigot 1.10.2 and Disguise 9.1.2

Installation: Stop the server and copy the jar into your pluginsfolder. After this restart your server and you can use all the commands and skills like with "/d" command of LibsDisguise.


# MythicMobs Versions 2.4.5 - 2.5.11:

   * Use AdvLibsDisguise as command skill like this:
     ~ Original LibsDisguiseCommand: /d creeper setPowered true

	 ~ AdvLibsDisguiseCommandSkill.: - command{cmd="advd <mob.uuid> <mob.l.w> creeper setPowered true"}

	 
   * Use Multi-Targeters (only for 2.5.11 or higher):
     ~ Original /d command: /d player DarthVader

	 ~ AdvLibsDisguiseCommandSkill with Multi-Targets: - command{cmd="advd <target.uuid> <target.l.w> player <trigger.name>"} @MIR{r=30;t=chicken} ~onDamaged 1
	   This will disguise all the chickens in radius of 30 blocks around the castermob into the attacker (if the attack is a player)
	   
   * Undisguise command:
     ~ Use this command to undisguise the mob again.
	 ``` 
	 - command{cmd="advdun <mob.uuid> <mob.l.w>"}
	 ```
	   
	   
# MythicMobs Versions 4.0.0 or higher

   * Use AdvLibsDisguise as skills:
   
     ~ Disguise Skill usage:
	   ```
	   - advdisguise{c="player <trigger.name>"} @MIR{r=30;t=cow} ~onInteract 1
	   ```
	   Where in c are all the options like in the /d command just without /d and the ability to use the MythicMobs variables and targeters.
	   
	 ~ Undisguise Skill usage:
	   ```
	   - advundisguise @self ~onDamaged 1
       ```   
	   This undisguise the mob when its damaged and if it was disguised.
	   
	   
   * Use AdvLibsDisguise Conditions (only for MythicMobs 4.0.0):
   
     ~ hasdisguise skill condition usage:
	   ```
       - hasdisguise{disguise=player;condition=true}
	   ```
       disguise or d = Valid LibsDisguise Type or use ANY to remove any disguise.
	   condition or c = TRUE / FALSE the skill will be casted if the condition meet (true) or meet not (false)

		 
Skill Example:
```
undisguise:
  Conditions:
  - hasdisguise{disguise=ANY;condition=true}
  Skills:
  - advundisguise @self
```
	   
Mob Examples:	   
```
WildHorse:
  Type: rabbit
  Display: 'WildHorse'
  Health: 30
  Damage: 15
  Faction: neutral
  Despawn: true
  Skills:
  - command{delay=1;cmd="advd <mob.uuid> <mob.l.w> Horse setColor Brown setRearing true"} @self ~onSpawn 1
  
FlyingGhost:
  Type: bat
  Display: 'Spooky'
  Health: 30
  Damage: 1
  Skills:
  - command{delay=1;cmd="advd <mob.uuid> <mob.l.w> creeper setPowered true setInvisible true"} @self ~onSpawn 1

disguiser:
  Type: cow
  AIGoalSelectors:
  - 0 clear
  Skills:
  - command{delay=1;cmd="advd <target.uuid> <target.l.w> cow"} @MIR{r=30;t=disguisedummy} ~onDamaged 1

disguisedummy:
  Type: chicken
  AIGoalSelectors:
  - 0 clear
```