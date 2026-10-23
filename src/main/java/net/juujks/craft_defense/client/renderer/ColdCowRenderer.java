package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.ColdCowEntity;
import net.juujks.craft_defense.client.model.Modelcold_cow;

public class ColdCowRenderer extends MobRenderer<ColdCowEntity, Modelcold_cow<ColdCowEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/cold_cow.png");

	public ColdCowRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelcold_cow<ColdCowEntity>(context.bakeLayer(Modelcold_cow.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(ColdCowEntity entity) {
		return entityTexture;
	}
}