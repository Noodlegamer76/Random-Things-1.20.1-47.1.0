// Made with Blockbench 4.2.4
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports


public class Imposter<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "imposter"), "main");
	private final ModelPart left_leg;
	private final ModelPart right_leg;
	private final ModelPart body;
	private final ModelPart right_hand;
	private final ModelPart left_hand;

	public Imposter(ModelPart root) {
		this.left_leg = root.getChild("left_leg");
		this.right_leg = root.getChild("right_leg");
		this.body = root.getChild("body");
		this.right_hand = root.getChild("right_hand");
		this.left_hand = root.getChild("left_hand");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 32).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 19.0F, 0.0F));

		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(22, 29).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 19.0F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -15.0F, -4.0F, 12.0F, 15.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(26, 22).addBox(-5.0F, -13.0F, -5.0F, 10.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 22).addBox(-5.0F, -12.0F, 3.0F, 10.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 19.0F, 0.0F));

		PartDefinition right_hand = partdefinition.addOrReplaceChild("right_hand", CubeListBuilder.create(), PartPose.offset(-6.0F, 13.0F, -2.0F));

		PartDefinition left_hand = partdefinition.addOrReplaceChild("left_hand", CubeListBuilder.create(), PartPose.offset(6.0F, 13.0F, -2.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_hand.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_hand.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}