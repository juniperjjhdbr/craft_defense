package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.RavagerEntity;
import net.juujks.craft_defense.client.model.Modelravager;

public class RavagerRenderer extends MobRenderer<RavagerEntity, Modelravager<RavagerEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/ravager.png");

	public RavagerRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelravager<RavagerEntity>(context.bakeLayer(Modelravager.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(RavagerEntity entity) {
		return entityTexture;
	}
}