package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.VindicatorEntity;
import net.juujks.craft_defense.client.model.Modelvindicator;

public class VindicatorRenderer extends MobRenderer<VindicatorEntity, Modelvindicator<VindicatorEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/vindicator.png");

	public VindicatorRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelvindicator<VindicatorEntity>(context.bakeLayer(Modelvindicator.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(VindicatorEntity entity) {
		return entityTexture;
	}
}