package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.WarmPigEntity;
import net.juujks.craft_defense.client.model.Modelwarm_pig;

public class WarmPigRenderer extends MobRenderer<WarmPigEntity, Modelwarm_pig<WarmPigEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/warm_pig.png");

	public WarmPigRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelwarm_pig<WarmPigEntity>(context.bakeLayer(Modelwarm_pig.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(WarmPigEntity entity) {
		return entityTexture;
	}
}