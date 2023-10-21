package com.noodlegamer76.randomthings.Items;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.level.Level;

public class CactusShield extends ShieldItem {

    public CactusShield(Properties p_43089_) {
        super(p_43089_);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        InteractionResultHolder<ItemStack> ar = super.use(level, player, hand);
        if (!level.isClientSide) {
            player.hurt(level.damageSources().cactus(), 1);
        }

        return ar;
    }

   // @Override
  /*  public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {

            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                return new CactusShieldRenderer(, Minecraft.getInstance().getEntityModels());
            }
        });
    }*/

}
