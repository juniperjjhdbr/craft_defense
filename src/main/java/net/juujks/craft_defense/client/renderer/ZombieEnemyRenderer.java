package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.ZombieEnemyEntity;
import net.juujks.craft_defense.client.model.ModelzombieV1;

public class ZombieEnemyRenderer extends MobRenderer<ZombieEnemyEntity, ModelzombieV1<ZombieEnemyEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/zombie.png");

	public ZombieEnemyRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelzombieV1<ZombieEnemyEntity>(context.bakeLayer(ModelzombieV1.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(ZombieEnemyEntity entity) {
		return entityTexture;
	}
}