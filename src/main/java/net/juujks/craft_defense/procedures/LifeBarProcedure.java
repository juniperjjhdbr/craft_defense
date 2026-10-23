package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.juujks.craft_defense.CraftDefenseMod;

public class LifeBarProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		CraftDefenseMod.queueServerWork(20, () -> {
			if (entity.getPersistentData().getDouble("powerful") == 0 && !entity.getPersistentData().getBoolean("aerial") && !entity.getPersistentData().getBoolean("fast") && !entity.getPersistentData().getBoolean("regen")
					&& !entity.getPersistentData().getBoolean("tank") && !entity.getPersistentData().getBoolean("cloner") && entity.getPersistentData().getDouble("boss") == 0) {
				entity.setCustomName(Component.literal(("\u2764 " + (new java.text.DecimalFormat("#,###").format(entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)) + "/"
						+ (new java.text.DecimalFormat("#,###").format(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1)))));
			}
		});
	}
}