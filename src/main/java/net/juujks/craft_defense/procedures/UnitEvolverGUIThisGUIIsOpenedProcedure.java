package net.juujks.craft_defense.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.juujks.craft_defense.configuration.CraftDefenseConfigConfiguration;

public class UnitEvolverGUIThisGUIIsOpenedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!CraftDefenseConfigConfiguration.UNIT_EVOLVER.get()) {
			if (entity instanceof Player _player)
				_player.closeContainer();
		}
	}
}