package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.DonkeyEntity;
import net.juujks.craft_defense.client.model.Modeldonkey;

public class DonkeyRenderer extends MobRenderer<DonkeyEntity, Modeldonkey<DonkeyEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/donkey.png");

	public DonkeyRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeldonkey<DonkeyEntity>(context.bakeLayer(Modeldonkey.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(DonkeyEntity entity) {
		return entityTexture;
	}
}