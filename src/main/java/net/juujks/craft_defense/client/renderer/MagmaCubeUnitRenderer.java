package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.MagmaCubeUnitEntity;
import net.juujks.craft_defense.client.model.Modelmagma_cube;

public class MagmaCubeUnitRenderer extends MobRenderer<MagmaCubeUnitEntity, Modelmagma_cube<MagmaCubeUnitEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/magma_cube.png");

	public MagmaCubeUnitRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelmagma_cube<MagmaCubeUnitEntity>(context.bakeLayer(Modelmagma_cube.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(MagmaCubeUnitEntity entity) {
		return entityTexture;
	}
}