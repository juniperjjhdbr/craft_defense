package net.juujks.craft_defense.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.juujks.craft_defense.entity.model.ZombifiedPiglinUnitModel;
import net.juujks.craft_defense.entity.ZombifiedPiglinUnitEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class ZombifiedPiglinUnitRenderer extends GeoEntityRenderer<ZombifiedPiglinUnitEntity> {
	public ZombifiedPiglinUnitRenderer(EntityRendererProvider.Context context) {
		super(context, new ZombifiedPiglinUnitModel());
		this.shadowRadius = 0.5f;
	}

	@Override
	public RenderType getRenderType(ZombifiedPiglinUnitEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, ZombifiedPiglinUnitEntity animatable, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int colour) {
		// Hide Blockbench utility bones so they are never drawn as geometry
		model.getBone("hitbox").ifPresent(bone -> bone.setHidden(true));
		model.getBone("tag_name").ifPresent(bone -> bone.setHidden(true));
		super.preRender(poseStack, animatable, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, colour);
	}
}