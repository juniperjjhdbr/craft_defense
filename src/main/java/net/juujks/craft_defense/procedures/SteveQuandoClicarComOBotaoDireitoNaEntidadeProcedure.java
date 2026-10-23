package net.juujks.craft_defense.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

public class SteveQuandoClicarComOBotaoDireitoNaEntidadeProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		{
			Entity _ent = entity;
			if (!_ent.level().isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
						_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound minecraft:entity.player.levelup master @s ~ ~ ~ 1 2");
			}
		}
		{
			Entity _ent = sourceentity;
			if (!_ent.level().isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
						_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound minecraft:entity.player.levelup master @s ~ ~ ~ 1 2");
			}
		}
		entity.getPersistentData().putBoolean("guiOpen", true);
		entity.getPersistentData().putString("guiOpenedBy", (sourceentity.getStringUUID()));
		sourceentity.getPersistentData().putString("guiOpenedOf", (entity.getStringUUID()));
		{
			CraftDefenseModVariables.PlayerVariables _vars = sourceentity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
			_vars.unitLevel = entity.getPersistentData().getDouble("unitLevel");
			_vars.damageBuff = entity.getPersistentData().getDouble("damageBuff");
			_vars.rangeBuff = entity.getPersistentData().getDouble("rangeBuff");
			_vars.spaBuff = entity.getPersistentData().getDouble("spaBuff");
			_vars.moneyUnits = entity.getPersistentData().getDouble("money");
			_vars.markSyncDirty();
		}
		sourceentity.getPersistentData().putString("unitName", (entity.getDisplayName().getString()));
		sourceentity.getPersistentData().putString("damage", (new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDouble("damage"))));
		entity.getPersistentData().putString("damagePreview2", (new java.text.DecimalFormat("##").format(entity.getPersistentData().getDouble("damage"))));
		sourceentity.getPersistentData().putString("range", (new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDouble("range"))));
		sourceentity.getPersistentData().putString("spa", (new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDouble("spa"))));
		sourceentity.getPersistentData().putString("trait", (entity.getPersistentData().getString("traitText")));
		sourceentity.getPersistentData().putString("upCost", (new java.text.DecimalFormat("##").format(entity.getPersistentData().getDouble("upCost"))));
		sourceentity.getPersistentData().putDouble("level", (entity.getPersistentData().getDouble("level")));
		{
			CraftDefenseModVariables.PlayerVariables _vars = sourceentity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
			_vars.level = entity.getPersistentData().getDouble("level");
			_vars.maxLevel = entity.getPersistentData().getDouble("maxLevel");
			_vars.upCost = entity.getPersistentData().getDouble("upcost");
			_vars.markSyncDirty();
		}
		sourceentity.getPersistentData().putDouble("damageBuff", (entity.getPersistentData().getDouble("damageBuff")));
		sourceentity.getPersistentData().putDouble("rangeBuff", (entity.getPersistentData().getDouble("rangeBuff")));
		sourceentity.getPersistentData().putDouble("spaBuff", (entity.getPersistentData().getDouble("spaBuff")));
		sourceentity.getPersistentData().putDouble("upCost", (entity.getPersistentData().getDouble("upCost")));
		if (entity.getPersistentData().getBoolean("evo")) {
			sourceentity.getPersistentData().putDouble("maxLevel", (entity.getPersistentData().getDouble("maxLevel") + 2));
			sourceentity.getPersistentData().putBoolean("evo", true);
		} else {
			sourceentity.getPersistentData().putDouble("maxLevel", (entity.getPersistentData().getDouble("maxLevel")));
			sourceentity.getPersistentData().putBoolean("evo", false);
		}
	}
}