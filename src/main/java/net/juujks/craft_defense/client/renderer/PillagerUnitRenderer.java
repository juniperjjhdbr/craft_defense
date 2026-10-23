package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.PillagerUnitEntity;
import net.juujks.craft_defense.client.model.Modelpillager;

public class PillagerUnitRenderer extends MobRenderer<PillagerUnitEntity, Modelpillager<PillagerUnitEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/pillager_full.png");

	public PillagerUnitRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelpillager<PillagerUnitEntity>(context.bakeLayer(Modelpillager.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(PillagerUnitEntity entity) {
		return entityTexture;
	}
}