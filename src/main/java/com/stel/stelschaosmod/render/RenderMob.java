package com.stel.stelschaosmod.render;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class RenderMob<T extends  LivingEntity> extends LivingRenderer<T, EntityModel<T>> implements IRenderFactory<Entity>
{

    private float scale;
    private EntityModel model;
    private String texturesSprite;
    private ResourceLocation texture;

    public RenderMob(EntityRendererManager mg, EntityModel model, float scale, String staticTexture)
    {
        super(mg, (EntityModel<T>) model, scale);
        this.model = model;
        this.scale = scale;
        this.texturesSprite = staticTexture;
        this.texture = new ResourceLocation("spawnermob:textures/mob/" + staticTexture + ".png");
    }

    @Override
    public EntityRenderer<? super Entity> createRenderFor(EntityRendererManager manager) {
        return new RenderMob(manager, model, scale, texturesSprite);
    }


    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(T entity) {
        return texture;
    }
}
