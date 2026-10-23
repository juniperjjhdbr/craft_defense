// Made with Blockbench 4.12.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelsnow_golem<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "snow_golem"), "main");
	private final ModelPart head;
	private final ModelPart left_hand;
	private final ModelPart left_hand_rotation;
	private final ModelPart right_hand;
	private final ModelPart right_hand_flip;
	private final ModelPart right_hand_rotation;
	private final ModelPart body;
	private final ModelPart body_bottom;

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

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(
				-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(-0.5F)), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition left_hand = partdefinition.addOrReplaceChild("left_hand", CubeListBuilder.create(),
				PartPose.offset(4.5F, 5.25F, 0.0F));

		PartDefinition left_hand_rotation = left_hand.addOrReplaceChild("left_hand_rotation",
				CubeListBuilder.create().texOffs(32, 0).addBox(-0.5F, -1.0F, -1.0F, 12.0F, 2.0F, 2.0F,
						new CubeDeformation(-0.5F)),
				PartPose.offsetAndRotation(-0.5F, 1.0F, 0.0F, 0.0F, 0.0F, 0.9948F));

		PartDefinition right_hand = partdefinition.addOrReplaceChild("right_hand", CubeListBuilder.create(),
				PartPose.offset(-14.5F, 5.25F, 0.0F));

		PartDefinition right_hand_flip = right_hand.addOrReplaceChild("right_hand_flip", CubeListBuilder.create(),
				PartPose.offsetAndRotation(5.0F, 1.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition right_hand_rotation = right_hand_flip.addOrReplaceChild("right_hand_rotation",
				CubeListBuilder.create().texOffs(32, 0).addBox(-0.5F, -1.0F, -1.0F, 12.0F, 2.0F, 2.0F,
						new CubeDeformation(-0.5F)),
				PartPose.offsetAndRotation(-5.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.9948F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 16)
				.addBox(-5.0F, -10.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(-0.5F)),
				PartPose.offset(0.0F, 13.0F, 0.0F));

		PartDefinition body_bottom = partdefinition.addOrReplaceChild("body_bottom", CubeListBuilder.create()
				.texOffs(0, 36).addBox(-6.0F, -12.0F, -6.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(-0.5F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_hand.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_hand.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body_bottom.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
	}
}