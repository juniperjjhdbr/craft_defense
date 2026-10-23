package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.NPCMission1Entity;
import net.juujks.craft_defense.client.model.Modelbiped_player;

public class NPCMission1Renderer extends MobRenderer<NPCMission1Entity, Modelbiped_player<NPCMission1Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/f26d98740b57d665.png");

	public NPCMission1Renderer(EntityRendererProvider.Context context) {
		super(context, new Modelbiped_player<NPCMission1Entity>(context.bakeLayer(Modelbiped_player.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(NPCMission1Entity entity) {
		return entityTexture;
	}
}