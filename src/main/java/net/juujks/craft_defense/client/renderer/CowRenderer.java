package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.CowEntity;
import net.juujks.craft_defense.client.model.Modelcow;

public class CowRenderer extends MobRenderer<CowEntity, Modelcow<CowEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/cow.png");

	public CowRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelcow<CowEntity>(context.bakeLayer(Modelcow.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(CowEntity entity) {
		return entityTexture;
	}
}