// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modeldolphin<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "dolphin"), "main");
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart tail;
	private final ModelPart right_fin;
	private final ModelPart left_fin;
	private final ModelPart back_fin;
	private final ModelPart tail_fin;

	public Modeldolphin(ModelPart root) {
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.tail = root.getChild("tail");
		this.right_fin = root.getChild("right_fin");
		this.left_fin = root.getChild("left_fin");
		this.back_fin = root.getChild("back_fin");
		this.tail_fin = root.getChild("tail_fin");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(
				-4.0F, -3.0F, -3.0F, 8.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 20.0F, -6.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body",
				CubeListBuilder.create().texOffs(0, 13)
						.addBox(-1.0F, -2.0F, -10.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(22, 0)
						.addBox(-4.0F, -7.0F, 0.0F, 8.0F, 7.0F, 13.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, -3.0F));

		PartDefinition tail = partdefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 19)
				.addBox(-2.0F, -2.5F, -1.0F, 4.0F, 5.0F, 11.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 21.5F, 11.0F));

		PartDefinition right_fin = partdefinition.addOrReplaceChild("right_fin", CubeListBuilder.create()
				.texOffs(48, 20).addBox(-0.5F, -4.0F, 0.0F, 1.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-4.5F, 24.0F, -2.0F));

		PartDefinition left_fin = partdefinition.addOrReplaceChild("left_fin", CubeListBuilder.create().texOffs(48, 20)
				.addBox(-0.5F, -4.0F, 0.0F, 1.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offset(4.5F, 24.0F, -2.0F));

		PartDefinition back_fin = partdefinition.addOrReplaceChild("back_fin", CubeListBuilder.create().texOffs(51, 0)
				.addBox(-0.5F, 0.0F, 8.0F, 1.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 13.0F, -5.0F));

		PartDefinition tail_fin = partdefinition.addOrReplaceChild("tail_fin", CubeListBuilder.create().texOffs(19, 20)
				.addBox(-5.0F, -0.5F, -1.0F, 10.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 21.5F, 20.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_fin.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_fin.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		back_fin.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tail_fin.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
	}
}