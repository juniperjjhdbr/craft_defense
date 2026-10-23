package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.RavagerBossEntity;
import net.juujks.craft_defense.client.model.Modelravager;

public class RavagerBossRenderer extends MobRenderer<RavagerBossEntity, Modelravager<RavagerBossEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/ravager.png");

	public RavagerBossRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelravager<RavagerBossEntity>(context.bakeLayer(Modelravager.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(RavagerBossEntity entity) {
		return entityTexture;
	}
}