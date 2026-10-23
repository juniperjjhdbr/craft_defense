// Made with Blockbench 5.1.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelpillager<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "pillager"), "main");
	private final ModelPart head;
	private final ModelPart hat;
	private final ModelPart nose;
	private final ModelPart body;
	private final ModelPart left_arm;
	private final ModelPart right_arm;
	private final ModelPart left_leg;
	private final ModelPart right_leg;
	private final ModelPart bone;

	public Modelpillager(ModelPart root) {
		this.head = root.getChild("head");
		this.hat = root.getChild("hat");
		this.nose = root.getChild("nose");
		this.body = root.getChild("body");
		this.left_arm = root.getChild("left_arm");
		this.right_arm = root.getChild("right_arm");
		this.left_leg = root.getChild("left_leg");
		this.right_leg = root.getChild("right_leg");
		this.bone = root.getChild("bone");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(
				-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition hat = partdefinition.addOrReplaceChild("hat", CubeListBuilder.create(),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition nose = partdefinition.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(24, 0).addBox(
				-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body",
				CubeListBuilder.create().texOffs(16, 20)
						.addBox(-4.0F, 0.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(0, 38)
						.addBox(-4.0F, 0.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.25F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm",
				CubeListBuilder.create().texOffs(40, 46).mirror()
						.addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, -1.5708F, 0.6109F, 0.0F));

		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm",
				CubeListBuilder.create().texOffs(40, 46).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, -1.5708F, -0.3054F, 0.0F));

		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg",
				CubeListBuilder.create().texOffs(0, 22).mirror()
						.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(2.0F, 12.0F, 0.0F));

		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 22)
				.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-2.0F, 12.0F, 0.0F));

		PartDefinition bone = partdefinition.addOrReplaceChild("bone",
				CubeListBuilder.create().texOffs(78, 28)
						.addBox(5.0667F, -1.0F, -7.5167F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(90, 32)
						.addBox(7.0667F, -1.0F, -6.5167F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(70, 36)
						.addBox(5.0667F, -1.0F, -3.5167F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(84, 0)
						.addBox(3.0667F, -1.0F, -5.5167F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(80, 20)
						.addBox(2.0667F, -1.0F, -4.5167F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(64, 28)
						.addBox(4.0667F, -1.0F, -6.5167F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(64, 11)
						.addBox(1.0667F, -1.0F, -4.5167F, 1.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(80, 11)
						.addBox(0.0667F, -1.0F, -3.5167F, 1.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(64, 0)
						.addBox(-0.9333F, -1.0F, -2.5167F, 1.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(74, 36)
						.addBox(2.0667F, -1.0F, 2.4833F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(90, 36)
						.addBox(3.0667F, -1.0F, 3.4833F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(94, 20)
						.addBox(4.0667F, -1.0F, 4.4833F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(96, 32)
						.addBox(5.0667F, -1.0F, 5.4833F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(96, 8)
						.addBox(0.0667F, -1.0F, 5.4833F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(96, 12)
						.addBox(0.0667F, -1.0F, 4.4833F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(94, 36)
						.addBox(-2.9333F, -1.0F, -2.5167F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(98, 36)
						.addBox(-3.9333F, -1.0F, -3.5167F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(84, 37)
						.addBox(-4.9333F, -1.0F, -4.5167F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(64, 20)
						.addBox(-6.9333F, -1.0F, -5.5167F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(84, 8)
						.addBox(-4.9333F, -1.0F, 2.4833F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(78, 38)
						.addBox(-7.9333F, -1.0F, -4.5167F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(98, 0)
						.addBox(-4.9333F, -1.0F, -1.5167F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(90, 28)
						.addBox(-5.9333F, -1.0F, 0.4833F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(102, 32)
						.addBox(-2.9333F, -1.0F, -0.5167F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(98, 4)
						.addBox(-1.9333F, -1.0F, -1.5167F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(96, 15)
						.addBox(-3.9333F, -1.0F, 3.4833F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(84, 34)
						.addBox(-2.9333F, -1.0F, 4.4833F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(102, 35)
						.addBox(-1.9333F, -1.0F, 5.4833F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(64, 36)
						.addBox(-3.9333F, -1.0F, 6.4833F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(78, 34)
						.addBox(-4.9333F, -1.0F, 4.4833F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0667F, 0.0F, -14.4833F, 0.0F, -2.3998F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		hat.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		nose.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
	}
}