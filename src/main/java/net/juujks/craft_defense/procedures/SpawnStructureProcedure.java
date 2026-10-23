package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.juujks.craft_defense.network.CraftDefenseModVariables;
import net.juujks.craft_defense.CraftDefenseMod;

public class SpawnStructureProcedure {
	public static void execute(LevelAccessor world) {
		CraftDefenseModVariables.MapVariables.get(world).globalTime = world.dayTime();
		CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
		if (CraftDefenseModVariables.MapVariables.get(world).act <= 5) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("craft_defense", "world1"));
				if (template != null) {
					template.placeInWorld(_serverworld, new BlockPos(0, 200, 0), new BlockPos(0, 200, 0), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
			CraftDefenseMod.queueServerWork(100, () -> {
				if (world instanceof ServerLevel _level)
					_level.setDayTime(3000);
			});
		}
		if (CraftDefenseModVariables.MapVariables.get(world).act > 5 && CraftDefenseModVariables.MapVariables.get(world).act <= 10) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("craft_defense", "world2"));
				if (template != null) {
					template.placeInWorld(_serverworld, new BlockPos(1000, 200, 1000), new BlockPos(1000, 200, 1000), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
			CraftDefenseMod.queueServerWork(100, () -> {
				if (world instanceof ServerLevel _level)
					_level.setDayTime(15000);
			});
		}
		if (CraftDefenseModVariables.MapVariables.get(world).act > 10 && CraftDefenseModVariables.MapVariables.get(world).act <= 15) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("craft_defense", "world3"));
				if (template != null) {
					template.placeInWorld(_serverworld, new BlockPos(1000, 200, -1000), new BlockPos(1000, 200, -1000), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
		}
		if (CraftDefenseModVariables.MapVariables.get(world).act > 15 && CraftDefenseModVariables.MapVariables.get(world).act <= 20) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("craft_defense", "w4"));
				if (template != null) {
					template.placeInWorld(_serverworld, new BlockPos(-1000, 200, -1000), new BlockPos(-1000, 200, -1000), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random,
							3);
				}
			}
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("craft_defense", "w41"));
				if (template != null) {
					template.placeInWorld(_serverworld, new BlockPos(-1000, 200, -1015), new BlockPos(-1000, 200, -1015), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random,
							3);
				}
			}
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("craft_defense", "w42"));
				if (template != null) {
					template.placeInWorld(_serverworld, new BlockPos(-952, 200, -1015), new BlockPos(-952, 200, -1015), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("craft_defense", "w43"));
				if (template != null) {
					template.placeInWorld(_serverworld, new BlockPos(-952, 200, -1000), new BlockPos(-952, 200, -1000), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
			CraftDefenseMod.queueServerWork(100, () -> {
				if (world instanceof ServerLevel _level)
					_level.setDayTime(3000);
			});
		}
		if (CraftDefenseModVariables.MapVariables.get(world).act > 20 && CraftDefenseModVariables.MapVariables.get(world).act <= 25) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("craft_defense", "desertmaze"));
				if (template != null) {
					template.placeInWorld(_serverworld, new BlockPos(-1000, 200, 1000), new BlockPos(-1000, 200, 1000), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
			CraftDefenseMod.queueServerWork(100, () -> {
				if (world instanceof ServerLevel _level)
					_level.setDayTime(10000);
			});
		}
		if (CraftDefenseModVariables.MapVariables.get(world).act > 25 && CraftDefenseModVariables.MapVariables.get(world).act <= 30) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("craft_defense", "w66"));
				if (template != null) {
					template.placeInWorld(_serverworld, new BlockPos(1000, 200, 0), new BlockPos(1000, 200, 0), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
		}
		if (CraftDefenseModVariables.MapVariables.get(world).act == 1000) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("craft_defense", "infinity"));
				if (template != null) {
					template.placeInWorld(_serverworld, new BlockPos(10000, 200, 10000), new BlockPos(10000, 200, 10000), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random,
							3);
				}
			}
			CraftDefenseMod.queueServerWork(100, () -> {
				if (world instanceof ServerLevel _level)
					_level.setDayTime(3000);
			});
		}
		if (CraftDefenseModVariables.MapVariables.get(world).act > 900 && CraftDefenseModVariables.MapVariables.get(world).act <= 910) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("craft_defense", "bossrush"));
				if (template != null) {
					template.placeInWorld(_serverworld, new BlockPos(10000, 200, 0), new BlockPos(10000, 200, 0), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
			CraftDefenseMod.queueServerWork(100, () -> {
				if (world instanceof ServerLevel _level)
					_level.setDayTime(15000);
			});
		}
		CraftDefenseMod.queueServerWork(20, () -> {
			if (CraftDefenseModVariables.MapVariables.get(world).act == 911) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("craft_defense", "event"));
					if (template != null) {
						template.placeInWorld(_serverworld, new BlockPos(10000, 200, -10000), new BlockPos(10000, 200, -10000), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
								_serverworld.random, 3);
					}
				}
				CraftDefenseMod.queueServerWork(100, () -> {
					if (world instanceof ServerLevel _level)
						_level.setDayTime(3000);
				});
			}
		});
		SpawnCustomStructureProcedure.execute(world);
	}
}