package net.juujks.craft_defense.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.juujks.craft_defense.entity.RangeSquareEntity;

public class RangeSquareTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.invulnerableTime = 20;
		{
			Entity _ent = entity;
			_ent.setYRot(0);
			_ent.setXRot(0);
			_ent.setYBodyRot(_ent.getYRot());
			_ent.setYHeadRot(_ent.getYRot());
			_ent.yRotO = _ent.getYRot();
			_ent.xRotO = _ent.getXRot();
			if (_ent instanceof LivingEntity _entity) {
				_entity.yBodyRotO = _entity.getYRot();
				_entity.yHeadRotO = _entity.getYRot();
			}
		}
		if (entity instanceof RangeSquareEntity _datEntL2 && _datEntL2.getEntityData().get(RangeSquareEntity.DATA_visible)) {
			entity.setInvisible(false);
		} else {
			entity.setInvisible(true);
		}
	}
}