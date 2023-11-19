package tech.lq0.providencraft.render;

import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import tech.lq0.providencraft.init.EntityRegistry;
import tech.lq0.providencraft.init.ItemRegistry;
import tech.lq0.providencraft.render.curios.LunaticBowRenderer;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientRenderHandler {
    @SubscribeEvent
    public static void onClientSetUpEvent(FMLClientSetupEvent event) {
        EntityRenderers.register(EntityRegistry.BLOOD_CRYSTAL_ENTITY.get(), BloodCrystalEntityRenderer::new);

        CuriosRendererRegistry.register(ItemRegistry.LUNATIC_BOW.get(), LunaticBowRenderer::new);
    }
}
