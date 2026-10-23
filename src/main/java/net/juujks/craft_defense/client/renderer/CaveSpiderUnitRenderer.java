package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.CaveSpiderUnitEntity;
import net.juujks.craft_defense.client.model.Modelcave_spider;

public class CaveSpiderUnitRenderer extends MobRenderer<CaveSpiderUnitEntity, Modelcave_spider<CaveSpiderUnitEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/cave_spider.png");

	public CaveSpiderUnitRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelcave_spider<CaveSpiderUnitEntity>(context.bakeLayer(Modelcave_spider.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(CaveSpiderUnitEntity entity) {
		return entityTexture;
	}
}