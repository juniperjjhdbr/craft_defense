package net.juujks.craft_defense.entity.model;

import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.cache.GeckoLibCache;

import net.minecraft.resources.ResourceLocation;

import net.juujks.craft_defense.entity.SnowGolemUnitEntity;

public class SnowGolemUnitModel extends GeoModel<SnowGolemUnitEntity> {
	// DefaultedEntityGeoModel-style paths (recommended GeckoLib 4 layout)
	private static final ResourceLocation MODEL_ENTITY = ResourceLocation.parse("craft_defense:geo/entity/snow_golem_-_converted.geo.json");
	private static final ResourceLocation ANIM_ENTITY = ResourceLocation.parse("craft_defense:animations/entity/snow_golem_-_converted.animation.json");
	// Flat legacy layout (older plugin imports)
	private static final ResourceLocation MODEL_FLAT = ResourceLocation.parse("craft_defense:geo/snow_golem_-_converted.geo.json");
	private static final ResourceLocation ANIM_FLAT = ResourceLocation.parse("craft_defense:animations/snow_golem_-_converted.animation.json");

	@Override
	public ResourceLocation getModelResource(SnowGolemUnitEntity animatable) {
		if (GeckoLibCache.getBakedModels().containsKey(MODEL_ENTITY))
			return MODEL_ENTITY;
		return MODEL_FLAT;
	}

	@Override
	public ResourceLocation getTextureResource(SnowGolemUnitEntity animatable) {
		// MCreator entity textures are imported to textures/entities/
		return ResourceLocation.parse("craft_defense:textures/entities/" + animatable.getTexture() + ".png");
	}

	@Override
	public ResourceLocation getAnimationResource(SnowGolemUnitEntity animatable) {
		if (GeckoLibCache.getBakedAnimations().containsKey(ANIM_ENTITY))
			return ANIM_ENTITY;
		return ANIM_FLAT;
	}
}