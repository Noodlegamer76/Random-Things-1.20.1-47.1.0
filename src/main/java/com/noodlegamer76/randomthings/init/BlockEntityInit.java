package com.noodlegamer76.randomthings.init;

import com.noodlegamer76.randomthings.blockentities.CactusChestBlockEntity;
import com.noodlegamer76.randomthings.blockentities.TntChestBlockEntity;
import com.noodlegamer76.randomthings.RandomThingsMod;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntityInit {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, RandomThingsMod.MODID);

    public static final RegistryObject<BlockEntityType<CactusChestBlockEntity>> CACTUS_CHEST = BLOCK_ENTITIES.register("cactus_chest",
            () -> BlockEntityType.Builder.of(CactusChestBlockEntity::new, BlockInit.CACTUS_CHEST.get()).build(null));
    public static final RegistryObject<BlockEntityType<TntChestBlockEntity>> TNT_CHEST = BLOCK_ENTITIES.register("tnt_chest",
            () -> BlockEntityType.Builder.of(TntChestBlockEntity::new, BlockInit.TNT_CHEST.get()).build(null));
}
