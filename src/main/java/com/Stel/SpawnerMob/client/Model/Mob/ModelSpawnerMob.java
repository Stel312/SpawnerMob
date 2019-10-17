package com.Stel.SpawnerMob.client.Model.Mob;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ENEMY BLOX - m= abel a= abel t= abel abel=abel
 * Created using Tabula 7.0.1
 */
public class ModelSpawnerMob extends ModelBase {
    public ModelRenderer thebody;
    public ModelRenderer LEG1;
    public ModelRenderer leg2;
    public ModelRenderer leg3;
    public ModelRenderer leg4;
    public ModelRenderer arm1;
    public ModelRenderer hand1;
    public ModelRenderer arm2;
    public ModelRenderer hand2;
    public ModelRenderer arm3;
    public ModelRenderer underarm1;
    public ModelRenderer hand3;
    public ModelRenderer arm4;
    public ModelRenderer underarm2;
    public ModelRenderer hand4;

    public ModelSpawnerMob() {
        this.textureWidth = 16;
        this.textureHeight = 16;
        this.leg3 = new ModelRenderer(this, 0, 9);
        this.leg3.mirror = true;
        this.leg3.setRotationPoint(-5.9F, -2.9F, 6.0F);
        this.leg3.addBox(0.0F, 0.0F, 0.0F, 2, 5, 2, 0.0F);
        this.setRotateAngle(leg3, 0.8196066167365371F, 0.0F, 1.8668041679331349F);
        this.arm3 = new ModelRenderer(this, 0, 0);
        this.arm3.mirror = true;
        this.arm3.setRotationPoint(5.1F, 14.2F, 1.7F);
        this.arm3.addBox(0.3F, 1.4F, 2.4F, 2, 8, 2, 0.0F);
        this.setRotateAngle(arm3, -1.9123572614101867F, -1.3658946726107624F, -1.9577358219620393F);
        this.underarm2 = new ModelRenderer(this, 0, 0);
        this.underarm2.setRotationPoint(-2.6F, 0.9F, 2.1F);
        this.underarm2.addBox(0.0F, 0.0F, 0.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(underarm2, 0.091106186954104F, 0.0F, -1.1383037381507017F);
        this.underarm1 = new ModelRenderer(this, 0, 0);
        this.underarm1.setRotationPoint(1.0F, -1.7F, 5.9F);
        this.underarm1.addBox(0.0F, 0.0F, 0.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(underarm1, -1.0016444577195458F, 0.136659280431156F, 0.136659280431156F);
        this.arm4 = new ModelRenderer(this, 0, 0);
        this.arm4.mirror = true;
        this.arm4.setRotationPoint(-6.2F, 11.2F, 5.7F);
        this.arm4.addBox(0.0F, 1.7F, 2.4F, 2, 8, 2, 0.0F);
        this.setRotateAngle(arm4, -3.0049333731586367F, 0.045553093477052F, 0.6829473363053812F);
        this.leg2 = new ModelRenderer(this, 0, 0);
        this.leg2.mirror = true;
        this.leg2.setRotationPoint(6.1F, 2.0F, -6.2F);
        this.leg2.addBox(0.0F, 0.0F, -0.3F, 2, 5, 2, 0.0F);
        this.setRotateAngle(leg2, -0.9105382707654417F, -0.2509783464367846F, -1.7678439993450563F);
        this.hand4 = new ModelRenderer(this, 0, 0);
        this.hand4.setRotationPoint(-0.7F, -3.6F, 0.0F);
        this.hand4.addBox(0.0F, 0.0F, 0.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(hand4, 0.0F, 0.0F, -0.136659280431156F);
        this.thebody = new ModelRenderer(this, 0, 0);
        this.thebody.setRotationPoint(-0.3F, 13.5F, -0.2F);
        this.thebody.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 7.5F);
        this.hand1 = new ModelRenderer(this, 0, 0);
        this.hand1.setRotationPoint(0.3F, 7.5F, 0.4F);
        this.hand1.addBox(0.4F, 0.0F, 0.0F, 2, 5, 2, 0.0F);
        this.setRotateAngle(hand1, 0.0F, 0.0F, -0.7285004297824331F);
        this.hand3 = new ModelRenderer(this, 0, 0);
        this.hand3.setRotationPoint(0.0F, -3.7F, 0.6F);
        this.hand3.addBox(0.0F, 0.0F, 0.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(hand3, -0.136659280431156F, 0.0F, 0.0F);
        this.leg4 = new ModelRenderer(this, 0, 0);
        this.leg4.mirror = true;
        this.leg4.setRotationPoint(8.0F, -1.3F, 6.5F);
        this.leg4.addBox(0.0F, 0.0F, 0.0F, 2, 5, 2, 0.0F);
        this.setRotateAngle(leg4, 0.8196066167365371F, 0.0F, -1.8668041679331349F);
        this.arm2 = new ModelRenderer(this, 0, 0);
        this.arm2.setRotationPoint(1.5F, 8.8F, 0.1F);
        this.arm2.addBox(-0.5F, -0.9F, 2.5F, 2, 8, 2, 0.0F);
        this.setRotateAngle(arm2, -0.8196066167365371F, -1.4570008595648662F, 1.9577358219620393F);
        this.arm1 = new ModelRenderer(this, 0, 0);
        this.arm1.setRotationPoint(1.4F, 6.3F, -0.6F);
        this.arm1.addBox(0.5F, -0.9F, 0.4F, 2, 8, 2, 0.0F);
        this.setRotateAngle(arm1, -0.091106186954104F, 0.0F, -1.1838568316277536F);
        this.LEG1 = new ModelRenderer(this, 0, 0);
        this.LEG1.mirror = true;
        this.LEG1.setRotationPoint(-5.4F, -0.4F, -6.0F);
        this.LEG1.addBox(0.0F, 0.0F, -0.3F, 2, 5, 2, 0.0F);
        this.setRotateAngle(LEG1, -0.9105382707654417F, 0.22759093446006054F, 1.8212510744560826F);
        this.hand2 = new ModelRenderer(this, 0, 0);
        this.hand2.setRotationPoint(-0.5F, 7.3F, 2.5F);
        this.hand2.addBox(0.0F, 0.0F, 0.0F, 2, 5, 2, 0.0F);
        this.setRotateAngle(hand2, 0.7285004297824331F, 0.0F, 0.0F);
        this.thebody.addChild(this.leg3);
        this.leg3.addChild(this.arm3);
        this.arm4.addChild(this.underarm2);
        this.arm3.addChild(this.underarm1);
        this.leg4.addChild(this.arm4);
        this.thebody.addChild(this.leg2);
        this.underarm2.addChild(this.hand4);
        this.arm1.addChild(this.hand1);
        this.underarm1.addChild(this.hand3);
        this.thebody.addChild(this.leg4);
        this.leg2.addChild(this.arm2);
        this.LEG1.addChild(this.arm1);
        this.thebody.addChild(this.LEG1);
        this.arm2.addChild(this.hand2);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.thebody.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
