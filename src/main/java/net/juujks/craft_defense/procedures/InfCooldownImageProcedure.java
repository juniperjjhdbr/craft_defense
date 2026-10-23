package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

public class InfCooldownImageProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (CraftDefenseModVariables.MapVariables.get(world).inGame) {
			if (entity instanceof Player _player)
				_player.closeContainer();
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7cERROR: You can not start a raid while there is already one raid happening!"), false);
		}
		CraftDefenseModVariables.MapVariables.get(world).cooldownInf = CraftDefenseModVariables.MapVariables.get(world).cooldownInf + 1;
		CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
		if (CraftDefenseModVariables.MapVariables.get(world).cooldownInf >= 60) {
			CraftDefenseModVariables.MapVariables.get(world).cooldownInf = 0;
			CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
		}
	}
}