package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.ArmadilloEntity;
import net.juujks.craft_defense.client.model.Modelarmadillo;

public class ArmadilloRenderer extends MobRenderer<ArmadilloEntity, Modelarmadillo<ArmadilloEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/armadillo.png");

	public ArmadilloRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelarmadillo<ArmadilloEntity>(context.bakeLayer(Modelarmadillo.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(ArmadilloEntity entity) {
		return entityTexture;
	}
}