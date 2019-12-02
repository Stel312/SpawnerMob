package com.stel.stelschaosmod.model.mob;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.entity.Entity;

/**
 * ModelSpawnerMob - Undefined
 * Created using Tabula 7.0.1
 */
public class ModelSpawnerMob extends EntityModel {
    public RendererModel shape1;
    public RendererModel shape2;
    public RendererModel shape3;
    public RendererModel shape4;
    public RendererModel shape5;
    public RendererModel shape6;
    public RendererModel shape9;
    public RendererModel shape7;
    public RendererModel shape8;

    public ModelSpawnerMob() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.shape9 = new RendererModel(this, 0, 0);
        this.shape9.setRotationPoint(0.0F, 6.5F, 0.0F);
        this.shape9.addBox(-0.5F, 0.0F, -0.5F, 1, 9, 1, 0.0F);
        this.setRotateAngle(shape9, -1.9198621771937625F, 0.0F, 0.0F);
        this.shape1 = new RendererModel(this, 0, 0);
        this.shape1.setRotationPoint(0.0F, 15.7F, 0.0F);
        this.shape1.addBox(-8.0F, -8.0F, -8.0F, 16, 16, 16, -2.0F);
        this.shape3 = new RendererModel(this, 0, 0);
        this.shape3.setRotationPoint(5.5F, 5.0F, -5.5F);
        this.shape3.addBox(-0.5F, 0.0F, -0.5F, 1, 7, 1, 0.0F);
        this.setRotateAngle(shape3, 2.356194490192345F, 2.356194490192345F, 0.0F);
        this.shape4 = new RendererModel(this, 0, 0);
        this.shape4.setRotationPoint(-5.5F, 5.0F, -5.5F);
        this.shape4.addBox(-0.5F, 0.0F, -0.5F, 1, 7, 1, 0.0F);
        this.setRotateAngle(shape4, 2.356194490192345F, -2.356194490192345F, 0.0F);
        this.shape5 = new RendererModel(this, 0, 0);
        this.shape5.setRotationPoint(-5.5F, 5.0F, 5.5F);
        this.shape5.addBox(-0.5F, 0.0F, -0.5F, 1, 7, 1, 0.0F);
        this.setRotateAngle(shape5, -2.356194490192345F, 2.356194490192345F, 0.0F);
        this.shape8 = new RendererModel(this, 0, 0);
        this.shape8.setRotationPoint(0.0F, 6.5F, 0.0F);
        this.shape8.addBox(-0.5F, 0.0F, -0.5F, 1, 9, 1, 0.0F);
        this.setRotateAngle(shape8, 1.9198621771937625F, 0.0F, 0.0F);
        this.shape6 = new RendererModel(this, 0, 0);
        this.shape6.setRotationPoint(0.0F, 6.5F, 0.0F);
        this.shape6.addBox(-0.5F, 0.0F, -0.5F, 1, 9, 1, 0.0F);
        this.setRotateAngle(shape6, 1.9198621771937625F, 0.0F, 0.0F);
        this.shape2 = new RendererModel(this, 0, 0);
        this.shape2.setRotationPoint(5.5F, 5.0F, 5.5F);
        this.shape2.addBox(-0.5F, 0.0F, -0.5F, 1, 7, 1, 0.0F);
        this.setRotateAngle(shape2, -2.356194490192345F, -2.356194490192345F, 0.0F);
        this.shape7 = new RendererModel(this, 0, 0);
        this.shape7.setRotationPoint(0.0F, 6.5F, 0.0F);
        this.shape7.addBox(-0.5F, 0.0F, -0.5F, 1, 9, 1, 0.0F);
        this.setRotateAngle(shape7, -1.9198621771937625F, 0.0F, 0.0F);
        this.shape3.addChild(this.shape9);
        this.shape1.addChild(this.shape3);
        this.shape1.addChild(this.shape4);
        this.shape1.addChild(this.shape5);
        this.shape5.addChild(this.shape8);
        this.shape2.addChild(this.shape6);
        this.shape1.addChild(this.shape2);
        this.shape4.addChild(this.shape7);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.shape1.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(RendererModel RendererModel, float x, float y, float z) {
        RendererModel.rotateAngleX = x;
        RendererModel.rotateAngleY = y;
        RendererModel.rotateAngleZ = z;
    }
}
