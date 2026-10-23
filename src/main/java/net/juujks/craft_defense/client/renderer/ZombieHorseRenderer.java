package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.ZombieHorseEntity;
import net.juujks.craft_defense.client.model.Modelzombie_horse;

public class ZombieHorseRenderer extends MobRenderer<ZombieHorseEntity, Modelzombie_horse<ZombieHorseEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/zombie_horse.png");

	public ZombieHorseRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelzombie_horse<ZombieHorseEntity>(context.bakeLayer(Modelzombie_horse.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(ZombieHorseEntity entity) {
		return entityTexture;
	}
}