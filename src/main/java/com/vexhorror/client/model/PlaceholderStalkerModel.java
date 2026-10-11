package com.vexhorror.client.model;

import com.vexhorror.entity.VexStalker;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

/** Modelo provisório geométrico para testar o renderer e a animação de caminhada. */
public class PlaceholderStalkerModel extends HierarchicalModel<VexStalker> {
    public static final ModelLayerLocation LAYER_LOCATION =
            new ModelLayerLocation(new ResourceLocation("vexhorror", "placeholder_stalker"), "main");

    private final ModelPart root;
    private final ModelPart head;
    private final ModelPart body;
    private final ModelPart leftArm;
    private final ModelPart rightArm;
    private final ModelPart leftLeg;
    private final ModelPart rightLeg;

    public PlaceholderStalkerModel(ModelPart root) {
        this.root = root;
        this.head = root.getChild("head");
        this.body = root.getChild("body");
        this.leftArm = root.getChild("left_arm");
        this.rightArm = root.getChild("right_arm");
        this.leftLeg = root.getChild("left_leg");
        this.rightLeg = root.getChild("right_leg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0)
                .addBox(-4F, -8F, -4F, 8F, 8F, 8F), PartPose.offset(0F, 0F, 0F));
        root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 16)
                .addBox(-4F, 0F, -2F, 8F, 12F, 4F), PartPose.offset(0F, 0F, 0F));
        root.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(40, 16)
                .addBox(-1F, -2F, -1F, 2F, 12F, 2F), PartPose.offset(5F, 2F, 0F));
        root.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(40, 16)
                .addBox(-1F, -2F, -1F, 2F, 12F, 2F), PartPose.offset(-5F, 2F, 0F));
        root.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 16)
                .addBox(-1.5F, 0F, -1.5F, 3F, 12F, 3F), PartPose.offset(2F, 12F, 0F));
        root.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 16)
                .addBox(-1.5F, 0F, -1.5F, 3F, 12F, 3F), PartPose.offset(-2F, 12F, 0F));
        return LayerDefinition.create(mesh, 64, 32);
    }

    @Override
    public ModelPart root() {
        return root;
    }

    @Override
    public void setupAnim(VexStalker entity, float limbSwing, float limbSwingAmount,
                          float ageInTicks, float netHeadYaw, float headPitch) {
        head.yRot = netHeadYaw * ((float)Math.PI / 180F);
        head.xRot = headPitch * ((float)Math.PI / 180F);
        leftLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.3F * limbSwingAmount;
        rightLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.3F * limbSwingAmount;
        leftArm.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.1F * limbSwingAmount;
        rightArm.xRot = Mth.cos(limbSwing * 0.6662F) * 1.1F * limbSwingAmount;
    }
}