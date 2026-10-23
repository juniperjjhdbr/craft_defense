package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.EvokerEntity;
import net.juujks.craft_defense.client.model.Modelevoker;

public class EvokerRenderer extends MobRenderer<EvokerEntity, Modelevoker<EvokerEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/evoker.png");

	public EvokerRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelevoker<EvokerEntity>(context.bakeLayer(Modelevoker.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(EvokerEntity entity) {
		return entityTexture;
	}
}