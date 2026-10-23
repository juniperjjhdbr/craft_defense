package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.EvokerBossEntity;
import net.juujks.craft_defense.client.model.Modelevoker;

public class EvokerBossRenderer extends MobRenderer<EvokerBossEntity, Modelevoker<EvokerBossEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/evoker.png");

	public EvokerBossRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelevoker<EvokerBossEntity>(context.bakeLayer(Modelevoker.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(EvokerBossEntity entity) {
		return entityTexture;
	}
}