//package com.nexusdino.lifeofnexus.client.entity.model;
//
//import com.mojang.blaze3d.vertex.PoseStack;
//import com.mojang.blaze3d.vertex.VertexConsumer;
//import com.nexusdino.lifeofnexus.common.entity.Oryx;
//
//import net.minecraft.client.model.EntityModel;
//import net.minecraft.client.model.geom.ModelLayerLocation;
//import net.minecraft.client.model.geom.ModelPart;
//import net.minecraft.client.model.geom.PartPose;
//import net.minecraft.client.model.geom.builders.CubeDeformation;
//import net.minecraft.client.model.geom.builders.CubeListBuilder;
//import net.minecraft.client.model.geom.builders.LayerDefinition;
//import net.minecraft.client.model.geom.builders.MeshDefinition;
//import net.minecraft.client.model.geom.builders.PartDefinition;
//import net.minecraft.resources.ResourceLocation;
//
////Made with Blockbench 4.1.3
////Exported for Minecraft version 1.17 with Mojang mappings
////Paste this class into your mod and generate all required imports
//
//public class OryxModel<T extends Oryx> extends EntityModel<T> {
//	// This layer location should be baked with EntityRendererProvider.Context in
//	// the entity renderer and passed into this model's constructor
//	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
//			new ResourceLocation("modid", "oryxmodel"), "main");
//	private final ModelPart head;
//	private final ModelPart nose;
//	private final ModelPart left_horn;
//	private final ModelPart right_horn;
//	private final ModelPart body;
//	private final ModelPart leg1;
//	private final ModelPart leg2;
//	private final ModelPart leg3;
//	private final ModelPart leg4;
//
//	public OryxModel(ModelPart root) {
//		this.head = root.getChild("head");
//		this.nose = root.getChild("nose");
//		this.left_horn = root.getChild("left_horn");
//		this.right_horn = root.getChild("right_horn");
//		this.body = root.getChild("body");
//		this.leg1 = root.getChild("leg1");
//		this.leg2 = root.getChild("leg2");
//		this.leg3 = root.getChild("leg3");
//		this.leg4 = root.getChild("leg4");
//	}
//
//	public static LayerDefinition createBodyLayer() {
//		MeshDefinition meshdefinition = new MeshDefinition();
//		PartDefinition partdefinition = meshdefinition.getRoot();
//
//		PartDefinition head = partdefinition.addOrReplaceChild("head",
//				CubeListBuilder.create().texOffs(23, 52)
//						.addBox(0.5F, -3.0F, -14.0F, 0.0F, 7.0F, 5.0F, CubeDeformation.NONE).texOffs(2, 61)
//						.addBox(-5.0F, -11.0F, -10.0F, 3.0F, 2.0F, 1.0F, CubeDeformation.NONE),
//				PartPose.offset(-0.5F, 14.0F, 0.0F));
//
//		head.addOrReplaceChild("mirror",
//				CubeListBuilder.create().texOffs(2, 61).mirror()
//						.addBox(2.5F, -21.0F, -10.0F, 3.0F, 2.0F, 1.0F, CubeDeformation.NONE).mirror(false),
//				PartPose.offset(0.5F, 10.0F, 0.0F));
//
//		partdefinition.addOrReplaceChild("nose",
//				CubeListBuilder.create().texOffs(34, 46).addBox(-2.0F, -4.0F, -8.0F, 5.0F, 7.0F, 10.0F,
//						CubeDeformation.NONE),
//				PartPose.offsetAndRotation(-0.5F, 6.0F, -8.0F, 0.9599F, 0.0F, 0.0F));
//
//		partdefinition.addOrReplaceChild("left_horn", CubeListBuilder.create().texOffs(12, 55).addBox(0.99F, -16.0F,
//				-10.0F, 2.0F, 7.0F, 2.0F, CubeDeformation.NONE), PartPose.offset(-0.5F, 14.0F, 0.0F));
//
//		partdefinition.addOrReplaceChild("right_horn", CubeListBuilder.create().texOffs(12, 55).addBox(-1.99F, -16.0F,
//				-10.0F, 2.0F, 7.0F, 2.0F, CubeDeformation.NONE), PartPose.offset(-0.5F, 14.0F, 0.0F));
//
//		partdefinition.addOrReplaceChild("body",
//				CubeListBuilder.create().texOffs(1, 1)
//						.addBox(-5.0F, -17.0F, -7.0F, 9.0F, 11.0F, 16.0F, CubeDeformation.NONE).texOffs(0, 28)
//						.addBox(-6.0F, -18.0F, -8.0F, 11.0F, 14.0F, 11.0F, CubeDeformation.NONE),
//				PartPose.offset(0.5F, 24.0F, 0.0F));
//
//		partdefinition.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(49, 29).addBox(-7.0F, 4.0F, 0.0F,
//				3.0F, 6.0F, 3.0F, CubeDeformation.NONE), PartPose.offset(3.5F, 14.0F, 4.0F));
//
//		partdefinition.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(36, 29).addBox(1.0F, 4.0F, 0.0F, 3.0F,
//				6.0F, 3.0F, CubeDeformation.NONE), PartPose.offset(-0.5F, 14.0F, 4.0F));
//
//		partdefinition.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(49, 2).addBox(-7.0F, 0.0F, 0.0F, 3.0F,
//				10.0F, 3.0F, CubeDeformation.NONE), PartPose.offset(3.5F, 14.0F, -6.0F));
//
//		partdefinition.addOrReplaceChild("leg4", CubeListBuilder.create().texOffs(35, 2).addBox(1.0F, 0.0F, 0.0F, 3.0F,
//				10.0F, 3.0F, CubeDeformation.NONE), PartPose.offset(-0.5F, 14.0F, -6.0F));
//
//		return LayerDefinition.create(meshdefinition, 64, 64);
//	}
//
//	@Override
//	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
//			float headPitch) {
//		
//	}
//
//	@Override
//	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay,
//			float red, float green, float blue, float alpha) {
//		head.render(poseStack, buffer, packedLight, packedOverlay);
//		nose.render(poseStack, buffer, packedLight, packedOverlay);
//		left_horn.render(poseStack, buffer, packedLight, packedOverlay);
//		right_horn.render(poseStack, buffer, packedLight, packedOverlay);
//		body.render(poseStack, buffer, packedLight, packedOverlay);
//		leg1.render(poseStack, buffer, packedLight, packedOverlay);
//		leg2.render(poseStack, buffer, packedLight, packedOverlay);
//		leg3.render(poseStack, buffer, packedLight, packedOverlay);
//		leg4.render(poseStack, buffer, packedLight, packedOverlay);
//	}
//}