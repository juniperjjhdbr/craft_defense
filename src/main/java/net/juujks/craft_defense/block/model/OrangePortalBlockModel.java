package net.juujks.craft_defense.block.model;

import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.cache.GeckoLibCache;

import net.minecraft.resources.ResourceLocation;

import net.juujks.craft_defense.block.entity.OrangePortalTileEntity;

public class OrangePortalBlockModel extends GeoModel<OrangePortalTileEntity> {
	// Preferred GeckoLib 4 block layout
	private static final ResourceLocation MODEL_BLOCK = ResourceLocation.parse("craft_defense:geo/block/portal.geo.json");
	private static final ResourceLocation ANIM_BLOCK = ResourceLocation.parse("craft_defense:animations/block/portal.animation.json");
	// Shared plugin import layout (entity/ subfolder)
	private static final ResourceLocation MODEL_ENTITY = ResourceLocation.parse("craft_defense:geo/entity/portal.geo.json");
	private static final ResourceLocation ANIM_ENTITY = ResourceLocation.parse("craft_defense:animations/entity/portal.animation.json");
	// Flat legacy layout
	private static final ResourceLocation MODEL_FLAT = ResourceLocation.parse("craft_defense:geo/portal.geo.json");
	private static final ResourceLocation ANIM_FLAT = ResourceLocation.parse("craft_defense:animations/portal.animation.json");

	private static ResourceLocation resolveModel(ResourceLocation block, ResourceLocation entity, ResourceLocation flat) {
		if (GeckoLibCache.getBakedModels().containsKey(block))
			return block;
		if (GeckoLibCache.getBakedModels().containsKey(entity))
			return entity;
		return flat;
	}

	private static ResourceLocation resolveAnim(ResourceLocation block, ResourceLocation entity, ResourceLocation flat) {
		if (GeckoLibCache.getBakedAnimations().containsKey(block))
			return block;
		if (GeckoLibCache.getBakedAnimations().containsKey(entity))
			return entity;
		return flat;
	}

	@Override
	public ResourceLocation getAnimationResource(OrangePortalTileEntity animatable) {
		return resolveAnim(ANIM_BLOCK, ANIM_ENTITY, ANIM_FLAT);
	}

	@Override
	public ResourceLocation getModelResource(OrangePortalTileEntity animatable) {
		return resolveModel(MODEL_BLOCK, MODEL_ENTITY, MODEL_FLAT);
	}

	@Override
	public ResourceLocation getTextureResource(OrangePortalTileEntity animatable) {
		// MCreator block textures: assets/<modid>/textures/block/<name>.png
		return ResourceLocation.parse("craft_defense:textures/block/portal_texture2.png");
	}
}