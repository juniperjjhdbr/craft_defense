package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.SheepEntity;
import net.juujks.craft_defense.client.model.Modelsheep;

public class SheepRenderer extends MobRenderer<SheepEntity, Modelsheep<SheepEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/sheep_full.png");

	public SheepRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelsheep<SheepEntity>(context.bakeLayer(Modelsheep.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(SheepEntity entity) {
		return entityTexture;
	}
}