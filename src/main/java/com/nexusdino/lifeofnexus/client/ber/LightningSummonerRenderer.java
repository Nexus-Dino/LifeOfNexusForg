package com.nexusdino.lifeofnexus.client.ber;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import com.nexusdino.lifeofnexus.LifeOfNexus;
import com.nexusdino.lifeofnexus.client.util.LONModelLayers;
import com.nexusdino.lifeofnexus.common.blockentity.LightningSummonerBlockEntity;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class LightningSummonerRenderer implements BlockEntityRenderer<LightningSummonerBlockEntity> {
	public static final ResourceLocation TEXTURE = new ResourceLocation(LifeOfNexus.MOD_ID,
			"entity/lightning_summoner.png");
	@SuppressWarnings("deprecation")
	private static final Material MATERIAL = new Material(TextureAtlas.LOCATION_BLOCKS, TEXTURE);
	@SuppressWarnings("unused")
	private final BlockEntityRenderDispatcher dispatcher;
	private final ModelPart lightning_summoner;

	public LightningSummonerRenderer(BlockEntityRendererProvider.Context context) {
		this.dispatcher = context.getBlockEntityRenderDispatcher();
		this.lightning_summoner = context.bakeLayer(LONModelLayers.LIGHTNING_SUMMONER);
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("lightning_summoner", CubeListBuilder.create().texOffs(0, 0)
				.addBox(-8.0F, -16.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void render(LightningSummonerBlockEntity pBlockEntity, float pPartialTick, PoseStack stack,
			MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
		VertexConsumer consumer = MATERIAL.buffer(pBufferSource, RenderType::entitySolid);
		stack.pushPose();
		stack.translate(0.5, 1, 0.5);
		stack.mulPose(Vector3f.YP.rotationDegrees(180f));
		
		this.lightning_summoner.render(stack, consumer, pPackedLight, pPackedOverlay);
		stack.popPose();
	}
}
