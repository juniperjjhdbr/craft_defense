// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelaxolotl<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "axolotl"), "main");
	private final ModelPart head;
	private final ModelPart top_gills;
	private final ModelPart left_gills;
	private final ModelPart right_gills;
	private final ModelPart body;
	private final ModelPart leg4;
	private final ModelPart leg2;
	private final ModelPart leg3;
	private final ModelPart leg1;
	private final ModelPart tail;

	public Modelaxolotl(ModelPart root) {
		this.head = root.getChild("head");
		this.top_gills = root.getChild("top_gills");
		this.left_gills = root.getChild("left_gills");
		this.right_gills = root.getChild("right_gills");
		this.body = root.getChild("body");
		this.leg4 = root.getChild("leg4");
		this.leg2 = root.getChild("leg2");
		this.leg3 = root.getChild("leg3");
		this.leg1 = root.getChild("leg1");
		this.tail = root.getChild("tail");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 1).addBox(
				-4.0F, -3.0F, -5.0F, 8.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 18.0F, -5.0F));

		PartDefinition top_gills = partdefinition.addOrReplaceChild("top_gills", CubeListBuilder.create().texOffs(3, 37)
				.addBox(-4.0F, -3.0F, 0.0F, 8.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 15.0F, -6.0F));

		PartDefinition left_gills = partdefinition.addOrReplaceChild("left_gills", CubeListBuilder.create()
				.texOffs(0, 40).addBox(-3.0F, -5.0F, 0.0F, 3.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-4.0F, 18.0F, -6.0F));

		PartDefinition right_gills = partdefinition.addOrReplaceChild("right_gills", CubeListBuilder.create()
				.texOffs(11, 40).addBox(0.0F, -5.0F, 0.0F, 3.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offset(4.0F, 18.0F, -6.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body",
				CubeListBuilder.create().texOffs(0, 11)
						.addBox(-4.0F, -2.0F, -9.0F, 8.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(2, 17)
						.addBox(0.0F, -3.0F, -8.0F, 0.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 18.0F, 4.0F));

		PartDefinition leg4 = partdefinition.addOrReplaceChild("leg4",
				CubeListBuilder.create().texOffs(2, 13).addBox(-1.0F, 0.0F, 0.0F, 3.0F, 5.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.5F, 19.0F, -4.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition leg2 = partdefinition.addOrReplaceChild("leg2",
				CubeListBuilder.create().texOffs(2, 13).addBox(-1.0F, 0.0F, 0.0F, 3.0F, 5.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.5F, 19.0F, 3.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition leg3 = partdefinition.addOrReplaceChild("leg3",
				CubeListBuilder.create().texOffs(2, 13).addBox(-2.0F, 0.0F, 0.0F, 3.0F, 5.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.5F, 19.0F, -4.0F, 0.0F, 0.0F, 1.5708F));

		PartDefinition leg1 = partdefinition.addOrReplaceChild("leg1",
				CubeListBuilder.create().texOffs(2, 13).addBox(-2.0F, 0.0F, 0.0F, 3.0F, 5.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.5F, 19.0F, 3.0F, 0.0F, 0.0F, 1.5708F));

		PartDefinition tail = partdefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(2, 19).addBox(
				0.0F, -3.0F, 0.0F, 0.0F, 5.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 18.0F, 5.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		top_gills.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_gills.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_gills.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
	}
}