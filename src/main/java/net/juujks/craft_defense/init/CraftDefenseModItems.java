package net.juujks.craft_defense.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.juujks.craft_defense.item.*;
import net.juujks.craft_defense.block.display.OrangePortalDisplayItem;
import net.juujks.craft_defense.block.display.BluePortalDisplayItem;
import net.juujks.craft_defense.CraftDefenseMod;

public class CraftDefenseModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(CraftDefenseMod.MODID);
	public static final DeferredItem<Item> PATH_BLOCK_WAY;
	public static final DeferredItem<Item> PATH_BLOCK_LEFT_CURVE;
	public static final DeferredItem<Item> PATH_BLOCK_RIGHT_CURVE;
	public static final DeferredItem<Item> STEVE_UNIT;
	public static final DeferredItem<Item> START_TOWER;
	public static final DeferredItem<Item> ALEX_UNIT;
	public static final DeferredItem<Item> END_TOWER;
	public static final DeferredItem<Item> TOWER_GEM;
	public static final DeferredItem<Item> ZOMBIE_UNIT_ITEM;
	public static final DeferredItem<Item> SKELETON_UNIT_ITEM;
	public static final DeferredItem<Item> CREEPER_UNIT_ITEM;
	public static final DeferredItem<Item> RAID_MANAGER;
	public static final DeferredItem<Item> AERIAL_BLOCK;
	public static final DeferredItem<Item> UNIT_MACHINE;
	public static final DeferredItem<Item> SPIDER_UNIT_ITEM;
	public static final DeferredItem<Item> WITCH_UNIT_ITEM;
	public static final DeferredItem<Item> SLIME_UNIT_ITEM;
	public static final DeferredItem<Item> VILLAGER_UNIT_ITEM;
	public static final DeferredItem<Item> EPIC_UPGRADE;
	public static final DeferredItem<Item> TRAIT_CUBE;
	public static final DeferredItem<Item> TRAIT_REROLLER;
	public static final DeferredItem<Item> CAVE_SPIDER_UNIT_ITEM;
	public static final DeferredItem<Item> STRAY_UNIT_ITEM;
	public static final DeferredItem<Item> ZOMBIFIED_PIGLIN_ITEM;
	public static final DeferredItem<Item> PIGLIN_UNIT_ITEM;
	public static final DeferredItem<Item> PUFFERFISH_UNIT_ITEM;
	public static final DeferredItem<Item> EVOLUTION_CRYSTAL;
	public static final DeferredItem<Item> LEGENDARY_UPGRADE;
	public static final DeferredItem<Item> IRON_GOLEM_UNIT_ITEM;
	public static final DeferredItem<Item> COMMON_XP_CANDY;
	public static final DeferredItem<Item> RARE_XP_CANDY;
	public static final DeferredItem<Item> EPIC_XP_CANDY;
	public static final DeferredItem<Item> SNOW_GOLEM_UNIT_ITEM;
	public static final DeferredItem<Item> HUSK_UNIT_ITEM;
	public static final DeferredItem<Item> MAGMA_CUBE_UNIT_ITEM;
	public static final DeferredItem<Item> POLAR_BEAR_UNIT_ITEM;
	public static final DeferredItem<Item> COMMON_DUST;
	public static final DeferredItem<Item> RARE_DUST;
	public static final DeferredItem<Item> EPIC_DUST;
	public static final DeferredItem<Item> LEGENDARY_XP_CANDY;
	public static final DeferredItem<Item> LEGENDARY_DUST;
	public static final DeferredItem<Item> CHARGED_CREEPER_UNIT_ITEM;
	public static final DeferredItem<Item> RAVAGER_UNIT_ITEM;
	public static final DeferredItem<Item> ENDERMAN_UNIT_ITEM;
	public static final DeferredItem<Item> BREEZE_UNIT_ITEM;
	public static final DeferredItem<Item> WOLF_UNIT_ITEM;
	public static final DeferredItem<Item> PILLAGER_UNIT_ITEM;
	public static final DeferredItem<Item> FIRST_WORLD_TROPHY;
	public static final DeferredItem<Item> SECOND_WORLD_TROPHY;
	public static final DeferredItem<Item> THIRD_WORLD_TROPHY;
	public static final DeferredItem<Item> FOURTH_WORLD_TROPHY;
	public static final DeferredItem<Item> FIFTH_WORLD_TROPHY;
	public static final DeferredItem<Item> SIXTH_WORLD_TROPHY;
	public static final DeferredItem<Item> UNIT_INCUBATOR;
	public static final DeferredItem<Item> UNIT_RECYCLER;
	public static final DeferredItem<Item> BLAZE_UNIT_ITEM;
	public static final DeferredItem<Item> MYTHIC_UPGRADE;
	public static final DeferredItem<Item> MYTHIC_DUST;
	public static final DeferredItem<Item> RARE_UPGRADE;
	public static final DeferredItem<Item> UNIT_EVOLVER;
	public static final DeferredItem<Item> DUPLICATION_TOKEN;
	public static final DeferredItem<Item> BOGGED_UNIT_ITEM;
	public static final DeferredItem<Item> STAT_DICE;
	public static final DeferredItem<Item> BLUE_PORTAL;
	public static final DeferredItem<Item> ORANGE_PORTAL;
	public static final DeferredItem<Item> DROWNED_UNIT_ITEM;
	public static final DeferredItem<Item> FROSTBITE_UNIT_ITEM;
	static {
		PATH_BLOCK_WAY = block(CraftDefenseModBlocks.PATH_BLOCK_WAY);
		PATH_BLOCK_LEFT_CURVE = block(CraftDefenseModBlocks.PATH_BLOCK_LEFT_CURVE);
		PATH_BLOCK_RIGHT_CURVE = block(CraftDefenseModBlocks.PATH_BLOCK_RIGHT_CURVE);
		STEVE_UNIT = REGISTRY.register("steve_unit", SteveUnitItem::new);
		START_TOWER = block(CraftDefenseModBlocks.START_TOWER);
		ALEX_UNIT = REGISTRY.register("alex_unit", AlexUnitItem::new);
		END_TOWER = block(CraftDefenseModBlocks.END_TOWER);
		TOWER_GEM = REGISTRY.register("tower_gem", TowerGemItem::new);
		ZOMBIE_UNIT_ITEM = REGISTRY.register("zombie_unit_item", ZombieUnitItemItem::new);
		SKELETON_UNIT_ITEM = REGISTRY.register("skeleton_unit_item", SkeletonUnitItemItem::new);
		CREEPER_UNIT_ITEM = REGISTRY.register("creeper_unit_item", CreeperUnitItemItem::new);
		RAID_MANAGER = block(CraftDefenseModBlocks.RAID_MANAGER);
		AERIAL_BLOCK = block(CraftDefenseModBlocks.AERIAL_BLOCK);
		UNIT_MACHINE = block(CraftDefenseModBlocks.UNIT_MACHINE);
		SPIDER_UNIT_ITEM = REGISTRY.register("spider_unit_item", SpiderUnitItemItem::new);
		WITCH_UNIT_ITEM = REGISTRY.register("witch_unit_item", WitchUnitItemItem::new);
		SLIME_UNIT_ITEM = REGISTRY.register("slime_unit_item", SlimeUnitItemItem::new);
		VILLAGER_UNIT_ITEM = REGISTRY.register("villager_unit_item", VillagerUnitItemItem::new);
		EPIC_UPGRADE = REGISTRY.register("epic_upgrade", EpicUpgradeItem::new);
		TRAIT_CUBE = REGISTRY.register("trait_cube", TraitCubeItem::new);
		TRAIT_REROLLER = block(CraftDefenseModBlocks.TRAIT_REROLLER);
		CAVE_SPIDER_UNIT_ITEM = REGISTRY.register("cave_spider_unit_item", CaveSpiderUnitItemItem::new);
		STRAY_UNIT_ITEM = REGISTRY.register("stray_unit_item", StrayUnitItemItem::new);
		ZOMBIFIED_PIGLIN_ITEM = REGISTRY.register("zombified_piglin_item", ZombifiedPiglinItemItem::new);
		PIGLIN_UNIT_ITEM = REGISTRY.register("piglin_unit_item", PiglinUnitItemItem::new);
		PUFFERFISH_UNIT_ITEM = REGISTRY.register("pufferfish_unit_item", PufferfishUnitItemItem::new);
		EVOLUTION_CRYSTAL = REGISTRY.register("evolution_crystal", EvolutionCrystalItem::new);
		LEGENDARY_UPGRADE = REGISTRY.register("legendary_upgrade", LegendaryUpgradeItem::new);
		IRON_GOLEM_UNIT_ITEM = REGISTRY.register("iron_golem_unit_item", IronGolemUnitItemItem::new);
		COMMON_XP_CANDY = REGISTRY.register("common_xp_candy", CommonXpCandyItem::new);
		RARE_XP_CANDY = REGISTRY.register("rare_xp_candy", RareXpCandyItem::new);
		EPIC_XP_CANDY = REGISTRY.register("epic_xp_candy", EpicXpCandyItem::new);
		SNOW_GOLEM_UNIT_ITEM = REGISTRY.register("snow_golem_unit_item", SnowGolemUnitItemItem::new);
		HUSK_UNIT_ITEM = REGISTRY.register("husk_unit_item", HuskUnitItemItem::new);
		MAGMA_CUBE_UNIT_ITEM = REGISTRY.register("magma_cube_unit_item", MagmaCubeUnitItemItem::new);
		POLAR_BEAR_UNIT_ITEM = REGISTRY.register("polar_bear_unit_item", PolarBearUnitItemItem::new);
		COMMON_DUST = REGISTRY.register("common_dust", CommonDustItem::new);
		RARE_DUST = REGISTRY.register("rare_dust", RareDustItem::new);
		EPIC_DUST = REGISTRY.register("epic_dust", EpicDustItem::new);
		LEGENDARY_XP_CANDY = REGISTRY.register("legendary_xp_candy", LegendaryXpCandyItem::new);
		LEGENDARY_DUST = REGISTRY.register("legendary_dust", LegendaryDustItem::new);
		CHARGED_CREEPER_UNIT_ITEM = REGISTRY.register("charged_creeper_unit_item", ChargedCreeperUnitItemItem::new);
		RAVAGER_UNIT_ITEM = REGISTRY.register("ravager_unit_item", RavagerUnitItemItem::new);
		ENDERMAN_UNIT_ITEM = REGISTRY.register("enderman_unit_item", EndermanUnitItemItem::new);
		BREEZE_UNIT_ITEM = REGISTRY.register("breeze_unit_item", BreezeUnitItemItem::new);
		WOLF_UNIT_ITEM = REGISTRY.register("wolf_unit_item", WolfUnitItemItem::new);
		PILLAGER_UNIT_ITEM = REGISTRY.register("pillager_unit_item", PillagerUnitItemItem::new);
		FIRST_WORLD_TROPHY = block(CraftDefenseModBlocks.FIRST_WORLD_TROPHY);
		SECOND_WORLD_TROPHY = block(CraftDefenseModBlocks.SECOND_WORLD_TROPHY);
		THIRD_WORLD_TROPHY = block(CraftDefenseModBlocks.THIRD_WORLD_TROPHY);
		FOURTH_WORLD_TROPHY = block(CraftDefenseModBlocks.FOURTH_WORLD_TROPHY);
		FIFTH_WORLD_TROPHY = block(CraftDefenseModBlocks.FIFTH_WORLD_TROPHY);
		SIXTH_WORLD_TROPHY = block(CraftDefenseModBlocks.SIXTH_WORLD_TROPHY);
		UNIT_INCUBATOR = block(CraftDefenseModBlocks.UNIT_INCUBATOR);
		UNIT_RECYCLER = block(CraftDefenseModBlocks.UNIT_RECYCLER);
		BLAZE_UNIT_ITEM = REGISTRY.register("blaze_unit_item", BlazeUnitItemItem::new);
		MYTHIC_UPGRADE = REGISTRY.register("mythic_upgrade", MythicUpgradeItem::new);
		MYTHIC_DUST = REGISTRY.register("mythic_dust", MythicDustItem::new);
		RARE_UPGRADE = REGISTRY.register("rare_upgrade", RareUpgradeItem::new);
		UNIT_EVOLVER = block(CraftDefenseModBlocks.UNIT_EVOLVER);
		DUPLICATION_TOKEN = REGISTRY.register("duplication_token", DuplicationTokenItem::new);
		BOGGED_UNIT_ITEM = REGISTRY.register("bogged_unit_item", BoggedUnitItemItem::new);
		STAT_DICE = REGISTRY.register("stat_dice", StatDiceItem::new);
		BLUE_PORTAL = REGISTRY.register(CraftDefenseModBlocks.BLUE_PORTAL.getId().getPath(), () -> new BluePortalDisplayItem(CraftDefenseModBlocks.BLUE_PORTAL.get(), new Item.Properties()));
		ORANGE_PORTAL = REGISTRY.register(CraftDefenseModBlocks.ORANGE_PORTAL.getId().getPath(), () -> new OrangePortalDisplayItem(CraftDefenseModBlocks.ORANGE_PORTAL.get(), new Item.Properties()));
		DROWNED_UNIT_ITEM = REGISTRY.register("drowned_unit_item", DrownedUnitItemItem::new);
		FROSTBITE_UNIT_ITEM = REGISTRY.register("frostbite_unit_item", FrostbiteUnitItemItem::new);
	}

	// Start of user code block custom items
	// End of user code block custom items
	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return block(block, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block, Item.Properties properties) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), properties));
	}
}