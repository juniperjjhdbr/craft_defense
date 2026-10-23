package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.LlamaBEntity;
import net.juujks.craft_defense.client.model.Modelllama;

public class LlamaBRenderer extends MobRenderer<LlamaBEntity, Modelllama<LlamaBEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/llama.png");

	public LlamaBRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelllama<LlamaBEntity>(context.bakeLayer(Modelllama.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(LlamaBEntity entity) {
		return entityTexture;
	}
}