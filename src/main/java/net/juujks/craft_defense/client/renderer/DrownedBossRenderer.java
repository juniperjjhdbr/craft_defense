package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.DrownedBossEntity;
import net.juujks.craft_defense.client.model.Modeldrowned;

public class DrownedBossRenderer extends MobRenderer<DrownedBossEntity, Modeldrowned<DrownedBossEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/drowned_full.png");

	public DrownedBossRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeldrowned<DrownedBossEntity>(context.bakeLayer(Modeldrowned.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(DrownedBossEntity entity) {
		return entityTexture;
	}
}