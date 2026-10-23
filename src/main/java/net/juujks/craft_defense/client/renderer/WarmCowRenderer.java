package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.WarmCowEntity;
import net.juujks.craft_defense.client.model.Modelwarm_cow;

public class WarmCowRenderer extends MobRenderer<WarmCowEntity, Modelwarm_cow<WarmCowEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/warm_cow.png");

	public WarmCowRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelwarm_cow<WarmCowEntity>(context.bakeLayer(Modelwarm_cow.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(WarmCowEntity entity) {
		return entityTexture;
	}
}