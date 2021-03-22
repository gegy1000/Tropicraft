package net.tropicraft.core.common.dimension.feature.jigsaw;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.gen.feature.template.StructureProcessor;
import net.minecraftforge.common.util.Constants.BlockFlags;

public abstract class CheatyStructureProcessor extends StructureProcessor {
    protected boolean isAirOrWater(IWorldReader worldReaderIn, BlockPos pos) {
        return worldReaderIn.isEmptyBlock(pos) || worldReaderIn.getBlockState(pos).getBlock() == Blocks.WATER;
    }

    protected boolean setBlockState(IWorldReader world, BlockPos pos, BlockState state) {
        if (world instanceof IWorld) {
            return ((IWorld) world).setBlock(pos, state, BlockFlags.NO_RERENDER | BlockFlags.UPDATE_NEIGHBORS);
        }
        return false;
    }
}
