package com.vexhorror.registry;

import com.vexhorror.VexHorror;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, VexHorror.MOD_ID);

    public static final RegistryObject<Item> VEX_STALKER_SPAWN_EGG =
            ITEMS.register("vex_stalker_spawn_egg", () ->
                    new ForgeSpawnEggItem(ModEntities.VEX_STALKER, 0x15151B, 0xA50018, new Item.Properties()));

    private ModItems() {}
}
