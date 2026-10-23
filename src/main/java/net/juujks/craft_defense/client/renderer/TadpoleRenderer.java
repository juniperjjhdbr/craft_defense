package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.TadpoleEntity;
import net.juujks.craft_defense.client.model.Modeltadpole;

public class TadpoleRenderer extends MobRenderer<TadpoleEntity, Modeltadpole<TadpoleEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/tadpole.png");

	public TadpoleRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeltadpole<TadpoleEntity>(context.bakeLayer(Modeltadpole.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(TadpoleEntity entity) {
		return entityTexture;
	}
}