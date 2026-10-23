package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.juujks.craft_defense.CraftDefenseMod;

public class LifeBarPowerfulProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		CraftDefenseMod.queueServerWork(20, () -> {
			if (entity.getPersistentData().getDouble("powerful") == 2) {
				entity.setCustomName(Component.literal(("\u2764 " + (new java.text.DecimalFormat("#,###").format(entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)) + "/"
						+ (new java.text.DecimalFormat("#,###").format(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1)) + " - \u00A7cPowerful")));
			}
			if (entity.getPersistentData().getDouble("powerful") == 3) {
				entity.setCustomName(Component.literal(("\u2764 " + (new java.text.DecimalFormat("#,###").format(entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)) + "/"
						+ (new java.text.DecimalFormat("#,###").format(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1)) + " - \u00A74Powerful II")));
			}
			if (entity.getPersistentData().getDouble("powerful") == 4) {
				entity.setCustomName(Component.literal(("\u2764 " + (new java.text.DecimalFormat("#,###").format(entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)) + "/"
						+ (new java.text.DecimalFormat("#,###").format(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1)) + " - \u00A7l\u00A70Powerful III")));
			}
		});
	}
}