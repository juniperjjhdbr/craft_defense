package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.SnowFoxEntity;
import net.juujks.craft_defense.client.model.Modelfox;

public class SnowFoxRenderer extends MobRenderer<SnowFoxEntity, Modelfox<SnowFoxEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/snow_fox.png");

	public SnowFoxRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelfox<SnowFoxEntity>(context.bakeLayer(Modelfox.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(SnowFoxEntity entity) {
		return entityTexture;
	}
}