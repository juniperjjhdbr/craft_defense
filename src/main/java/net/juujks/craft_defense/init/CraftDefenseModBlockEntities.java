package net.juujks.craft_defense.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.items.wrapper.SidedInvWrapper;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;

import net.juujks.craft_defense.block.entity.*;
import net.juujks.craft_defense.CraftDefenseMod;

@EventBusSubscriber
public class CraftDefenseModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, CraftDefenseMod.MODID);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<StartTowerBlockEntity>> START_TOWER = register("start_tower", CraftDefenseModBlocks.START_TOWER, StartTowerBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<EndTowerBlockEntity>> END_TOWER = register("end_tower", CraftDefenseModBlocks.END_TOWER, EndTowerBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<RaidManagerBlockEntity>> RAID_MANAGER = register("raid_manager", CraftDefenseModBlocks.RAID_MANAGER, RaidManagerBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<UnitMachineBlockEntity>> UNIT_MACHINE = register("unit_machine", CraftDefenseModBlocks.UNIT_MACHINE, UnitMachineBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TraitRerollerBlockEntity>> TRAIT_REROLLER = register("trait_reroller", CraftDefenseModBlocks.TRAIT_REROLLER, TraitRerollerBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<UnitIncubatorBlockEntity>> UNIT_INCUBATOR = register("unit_incubator", CraftDefenseModBlocks.UNIT_INCUBATOR, UnitIncubatorBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<UnitRecyclerBlockEntity>> UNIT_RECYCLER = register("unit_recycler", CraftDefenseModBlocks.UNIT_RECYCLER, UnitRecyclerBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<UnitEvolverBlockEntity>> UNIT_EVOLVER = register("unit_evolver", CraftDefenseModBlocks.UNIT_EVOLVER, UnitEvolverBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BluePortalTileEntity>> BLUE_PORTAL = register("blue_portal", CraftDefenseModBlocks.BLUE_PORTAL, BluePortalTileEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<OrangePortalTileEntity>> ORANGE_PORTAL = register("orange_portal", CraftDefenseModBlocks.ORANGE_PORTAL, OrangePortalTileEntity::new);

	// Start of user code block custom block entities
	// End of user code block custom block entities
	private static <T extends BlockEntity> DeferredHolder<BlockEntityType<?>, BlockEntityType<T>> register(String registryname, DeferredHolder<Block, Block> block, BlockEntityType.BlockEntitySupplier<T> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}

	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, START_TOWER.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, END_TOWER.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, RAID_MANAGER.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, UNIT_MACHINE.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, TRAIT_REROLLER.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, UNIT_INCUBATOR.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, UNIT_RECYCLER.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, UNIT_EVOLVER.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, BLUE_PORTAL.get(), SidedInvWrapper::new);
	}
}