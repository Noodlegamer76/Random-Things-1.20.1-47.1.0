package com.Noodlegamer76.RandomThings.Items;

import com.Noodlegamer76.RandomThings.partcle.ModParticle;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Minecart;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class YoutuberPickaxe extends PickaxeItem {
    public YoutuberPickaxe(Tier p_42961_, int p_42962_, float p_42963_, Properties p_42964_) {
        super(p_42961_, p_42962_, p_42963_, p_42964_);
    }

    @Override
    public boolean mineBlock(ItemStack item, Level level, BlockState blockState, BlockPos blockPos, LivingEntity player) {

        if (!level.isClientSide()) {
            int width = 10 / 2;
            int height = 10 / 2;
            int length = 10 / 2;
            level.destroyBlock(blockPos, true, player);
            for (int dx = width / 2 - width; dx < width; dx++) {
                for (int dy = height / 2 - height; dy < height; dy++) {
                    for (int dz = length / 2 - length; dz < length; dz++) {
                        level.destroyBlock(new BlockPos(blockPos.east(dx).getX(), blockPos.above(dy).getY(), blockPos.north(dz).getZ()), true, player);
                    }
                }
            }
        }


        //if (!level.isClientSide) {
        //    BlockPos current = blockPos;
        //    for(int i = 0;i < 100;i++) {
        //        int offset = (int) ((Math.random() * (6 - 1)) + 1);
        //        switch (offset) {
        //            case 1: {current = current.above(1); break;}
        //            case 2: {current = current.below(1); break;}
        //            case 3: {current = current.east(1); break;}
        //            case 4: {current = current.west(1); break;}
        //            case 5: {current = current.north(1); break;}
        //            case 6: {current = current.south(1); break;}
        //            default: player.hurt(level.damageSources().cactus(), 1);
        //        }
        //        level.destroyBlock(current, true, player);
        //        level.explode(player, current.getX(), current.getY(), current.getZ(), 4, Level.ExplosionInteraction.TNT);
        //    }
        //}
        return true;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
      //  if (!pLevel.isClientSide) {
      //      ThrownTntEntity thrownTnt = new ThrownTntEntity(EntityInit.THROWN_TNT.get(), pPlayer, pLevel, 4.0f);
      //      thrownTnt.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 3.0F, 1.0F);
      //      pLevel.addFreshEntity(thrownTnt);
      //  }



        Zombie camera = new Zombie(EntityType.ZOMBIE, pLevel);
        camera.setPos(pPlayer.blockPosition().getCenter());
        pLevel.addFreshEntity(camera);
        
             if(pLevel.isClientSide) {
                 for(int i = 0; i < 1000; i++) {
                     pLevel.addParticle(ModParticle.CUBE.get(),pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), Math.random() - 0.5, Math.random() - 0.5, Math.random() - 0.5 );
                 }
             }
        return super.use(pLevel, pPlayer, pUsedHand);
    }


}
