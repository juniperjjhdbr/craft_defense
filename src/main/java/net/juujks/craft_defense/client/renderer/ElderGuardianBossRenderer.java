package net.juujks.craft_defense.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.juujks.craft_defense.entity.ElderGuardianBossEntity;
import net.juujks.craft_defense.client.model.Modelelder_guardian;

public class ElderGuardianBossRenderer extends MobRenderer<ElderGuardianBossEntity, Modelelder_guardian<ElderGuardianBossEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("craft_defense:textures/entities/elder_guardian.png");

	public ElderGuardianBossRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelelder_guardian<ElderGuardianBossEntity>(context.bakeLayer(Modelelder_guardian.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(ElderGuardianBossEntity entity) {
		return entityTexture;
	}
}