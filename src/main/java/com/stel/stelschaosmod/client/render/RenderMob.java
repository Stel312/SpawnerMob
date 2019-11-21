package com.stel.stelschaosmod.client.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class RenderMob extends RenderLiving<EntityLiving> implements IRenderFactory<EntityMob>
{

    private float scale;
    private ModelBase model;
    private String texturesSprite;
    private ResourceLocation texture;

    public RenderMob(RenderManager mg, ModelBase model, float scale, String staticTexture)
    {
        super(mg, model, scale / 2);
        this.model = model;
        this.scale = scale;
        this.texturesSprite = staticTexture;
        this.texture = new ResourceLocation("spawnermob:textures/mob/" + staticTexture + ".png");
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityLiving entity) {
        return this.texture;
    }

    @Override
    public Render<? super EntityMob> createRenderFor(RenderManager manager) {
        return new RenderMob(manager, model, scale, texturesSprite);
    }
}
