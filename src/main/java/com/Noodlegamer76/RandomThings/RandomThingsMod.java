package com.Noodlegamer76.RandomThings;

import com.Noodlegamer76.RandomThings.Events.CreativeTab;
import com.Noodlegamer76.RandomThings.enchantment.ModEnchantments;
import com.Noodlegamer76.RandomThings.init.*;
import com.Noodlegamer76.RandomThings.menus.WandScreen;
import com.Noodlegamer76.RandomThings.partcle.ModParticle;
import com.Noodlegamer76.RandomThings.partcle.custom.ConfettiParticles;
import com.Noodlegamer76.RandomThings.partcle.custom.CubePartcles;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.synth.PerlinNoise;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;

import java.awt.*;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(RandomThingsMod.MODID)
public class RandomThingsMod
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "random_things";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    public RandomThingsMod()
    {

        //explosion event test
        //MinecraftForge.EVENT_BUS.register(new ExplosionEvent());

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        EntityInit.ENTITIES.register(modEventBus);
        BlockEntityInit.BLOCK_ENTITIES.register(modEventBus);
        ItemInit.ITEMS.register(modEventBus);
        BlockInit.BLOCKS.register(modEventBus);
        MenuTypeInit.MENU_TYPES.register(modEventBus);
        CreativeTabInit.CREATIVE_TABS.register(modEventBus);

        FeaturesInit.FEATURES.register(modEventBus);
        ModEnchantments.ENCHANTMENTS.register(modEventBus);
        ModParticle.PARTICLE_TYPES.register(modEventBus);

        //ModConfiguredFeatures.register(modEventBus);

        modEventBus.register(new CreativeTab());






        // Register the Deferred Register to the mod event bus so blocks get registered
        //BLOCKS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so items get registered
        //ITEMS.register(modEventBus);

        // Register ourselves for server and other game Events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        //modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");

        LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));
    }

    /*private void addCreative(CreativeModeTabEvent.BuildContents event)
    {
        if (event.getTab() == CreativeModeTabs.BUILDING_BLOCKS)
            event.accept(EXAMPLE_BLOCK_ITEM);
    }*/

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

            event.enqueueWork(
                    () -> MenuScreens.register(MenuTypeInit.WAND_MENU.get(), WandScreen::new));

            MeshDefinition meshdefinition = new MeshDefinition();
            PartDefinition partdefinition = meshdefinition.getRoot();

            PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, 0.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));


            // Some client setup code

            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
        @SubscribeEvent
        void RegisterParticleProviders(RegisterParticleProvidersEvent event) {
            Minecraft.getInstance().particleEngine.register(ModParticle.CONFETTI.get(),
                    ConfettiParticles.Provider::new);
            Minecraft.getInstance().particleEngine.register(ModParticle.CUBE.get(),
                    CubePartcles.Provider::new);
        }

        @SubscribeEvent
        public static void assignBlockColors(RegisterColorHandlersEvent.Block event) {
            event.register((state, level, pos, tintIndex) -> pos != null && level != null ?
                    Color.getHSBColor((float) (pos.getX() + pos.getY() + pos.getZ()) / 360, 1.0F, 1.0F).getRGB() : 254,
                    BlockInit.CRYSTALLIZED_STONE.get(),
                    BlockInit.CRYSTALLIZED_DIRT.get(),
                    BlockInit.CRYSTALLIZED_GRASS_BLOCK.get()
            );
        }

        @SubscribeEvent
        public static void assignItemColors(RegisterColorHandlersEvent.Item event) {
           event.register((item,tintIndex) -> tintIndex != -1 ? Color.getHSBColor(0, 1.0F, 1.0F).getRGB() : Color.RED.getRGB(),
                   ItemInit.CRYSTALLIZED_STONE.get(),
                   ItemInit.CRYSTALLIZED_DIRT.get(),
                   ItemInit.CRYSTALLIZED_GRASS_BLOCK.get()
           );

        }
    }
}
