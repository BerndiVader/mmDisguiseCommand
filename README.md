# AdvLibsDisguise Command for MythicMobs 2.5.0 or higher & LibsDisguise 8.6.8 or higher


With help of this command you can use the /d ingame disguise command for your MythicMobs! 

For 2.5.0 - 2.5.1 https://github.com/BerndiVader/mmDisguiseCommand/blob/master/mmDisguiseCommand251.jar
For 2.6 https://github.com/BerndiVader/mmDisguiseCommand/blob/master/mmDisguiseCommand260.jar

Copy the jar into your plugins folder and restart the server. Now you can start to use the commandskill like this:

Example 1:

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
```

Example 2:

```
FlyingGhost:
  Type: bat
  Display: 'Spooky'
  Health: 30
  Damage: 1
  Skills:
  - command{delay=1;cmd="advd <mob.uuid> <mob.l.w> creeper setPowered true setInvisible true"} @self ~onSpawn 1
```


Disclaimer: Use the command skill to execute the "advd" or "advdisguise" as command. Followed by <mob.uuid> and <mob.l.w> for the mobs world. Now use all the options that you also use in the /d ingame disguise command. 

Enjoy!
