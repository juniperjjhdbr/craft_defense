package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.ParchedBossEntity;
import net.juujks.craft_defense.client.model.Modelstray;

public class ParchedBossRenderer extends MobRenderer<ParchedBossEntity, Modelstray<ParchedBossEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/parched.png");

	public ParchedBossRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelstray<ParchedBossEntity>(context.bakeLayer(Modelstray.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(ParchedBossEntity entity) {
		return entityTexture;
	}
}