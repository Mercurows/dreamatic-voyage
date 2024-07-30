package tech.lq0.dreamaticvoyage.client;

import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterClientTooltipComponentFactoriesEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import tech.lq0.dreamaticvoyage.client.particle.TentacleParticle;
import tech.lq0.dreamaticvoyage.client.particle.UmuLightParticle;
import tech.lq0.dreamaticvoyage.client.render.*;
import tech.lq0.dreamaticvoyage.client.render.curios.*;
import tech.lq0.dreamaticvoyage.client.render.tooltip.ClientImageTooltip;
import tech.lq0.dreamaticvoyage.client.render.tooltip.ImageTooltip;
import tech.lq0.dreamaticvoyage.init.BlockEntityRegistry;
import tech.lq0.dreamaticvoyage.init.EntityRegistry;
import tech.lq0.dreamaticvoyage.init.ItemRegistry;
import tech.lq0.dreamaticvoyage.init.ParticleRegistry;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientRenderHandler {
    @SubscribeEvent
    public static void onClientSetUpEvent(FMLClientSetupEvent event) {
        EntityRenderers.register(EntityRegistry.BLOOD_CRYSTAL_ENTITY.get(), BloodCrystalEntityRenderer::new);
        EntityRenderers.register(EntityRegistry.DAIFUKU_SYRUP_ENTITY.get(), DaifukuSyrupEntityRenderer::new);
        EntityRenderers.register(EntityRegistry.CURSED_CAT_DOLL_ENTITY.get(), CursedCatDollEntityRenderer::new);
        EntityRenderers.register(EntityRegistry.AHOGE_BOOMERANG_ENTITY.get(), AhogeBoomerangEntityRenderer::new);
        EntityRenderers.register(EntityRegistry.SEAT_ENTITY.get(), SeatEntityRenderer::new);
        EntityRenderers.register(EntityRegistry.WHITE_AHOGE_ENTITY.get(), WhiteAhogeEntityRenderer::new);
        EntityRenderers.register(EntityRegistry.SHU_RINO_KEN_ENTITY.get(), ShuRinoKenEntityRenderer::new);
        EntityRenderers.register(EntityRegistry.TAIL_HOOK_ENTITY.get(), TailHookEntityRenderer::new);
        EntityRenderers.register(EntityRegistry.FLUFF_BALL_ENTITY.get(), FluffBallEntityRenderer::new);
        EntityRenderers.register(EntityRegistry.PLUNGER_ENTITY.get(), PlungerEntityRenderer::new);
        EntityRenderers.register(EntityRegistry.HIRENADE_GG_ENTITY.get(), HirenadeGGEntityRenderer::new);
        EntityRenderers.register(EntityRegistry.WATER_CARD_ENTITY.get(), WaterCardEntityRenderer::new);
        EntityRenderers.register(EntityRegistry.TETRIS_I_BLOCK_ENTITY.get(), TetrisIBlockRenderer::new);
        EntityRenderers.register(EntityRegistry.LEVIY_BEAM_ENTITY.get(), LeviyBeamEntityRenderer::new);
        EntityRenderers.register(EntityRegistry.KURUMI_BOOMERANG_ENTITY.get(), KurumiBoomerangEntityRenderer::new);

        CuriosRendererRegistry.register(ItemRegistry.LUNATIC_BOW.get(), LunaticBowRenderer::new);
        CuriosRendererRegistry.register(ItemRegistry.RED_NOSE.get(), RedNoseRenderer::new);
        CuriosRendererRegistry.register(ItemRegistry.CHIRAM_HAT.get(), ChiramHatRenderer::new);
        CuriosRendererRegistry.register(ItemRegistry.YEGGY_PEARL.get(), YeggyPearlRenderer::new);
        CuriosRendererRegistry.register(ItemRegistry.DARK_ELF_GLASSES.get(), DarkElfGlassesRenderer::new);
    }

    @SubscribeEvent
    public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(BlockEntityRegistry.POINTS_STORE_BLOCK_ENTITY.get(), PointsStoreBlockEntityRenderer::new);
        event.registerBlockEntityRenderer(BlockEntityRegistry.FUKAMIZU_CRUSHER_BLOCK_ENTITY.get(), FukamizuCrusherBlockEntityRenderer::new);
    }

    @SubscribeEvent
    public static void registerParticles(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(ParticleRegistry.TENTACLE.get(), TentacleParticle.Provider::new);
        event.registerSpriteSet(ParticleRegistry.UMU_LIGHT.get(), UmuLightParticle.Provider::new);
    }

    @SubscribeEvent
    public static void registerTooltip(RegisterClientTooltipComponentFactoriesEvent event) {
        event.register(ImageTooltip.class, ClientImageTooltip::new);
    }
}
