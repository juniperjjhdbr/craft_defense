package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.ZombieVillagerEntity;
import net.juujks.craft_defense.client.model.Modelzombie_villager;

public class ZombieVillagerRenderer extends MobRenderer<ZombieVillagerEntity, Modelzombie_villager<ZombieVillagerEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/zombie_villager_full.png");

	public ZombieVillagerRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelzombie_villager<ZombieVillagerEntity>(context.bakeLayer(Modelzombie_villager.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(ZombieVillagerEntity entity) {
		return entityTexture;
	}
}