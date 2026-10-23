package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.RavagerUnitEntity;
import net.juujks.craft_defense.client.model.Modelravager;

public class RavagerUnitRenderer extends MobRenderer<RavagerUnitEntity, Modelravager<RavagerUnitEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/ravager.png");

	public RavagerUnitRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelravager<RavagerUnitEntity>(context.bakeLayer(Modelravager.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(RavagerUnitEntity entity) {
		return entityTexture;
	}
}