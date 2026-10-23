package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.HuskEntity;
import net.juujks.craft_defense.client.model.Modelhusk;

public class HuskRenderer extends MobRenderer<HuskEntity, Modelhusk<HuskEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/husk.png");

	public HuskRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelhusk<HuskEntity>(context.bakeLayer(Modelhusk.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(HuskEntity entity) {
		return entityTexture;
	}
}