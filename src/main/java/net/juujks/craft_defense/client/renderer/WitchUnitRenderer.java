package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.WitchUnitEntity;
import net.juujks.craft_defense.client.model.Modelwitch;

public class WitchUnitRenderer extends MobRenderer<WitchUnitEntity, Modelwitch<WitchUnitEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/witch.png");

	public WitchUnitRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelwitch<WitchUnitEntity>(context.bakeLayer(Modelwitch.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(WitchUnitEntity entity) {
		return entityTexture;
	}
}