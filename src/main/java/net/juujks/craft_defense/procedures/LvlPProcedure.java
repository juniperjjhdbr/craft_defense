package net.juujks.craft_defense.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

import java.util.Comparator;

public class LvlPProcedure {
	public static String execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return "";
		String texto = "";
		{
			final Vec3 _center = new Vec3(x, y, z);
			for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(12 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
				if ((entity.getPersistentData().getString("guiOpenedOf")).equals(entityiterator.getStringUUID())) {
					texto = "Upgrade: " + new java.text.DecimalFormat("##").format(entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).level) + "/"
							+ new java.text.DecimalFormat("##").format(entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).maxLevel);
				}
			}
		}
		return texto;
	}
}