package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.PolarBearUnitEntity;
import net.juujks.craft_defense.client.model.Modelpolar_bear;

public class PolarBearUnitRenderer extends MobRenderer<PolarBearUnitEntity, Modelpolar_bear<PolarBearUnitEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/polar_bear.png");

	public PolarBearUnitRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelpolar_bear<PolarBearUnitEntity>(context.bakeLayer(Modelpolar_bear.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(PolarBearUnitEntity entity) {
		return entityTexture;
	}
}