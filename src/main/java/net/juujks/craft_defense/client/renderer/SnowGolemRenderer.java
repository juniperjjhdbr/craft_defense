package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.SnowGolemEntity;
import net.juujks.craft_defense.client.model.Modelsnow_golem;

public class SnowGolemRenderer extends MobRenderer<SnowGolemEntity, Modelsnow_golem<SnowGolemEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/snow_golem.png");

	public SnowGolemRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelsnow_golem<SnowGolemEntity>(context.bakeLayer(Modelsnow_golem.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(SnowGolemEntity entity) {
		return entityTexture;
	}
}