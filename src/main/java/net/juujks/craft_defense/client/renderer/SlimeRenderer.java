package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.SlimeEntity;
import net.juujks.craft_defense.client.model.Modelslime;

public class SlimeRenderer extends MobRenderer<SlimeEntity, Modelslime<SlimeEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/slime_full.png");

	public SlimeRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelslime<SlimeEntity>(context.bakeLayer(Modelslime.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(SlimeEntity entity) {
		return entityTexture;
	}
}