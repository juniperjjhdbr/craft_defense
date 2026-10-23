package net.juujks.craft_defense.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.juujks.craft_defense.block.model.OrangePortalDisplayModel;
import net.juujks.craft_defense.block.display.OrangePortalDisplayItem;

public class OrangePortalDisplayItemRenderer extends GeoItemRenderer<OrangePortalDisplayItem> {
	public OrangePortalDisplayItemRenderer() {
		super(new OrangePortalDisplayModel());
	}

	@Override
	public RenderType getRenderType(OrangePortalDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}