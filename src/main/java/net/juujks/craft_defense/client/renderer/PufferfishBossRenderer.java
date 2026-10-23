package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.PufferfishBossEntity;
import net.juujks.craft_defense.client.model.Modelpuffer_fish_big;

public class PufferfishBossRenderer extends MobRenderer<PufferfishBossEntity, Modelpuffer_fish_big<PufferfishBossEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/puffer_fish_big.png");

	public PufferfishBossRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelpuffer_fish_big<PufferfishBossEntity>(context.bakeLayer(Modelpuffer_fish_big.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(PufferfishBossEntity entity) {
		return entityTexture;
	}
}