package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.DonkeyBossEntity;
import net.juujks.craft_defense.client.model.Modeldonkey;

public class DonkeyBossRenderer extends MobRenderer<DonkeyBossEntity, Modeldonkey<DonkeyBossEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/donkey.png");

	public DonkeyBossRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeldonkey<DonkeyBossEntity>(context.bakeLayer(Modeldonkey.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(DonkeyBossEntity entity) {
		return entityTexture;
	}
}