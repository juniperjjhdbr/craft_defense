package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.RabbitEntity;
import net.juujks.craft_defense.client.model.Modelrabbit;

public class RabbitRenderer extends MobRenderer<RabbitEntity, Modelrabbit<RabbitEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/rabbit.png");

	public RabbitRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelrabbit<RabbitEntity>(context.bakeLayer(Modelrabbit.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(RabbitEntity entity) {
		return entityTexture;
	}
}