package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.Witch2Entity;
import net.juujks.craft_defense.client.model.Modelwitch;

public class Witch2Renderer extends MobRenderer<Witch2Entity, Modelwitch<Witch2Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/witch.png");

	public Witch2Renderer(EntityRendererProvider.Context context) {
		super(context, new Modelwitch<Witch2Entity>(context.bakeLayer(Modelwitch.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(Witch2Entity entity) {
		return entityTexture;
	}
}