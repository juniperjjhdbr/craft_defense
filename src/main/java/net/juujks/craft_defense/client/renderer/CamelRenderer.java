package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.CamelEntity;
import net.juujks.craft_defense.client.model.Modelcamel;

public class CamelRenderer extends MobRenderer<CamelEntity, Modelcamel<CamelEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/camel.png");

	public CamelRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelcamel<CamelEntity>(context.bakeLayer(Modelcamel.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(CamelEntity entity) {
		return entityTexture;
	}
}