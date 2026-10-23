package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.SlimeEnemyEntity;
import net.juujks.craft_defense.client.model.Modelslime;

public class SlimeEnemyRenderer extends MobRenderer<SlimeEnemyEntity, Modelslime<SlimeEnemyEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/slime_full.png");

	public SlimeEnemyRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelslime<SlimeEnemyEntity>(context.bakeLayer(Modelslime.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(SlimeEnemyEntity entity) {
		return entityTexture;
	}
}