package net.juujks.craft_defense.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelpuffer_fish_big<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("craft_defense", "modelpuffer_fish_big"), "main");
	public final ModelPart body;
	public final ModelPart fin_left;
	public final ModelPart fin_right;
	public final ModelPart spikes_front_top;
	public final ModelPart spikes_middle_top;
	public final ModelPart spikes_back_top;
	public final ModelPart spikes_front_left;
	public final ModelPart spikes_front_right;
	public final ModelPart spikes_back_left;
	public final ModelPart spikes_back_right;
	public final ModelPart spikes_front_bottom;
	public final ModelPart spikes_middle_bottom;
	public final ModelPart spikes_back_bottom;

	public Modelpuffer_fish_big(ModelPart root) {
		this.body = root.getChild("body");
		this.fin_left = root.getChild("fin_left");
		this.fin_right = root.getChild("fin_right");
		this.spikes_front_top = root.getChild("spikes_front_top");
		this.spikes_middle_top = root.getChild("spikes_middle_top");
		this.spikes_back_top = root.getChild("spikes_back_top");
		this.spikes_front_left = root.getChild("spikes_front_left");
		this.spikes_front_right = root.getChild("spikes_front_right");
		this.spikes_back_left = root.getChild("spikes_back_left");
		this.spikes_back_right = root.getChild("spikes_back_right");
		this.spikes_front_bottom = root.getChild("spikes_front_bottom");
		this.spikes_middle_bottom = root.getChild("spikes_middle_bottom");
		this.spikes_back_bottom = root.getChild("spikes_back_bottom");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 23.0F, 0.0F));
		PartDefinition fin_left = partdefinition.addOrReplaceChild("fin_left", CubeListBuilder.create().texOffs(24, 3).addBox(0.0F, 0.0F, -0.99F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 16.0F, -2.0F));
		PartDefinition fin_right = partdefinition.addOrReplaceChild("fin_right", CubeListBuilder.create().texOffs(24, 0).addBox(-2.0F, 0.0F, -0.99F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 16.0F, -2.0F));
		PartDefinition spikes_front_top = partdefinition.addOrReplaceChild("spikes_front_top", CubeListBuilder.create().texOffs(15, 17).addBox(-4.0F, -1.0F, 0.0F, 8.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 15.0F, -4.0F, 0.7854F, 0.0F, 0.0F));
		PartDefinition spikes_middle_top = partdefinition.addOrReplaceChild("spikes_middle_top", CubeListBuilder.create().texOffs(14, 16).addBox(-4.0F, -1.0F, 0.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.0F, 0.0F));
		PartDefinition spikes_back_top = partdefinition.addOrReplaceChild("spikes_back_top", CubeListBuilder.create().texOffs(23, 18).addBox(-4.0F, -1.0F, 0.0F, 8.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 15.0F, 4.0F, -0.7854F, 0.0F, 0.0F));
		PartDefinition spikes_front_left = partdefinition.addOrReplaceChild("spikes_front_left", CubeListBuilder.create().texOffs(1, 17).addBox(0.0F, -8.0F, 0.0F, 1.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.0F, 23.0F, -4.0F, 0.0F, 0.7854F, 0.0F));
		PartDefinition spikes_front_right = partdefinition.addOrReplaceChild("spikes_front_right", CubeListBuilder.create().texOffs(5, 17).addBox(-1.0F, -8.0F, 0.0F, 1.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.0F, 23.0F, -4.0F, 0.0F, -0.7854F, 0.0F));
		PartDefinition spikes_back_left = partdefinition.addOrReplaceChild("spikes_back_left", CubeListBuilder.create().texOffs(9, 17).addBox(0.0F, -8.0F, 0.0F, 1.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.0F, 23.0F, 4.0F, 0.0F, -0.7854F, 0.0F));
		PartDefinition spikes_back_right = partdefinition.addOrReplaceChild("spikes_back_right", CubeListBuilder.create().texOffs(9, 17).addBox(-1.0F, -8.0F, 0.0F, 1.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.0F, 23.0F, 4.0F, 0.0F, 0.7854F, 0.0F));
		PartDefinition spikes_front_bottom = partdefinition.addOrReplaceChild("spikes_front_bottom", CubeListBuilder.create().texOffs(15, 20).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 23.0F, -4.0F, -0.7854F, 0.0F, 0.0F));
		PartDefinition spikes_middle_bottom = partdefinition.addOrReplaceChild("spikes_middle_bottom", CubeListBuilder.create().texOffs(15, 20).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 23.0F, 0.0F));
		PartDefinition spikes_back_bottom = partdefinition.addOrReplaceChild("spikes_back_bottom", CubeListBuilder.create().texOffs(15, 20).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 23.0F, 4.0F, 0.7854F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		fin_left.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		fin_right.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		spikes_front_top.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		spikes_middle_top.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		spikes_back_top.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		spikes_front_left.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		spikes_front_right.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		spikes_back_left.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		spikes_back_right.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		spikes_front_bottom.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		spikes_middle_bottom.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		spikes_back_bottom.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
}