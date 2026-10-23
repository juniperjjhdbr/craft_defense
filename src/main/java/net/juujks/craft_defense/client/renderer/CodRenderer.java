package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.CodEntity;
import net.juujks.craft_defense.client.model.Modelcod;

public class CodRenderer extends MobRenderer<CodEntity, Modelcod<CodEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/cod.png");

	public CodRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelcod<CodEntity>(context.bakeLayer(Modelcod.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(CodEntity entity) {
		return entityTexture;
	}
}