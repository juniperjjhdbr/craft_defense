package net.juujks.craft_defense.entity.model;

import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.cache.GeckoLibCache;

import net.minecraft.resources.ResourceLocation;

import net.juujks.craft_defense.entity.WarmChickenEntity;

public class WarmChickenModel extends GeoModel<WarmChickenEntity> {
	// DefaultedEntityGeoModel-style paths (recommended GeckoLib 4 layout)
	private static final ResourceLocation MODEL_ENTITY = ResourceLocation.parse("craft_defense:geo/entity/chicken.geo.json");
	private static final ResourceLocation ANIM_ENTITY = ResourceLocation.parse("craft_defense:animations/entity/chicken.animation.json");
	// Flat legacy layout (older plugin imports)
	private static final ResourceLocation MODEL_FLAT = ResourceLocation.parse("craft_defense:geo/chicken.geo.json");
	private static final ResourceLocation ANIM_FLAT = ResourceLocation.parse("craft_defense:animations/chicken.animation.json");

	@Override
	public ResourceLocation getModelResource(WarmChickenEntity animatable) {
		if (GeckoLibCache.getBakedModels().containsKey(MODEL_ENTITY))
			return MODEL_ENTITY;
		return MODEL_FLAT;
	}

	@Override
	public ResourceLocation getTextureResource(WarmChickenEntity animatable) {
		// MCreator entity textures are imported to textures/entities/
		return ResourceLocation.parse("craft_defense:textures/entities/" + animatable.getTexture() + ".png");
	}

	@Override
	public ResourceLocation getAnimationResource(WarmChickenEntity animatable) {
		if (GeckoLibCache.getBakedAnimations().containsKey(ANIM_ENTITY))
			return ANIM_ENTITY;
		return ANIM_FLAT;
	}
}