package com.stel.stelschaosmod.client.model.mob;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelSilverfish - Either Mojang or a mod author
 * Created using Tabula 7.0.1
 */
public class ModelRedfish extends ModelBase {
    public ModelRenderer field_78171_a3;
    public ModelRenderer field_78169_b3;
    public ModelRenderer field_78171_a4;
    public ModelRenderer field_78171_a5;
    public ModelRenderer field_78169_b1;
    public ModelRenderer field_78171_a6;
    public ModelRenderer field_78169_b2;
    public ModelRenderer field_78171_a1;
    public ModelRenderer field_78171_a2;
    public ModelRenderer field_78171_a7;

    public ModelRedfish() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.field_78171_a7 = new ModelRenderer(this, 13, 4);
        this.field_78171_a7.setRotationPoint(0.7766903042793274F, 23.0F, 11.5F);
        this.field_78171_a7.addBox(-0.5F, 0.0F, -1.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(field_78171_a7, 0.0F, -0.7469534277915955F, 0.0F);
        this.field_78171_a1 = new ModelRenderer(this, 0, 0);
        this.field_78171_a1.setRotationPoint(0.0F, 22.0F, -3.5F);
        this.field_78171_a1.addBox(-1.5F, 0.0F, -1.0F, 3, 2, 2, 0.0F);
        this.setRotateAngle(field_78171_a1, 0.0F, 0.471238911151886F, 0.0F);
        this.field_78169_b3 = new ModelRenderer(this, 20, 18);
        this.field_78169_b3.setRotationPoint(0.28523990511894226F, 19.0F, -1.5F);
        this.field_78169_b3.addBox(-3.0F, 0.0F, -1.5F, 6, 5, 2, 0.0F);
        this.setRotateAngle(field_78169_b3, 0.0F, 0.27992069721221924F, 0.0F);
        this.field_78171_a6 = new ModelRenderer(this, 11, 0);
        this.field_78171_a6.setRotationPoint(1.3328649997711182F, 23.0F, 9.5F);
        this.field_78171_a6.addBox(-1.0F, 0.0F, -1.0F, 2, 1, 2, 0.0F);
        this.setRotateAngle(field_78171_a6, 0.0F, -0.44428831338882446F, 0.0F);
        this.field_78171_a4 = new ModelRenderer(this, 0, 16);
        this.field_78171_a4.setRotationPoint(0.6205772757530212F, 21.0F, 4.0F);
        this.field_78171_a4.addBox(-1.5F, 0.0F, -1.5F, 3, 3, 3, 0.0F);
        this.setRotateAngle(field_78171_a4, 0.0F, 0.04916318878531456F, 0.0F);
        this.field_78171_a5 = new ModelRenderer(this, 0, 22);
        this.field_78171_a5.setRotationPoint(1.1951626539230347F, 22.0F, 7.0F);
        this.field_78171_a5.addBox(-1.0F, 0.0F, -1.5F, 2, 2, 3, 0.0F);
        this.setRotateAngle(field_78171_a5, 0.0F, -0.14558644592761996F, 0.0F);
        this.field_78169_b2 = new ModelRenderer(this, 20, 11);
        this.field_78169_b2.setRotationPoint(1.1951626539230347F, 20.0F, 7.0F);
        this.field_78169_b2.addBox(-3.0F, 0.0F, -1.5F, 6, 4, 3, 0.0F);
        this.setRotateAngle(field_78169_b2, 0.0F, -0.14558644592761996F, 0.0F);
        this.field_78171_a2 = new ModelRenderer(this, 0, 4);
        this.field_78171_a2.setRotationPoint(0.28523990511894226F, 21.0F, -1.5F);
        this.field_78171_a2.addBox(-2.0F, 0.0F, -1.0F, 4, 3, 2, 0.0F);
        this.setRotateAngle(field_78171_a2, 0.0F, 0.27992069721221924F, 0.0F);
        this.field_78171_a3 = new ModelRenderer(this, 0, 9);
        this.field_78171_a3.setRotationPoint(0.0F, 20.0F, 1.0F);
        this.field_78171_a3.addBox(-3.0F, 0.0F, -1.5F, 6, 4, 3, 0.0F);
        this.setRotateAngle(field_78171_a3, 0.0F, 0.09233397245407104F, 0.0F);
        this.field_78169_b1 = new ModelRenderer(this, 20, 0);
        this.field_78169_b1.setRotationPoint(0.0F, 16.0F, 1.0F);
        this.field_78169_b1.addBox(-5.0F, 0.0F, -1.5F, 10, 8, 3, 0.0F);
        this.setRotateAngle(field_78169_b1, 0.0F, 0.09233397245407104F, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.field_78171_a7.render(f5);
        this.field_78171_a1.render(f5);
        this.field_78169_b3.render(f5);
        this.field_78171_a6.render(f5);
        this.field_78171_a4.render(f5);
        this.field_78171_a5.render(f5);
        this.field_78169_b2.render(f5);
        this.field_78171_a2.render(f5);
        this.field_78171_a3.render(f5);
        this.field_78169_b1.render(f5);
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
