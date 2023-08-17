package com.Noodlegamer76.RandomThings.init;

import com.Noodlegamer76.RandomThings.BlockEntities.CactusChestBlockEntity;
import com.Noodlegamer76.RandomThings.RandomThingsMod;
import com.Noodlegamer76.RandomThings.client.renderer.CactusChestRenderer;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntityInit {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, RandomThingsMod.MODID);

    public static final RegistryObject<BlockEntityType<CactusChestBlockEntity>> CACTUS_CHEST = BLOCK_ENTITIES.register("cactus_chest",
            () -> BlockEntityType.Builder.of(CactusChestBlockEntity::new, BlockInit.CACTUS_CHEST.get()).build(null));
}
