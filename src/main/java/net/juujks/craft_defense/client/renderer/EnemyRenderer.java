package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.EnemyEntity;
import net.juujks.craft_defense.client.model.Modelplayer;

public class EnemyRenderer extends MobRenderer<EnemyEntity, Modelplayer<EnemyEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/inf_default.png");

	public EnemyRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelplayer<EnemyEntity>(context.bakeLayer(Modelplayer.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(EnemyEntity entity) {
		return entityTexture;
	}
}