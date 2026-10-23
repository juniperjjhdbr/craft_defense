package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.ColdPigEntity;
import net.juujks.craft_defense.client.model.Modelcold_pig;

public class ColdPigRenderer extends MobRenderer<ColdPigEntity, Modelcold_pig<ColdPigEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/cold_pig.png");

	public ColdPigRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelcold_pig<ColdPigEntity>(context.bakeLayer(Modelcold_pig.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(ColdPigEntity entity) {
		return entityTexture;
	}
}