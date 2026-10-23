// Made with Blockbench 4.12.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelravager<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "ravager"), "main");
	private final ModelPart head;
	private final ModelPart horns;
	private final ModelPart left_horn;
	private final ModelPart jaw;
	private final ModelPart body;
	private final ModelPart rotation;
	private final ModelPart leg1;
	private final ModelPart leg2;
	private final ModelPart leg3;
	private final ModelPart leg4;
	private final ModelPart neck;

	public Modelravager(ModelPart root) {
		this.head = root.getChild("head");
		this.horns = this.head.getChild("horns");
		this.left_horn = this.horns.getChild("left_horn");
		this.jaw = root.getChild("jaw");
		this.body = root.getChild("body");
		this.rotation = this.body.getChild("rotation");
		this.leg1 = root.getChild("leg1");
		this.leg2 = root.getChild("leg2");
		this.leg3 = root.getChild("leg3");
		this.leg4 = root.getChild("leg4");
		this.neck = root.getChild("neck");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-8.0F, -20.0F, -14.0F, 16.0F, 20.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-2.0F, -6.0F, -18.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 10.0F, -10.0F));

		PartDefinition horns = head.addOrReplaceChild("horns",
				CubeListBuilder.create().texOffs(74, 55).addBox(-5.0F, -14.0F, -1.0F, 2.0F, 14.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.0F, -13.0F, -9.0F, 1.0472F, 0.0F, 0.0F));

		PartDefinition left_horn = horns.addOrReplaceChild("left_horn",
				CubeListBuilder.create().texOffs(74, 55).mirror()
						.addBox(8.0F, -41.0F, -20.0F, 2.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(5.0F, 27.0F, 19.0F));

		PartDefinition jaw = partdefinition.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(0, 36)
				.addBox(-8.0F, 0.0F, -16.0F, 16.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 8.0F, -8.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(),
				PartPose.offset(0.0F, 1.0F, 3.5F));

		PartDefinition rotation = body.addOrReplaceChild("rotation",
				CubeListBuilder.create().texOffs(0, 55)
						.addBox(-7.0F, -10.0F, -7.0F, 14.0F, 16.0F, 20.0F, new CubeDeformation(0.0F)).texOffs(0, 91)
						.addBox(-6.0F, 6.0F, -7.0F, 12.0F, 13.0F, 18.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition leg1 = partdefinition.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(96, 0)
				.addBox(-4.0F, 0.0F, -4.0F, 8.0F, 37.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-8.0F, -13.0F, 21.0F));

		PartDefinition leg2 = partdefinition.addOrReplaceChild("leg2",
				CubeListBuilder.create().texOffs(96, 0).mirror()
						.addBox(-4.0F, 0.0F, -4.0F, 8.0F, 37.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(8.0F, -13.0F, 21.0F));

		PartDefinition leg3 = partdefinition.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(64, 0)
				.addBox(-4.0F, 0.0F, -4.0F, 8.0F, 37.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-8.0F, -13.0F, -3.5F));

		PartDefinition leg4 = partdefinition.addOrReplaceChild("leg4",
				CubeListBuilder.create().texOffs(64, 0).mirror()
						.addBox(-4.0F, 0.0F, -4.0F, 8.0F, 37.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(8.0F, -13.0F, -3.5F));

		PartDefinition neck = partdefinition.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(68, 73)
				.addBox(-5.0F, -1.0F, -18.0F, 10.0F, 10.0F, 18.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -6.0F, 8.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		jaw.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		neck.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
	}
}