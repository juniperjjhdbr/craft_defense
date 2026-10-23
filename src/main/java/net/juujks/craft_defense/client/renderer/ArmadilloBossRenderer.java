package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.ArmadilloBossEntity;
import net.juujks.craft_defense.client.model.Modelarmadillo;

public class ArmadilloBossRenderer extends MobRenderer<ArmadilloBossEntity, Modelarmadillo<ArmadilloBossEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/armadillo.png");

	public ArmadilloBossRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelarmadillo<ArmadilloBossEntity>(context.bakeLayer(Modelarmadillo.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(ArmadilloBossEntity entity) {
		return entityTexture;
	}
}