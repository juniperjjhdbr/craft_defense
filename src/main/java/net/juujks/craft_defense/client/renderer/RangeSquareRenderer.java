package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.RangeSquareEntity;
import net.juujks.craft_defense.client.model.ModelrangeCube3;

public class RangeSquareRenderer extends MobRenderer<RangeSquareEntity, ModelrangeCube3<RangeSquareEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/aoesquare.png");

	public RangeSquareRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelrangeCube3<RangeSquareEntity>(context.bakeLayer(ModelrangeCube3.LAYER_LOCATION)), 0f);
	}

	@Override
	public ResourceLocation getTextureLocation(RangeSquareEntity entity) {
		return entityTexture;
	}
}