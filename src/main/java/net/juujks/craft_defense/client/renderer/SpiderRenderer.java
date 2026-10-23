package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.SpiderEntity;
import net.juujks.craft_defense.client.model.Modelspider;

public class SpiderRenderer extends MobRenderer<SpiderEntity, Modelspider<SpiderEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/spider.png");

	public SpiderRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelspider<SpiderEntity>(context.bakeLayer(Modelspider.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(SpiderEntity entity) {
		return entityTexture;
	}
}