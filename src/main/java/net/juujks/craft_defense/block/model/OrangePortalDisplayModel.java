package net.juujks.craft_defense.block.model;

import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.cache.GeckoLibCache;

import net.minecraft.resources.ResourceLocation;

import net.juujks.craft_defense.block.display.OrangePortalDisplayItem;

public class OrangePortalDisplayModel extends GeoModel<OrangePortalDisplayItem> {
	// Preferred GeckoLib 4 block layout (shared with block entity)
	private static final ResourceLocation MODEL_BLOCK = ResourceLocation.parse("craft_defense:geo/block/portal.geo.json");
	private static final ResourceLocation ANIM_BLOCK = ResourceLocation.parse("craft_defense:animations/block/portal.animation.json");
	// Shared plugin import layout (entity/ subfolder) — matches actual import path
	private static final ResourceLocation MODEL_ENTITY = ResourceLocation.parse("craft_defense:geo/entity/portal.geo.json");
	private static final ResourceLocation ANIM_ENTITY = ResourceLocation.parse("craft_defense:animations/entity/portal.animation.json");
	// Flat legacy layout
	private static final ResourceLocation MODEL_FLAT = ResourceLocation.parse("craft_defense:geo/portal.geo.json");
	private static final ResourceLocation ANIM_FLAT = ResourceLocation.parse("craft_defense:animations/portal.animation.json");
	// Item layout (if someone places block geo under geo/item/)
	private static final ResourceLocation MODEL_ITEM = ResourceLocation.parse("craft_defense:geo/item/portal.geo.json");
	private static final ResourceLocation ANIM_ITEM = ResourceLocation.parse("craft_defense:animations/item/portal.animation.json");

	@Override
	public ResourceLocation getModelResource(OrangePortalDisplayItem animatable) {
		if (GeckoLibCache.getBakedModels().containsKey(MODEL_BLOCK))
			return MODEL_BLOCK;
		if (GeckoLibCache.getBakedModels().containsKey(MODEL_ENTITY))
			return MODEL_ENTITY;
		if (GeckoLibCache.getBakedModels().containsKey(MODEL_FLAT))
			return MODEL_FLAT;
		return MODEL_ITEM;
	}

	@Override
	public ResourceLocation getAnimationResource(OrangePortalDisplayItem animatable) {
		if (GeckoLibCache.getBakedAnimations().containsKey(ANIM_BLOCK))
			return ANIM_BLOCK;
		if (GeckoLibCache.getBakedAnimations().containsKey(ANIM_ENTITY))
			return ANIM_ENTITY;
		if (GeckoLibCache.getBakedAnimations().containsKey(ANIM_FLAT))
			return ANIM_FLAT;
		return ANIM_ITEM;
	}

	@Override
	public ResourceLocation getTextureResource(OrangePortalDisplayItem entity) {
		// Display items use the block texture (MCreator textures/block/)
		return ResourceLocation.parse("craft_defense:textures/block/portal_texture2.png");
	}
}