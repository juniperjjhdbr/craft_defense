package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.EnemyRegeneratorEntity;
import net.juujks.craft_defense.client.model.Modelplayer;

public class EnemyRegeneratorRenderer extends MobRenderer<EnemyRegeneratorEntity, Modelplayer<EnemyRegeneratorEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/inf_regenerator.png");

	public EnemyRegeneratorRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelplayer<EnemyRegeneratorEntity>(context.bakeLayer(Modelplayer.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(EnemyRegeneratorEntity entity) {
		return entityTexture;
	}
}