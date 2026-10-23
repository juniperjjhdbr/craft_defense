// Made with Blockbench 4.12.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelmagma_cube<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "magma_cube"), "main");
	private final ModelPart segment1;
	private final ModelPart segment2;
	private final ModelPart segment3;
	private final ModelPart segment4;
	private final ModelPart segment5;
	private final ModelPart segment6;
	private final ModelPart segment7;
	private final ModelPart segment8;
	private final ModelPart core;

	public Modelmagma_cube(ModelPart root) {
		this.segment1 = root.getChild("segment1");
		this.segment2 = root.getChild("segment2");
		this.segment3 = root.getChild("segment3");
		this.segment4 = root.getChild("segment4");
		this.segment5 = root.getChild("segment5");
		this.segment6 = root.getChild("segment6");
		this.segment7 = root.getChild("segment7");
		this.segment8 = root.getChild("segment8");
		this.core = root.getChild("core");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition segment1 = partdefinition.addOrReplaceChild("segment1", CubeListBuilder.create().texOffs(0, 0)
				.addBox(-4.0F, 16.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition segment2 = partdefinition.addOrReplaceChild("segment2", CubeListBuilder.create().texOffs(0, 9)
				.addBox(-4.0F, 17.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition segment3 = partdefinition.addOrReplaceChild("segment3", CubeListBuilder.create().texOffs(0, 18)
				.addBox(-4.0F, 18.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition segment4 = partdefinition.addOrReplaceChild("segment4", CubeListBuilder.create().texOffs(0, 27)
				.addBox(-4.0F, 19.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition segment5 = partdefinition.addOrReplaceChild("segment5", CubeListBuilder.create().texOffs(32, 0)
				.addBox(-4.0F, 20.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition segment6 = partdefinition.addOrReplaceChild("segment6", CubeListBuilder.create().texOffs(32, 9)
				.addBox(-4.0F, 21.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition segment7 = partdefinition.addOrReplaceChild("segment7", CubeListBuilder.create().texOffs(32, 18)
				.addBox(-4.0F, 22.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition segment8 = partdefinition.addOrReplaceChild("segment8", CubeListBuilder.create().texOffs(32, 27)
				.addBox(-4.0F, 23.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition core = partdefinition.addOrReplaceChild("core", CubeListBuilder.create().texOffs(24, 40).addBox(
				-2.0F, 18.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		segment1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		segment2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		segment3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		segment4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		segment5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		segment6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		segment7.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		segment8.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		core.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
	}
}