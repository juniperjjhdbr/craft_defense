package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.CaveSpiderEntity;
import net.juujks.craft_defense.client.model.Modelcave_spider;

public class CaveSpiderRenderer extends MobRenderer<CaveSpiderEntity, Modelcave_spider<CaveSpiderEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/cave_spider.png");

	public CaveSpiderRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelcave_spider<CaveSpiderEntity>(context.bakeLayer(Modelcave_spider.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(CaveSpiderEntity entity) {
		return entityTexture;
	}
}