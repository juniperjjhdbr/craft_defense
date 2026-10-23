package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.WitchEntity;
import net.juujks.craft_defense.client.model.Modelwitch;

public class WitchRenderer extends MobRenderer<WitchEntity, Modelwitch<WitchEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/witch.png");

	public WitchRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelwitch<WitchEntity>(context.bakeLayer(Modelwitch.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(WitchEntity entity) {
		return entityTexture;
	}
}