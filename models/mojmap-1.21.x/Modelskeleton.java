// Made with Blockbench 4.12.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelskeleton<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "skeleton"), "main");
	private final ModelPart head;
	private final ModelPart headwear;
	private final ModelPart body;
	private final ModelPart left_arm;
	private final ModelPart right_arm;
	private final ModelPart left_leg;
	private final ModelPart right_leg;
	private final ModelPart bow;

	public Modelskeleton(ModelPart root) {
		this.head = root.getChild("head");
		this.headwear = root.getChild("headwear");
		this.body = root.getChild("body");
		this.left_arm = root.getChild("left_arm");
		this.right_arm = root.getChild("right_arm");
		this.left_leg = root.getChild("left_leg");
		this.right_leg = root.getChild("right_leg");
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

		PartDefinition bow = partdefinition.addOrReplaceChild("bow",
				CubeListBuilder.create().texOffs(68, 7)
						.addBox(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(68, 19)
						.addBox(-1.0F, 0.0F, 0.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(78, 7)
						.addBox(-1.0F, -7.0F, 0.0F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(78, 13)
						.addBox(-1.0F, -9.0F, 1.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(68, 14)
						.addBox(-1.0F, -12.0F, 4.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(74, 18)
						.addBox(-1.0F, -10.0F, 2.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(82, 18)
						.addBox(-1.0F, -12.0F, 5.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(88, 6)
						.addBox(-1.0F, -11.0F, 3.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(80, 0)
						.addBox(-1.0F, -13.0F, 6.0F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(68, 0)
						.addBox(-1.0F, -14.0F, 9.0F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(88, 8)
						.addBox(-1.0F, -13.0F, 13.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(88, 10)
						.addBox(-1.0F, -11.0F, 11.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(88, 12)
						.addBox(-1.0F, -10.0F, 10.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(88, 14)
						.addBox(-1.0F, -9.0F, 9.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(88, 16)
						.addBox(-1.0F, -8.0F, 8.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(88, 18)
						.addBox(-1.0F, -7.0F, 7.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(88, 20)
						.addBox(-1.0F, -6.0F, 6.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(68, 21)
						.addBox(-1.0F, -5.0F, 5.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(74, 21)
						.addBox(-1.0F, -4.0F, 4.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(90, 0)
						.addBox(-1.0F, -3.0F, 3.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(90, 2)
						.addBox(-1.0F, -2.0F, 2.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.0F, 10.0F, -7.0F, 0.7854F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 96, 96);
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
		bow.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
	}
}