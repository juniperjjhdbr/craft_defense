package net.juujks.craft_defense.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.juujks.craft_defense.block.model.BluePortalBlockModel;
import net.juujks.craft_defense.block.entity.BluePortalTileEntity;

public class BluePortalTileRenderer extends GeoBlockRenderer<BluePortalTileEntity> {
	public BluePortalTileRenderer() {
		super(new BluePortalBlockModel());
	}

	@Override
	public RenderType getRenderType(BluePortalTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}