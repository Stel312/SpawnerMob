package com.stel.stelschaosmod.model.mob;

import net.minecraft.client.renderer.entity.model.IHasHead;
import net.minecraft.client.renderer.entity.model.IHeadToggle;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * gnome - WYND
 * Created using Tabula 7.1.0
 */
public class ModelGnome <T extends Entity> extends SegmentedModel<T> implements IHasHead, IHeadToggle {
    public ModelRenderer body;
    public ModelRenderer head;
    public ModelRenderer right_leg;
    public ModelRenderer left_leg;
    public ModelRenderer right_arm;
    public ModelRenderer left_arm;
    public ModelRenderer right_foot;
    public ModelRenderer left_foot;
    public ModelRenderer front_beard;
    public ModelRenderer hat_1;
    public ModelRenderer front_beard_tip;
    public ModelRenderer hat_2;
    public ModelRenderer hat_3;
    public ModelRenderer hat_4;

    public ModelGnome() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.left_leg = new ModelRenderer(this, 10, 30);
        this.left_leg.setRotationPoint(1.5F, 3.0F, 0.5F);
        this.left_leg.addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F);
        this.right_leg = new ModelRenderer(this, 0, 30);
        this.right_leg.setRotationPoint(-0.5F, 3.0F, 0.5F);
        this.right_leg.addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F);
        this.right_arm = new ModelRenderer(this, 0, 20);
        this.right_arm.setRotationPoint(-1.5F, -1.0F, 0.5F);
        this.right_arm.addBox(-1.0F, -1.0F, -1.0F, 1, 4, 2, 0.0F);
        this.front_beard_tip = new ModelRenderer(this, 0, 15);
        this.front_beard_tip.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.front_beard_tip.addBox(-0.5F, 4.0F, -3.0F, 1, 1, 1, 0.0F);
        this.front_beard = new ModelRenderer(this, 0, 10);
        this.front_beard.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.front_beard.addBox(-1.5F, 2.0F, -3.0F, 3, 2, 1, 0.0F);
        this.left_foot = new ModelRenderer(this, 10, 40);
        this.left_foot.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.left_foot.addBox(-1.0F, 2.0F, -2.0F, 2, 1, 1, 0.0F);
        this.body = new ModelRenderer(this, 18, 0);
        this.body.setRotationPoint(0.0F, 14.5F, 0.0F);
        this.body.addBox(-1.5F, -3.0F, -1.5F, 4, 6, 4, 0.0F);
        this.right_foot = new ModelRenderer(this, 0, 40);
        this.right_foot.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.right_foot.addBox(-1.0F, 2.0F, -2.0F, 2, 1, 1, 0.0F);
        this.left_arm = new ModelRenderer(this, 7, 20);
        this.left_arm.setRotationPoint(2.5F, -1.0F, 0.5F);
        this.left_arm.addBox(0.0F, -1.0F, -1.0F, 1, 4, 2, 0.0F);
        this.hat_1 = new ModelRenderer(this, 20, 20);
        this.hat_1.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.hat_1.addBox(-2.0F, 0.0F, -2.0F, 4, 1, 4, 0.0F);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.5F, 9.5F, 0.5F);
        this.head.addBox(-2.0F, -1.0F, -2.0F, 4, 3, 4, 0.0F);
        this.hat_2 = new ModelRenderer(this, 20, 26);
        this.hat_2.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.hat_2.addBox(-1.5F, 0.0F, -1.5F, 3, 1, 3, 0.0F);
        this.hat_3 = new ModelRenderer(this, 20, 32);
        this.hat_3.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.hat_3.addBox(-1.0F, 0.0F, -1.0F, 2, 1, 2, 0.0F);
        this.hat_4 = new ModelRenderer(this, 20, 37);
        this.hat_4.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.hat_4.addBox(-0.5F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
        this.body.addChild(this.left_leg);
        this.body.addChild(this.right_leg);
        this.body.addChild(this.right_arm);
        this.front_beard.addChild(this.front_beard_tip);
        this.head.addChild(this.front_beard);
        this.left_leg.addChild(this.left_foot);
        this.right_leg.addChild(this.right_foot);
        this.body.addChild(this.left_arm);
        this.head.addChild(this.hat_1);
        this.hat_1.addChild(this.hat_2);
        this.hat_2.addChild(this.hat_3);
        this.hat_3.addChild(this.hat_4);
    }

    @Override
    public void setRotationAngles(T t, float v, float v1, float v2, float v3, float v4) {

    }

    @Override
    public Iterable<ModelRenderer> getParts() {
        return null;
    }



    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    @Override
    public ModelRenderer getModelHead() {
        return head;
    }

    @Override
    public void func_217146_a(boolean b) {

    }
}
