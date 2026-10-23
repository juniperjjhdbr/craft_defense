// Made with Blockbench 4.12.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelstray<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "stray"), "main");
	private final ModelPart head;
	private final ModelPart headwear;
	private final ModelPart body;
	private final ModelPart left_arm;
	private final ModelPart right_arm;
	private final ModelPart left_leg;
	private final ModelPart right_leg;
	private final ModelPart head2;
	private final ModelPart headwear2;
	private final ModelPart body2;
	private final ModelPart left_arm2;
	private final ModelPart right_arm2;
	private final ModelPart left_leg2;
	private final ModelPart right_leg2;
	private final ModelPart bow;

	public Modelstray(ModelPart root) {
		this.head = root.getChild("head");
		this.headwear = root.getChild("headwear");
		this.body = root.getChild("body");
		this.left_arm = root.getChild("left_arm");
		this.right_arm = root.getChild("right_arm");
		this.left_leg = root.getChild("left_leg");
		this.right_leg = root.getChild("right_leg");
		this.head2 = root.getChild("head2");
		this.headwear2 = root.getChild("headwear2");
		this.body2 = root.getChild("body2");
		this.left_arm2 = root.getChild("left_arm2");
		this.right_arm2 = root.getChild("right_arm2");
		this.left_leg2 = root.getChild("left_leg2");
		this.right_leg2 = root.getChild("right_leg2");
		this.bow = root.getChild("bow");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(
				-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition headwear = partdefinition.addOrReplaceChild("headwear", CubeListBuilder.create().texOffs(32, 0)
				.addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.5F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 16).addBox(
				-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm",
				CubeListBuilder.create().texOffs(40, 16).mirror()
						.addBox(-1.0F, -2.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, -1.5708F, 0.6981F, 0.0F));

		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm",
				CubeListBuilder.create().texOffs(40, 16).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 12.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg",
				CubeListBuilder.create().texOffs(0, 16).mirror()
						.addBox(-1.0F, 0.0F, -1.1F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(2.0F, 12.0F, 0.1F));

		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 16)
				.addBox(-1.0F, 0.0F, -1.1F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-2.0F, 12.0F, 0.1F));

		PartDefinition head2 = partdefinition.addOrReplaceChild("head2", CubeListBuilder.create().texOffs(0, 32).addBox(
				-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.25F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition headwear2 = partdefinition.addOrReplaceChild("headwear2", CubeListBuilder.create()
				.texOffs(32, 32).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.75F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition body2 = partdefinition.addOrReplaceChild("body2", CubeListBuilder.create().texOffs(16, 48)
				.addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition left_arm2 = partdefinition.addOrReplaceChild("left_arm2",
				CubeListBuilder.create().texOffs(40, 48).mirror()
						.addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)).mirror(false),
				PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, -1.5708F, 0.6981F, 0.0F));

		PartDefinition right_arm2 = partdefinition.addOrReplaceChild("right_arm2",
				CubeListBuilder.create().texOffs(40, 48).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F,
						new CubeDeformation(0.25F)),
				PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition left_leg2 = partdefinition.addOrReplaceChild("left_leg2",
				CubeListBuilder.create().texOffs(0, 48).mirror()
						.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)).mirror(false),
				PartPose.offset(1.9F, 12.0F, 0.1F));

		PartDefinition right_leg2 = partdefinition.addOrReplaceChild("right_leg2", CubeListBuilder.create()
				.texOffs(0, 48).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)),
				PartPose.offset(-1.9F, 12.0F, 0.1F));

		PartDefinition bow = partdefinition.addOrReplaceChild("bow",
				CubeListBuilder.create().texOffs(64, 7)
						.addBox(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(64, 19)
						.addBox(-1.0F, 0.0F, 0.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(74, 7)
						.addBox(-1.0F, -7.0F, 0.0F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(74, 13)
						.addBox(-1.0F, -9.0F, 1.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(64, 14)
						.addBox(-1.0F, -12.0F, 4.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(70, 18)
						.addBox(-1.0F, -10.0F, 2.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(78, 18)
						.addBox(-1.0F, -12.0F, 5.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(84, 6)
						.addBox(-1.0F, -11.0F, 3.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(76, 0)
						.addBox(-1.0F, -13.0F, 6.0F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(64, 0)
						.addBox(-1.0F, -14.0F, 9.0F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(84, 8)
						.addBox(-1.0F, -13.0F, 13.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(84, 10)
						.addBox(-1.0F, -11.0F, 11.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(84, 12)
						.addBox(-1.0F, -10.0F, 10.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(84, 14)
						.addBox(-1.0F, -9.0F, 9.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(84, 16)
						.addBox(-1.0F, -8.0F, 8.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(84, 18)
						.addBox(-1.0F, -7.0F, 7.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(84, 20)
						.addBox(-1.0F, -6.0F, 6.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(64, 21)
						.addBox(-1.0F, -5.0F, 5.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(70, 21)
						.addBox(-1.0F, -4.0F, 4.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(86, 0)
						.addBox(-1.0F, -3.0F, 3.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(86, 2)
						.addBox(-1.0F, -2.0F, 2.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.0F, 10.0F, -7.0F, 0.7854F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 96, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		headwear.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		headwear2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_arm2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_arm2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_leg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bow.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
	}
}