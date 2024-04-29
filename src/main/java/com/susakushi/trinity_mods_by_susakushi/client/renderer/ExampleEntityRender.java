package com.susakushi.trinity_mods_by_susakushi.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.susakushi.trinity_mods_by_susakushi.TrinityModsbySusakushi;
import com.susakushi.trinity_mods_by_susakushi.client.model.ExampleEntityModel;
import com.susakushi.trinity_mods_by_susakushi.entity.custom.ExampleEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;


public class ExampleEntityRender extends MobRenderer<ExampleEntity, ExampleEntityModel<ExampleEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(TrinityModsbySusakushi.MOD_ID, "textures/entity/example_entity2.png");


    public ExampleEntityRender(EntityRendererProvider.Context pContext) {
        super(pContext, new ExampleEntityModel<>(pContext.bakeLayer(ExampleEntityModel.LAYER_LOCATION)),0.50f);
    }

    @Override
    public void render(ExampleEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {

            pMatrixStack.scale(5f, 5f, 5f);

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(ExampleEntity exampleEntity) {
        return TEXTURE;
    }
}
