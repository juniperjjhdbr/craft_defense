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

// Made with Blockbench 4.12.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelsnow_golem<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("craft_defense", "modelsnow_golem"), "main");
	public final ModelPart head;
	public final ModelPart left_hand;
	public final ModelPart left_hand_rotation;
	public final ModelPart right_hand;
	public final ModelPart right_hand_flip;
	public final ModelPart right_hand_rotation;
	public final ModelPart body;
	public final ModelPart body_bottom;

	public Modelsnow_golem(ModelPart root) {
		this.head = root.getChild("head");
		this.left_hand = root.getChild("left_hand");
		this.left_hand_rotation = this.left_hand.getChild("left_hand_rotation");
		this.right_hand = root.getChild("right_hand");
		this.right_hand_flip = this.right_hand.getChild("right_hand_flip");
		this.right_hand_rotation = this.right_hand_flip.getChild("right_hand_rotation");
		this.body = root.getChild("body");
		this.body_bottom = root.getChild("body_bottom");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(-0.5F)), PartPose.offset(0.0F, 4.0F, 0.0F));
		PartDefinition left_hand = partdefinition.addOrReplaceChild("left_hand", CubeListBuilder.create(), PartPose.offset(4.5F, 5.25F, 0.0F));
		PartDefinition left_hand_rotation = left_hand.addOrReplaceChild("left_hand_rotation", CubeListBuilder.create().texOffs(32, 0).addBox(-0.5F, -1.0F, -1.0F, 12.0F, 2.0F, 2.0F, new CubeDeformation(-0.5F)),
				PartPose.offsetAndRotation(-0.5F, 1.0F, 0.0F, 0.0F, 0.0F, 0.9948F));
		PartDefinition right_hand = partdefinition.addOrReplaceChild("right_hand", CubeListBuilder.create(), PartPose.offset(-14.5F, 5.25F, 0.0F));
		PartDefinition right_hand_flip = right_hand.addOrReplaceChild("right_hand_flip", CubeListBuilder.create(), PartPose.offsetAndRotation(5.0F, 1.0F, 0.0F, 0.0F, 3.1416F, 0.0F));
		PartDefinition right_hand_rotation = right_hand_flip.addOrReplaceChild("right_hand_rotation", CubeListBuilder.create().texOffs(32, 0).addBox(-0.5F, -1.0F, -1.0F, 12.0F, 2.0F, 2.0F, new CubeDeformation(-0.5F)),
				PartPose.offsetAndRotation(-5.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.9948F));
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 16).addBox(-5.0F, -10.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(-0.5F)), PartPose.offset(0.0F, 13.0F, 0.0F));
		PartDefinition body_bottom = partdefinition.addOrReplaceChild("body_bottom", CubeListBuilder.create().texOffs(0, 36).addBox(-6.0F, -12.0F, -6.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(-0.5F)), PartPose.offset(0.0F, 24.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		left_hand.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		right_hand.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		body_bottom.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
}