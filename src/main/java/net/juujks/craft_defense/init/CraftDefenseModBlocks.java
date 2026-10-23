/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.juujks.craft_defense.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

import net.juujks.craft_defense.block.*;
import net.juujks.craft_defense.CraftDefenseMod;

public class CraftDefenseModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(CraftDefenseMod.MODID);
	public static final DeferredBlock<Block> PATH_BLOCK_WAY;
	public static final DeferredBlock<Block> PATH_BLOCK_LEFT_CURVE;
	public static final DeferredBlock<Block> PATH_BLOCK_RIGHT_CURVE;
	public static final DeferredBlock<Block> START_TOWER;
	public static final DeferredBlock<Block> END_TOWER;
	public static final DeferredBlock<Block> RAID_MANAGER;
	public static final DeferredBlock<Block> AERIAL_BLOCK;
	public static final DeferredBlock<Block> UNIT_MACHINE;
	public static final DeferredBlock<Block> TRAIT_REROLLER;
	public static final DeferredBlock<Block> FIRST_WORLD_TROPHY;
	public static final DeferredBlock<Block> SECOND_WORLD_TROPHY;
	public static final DeferredBlock<Block> THIRD_WORLD_TROPHY;
	public static final DeferredBlock<Block> FOURTH_WORLD_TROPHY;
	public static final DeferredBlock<Block> FIFTH_WORLD_TROPHY;
	public static final DeferredBlock<Block> SIXTH_WORLD_TROPHY;
	public static final DeferredBlock<Block> UNIT_INCUBATOR;
	public static final DeferredBlock<Block> UNIT_RECYCLER;
	public static final DeferredBlock<Block> UNIT_EVOLVER;
	public static final DeferredBlock<Block> BLUE_PORTAL;
	public static final DeferredBlock<Block> ORANGE_PORTAL;
	static {
		PATH_BLOCK_WAY = REGISTRY.register("path_block_way", PathBlockWayBlock::new);
		PATH_BLOCK_LEFT_CURVE = REGISTRY.register("path_block_left_curve", PathBlockLeftCurveBlock::new);
		PATH_BLOCK_RIGHT_CURVE = REGISTRY.register("path_block_right_curve", PathBlockRightCurveBlock::new);
		START_TOWER = REGISTRY.register("start_tower", StartTowerBlock::new);
		END_TOWER = REGISTRY.register("end_tower", EndTowerBlock::new);
		RAID_MANAGER = REGISTRY.register("raid_manager", RaidManagerBlock::new);
		AERIAL_BLOCK = REGISTRY.register("aerial_block", VoidBlockBlock::new);
		UNIT_MACHINE = REGISTRY.register("unit_machine", UnitMachineBlock::new);
		TRAIT_REROLLER = REGISTRY.register("trait_reroller", TraitRerollerBlock::new);
		FIRST_WORLD_TROPHY = REGISTRY.register("first_world_trophy", FirstWorldTrophyBlock::new);
		SECOND_WORLD_TROPHY = REGISTRY.register("second_world_trophy", SecondWorldTrophyBlock::new);
		THIRD_WORLD_TROPHY = REGISTRY.register("third_world_trophy", ThirdWorldTrophyBlock::new);
		FOURTH_WORLD_TROPHY = REGISTRY.register("fourth_world_trophy", FourthWorldTrophyBlock::new);
		FIFTH_WORLD_TROPHY = REGISTRY.register("fifth_world_trophy", FifthWorldTrophyBlock::new);
		SIXTH_WORLD_TROPHY = REGISTRY.register("sixth_world_trophy", SixthWorldTrophyBlock::new);
		UNIT_INCUBATOR = REGISTRY.register("unit_incubator", UnitIncubatorBlock::new);
		UNIT_RECYCLER = REGISTRY.register("unit_recycler", UnitRecyclerBlock::new);
		UNIT_EVOLVER = REGISTRY.register("unit_evolver", UnitEvolverBlock::new);
		BLUE_PORTAL = REGISTRY.register("blue_portal", BluePortalBlock::new);
		ORANGE_PORTAL = REGISTRY.register("orange_portal", OrangePortalBlock::new);
	}
	// Start of user code block custom blocks
	// End of user code block custom blocks
}