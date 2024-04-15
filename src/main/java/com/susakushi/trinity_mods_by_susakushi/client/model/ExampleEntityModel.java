package com.susakushi.trinity_mods_by_susakushi.client.model;// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.susakushi.trinity_mods_by_susakushi.TrinityModsbySusakushi;
import com.susakushi.trinity_mods_by_susakushi.entity.custom.ExampleEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class ExampleEntityModel<T extends ExampleEntity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(TrinityModsbySusakushi.MOD_ID, "example_entity"), "main");
	private final ModelPart controlerGolem;

	public ExampleEntityModel(ModelPart root) {
		this.controlerGolem = root.getChild("controlerGolem");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition controlerGolem = partdefinition.addOrReplaceChild("controlerGolem", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = controlerGolem.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(-0.3F, -6.75F, 1.5F));

		PartDefinition torso = body.addOrReplaceChild("torso", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		torso.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(25, 55).addBox(-3.0F, -2.025F, -2.45F, 6.0F, 4.5F, 3.55F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, -3.0F, 0.125F, 0.3491F, 0.0F, 0.0F));

		torso.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(24, 19).addBox(-2.25F, -2.15F, -1.0F, 3.25F, 3.25F, 2.25F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.15F, -6.25F, -3.5F));

		head.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 58).addBox(-1.75F, -1.75F, -1.25F, 3.0F, 2.9F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		head.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(47, 55).addBox(-0.75F, -1.0F, -1.0F, 2.0F, 2.25F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 1.0F, 2.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition Jaw = head.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(60, 58).addBox(0.75F, -0.3F, 0.25F, 1.0F, 1.3F, 1.0F, new CubeDeformation(0.01F))
		.texOffs(56, 58).addBox(-1.75F, -0.3F, 0.25F, 1.0F, 1.3F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-0.25F, 1.35F, 0.0F, -1.3439F, 0.0F, 0.0F));

		Jaw.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(56, 61).addBox(-3.75F, -1.05F, -0.75F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.01F))
		.texOffs(60, 61).addBox(-1.25F, -1.05F, -0.75F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(2.0F, -0.75F, 0.5F, 0.7854F, 0.0F, 0.0F));

		Jaw.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(45, 60).addBox(-1.75F, -0.55F, -0.5F, 3.5F, 1.55F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.4419F, -0.2146F, 0.3927F, 0.0F, 0.0F));

		PartDefinition rightArm = body.addOrReplaceChild("rightArm", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.7F, -2.8169F, 0.4167F, -0.6471F, 0.1059F, 0.139F));

		rightArm.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 36).addBox(-1.75F, -1.9F, -2.5F, 3.5F, 3.4F, 3.5F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.25F, 6.0F, 0.0F, -0.3229F, 0.0F, 0.0F));

		rightArm.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 44).addBox(-1.25F, -1.5F, -0.75F, 2.5F, 3.0F, 2.5F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.25F, 3.0422F, -0.7081F, 0.0698F, 0.0F, 0.0F));

		rightArm.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 51).addBox(-1.5F, -1.5F, -1.25F, 3.0F, 3.5F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.25F, 0.0669F, -1.1667F, 0.3752F, 0.0F, 0.0F));

		PartDefinition leftLeg = body.addOrReplaceChild("leftLeg", CubeListBuilder.create(), PartPose.offset(3.175F, 5.25F, 0.0F));

		leftLeg.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(34, 32).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		leftLeg.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(36, 20).addBox(-0.75F, -1.25F, -1.0F, 1.5F, 2.5F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.6509F, -3.8574F, 0.0099F, -2.0115F, -1.5272F, 1.2217F));

		 leftLeg.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(35, 26).addBox(-1.0F, -1.375F, -0.75F, 2.0F, 2.5F, 2.5F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.375F, 0.0F, 0.0F, -1.5708F, -0.3927F));

		PartDefinition rightLeg = body.addOrReplaceChild("rightLeg", CubeListBuilder.create(), PartPose.offset(-3.2F, 5.25F, 0.0F));

		rightLeg.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(14, 32).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		rightLeg.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(15, 26).addBox(-1.0F, -1.25F, -1.25F, 2.0F, 2.5F, 2.5F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5188F, -2.2954F, 0.1736F, -3.1416F, 1.5184F, -2.7489F));

		rightLeg.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(16, 20).addBox(-0.75F, -1.125F, -1.0F, 1.5F, 2.25F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.6478F, -3.9253F, 0.135F, 2.2946F, 1.517F, 3.0374F));

		PartDefinition LeftArm = body.addOrReplaceChild("LeftArm", CubeListBuilder.create(), PartPose.offsetAndRotation(4.3F, -1.8169F, 0.4167F, -0.7304F, 0.0F, -0.3052F));

		LeftArm.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(50, 34).addBox(-1.75F, -1.7F, -1.75F, 3.5F, 3.4F, 3.5F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.5724F, -0.6478F, -0.3229F, 0.0F, 0.0F));

		LeftArm.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(54, 42).addBox(-1.25F, -1.5F, -1.25F, 2.5F, 3.0F, 2.5F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0073F, -0.2093F, 0.0698F, 0.0F, 0.0F));

		LeftArm.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(52, 48).addBox(-1.5F, -1.75F, -1.5F, 3.0F, 3.5F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.7921F, -0.8425F, 0.3752F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		controlerGolem.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}