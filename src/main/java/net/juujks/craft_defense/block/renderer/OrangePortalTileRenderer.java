package net.juujks.craft_defense.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.juujks.craft_defense.block.model.OrangePortalBlockModel;
import net.juujks.craft_defense.block.entity.OrangePortalTileEntity;

public class OrangePortalTileRenderer extends GeoBlockRenderer<OrangePortalTileEntity> {
	public OrangePortalTileRenderer() {
		super(new OrangePortalBlockModel());
	}

	@Override
	public RenderType getRenderType(OrangePortalTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}