package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.PillagerEntity;
import net.juujks.craft_defense.client.model.Modelpillager;

public class PillagerRenderer extends MobRenderer<PillagerEntity, Modelpillager<PillagerEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/pillager_full.png");

	public PillagerRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelpillager<PillagerEntity>(context.bakeLayer(Modelpillager.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(PillagerEntity entity) {
		return entityTexture;
	}
}