package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.GuardianBossEntity;
import net.juujks.craft_defense.client.model.Modelguardian;

public class GuardianBossRenderer extends MobRenderer<GuardianBossEntity, Modelguardian<GuardianBossEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/guardian.png");

	public GuardianBossRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelguardian<GuardianBossEntity>(context.bakeLayer(Modelguardian.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(GuardianBossEntity entity) {
		return entityTexture;
	}
}