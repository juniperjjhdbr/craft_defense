// Made with Blockbench 5.1.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelbogged<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "bogged"), "main");
	private final ModelPart head;
	private final ModelPart mushrooms;
	private final ModelPart mushrooms_top;
	private final ModelPart mushrooms_back;
	private final ModelPart headwear;
	private final ModelPart body;
	private final ModelPart left_arm;
	private final ModelPart bow;
	private final ModelPart right_arm;
	private final ModelPart left_leg;
	private final ModelPart right_leg;

	public Modelbogged(ModelPart root) {
		this.head = root.getChild("head");
		this.mushrooms = root.getChild("mushrooms");
		this.mushrooms_top = this.mushrooms.getChild("mushrooms_top");
		this.mushrooms_back = this.mushrooms.getChild("mushrooms_back");
		this.headwear = root.getChild("headwear");
		this.body = root.getChild("body");
		this.left_arm = root.getChild("left_arm");
		this.bow = this.left_arm.getChild("bow");
		this.right_arm = root.getChild("right_arm");
		this.left_leg = root.getChild("left_leg");
		this.right_leg = root.getChild("right_leg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 32)
						.addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.25F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition mushrooms = partdefinition.addOrReplaceChild("mushrooms", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition mushrooms_top = mushrooms.addOrReplaceChild("mushrooms_top",
				CubeListBuilder.create().texOffs(50, 16)
						.addBox(-3.0F, -3.0F, 0.0F, 6.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(50, 10)
						.addBox(0.0F, -3.0F, -3.0F, 0.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(50, 22)
						.addBox(-3.0F, -3.0F, -8.5F, 6.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(50, 16)
						.addBox(0.0F, -3.0F, -11.5F, 0.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.0F, -8.0F, 3.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition mushrooms_back = mushrooms.addOrReplaceChild("mushrooms_back",
				CubeListBuilder.create().texOffs(50, 28)
						.addBox(-3.0F, -3.0F, 0.0F, 6.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(50, 22)
						.addBox(0.0F, -3.0F, -3.0F, 0.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, -1.0F, 5.0F, -1.5708F, 0.0F, 2.3562F));

		PartDefinition headwear = partdefinition.addOrReplaceChild("headwear",
				CubeListBuilder.create().texOffs(32, 0)
						.addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.5F)).texOffs(32, 32)
						.addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.75F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body",
				CubeListBuilder.create().texOffs(16, 16)
						.addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(16, 48)
						.addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm",
				CubeListBuilder.create().texOffs(40, 16).mirror()
						.addBox(-1.0F, -2.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
						.texOffs(40, 48).mirror()
						.addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)).mirror(false),
				PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, -1.5708F, 0.2182F, 0.0F));

		PartDefinition bow = left_arm.addOrReplaceChild("bow",
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
				PartPose.offsetAndRotation(-1.0F, 9.0F, 7.0F, 2.3126F, 0.0F, 0.0F));

		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm",
				CubeListBuilder.create().texOffs(40, 16)
						.addBox(-1.0F, -2.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(40, 48)
						.addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)),
				PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, -1.5708F, -0.48F, 0.0F));

		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg",
				CubeListBuilder.create().texOffs(0, 16).mirror()
						.addBox(-1.0F, 0.0F, -1.1F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(2.0F, 12.0F, 0.1F));

		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 16)
				.addBox(-1.0F, 0.0F, -1.1F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-2.0F, 12.0F, 0.1F));

		return LayerDefinition.create(meshdefinition, 96, 96);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		mushrooms.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		headwear.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
	}
}