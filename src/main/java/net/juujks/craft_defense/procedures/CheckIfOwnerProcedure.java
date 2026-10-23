package net.juujks.craft_defense.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.juujks.craft_defense.network.CraftDefenseModVariables;
import net.juujks.craft_defense.CraftDefenseMod;

import java.util.Comparator;

public class CheckIfOwnerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		String texto = "";
		Entity entidade = null;
		CraftDefenseMod.queueServerWork(1, () -> {
			{
				final Vec3 _center = new Vec3(x, y, z);
				for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(12 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
					if ((entity.getPersistentData().getString("guiOpenedOf")).equals(entityiterator.getStringUUID())) {
						if (!(entityiterator.getPersistentData().getString("owner")).equals(entity.getStringUUID())) {
							CraftDefenseMod.queueServerWork(1, () -> {
								if (entity instanceof Player _player)
									_player.closeContainer();
								{
									Entity _ent = entity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
												_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
												"tellraw @s {\"text\":\"ERROR: This unit is not yours!\",\"color\":\"red\"}");
									}
								}
							});
						}
					}
				}
			}
		});
		CraftDefenseMod.queueServerWork(1, () -> {
			{
				final Vec3 _center = new Vec3(x, y, z);
				for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(12 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
					if ((entity.getPersistentData().getString("guiOpenedOf")).equals(entityiterator.getStringUUID())) {
						entity.getPersistentData().putString("unitName", (entityiterator.getDisplayName().getString()));
						{
							CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
							_vars.damage = entityiterator.getPersistentData().getDouble("damage");
							_vars.moneyUnits = entityiterator.getPersistentData().getDouble("money");
							_vars.range = entityiterator.getPersistentData().getDouble("range");
							_vars.spa = entityiterator.getPersistentData().getDouble("spa");
							_vars.trait = entityiterator.getPersistentData().getString("traitText");
							_vars.markSyncDirty();
						}
						entity.getPersistentData().putString("upCost", (new java.text.DecimalFormat("##").format(entityiterator.getPersistentData().getDouble("upCost"))));
						{
							CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
							_vars.level = entityiterator.getPersistentData().getDouble("level");
							_vars.maxLevel = entityiterator.getPersistentData().getDouble("maxLevel");
							_vars.upCost = entityiterator.getPersistentData().getDouble("upCost");
							_vars.markSyncDirty();
						}
						if (entityiterator.getPersistentData().getBoolean("evo")) {
							entity.getPersistentData().putBoolean("evo", true);
						} else {
							entity.getPersistentData().putBoolean("evo", false);
						}
					}
				}
			}
		});
	}
}