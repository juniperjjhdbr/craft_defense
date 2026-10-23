package net.juujks.craft_defense.init;

import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.juujks.craft_defense.entity.*;

@EventBusSubscriber(value = Dist.CLIENT)
public class EntityAnimationFactory {
	@SubscribeEvent
	public static void onEntityTick(EntityTickEvent.Pre event) {
		if (event != null && event.getEntity() != null) {
			if (event.getEntity() instanceof SteveEntity syncable) {
				String animation = syncable.getSyncedAnimation();
				if (!animation.equals("undefined")) {
					syncable.setAnimation("undefined");
					syncable.animationprocedure = animation;
				}
				syncable.applySyncedControllerAnimations();
			}
			if (event.getEntity() instanceof AlexEntity syncable) {
				String animation = syncable.getSyncedAnimation();
				if (!animation.equals("undefined")) {
					syncable.setAnimation("undefined");
					syncable.animationprocedure = animation;
				}
				syncable.applySyncedControllerAnimations();
			}
			if (event.getEntity() instanceof ChickenEntity syncable) {
				String animation = syncable.getSyncedAnimation();
				if (!animation.equals("undefined")) {
					syncable.setAnimation("undefined");
					syncable.animationprocedure = animation;
				}
				syncable.applySyncedControllerAnimations();
			}
			if (event.getEntity() instanceof ZombieUnitEntity syncable) {
				String animation = syncable.getSyncedAnimation();
				if (!animation.equals("undefined")) {
					syncable.setAnimation("undefined");
					syncable.animationprocedure = animation;
				}
				syncable.applySyncedControllerAnimations();
			}
			if (event.getEntity() instanceof CreeperUnitEntity syncable) {
				String animation = syncable.getSyncedAnimation();
				if (!animation.equals("undefined")) {
					syncable.setAnimation("undefined");
					syncable.animationprocedure = animation;
				}
				syncable.applySyncedControllerAnimations();
			}
			if (event.getEntity() instanceof ColdChickenEntity syncable) {
				String animation = syncable.getSyncedAnimation();
				if (!animation.equals("undefined")) {
					syncable.setAnimation("undefined");
					syncable.animationprocedure = animation;
				}
				syncable.applySyncedControllerAnimations();
			}
			if (event.getEntity() instanceof VillagerUnitEntity syncable) {
				String animation = syncable.getSyncedAnimation();
				if (!animation.equals("undefined")) {
					syncable.setAnimation("undefined");
					syncable.animationprocedure = animation;
				}
				syncable.applySyncedControllerAnimations();
			}
			if (event.getEntity() instanceof BatEntity syncable) {
				String animation = syncable.getSyncedAnimation();
				if (!animation.equals("undefined")) {
					syncable.setAnimation("undefined");
					syncable.animationprocedure = animation;
				}
				syncable.applySyncedControllerAnimations();
			}
			if (event.getEntity() instanceof ZombifiedPiglinUnitEntity syncable) {
				String animation = syncable.getSyncedAnimation();
				if (!animation.equals("undefined")) {
					syncable.setAnimation("undefined");
					syncable.animationprocedure = animation;
				}
				syncable.applySyncedControllerAnimations();
			}
			if (event.getEntity() instanceof PiglinUnitEntity syncable) {
				String animation = syncable.getSyncedAnimation();
				if (!animation.equals("undefined")) {
					syncable.setAnimation("undefined");
					syncable.animationprocedure = animation;
				}
				syncable.applySyncedControllerAnimations();
			}
			if (event.getEntity() instanceof PufferfishUnitEntity syncable) {
				String animation = syncable.getSyncedAnimation();
				if (!animation.equals("undefined")) {
					syncable.setAnimation("undefined");
					syncable.animationprocedure = animation;
				}
				syncable.applySyncedControllerAnimations();
			}
			if (event.getEntity() instanceof IronGolemUnitEntity syncable) {
				String animation = syncable.getSyncedAnimation();
				if (!animation.equals("undefined")) {
					syncable.setAnimation("undefined");
					syncable.animationprocedure = animation;
				}
				syncable.applySyncedControllerAnimations();
			}
			if (event.getEntity() instanceof VexEntity syncable) {
				String animation = syncable.getSyncedAnimation();
				if (!animation.equals("undefined")) {
					syncable.setAnimation("undefined");
					syncable.animationprocedure = animation;
				}
				syncable.applySyncedControllerAnimations();
			}
			if (event.getEntity() instanceof IronGolemBossEntity syncable) {
				String animation = syncable.getSyncedAnimation();
				if (!animation.equals("undefined")) {
					syncable.setAnimation("undefined");
					syncable.animationprocedure = animation;
				}
				syncable.applySyncedControllerAnimations();
			}
			if (event.getEntity() instanceof AllayBossEntity syncable) {
				String animation = syncable.getSyncedAnimation();
				if (!animation.equals("undefined")) {
					syncable.setAnimation("undefined");
					syncable.animationprocedure = animation;
				}
				syncable.applySyncedControllerAnimations();
			}
			if (event.getEntity() instanceof WarmChickenEntity syncable) {
				String animation = syncable.getSyncedAnimation();
				if (!animation.equals("undefined")) {
					syncable.setAnimation("undefined");
					syncable.animationprocedure = animation;
				}
				syncable.applySyncedControllerAnimations();
			}
			if (event.getEntity() instanceof HuskUnitEntity syncable) {
				String animation = syncable.getSyncedAnimation();
				if (!animation.equals("undefined")) {
					syncable.setAnimation("undefined");
					syncable.animationprocedure = animation;
				}
				syncable.applySyncedControllerAnimations();
			}
			if (event.getEntity() instanceof SkeletonUnitEntity syncable) {
				String animation = syncable.getSyncedAnimation();
				if (!animation.equals("undefined")) {
					syncable.setAnimation("undefined");
					syncable.animationprocedure = animation;
				}
				syncable.applySyncedControllerAnimations();
			}
			if (event.getEntity() instanceof SnowGolemUnitEntity syncable) {
				String animation = syncable.getSyncedAnimation();
				if (!animation.equals("undefined")) {
					syncable.setAnimation("undefined");
					syncable.animationprocedure = animation;
				}
				syncable.applySyncedControllerAnimations();
			}
			if (event.getEntity() instanceof ChargedCreeperUnitEntity syncable) {
				String animation = syncable.getSyncedAnimation();
				if (!animation.equals("undefined")) {
					syncable.setAnimation("undefined");
					syncable.animationprocedure = animation;
				}
				syncable.applySyncedControllerAnimations();
			}
			if (event.getEntity() instanceof EndermanUnitEntity syncable) {
				String animation = syncable.getSyncedAnimation();
				if (!animation.equals("undefined")) {
					syncable.setAnimation("undefined");
					syncable.animationprocedure = animation;
				}
				syncable.applySyncedControllerAnimations();
			}
			if (event.getEntity() instanceof BreezeUnitEntity syncable) {
				String animation = syncable.getSyncedAnimation();
				if (!animation.equals("undefined")) {
					syncable.setAnimation("undefined");
					syncable.animationprocedure = animation;
				}
				syncable.applySyncedControllerAnimations();
			}
			if (event.getEntity() instanceof WolfUnitEntity syncable) {
				String animation = syncable.getSyncedAnimation();
				if (!animation.equals("undefined")) {
					syncable.setAnimation("undefined");
					syncable.animationprocedure = animation;
				}
				syncable.applySyncedControllerAnimations();
			}
			if (event.getEntity() instanceof BlazeUnitEntity syncable) {
				String animation = syncable.getSyncedAnimation();
				if (!animation.equals("undefined")) {
					syncable.setAnimation("undefined");
					syncable.animationprocedure = animation;
				}
				syncable.applySyncedControllerAnimations();
			}
			if (event.getEntity() instanceof DrownedUnitEntity syncable) {
				String animation = syncable.getSyncedAnimation();
				if (!animation.equals("undefined")) {
					syncable.setAnimation("undefined");
					syncable.animationprocedure = animation;
				}
				syncable.applySyncedControllerAnimations();
			}
			if (event.getEntity() instanceof FrostbiteUnitEntity syncable) {
				String animation = syncable.getSyncedAnimation();
				if (!animation.equals("undefined")) {
					syncable.setAnimation("undefined");
					syncable.animationprocedure = animation;
				}
				syncable.applySyncedControllerAnimations();
			}
		}
	}
}