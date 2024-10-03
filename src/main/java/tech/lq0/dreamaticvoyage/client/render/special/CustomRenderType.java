package tech.lq0.dreamaticvoyage.client.render.special;

import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.minecraft.Util;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Function;

public class CustomRenderType extends RenderType {

    public CustomRenderType(String nameIn, VertexFormat formatIn, int drawModeIn, int bufferSizeIn, boolean useDelegateIn, boolean needsSortingIn, Runnable setupTaskIn, Runnable clearTaskIn) {
        super(nameIn, formatIn, VertexFormat.Mode.QUADS, bufferSizeIn, useDelegateIn, needsSortingIn, setupTaskIn, clearTaskIn);
    }

    public static final RenderType BLOCK_OVERLAY = create("block_overlay",
            DefaultVertexFormat.POSITION_COLOR, VertexFormat.Mode.QUADS, 256, false, false,
            RenderType.CompositeState.builder()
                    .setShaderState(ShaderStateShard.POSITION_COLOR_SHADER)
                    .setLayeringState(VIEW_OFFSET_Z_LAYERING)
                    .setTransparencyState(TRANSLUCENT_TRANSPARENCY)
                    .setTextureState(NO_TEXTURE)
                    .setDepthTestState(LEQUAL_DEPTH_TEST)
                    .setCullState(CULL)
                    .setLightmapState(NO_LIGHTMAP)
                    .setWriteMaskState(COLOR_DEPTH_WRITE)
                    .createCompositeState(false));

    public static final RenderType LANDMARK = create("landmark",
            DefaultVertexFormat.POSITION_COLOR, VertexFormat.Mode.QUADS, 256, false, false,
            RenderType.CompositeState.builder()
                    .setShaderState(ShaderStateShard.POSITION_COLOR_SHADER)
                    .setLayeringState(VIEW_OFFSET_Z_LAYERING)
                    .setTransparencyState(TRANSLUCENT_TRANSPARENCY)
                    .setTextureState(NO_TEXTURE)
                    .setDepthTestState(RenderStateShard.NO_DEPTH_TEST)
                    .setCullState(CULL)
                    .setLightmapState(NO_LIGHTMAP)
                    .setWriteMaskState(COLOR_DEPTH_WRITE)
                    .createCompositeState(false));

    private static final Function<ResourceLocation, RenderType> MAGIC_BEAM = Util.memoize((location) -> {
        RenderStateShard.TextureStateShard renderstateshard$texturestateshard = new RenderStateShard.TextureStateShard(location, false, false);
        return RenderType.create("magic_beam",
                DefaultVertexFormat.POSITION_COLOR_TEX, VertexFormat.Mode.QUADS, 256, false, false,
                RenderType.CompositeState.builder().setTextureState(renderstateshard$texturestateshard)
                        .setLayeringState(VIEW_OFFSET_Z_LAYERING)
                        .setTransparencyState(TRANSLUCENT_TRANSPARENCY)
                        .setDepthTestState(NO_DEPTH_TEST)
                        .setCullState(NO_CULL)
                        .setLightmapState(NO_LIGHTMAP)
                        .setWriteMaskState(COLOR_WRITE)
                        .setShaderState(RENDERTYPE_ENERGY_SWIRL_SHADER)
                        .createCompositeState(false));
    });

    public static RenderType magicBeam(ResourceLocation p_110459_) {
        return MAGIC_BEAM.apply(p_110459_);
    }
}

