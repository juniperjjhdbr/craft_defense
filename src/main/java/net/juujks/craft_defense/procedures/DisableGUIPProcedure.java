package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.juujks.craft_defense.network.CraftDefenseModVariables;
import net.juujks.craft_defense.init.CraftDefenseModMenus;

public class DisableGUIPProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Player _entity0 && _entity0.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu0) && _menu0.getMenuState(1, "disablegui", false)) {
			CraftDefenseModVariables.MapVariables.get(world).disableGUI = true;
			CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
		} else {
			CraftDefenseModVariables.MapVariables.get(world).disableGUI = false;
			CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
		}
	}
}