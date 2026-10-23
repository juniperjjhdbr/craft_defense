package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.LlamaEntity;
import net.juujks.craft_defense.client.model.Modelllama;

public class LlamaRenderer extends MobRenderer<LlamaEntity, Modelllama<LlamaEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/llama.png");

	public LlamaRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelllama<LlamaEntity>(context.bakeLayer(Modelllama.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(LlamaEntity entity) {
		return entityTexture;
	}
}