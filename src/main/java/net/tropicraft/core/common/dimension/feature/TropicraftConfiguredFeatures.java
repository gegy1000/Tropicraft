package net.tropicraft.core.common.dimension.feature;

import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.fml.RegistryObject;
import net.tropicraft.Constants;
import net.tropicraft.core.common.block.TropicraftBlocks;
import net.tropicraft.core.common.data.WorldgenDataConsumer;
import net.tropicraft.core.common.dimension.feature.config.FruitTreeConfig;
import net.tropicraft.core.common.dimension.feature.config.HomeTreeBranchConfig;
import net.tropicraft.core.common.dimension.feature.config.RainforestVinesConfig;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public final class TropicraftConfiguredFeatures {
	public final ConfiguredFeature<?, ?> grapefruitTree;
	public final ConfiguredFeature<?, ?> orangeTree;
	public final ConfiguredFeature<?, ?> lemonTree;
	public final ConfiguredFeature<?, ?> limeTree;
	public final ConfiguredFeature<?, ?> normalPalmTree;
	public final ConfiguredFeature<?, ?> curvedPalmTree;
	public final ConfiguredFeature<?, ?> largePalmTree;
	public final ConfiguredFeature<?, ?> rainforestUpTree;
	public final ConfiguredFeature<?, ?> rainforestSmallTualung;
	public final ConfiguredFeature<?, ?> rainforestLargeTualung;
	public final ConfiguredFeature<?, ?> rainforestTallTree;
	public final ConfiguredFeature<?, ?> rainforestVines;
	public final ConfiguredFeature<?, ?> eih;

	public final ConfiguredFeature<?, ?> homeTreeBranchSouth;
	public final ConfiguredFeature<?, ?> homeTreeBranchSouthExact;
	public final ConfiguredFeature<?, ?> homeTreeBranchSouthEast;
	public final ConfiguredFeature<?, ?> homeTreeBranchSouthEastExact;
	public final ConfiguredFeature<?, ?> homeTreeBranchEast;
	public final ConfiguredFeature<?, ?> homeTreeBranchEastExact;
	public final ConfiguredFeature<?, ?> homeTreeBranchNorthEast;
	public final ConfiguredFeature<?, ?> homeTreeBranchNorthEastExact;
	public final ConfiguredFeature<?, ?> homeTreeBranchNorth;
	public final ConfiguredFeature<?, ?> homeTreeBranchNorthExact;
	public final ConfiguredFeature<?, ?> homeTreeBranchNorthWest;
	public final ConfiguredFeature<?, ?> homeTreeBranchNorthWestExact;
	public final ConfiguredFeature<?, ?> homeTreeBranchWest;
	public final ConfiguredFeature<?, ?> homeTreeBranchWestExact;
	public final ConfiguredFeature<?, ?> homeTreeBranchSouthWest;
	public final ConfiguredFeature<?, ?> homeTreeBranchSouthWestExact;

	public TropicraftConfiguredFeatures(WorldgenDataConsumer<ConfiguredFeature<?, ?>> worldgen) {
		Register features = new Register(worldgen);

		this.grapefruitTree = features.fruitTree("grapefruit_tree", TropicraftBlocks.GRAPEFRUIT_SAPLING, TropicraftBlocks.GRAPEFRUIT_LEAVES);
		this.orangeTree = features.fruitTree("orange_tree", TropicraftBlocks.ORANGE_SAPLING, TropicraftBlocks.ORANGE_LEAVES);
		this.lemonTree = features.fruitTree("lemon_tree", TropicraftBlocks.LEMON_SAPLING, TropicraftBlocks.LEMON_LEAVES);
		this.limeTree = features.fruitTree("lime_tree", TropicraftBlocks.LIME_SAPLING, TropicraftBlocks.LIME_LEAVES);

		this.normalPalmTree = features.sparseTree("normal_palm_tree", TropicraftFeatures.NORMAL_PALM_TREE, IFeatureConfig.NONE, 0.2F);
		this.curvedPalmTree = features.sparseTree("curved_palm_tree", TropicraftFeatures.CURVED_PALM_TREE, IFeatureConfig.NONE, 0.2F);
		this.largePalmTree = features.sparseTree("large_palm_tree", TropicraftFeatures.LARGE_PALM_TREE, IFeatureConfig.NONE, 0.2F);

		this.rainforestUpTree = features.sparseTree("rainforest_up_tree", TropicraftFeatures.UP_TREE, IFeatureConfig.NONE, 0.2F);
		this.rainforestSmallTualung = features.sparseTree("rainforest_small_tualung", TropicraftFeatures.SMALL_TUALUNG, IFeatureConfig.NONE, 0.3F);
		this.rainforestLargeTualung = features.sparseTree("rainforest_large_tualung", TropicraftFeatures.LARGE_TUALUNG, IFeatureConfig.NONE, 0.4F);
		this.rainforestTallTree = features.sparseTree("rainforest_tall_tree", TropicraftFeatures.TALL_TREE, IFeatureConfig.NONE, 0.5F);
		this.rainforestVines = features.register("rainforest_vines", TropicraftFeatures.VINES,
				f -> f.configured(new RainforestVinesConfig()).squared().count(50)
		);

		this.eih = features.noConfig("eih", TropicraftFeatures.EIH,
				f -> f.decorated(Features.Placements.HEIGHTMAP_SQUARE)
						.decorated(Placement.COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(0, 0.01F, 1)))
		);

		// 0 = south
		// 90 = east
		// 180 = north
		// 270 = west
		this.homeTreeBranchSouth = features.homeTreeBranch("home_tree/branch/south", -30, 30);
		this.homeTreeBranchSouthExact = features.homeTreeBranch("home_tree/branch/south_exact", 0, 0);
		this.homeTreeBranchSouthEast = features.homeTreeBranch("home_tree/branch/southeast", 30, 60);
		this.homeTreeBranchSouthEastExact = features.homeTreeBranch("home_tree/branch/southeast_exact", 45, 45);
		this.homeTreeBranchEast = features.homeTreeBranch("home_tree/branch/east", 60, 120);
		this.homeTreeBranchEastExact = features.homeTreeBranch("home_tree/branch/east_exact", 90, 90);
		this.homeTreeBranchNorthEast = features.homeTreeBranch("home_tree/branch/northeast", 120, 150);
		this.homeTreeBranchNorthEastExact = features.homeTreeBranch("home_tree/branch/northeast_exact", 135, 135);
		this.homeTreeBranchNorth = features.homeTreeBranch("home_tree/branch/north", 150, 210);
		this.homeTreeBranchNorthExact = features.homeTreeBranch("home_tree/branch/north_exact", 180, 180);
		this.homeTreeBranchNorthWest = features.homeTreeBranch("home_tree/branch/northwest", 210, 240);
		this.homeTreeBranchNorthWestExact = features.homeTreeBranch("home_tree/branch/northwest_exact", 225, 225);
		this.homeTreeBranchWest = features.homeTreeBranch("home_tree/branch/west", 240, 300);
		this.homeTreeBranchWestExact = features.homeTreeBranch("home_tree/branch/west_exact", 270, 270);
		this.homeTreeBranchSouthWest = features.homeTreeBranch("home_tree/branch/southwest", 300, 330);
		this.homeTreeBranchSouthWestExact = features.homeTreeBranch("home_tree/branch/southwest_exact", 315, 315);
	}

	static final class Register {
		private final WorldgenDataConsumer<ConfiguredFeature<?, ?>> worldgen;

		Register(WorldgenDataConsumer<ConfiguredFeature<?, ?>> worldgen) {
			this.worldgen = worldgen;
		}

		public <F extends Feature<?>> ConfiguredFeature<?, ?> register(String id, RegistryObject<F> feature, Function<F, ConfiguredFeature<?, ?>> configure) {
			return this.worldgen.register(new ResourceLocation(Constants.MODID, id), configure.apply(feature.get()));
		}

		public <F extends Feature<NoFeatureConfig>> ConfiguredFeature<?, ?> noConfig(String id, RegistryObject<F> feature, UnaryOperator<ConfiguredFeature<?, ?>> configure) {
			return this.register(id, feature, f -> configure.apply(f.configured(NoFeatureConfig.INSTANCE)));
		}

		public ConfiguredFeature<?, ?> fruitTree(String id, Supplier<? extends Block> sapling, Supplier<? extends Block> fruitLeaves) {
			return this.sparseTree(id, TropicraftFeatures.FRUIT_TREE, new FruitTreeConfig(sapling, fruitLeaves), 0.2F);
		}

		public <C extends IFeatureConfig, F extends Feature<C>> ConfiguredFeature<?, ?> sparseTree(String id, RegistryObject<F> feature, C config, float chance) {
			return this.register(id, feature, f -> {
				return f.configured(config).decorated(Features.Placements.HEIGHTMAP_SQUARE)
						.decorated(Placement.COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(0, chance, 1)));
			});
		}

		public <C extends IFeatureConfig, F extends Feature<C>> ConfiguredFeature<?, ?> homeTreeBranch(String id, float minAngle, float maxAngle) {
			return this.register(id, TropicraftFeatures.HOME_TREE_BRANCH,
					f -> f.configured(new HomeTreeBranchConfig(minAngle, maxAngle))
			);
		}
	}
}