package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.BoggedUnitEntity;
import net.juujks.craft_defense.client.model.Modelbogged;

public class BoggedUnitRenderer extends MobRenderer<BoggedUnitEntity, Modelbogged<BoggedUnitEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/bogged.png");

	public BoggedUnitRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelbogged<BoggedUnitEntity>(context.bakeLayer(Modelbogged.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(BoggedUnitEntity entity) {
		return entityTexture;
	}
}