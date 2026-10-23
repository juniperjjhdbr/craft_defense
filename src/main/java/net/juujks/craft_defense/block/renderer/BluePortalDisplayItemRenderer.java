package net.juujks.craft_defense.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.juujks.craft_defense.block.model.BluePortalDisplayModel;
import net.juujks.craft_defense.block.display.BluePortalDisplayItem;

public class BluePortalDisplayItemRenderer extends GeoItemRenderer<BluePortalDisplayItem> {
	public BluePortalDisplayItemRenderer() {
		super(new BluePortalDisplayModel());
	}

	@Override
	public RenderType getRenderType(BluePortalDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}