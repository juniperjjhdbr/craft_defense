package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.ZombieEntity;
import net.juujks.craft_defense.client.model.ModelzombieV1;

public class ZombieRenderer extends MobRenderer<ZombieEntity, ModelzombieV1<ZombieEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/zombie.png");

	public ZombieRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelzombieV1<ZombieEntity>(context.bakeLayer(ModelzombieV1.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(ZombieEntity entity) {
		return entityTexture;
	}
}