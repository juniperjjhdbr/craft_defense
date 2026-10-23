package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.CamelBossEntity;
import net.juujks.craft_defense.client.model.Modelcamel;

public class CamelBossRenderer extends MobRenderer<CamelBossEntity, Modelcamel<CamelBossEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/camel.png");

	public CamelBossRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelcamel<CamelBossEntity>(context.bakeLayer(Modelcamel.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(CamelBossEntity entity) {
		return entityTexture;
	}
}