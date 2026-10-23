package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.SlimeClonedEntity;
import net.juujks.craft_defense.client.model.Modelslime;

public class SlimeClonedRenderer extends MobRenderer<SlimeClonedEntity, Modelslime<SlimeClonedEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/slime_full.png");

	public SlimeClonedRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelslime<SlimeClonedEntity>(context.bakeLayer(Modelslime.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(SlimeClonedEntity entity) {
		return entityTexture;
	}
}