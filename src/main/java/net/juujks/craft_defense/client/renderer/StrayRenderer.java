package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.StrayEntity;
import net.juujks.craft_defense.client.model.Modelstray;

public class StrayRenderer extends MobRenderer<StrayEntity, Modelstray<StrayEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/stray_full.png");

	public StrayRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelstray<StrayEntity>(context.bakeLayer(Modelstray.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(StrayEntity entity) {
		return entityTexture;
	}
}