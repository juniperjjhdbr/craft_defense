package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.CreeperEnemyEntity;
import net.juujks.craft_defense.client.model.Modelcreeper;

public class CreeperEnemyRenderer extends MobRenderer<CreeperEnemyEntity, Modelcreeper<CreeperEnemyEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/creeper.png");

	public CreeperEnemyRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelcreeper<CreeperEnemyEntity>(context.bakeLayer(Modelcreeper.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(CreeperEnemyEntity entity) {
		return entityTexture;
	}
}