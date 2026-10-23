package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.CreeperEntity;
import net.juujks.craft_defense.client.model.Modelcreeper;

public class CreeperRenderer extends MobRenderer<CreeperEntity, Modelcreeper<CreeperEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/creeper.png");

	public CreeperRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelcreeper<CreeperEntity>(context.bakeLayer(Modelcreeper.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(CreeperEntity entity) {
		return entityTexture;
	}
}