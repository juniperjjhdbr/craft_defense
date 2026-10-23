package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.EnemyFastEntity;
import net.juujks.craft_defense.client.model.Modelplayer;

public class EnemyFastRenderer extends MobRenderer<EnemyFastEntity, Modelplayer<EnemyFastEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/inf_fast.png");

	public EnemyFastRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelplayer<EnemyFastEntity>(context.bakeLayer(Modelplayer.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(EnemyFastEntity entity) {
		return entityTexture;
	}
}