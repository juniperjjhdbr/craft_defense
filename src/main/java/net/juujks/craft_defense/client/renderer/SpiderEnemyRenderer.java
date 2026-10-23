package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.SpiderEnemyEntity;
import net.juujks.craft_defense.client.model.Modelspider;

public class SpiderEnemyRenderer extends MobRenderer<SpiderEnemyEntity, Modelspider<SpiderEnemyEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/spider.png");

	public SpiderEnemyRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelspider<SpiderEnemyEntity>(context.bakeLayer(Modelspider.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(SpiderEnemyEntity entity) {
		return entityTexture;
	}
}