/*package com.example.examplemod.Blocks;

import com.example.examplemod.init.BlockEntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Block.Block;
import net.minecraft.world.level.Block.EntityBlock;
import net.minecraft.world.level.Block.entity.BlockEntity;
import net.minecraft.world.level.Block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class TempBlock extends Block implements EntityBlock {
    public TempBlock(Properties properties) {
        super(properties);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return BlockEntityInit.CACTUS_CHEST.get().create(pos, state);
    }

     @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
       if(level.getBlockEntity(pos) instanceof CactusChestBlockEntity cactusChest) {
            if(player instanceof ServerPlayer serverPlayer) {
                MenuConstructor menuConstructor = CactusChestMenu.getServerMenu(cactusChest, pos);
                SimpleMenuProvider provider = new SimpleMenuProvider(menuConstructor, CactusChestBlockEntity.title);
                NetworkHooks.openScreen(serverPlayer, provider, pos);
            }


        return InteractionResult.sidedSuccess(!level.isClientSide());
    } }

}
*/