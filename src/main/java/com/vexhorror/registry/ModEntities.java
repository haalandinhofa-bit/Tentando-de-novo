package com.vexhorror.registry;

import com.vexhorror.VexHorror;
import com.vexhorror.entity.VexStalker;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, VexHorror.MOD_ID);

    public static final RegistryObject<EntityType<VexStalker>> VEX_STALKER =
            ENTITY_TYPES.register("vex_stalker", () -> EntityType.Builder
                    .of(VexStalker::new, MobCategory.MONSTER)
                    .sized(0.9F, 2.8F)
                    .clientTrackingRange(10)
                    .updateInterval(2)
                    .build("vexhorror:vex_stalker"));

    private ModEntities() {}

    @Mod.EventBusSubscriber(modid = VexHorror.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static final class Attributes {
        @SubscribeEvent
        public static void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
            event.put(VEX_STALKER.get(), VexStalker.createAttributes().build());
        }
    }
}
