package net.tropicraft.core.common.dimension.feature;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.SaplingBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraftforge.common.util.Constants;
import net.tropicraft.core.common.block.CoconutBlock;
import net.tropicraft.core.common.block.TropicraftBlocks;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Random;

public abstract class PalmTreeFeature extends Feature<NoFeatureConfig> {

    public PalmTreeFeature(Codec<NoFeatureConfig> codec) {
        super(codec);
    }

    protected SaplingBlock getSapling() {
        return TropicraftBlocks.PALM_SAPLING.get();
    }
    
    protected final BlockState getLeaf() {
        return TropicraftBlocks.PALM_LEAVES.get().defaultBlockState();
    }
    
    protected final BlockState getLog() {
        return TropicraftBlocks.PALM_LOG.get().defaultBlockState();
    }

    protected void placeLeaf(final IWorldGenerationReader world, int x, int y, int z) {
    	this.placeLeaf(world, new BlockPos(x, y, z));
    }

	protected void placeLeaf(final IWorldGenerationReader world, BlockPos pos) {
		// From FoliagePlacer
		if (TreeFeature.validTreePos(world, pos)) {
			setBlock(world, pos, getLeaf());
		}
	}

    protected void placeLog(final IWorldGenerationReader world, int x, int y, int z) {
		this.placeLog(world, new BlockPos(x, y, z));
    }

	protected void placeLog(final IWorldGenerationReader world, BlockPos pos) {
		if (TreeFeature.isFree(world, pos)) {
			setBlock(world, pos, getLog());
		}
	}

    private static final Direction[] DIRECTIONS = ArrayUtils.removeElement(Direction.values(), Direction.UP);
    public static void spawnCoconuts(IWorldGenerationReader world, BlockPos pos, Random random, int chance, BlockState leaf) {
        final BlockState coconut = TropicraftBlocks.COCONUT.get().defaultBlockState();
        for (Direction d : DIRECTIONS) {
            BlockPos pos2 = pos.relative(d);
            if (random.nextInt(chance) == 0 && TreeFeature.isAirOrLeaves(world, pos2)) {
                world.setBlock(pos2, coconut.setValue(CoconutBlock.FACING, d.getOpposite()), Constants.BlockFlags.DEFAULT);
            }
        }
    }
}
