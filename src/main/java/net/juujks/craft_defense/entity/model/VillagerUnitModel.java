package net.juujks.craft_defense.entity.model;

import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.cache.GeckoLibCache;

import net.minecraft.resources.ResourceLocation;

import net.juujks.craft_defense.entity.VillagerUnitEntity;

public class VillagerUnitModel extends GeoModel<VillagerUnitEntity> {
	// DefaultedEntityGeoModel-style paths (recommended GeckoLib 4 layout)
	private static final ResourceLocation MODEL_ENTITY = ResourceLocation.parse("craft_defense:geo/entity/villager.geo.json");
	private static final ResourceLocation ANIM_ENTITY = ResourceLocation.parse("craft_defense:animations/entity/villager.animation.json");
	// Flat legacy layout (older plugin imports)
	private static final ResourceLocation MODEL_FLAT = ResourceLocation.parse("craft_defense:geo/villager.geo.json");
	private static final ResourceLocation ANIM_FLAT = ResourceLocation.parse("craft_defense:animations/villager.animation.json");

	@Override
	public ResourceLocation getModelResource(VillagerUnitEntity animatable) {
		if (GeckoLibCache.getBakedModels().containsKey(MODEL_ENTITY))
			return MODEL_ENTITY;
		return MODEL_FLAT;
	}

	@Override
	public ResourceLocation getTextureResource(VillagerUnitEntity animatable) {
		// MCreator entity textures are imported to textures/entities/
		return ResourceLocation.parse("craft_defense:textures/entities/" + animatable.getTexture() + ".png");
	}

	@Override
	public ResourceLocation getAnimationResource(VillagerUnitEntity animatable) {
		if (GeckoLibCache.getBakedAnimations().containsKey(ANIM_ENTITY))
			return ANIM_ENTITY;
		return ANIM_FLAT;
	}
}