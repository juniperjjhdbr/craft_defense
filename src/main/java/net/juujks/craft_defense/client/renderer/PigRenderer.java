package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.PigEntity;
import net.juujks.craft_defense.client.model.ModelPigTD;

public class PigRenderer extends MobRenderer<PigEntity, ModelPigTD<PigEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/pig.png");

	public PigRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelPigTD<PigEntity>(context.bakeLayer(ModelPigTD.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(PigEntity entity) {
		return entityTexture;
	}
}