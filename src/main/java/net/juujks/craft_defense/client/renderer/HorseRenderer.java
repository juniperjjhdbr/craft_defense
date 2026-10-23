package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.HorseEntity;
import net.juujks.craft_defense.client.model.Modelhorse;

public class HorseRenderer extends MobRenderer<HorseEntity, Modelhorse<HorseEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/horse.png");

	public HorseRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelhorse<HorseEntity>(context.bakeLayer(Modelhorse.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(HorseEntity entity) {
		return entityTexture;
	}
}