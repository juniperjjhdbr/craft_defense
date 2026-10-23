package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.SalmonEntity;
import net.juujks.craft_defense.client.model.Modelsalmon_large;

public class SalmonRenderer extends MobRenderer<SalmonEntity, Modelsalmon_large<SalmonEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/salmon_large.png");

	public SalmonRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelsalmon_large<SalmonEntity>(context.bakeLayer(Modelsalmon_large.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(SalmonEntity entity) {
		return entityTexture;
	}
}