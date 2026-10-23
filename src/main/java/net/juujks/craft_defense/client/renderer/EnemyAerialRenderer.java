package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.EnemyAerialEntity;
import net.juujks.craft_defense.client.model.Modelinfenemy;

public class EnemyAerialRenderer extends MobRenderer<EnemyAerialEntity, Modelinfenemy<EnemyAerialEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/inf_aerial.png");

	public EnemyAerialRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelinfenemy<EnemyAerialEntity>(context.bakeLayer(Modelinfenemy.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(EnemyAerialEntity entity) {
		return entityTexture;
	}
}