package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.StrayUnitEntity;
import net.juujks.craft_defense.client.model.Modelstray;

public class StrayUnitRenderer extends MobRenderer<StrayUnitEntity, Modelstray<StrayUnitEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/stray_full.png");

	public StrayUnitRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelstray<StrayUnitEntity>(context.bakeLayer(Modelstray.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(StrayUnitEntity entity) {
		return entityTexture;
	}
}