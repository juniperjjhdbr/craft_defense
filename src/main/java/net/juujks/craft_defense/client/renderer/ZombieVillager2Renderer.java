package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.ZombieVillager2Entity;
import net.juujks.craft_defense.client.model.Modelzombie_villager;

public class ZombieVillager2Renderer extends MobRenderer<ZombieVillager2Entity, Modelzombie_villager<ZombieVillager2Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/zombie_villager_full.png");

	public ZombieVillager2Renderer(EntityRendererProvider.Context context) {
		super(context, new Modelzombie_villager<ZombieVillager2Entity>(context.bakeLayer(Modelzombie_villager.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(ZombieVillager2Entity entity) {
		return entityTexture;
	}
}