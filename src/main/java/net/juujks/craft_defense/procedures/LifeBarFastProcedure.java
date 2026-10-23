package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.juujks.craft_defense.CraftDefenseMod;

public class LifeBarFastProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		CraftDefenseMod.queueServerWork(20, () -> {
			if (entity.getPersistentData().getBoolean("fast")) {
				entity.setCustomName(Component.literal(("\u2764 " + (new java.text.DecimalFormat("#,###").format(entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)) + "/"
						+ (new java.text.DecimalFormat("#,###").format(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1)) + " - \u00A76Fast")));
			}
		});
	}
}