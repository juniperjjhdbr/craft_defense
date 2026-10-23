package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.PillagerBossEntity;
import net.juujks.craft_defense.client.model.Modelpillager;

public class PillagerBossRenderer extends MobRenderer<PillagerBossEntity, Modelpillager<PillagerBossEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/pillager_full.png");

	public PillagerBossRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelpillager<PillagerBossEntity>(context.bakeLayer(Modelpillager.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(PillagerBossEntity entity) {
		return entityTexture;
	}
}