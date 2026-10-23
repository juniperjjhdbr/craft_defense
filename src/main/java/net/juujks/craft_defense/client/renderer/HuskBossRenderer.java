package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.HuskBossEntity;
import net.juujks.craft_defense.client.model.Modelhusk;

public class HuskBossRenderer extends MobRenderer<HuskBossEntity, Modelhusk<HuskBossEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/husk.png");

	public HuskBossRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelhusk<HuskBossEntity>(context.bakeLayer(Modelhusk.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(HuskBossEntity entity) {
		return entityTexture;
	}
}