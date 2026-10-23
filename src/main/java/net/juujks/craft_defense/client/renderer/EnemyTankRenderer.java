package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.EnemyTankEntity;
import net.juujks.craft_defense.client.model.Modelplayer;

public class EnemyTankRenderer extends MobRenderer<EnemyTankEntity, Modelplayer<EnemyTankEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/inf_tank.png");

	public EnemyTankRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelplayer<EnemyTankEntity>(context.bakeLayer(Modelplayer.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(EnemyTankEntity entity) {
		return entityTexture;
	}
}