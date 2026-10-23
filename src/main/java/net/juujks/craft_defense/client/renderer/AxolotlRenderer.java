package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.AxolotlEntity;
import net.juujks.craft_defense.client.model.Modelaxolotl;

public class AxolotlRenderer extends MobRenderer<AxolotlEntity, Modelaxolotl<AxolotlEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/axolotl.png");

	public AxolotlRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelaxolotl<AxolotlEntity>(context.bakeLayer(Modelaxolotl.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(AxolotlEntity entity) {
		return entityTexture;
	}
}