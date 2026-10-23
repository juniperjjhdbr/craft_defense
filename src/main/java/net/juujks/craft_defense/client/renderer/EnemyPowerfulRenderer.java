package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.EnemyPowerfulEntity;
import net.juujks.craft_defense.client.model.Modelplayer;

public class EnemyPowerfulRenderer extends MobRenderer<EnemyPowerfulEntity, Modelplayer<EnemyPowerfulEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/inf_powerful.png");

	public EnemyPowerfulRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelplayer<EnemyPowerfulEntity>(context.bakeLayer(Modelplayer.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(EnemyPowerfulEntity entity) {
		return entityTexture;
	}
}