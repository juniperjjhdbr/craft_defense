package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

public class D11Procedure {
	public static String execute(LevelAccessor world) {
		return "OWNER_OF_RAID: " + CraftDefenseModVariables.MapVariables.get(world).ownerOfRaid;
	}
}