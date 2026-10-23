package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.DolphinBossEntity;
import net.juujks.craft_defense.client.model.Modeldolphin;

public class DolphinBossRenderer extends MobRenderer<DolphinBossEntity, Modeldolphin<DolphinBossEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/dolphin.png");

	public DolphinBossRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeldolphin<DolphinBossEntity>(context.bakeLayer(Modeldolphin.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(DolphinBossEntity entity) {
		return entityTexture;
	}
}