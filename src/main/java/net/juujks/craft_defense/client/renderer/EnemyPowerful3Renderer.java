package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.EnemyPowerful3Entity;
import net.juujks.craft_defense.client.model.Modelplayer;

public class EnemyPowerful3Renderer extends MobRenderer<EnemyPowerful3Entity, Modelplayer<EnemyPowerful3Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/inf_powerful3.png");

	public EnemyPowerful3Renderer(EntityRendererProvider.Context context) {
		super(context, new Modelplayer<EnemyPowerful3Entity>(context.bakeLayer(Modelplayer.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(EnemyPowerful3Entity entity) {
		return entityTexture;
	}
}