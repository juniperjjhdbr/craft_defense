package net.juujks.craft_defense.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.juujks.craft_defense.network.CraftDefenseModVariables;
import net.juujks.craft_defense.entity.VillagerUnitEntity;
import net.juujks.craft_defense.entity.PiglinUnitEntity;

import java.util.Comparator;

public class DmgP2Procedure {
	public static String execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return "";
		String texto = "";
		Entity entidade = null;
		{
			final Vec3 _center = new Vec3(x, y, z);
			for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(12 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
				if ((entity.getPersistentData().getString("guiOpenedOf")).equals(entityiterator.getStringUUID())) {
					if (!(entityiterator instanceof VillagerUnitEntity) && !(entityiterator instanceof PiglinUnitEntity)) {
						texto = "\u00A7cDMG: " + new java.text.DecimalFormat("#,###.##").format(entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).damage);
					} else if (entityiterator instanceof PiglinUnitEntity) {
						texto = "\u00A7c" + new java.text.DecimalFormat("#,###.##").format(entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).damage) + "\u00A7f | \u00A7a$"
								+ new java.text.DecimalFormat("#,###.##").format(entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).moneyUnits);
					} else {
						texto = "\u00A7aMNY: " + new java.text.DecimalFormat("#,###.##").format(entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).moneyUnits);
					}
				}
			}
		}
		return texto;
	}
}