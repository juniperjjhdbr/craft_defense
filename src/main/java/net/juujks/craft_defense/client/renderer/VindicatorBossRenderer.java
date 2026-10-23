package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.VindicatorBossEntity;
import net.juujks.craft_defense.client.model.Modelvindicator;

public class VindicatorBossRenderer extends MobRenderer<VindicatorBossEntity, Modelvindicator<VindicatorBossEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/vindicator.png");

	public VindicatorBossRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelvindicator<VindicatorBossEntity>(context.bakeLayer(Modelvindicator.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(VindicatorBossEntity entity) {
		return entityTexture;
	}
}