package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.EnemyPowerful2Entity;
import net.juujks.craft_defense.client.model.Modelplayer;

public class EnemyPowerful2Renderer extends MobRenderer<EnemyPowerful2Entity, Modelplayer<EnemyPowerful2Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/inf_powerful2.png");

	public EnemyPowerful2Renderer(EntityRendererProvider.Context context) {
		super(context, new Modelplayer<EnemyPowerful2Entity>(context.bakeLayer(Modelplayer.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(EnemyPowerful2Entity entity) {
		return entityTexture;
	}
}