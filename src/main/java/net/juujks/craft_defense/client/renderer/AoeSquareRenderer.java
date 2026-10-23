package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.AoeSquareEntity;
import net.juujks.craft_defense.client.model.ModelaoeSquare;

public class AoeSquareRenderer extends MobRenderer<AoeSquareEntity, ModelaoeSquare<AoeSquareEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/aoesquare.png");

	public AoeSquareRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelaoeSquare<AoeSquareEntity>(context.bakeLayer(ModelaoeSquare.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(AoeSquareEntity entity) {
		return entityTexture;
	}
}