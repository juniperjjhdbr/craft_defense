package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.SkeletonEnemyEntity;
import net.juujks.craft_defense.client.model.Modelskeleton;

public class SkeletonEnemyRenderer extends MobRenderer<SkeletonEnemyEntity, Modelskeleton<SkeletonEnemyEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/skeleton_full.png");

	public SkeletonEnemyRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelskeleton<SkeletonEnemyEntity>(context.bakeLayer(Modelskeleton.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(SkeletonEnemyEntity entity) {
		return entityTexture;
	}
}