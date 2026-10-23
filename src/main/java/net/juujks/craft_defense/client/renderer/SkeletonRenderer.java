package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.SkeletonEntity;
import net.juujks.craft_defense.client.model.Modelskeleton;

public class SkeletonRenderer extends MobRenderer<SkeletonEntity, Modelskeleton<SkeletonEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/skeleton_full.png");

	public SkeletonRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelskeleton<SkeletonEntity>(context.bakeLayer(Modelskeleton.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(SkeletonEntity entity) {
		return entityTexture;
	}
}