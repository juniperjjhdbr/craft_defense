package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.GoatEntity;
import net.juujks.craft_defense.client.model.Modelgoat;

public class GoatRenderer extends MobRenderer<GoatEntity, Modelgoat<GoatEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/goat.png");

	public GoatRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelgoat<GoatEntity>(context.bakeLayer(Modelgoat.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(GoatEntity entity) {
		return entityTexture;
	}
}