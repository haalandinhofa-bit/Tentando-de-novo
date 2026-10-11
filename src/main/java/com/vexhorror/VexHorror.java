package com.vexhorror;

import com.vexhorror.registry.ModEntities;
import com.vexhorror.registry.ModItems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(VexHorror.MOD_ID)
public class VexHorror {
    public static final String MOD_ID = "vexhorror";

    public VexHorror() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModEntities.ENTITY_TYPES.register(bus);
        ModItems.ITEMS.register(bus);
    }
}
