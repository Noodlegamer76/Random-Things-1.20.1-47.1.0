package com.Noodlegamer76.RandomThings.spellcrafting.spell.items;

import com.Noodlegamer76.RandomThings.Events.ClientSetupEvent;
import com.Noodlegamer76.RandomThings.RandomThingsMod;
import com.Noodlegamer76.RandomThings.client.renderer.BEWLR.BEWLR;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Consumer;

public class TntSpellItem extends SpellItem {
    public static int ticks = 0;
    public static float rotation = 0.1F;
    public TntSpellItem(Properties properties) {
        super(properties);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {

            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                return ClientSetupEvent.bewlr;
            }
        });
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        tick();
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
    }

    public void tick() {
        ticks++;
        if(rotation > 360f) {
            rotation = 0.2f;
        }
        if(rotation <= 360f) {
            rotation += 0.2f;
        }
    }
}
