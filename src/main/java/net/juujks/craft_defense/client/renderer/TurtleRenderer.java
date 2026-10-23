package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.TurtleEntity;
import net.juujks.craft_defense.client.model.Modelturtle;

public class TurtleRenderer extends MobRenderer<TurtleEntity, Modelturtle<TurtleEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/turtle.png");

	public TurtleRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelturtle<TurtleEntity>(context.bakeLayer(Modelturtle.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(TurtleEntity entity) {
		return entityTexture;
	}
}