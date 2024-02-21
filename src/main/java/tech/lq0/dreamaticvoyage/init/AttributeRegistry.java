package tech.lq0.dreamaticvoyage.init;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import tech.lq0.dreamaticvoyage.Utils;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class AttributeRegistry {
    public static final DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(ForgeRegistries.ATTRIBUTES, Utils.MOD_ID);

    public static final RegistryObject<Attribute> CHAOS = ATTRIBUTES.register("chaos",
            () -> (new RangedAttribute("attribute.chaos", 0.0D, -100.0D, 100.0D)).setSyncable(true));

    @SubscribeEvent
    public static void createAttributes(EntityAttributeModificationEvent event){
        if (!event.has(EntityType.PLAYER, AttributeRegistry.CHAOS.get())) {
            event.add(EntityType.PLAYER, AttributeRegistry.CHAOS.get());
        }
    }
}
