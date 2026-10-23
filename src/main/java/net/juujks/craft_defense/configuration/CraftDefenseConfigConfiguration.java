package net.juujks.craft_defense.configuration;

import net.neoforged.neoforge.common.ModConfigSpec;

public class CraftDefenseConfigConfiguration {
	public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
	public static final ModConfigSpec SPEC;
	public static final ModConfigSpec.ConfigValue<Double> DROPS_MULTIPLIER;
	public static final ModConfigSpec.ConfigValue<Boolean> X3_SPEED;
	public static final ModConfigSpec.ConfigValue<Boolean> BLOCK_BREAKING;
	public static final ModConfigSpec.ConfigValue<Boolean> BLOCK_PLACING;
	public static final ModConfigSpec.ConfigValue<Boolean> ITEM_DROPPING;
	public static final ModConfigSpec.ConfigValue<Double> LEVEL_CAP;
	public static final ModConfigSpec.ConfigValue<Double> XP_MULTIPLIER;
	public static final ModConfigSpec.ConfigValue<Boolean> EVOLVE_UNITS;
	public static final ModConfigSpec.ConfigValue<Boolean> XP_CANDY;
	public static final ModConfigSpec.ConfigValue<Boolean> UNIT_MACHINE;
	public static final ModConfigSpec.ConfigValue<Boolean> UNIT_EVOLVER;
	public static final ModConfigSpec.ConfigValue<Boolean> UNIT_INCUBATOR;
	static {
		BUILDER.push("events_in_raids");
		DROPS_MULTIPLIER = BUILDER.comment("Multiplier for raid drops").define("drops_multiplier", (double) 1);
		X3_SPEED = BUILDER.comment("Allows using 3x speed during raids").define("enable_3x_speed", false);
		BLOCK_BREAKING = BUILDER.comment("Allows block breaking in survival mode during raids").define("block_breaking", false);
		BLOCK_PLACING = BUILDER.comment("Allows block placing in survival mode during raids").define("block_placing", false);
		ITEM_DROPPING = BUILDER.comment("Allows item dropping in survival mode during raids").define("item_dropping", false);
		BUILDER.pop();
		BUILDER.push("units");
		LEVEL_CAP = BUILDER.comment("Caps the maximum level of units").define("unit_level_cap", (double) 50);
		XP_MULTIPLIER = BUILDER.comment("Multiplier for unit XP").define("xp_multiplier", (double) 1);
		EVOLVE_UNITS = BUILDER.comment("Allows using the evolution crystal on units").define("evolve_units", true);
		XP_CANDY = BUILDER.comment("Allows using xp candies").define("xp_candy", true);
		BUILDER.pop();
		BUILDER.push("misc");
		UNIT_MACHINE = BUILDER.comment("Allows using the unit machine").define("unit_machine", true);
		UNIT_EVOLVER = BUILDER.comment("Allows using the unit evolver").define("unit_evolver", true);
		UNIT_INCUBATOR = BUILDER.comment("Allows using the unit incubator").define("unit_incubator", true);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}