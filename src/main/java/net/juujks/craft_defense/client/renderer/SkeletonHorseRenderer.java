package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.SkeletonHorseEntity;
import net.juujks.craft_defense.client.model.Modelskeleton_horse;

public class SkeletonHorseRenderer extends MobRenderer<SkeletonHorseEntity, Modelskeleton_horse<SkeletonHorseEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/skeleton_horse.png");

	public SkeletonHorseRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelskeleton_horse<SkeletonHorseEntity>(context.bakeLayer(Modelskeleton_horse.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(SkeletonHorseEntity entity) {
		return entityTexture;
	}
}