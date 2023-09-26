package com.Noodlegamer76.RandomThings.spellcrafting.spell.items;

import com.Noodlegamer76.RandomThings.Events.RegisterParticleProviders;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

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
                return RegisterParticleProviders.bewlr;
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
