package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.SpiderUnitEntity;
import net.juujks.craft_defense.client.model.Modelspider;

public class SpiderUnitRenderer extends MobRenderer<SpiderUnitEntity, Modelspider<SpiderUnitEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/spider.png");

	public SpiderUnitRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelspider<SpiderUnitEntity>(context.bakeLayer(Modelspider.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(SpiderUnitEntity entity) {
		return entityTexture;
	}
}