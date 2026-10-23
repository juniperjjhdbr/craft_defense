package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.juujks.craft_defense.network.CraftDefenseModVariables;
import net.juujks.craft_defense.init.CraftDefenseModBlocks;

public class WalkSysProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double kbX = 0;
		double kbZ = 0;
		if (entity.isAlive()) {
			kbX = entity.getPersistentData().getDouble("knockbackDX") * 0.07 * CraftDefenseModVariables.MapVariables.get(world).gameSpeed;
			kbZ = entity.getPersistentData().getDouble("knockbackDZ") * 0.07 * CraftDefenseModVariables.MapVariables.get(world).gameSpeed;
			if (entity.getPersistentData().getBoolean("knockback")) {
				entity.getPersistentData().putDouble("knockbackTime", (entity.getPersistentData().getDouble("knockbackTime") - 1 * CraftDefenseModVariables.MapVariables.get(world).gameSpeed));
				if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == CraftDefenseModBlocks.PATH_BLOCK_WAY.get()) {
					if ((getDirectionFromBlockState((world.getBlockState(BlockPos.containing(x, y - 1, z))))) == Direction.NORTH || (getDirectionFromBlockState((world.getBlockState(BlockPos.containing(x, y - 1, z))))) == Direction.SOUTH) {
						{
							Entity _ent = entity;
							double _tx = (entity.getX());
							double _ty = (entity.getY());
							double _tz = (entity.getZ() + kbZ);
							_ent.teleportTo(_tx, _ty, _tz);
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
						}
					} else if ((getDirectionFromBlockState((world.getBlockState(BlockPos.containing(x, y - 1, z))))) == Direction.WEST || (getDirectionFromBlockState((world.getBlockState(BlockPos.containing(x, y - 1, z))))) == Direction.EAST) {
						{
							Entity _ent = entity;
							double _tx = (entity.getX() + kbX);
							double _ty = (entity.getY());
							double _tz = (entity.getZ());
							_ent.teleportTo(_tx, _ty, _tz);
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
						}
					}
				}
				if (!((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == CraftDefenseModBlocks.PATH_BLOCK_WAY.get())) {
					{
						Entity _ent = entity;
						double _tx = (entity.getPersistentData().getDouble("lastPathX"));
						double _ty = (entity.getPersistentData().getDouble("lastPathY"));
						double _tz = (entity.getPersistentData().getDouble("lastPathZ"));
						_ent.teleportTo(_tx, _ty, _tz);
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
					}
				}
				if (entity.getPersistentData().getDouble("knockbackTime") <= 0) {
					entity.getPersistentData().putBoolean("knockback", false);
					if (!((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == CraftDefenseModBlocks.PATH_BLOCK_WAY.get())) {
						{
							Entity _ent = entity;
							double _tx = (entity.getPersistentData().getDouble("lastPathX"));
							double _ty = (entity.getPersistentData().getDouble("lastPathY"));
							double _tz = (entity.getPersistentData().getDouble("lastPathZ"));
							_ent.teleportTo(_tx, _ty, _tz);
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
						}
					}
				}
			} else {
				if (!entity.getPersistentData().getBoolean("stunned") || !(entity.getPersistentData().getDouble("stunTimer") < 60) && entity.getPersistentData().getBoolean("stunned")) {
					if (CraftDefenseModVariables.MapVariables.get(world).gameSpeed == 1) {
						if (!entity.getPersistentData().getBoolean("fast") && !entity.getPersistentData().getBoolean("tank")
								&& !(CraftDefenseModVariables.MapVariables.get(world).act > 900 && CraftDefenseModVariables.MapVariables.get(world).act <= 910) && !entity.getPersistentData().getBoolean("slow")) {
							if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == CraftDefenseModBlocks.PATH_BLOCK_WAY.get()) {
								if ((getDirectionFromBlockState((world.getBlockState(BlockPos.containing(x, y - 1, z))))) == Direction.NORTH) {
									{
										Entity _ent = entity;
										if (!_ent.level().isClientSide() && _ent.getServer() != null) {
											_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
													_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tp @s ~ ~ ~-0.05 180 ~");
										}
									}
								} else if ((getDirectionFromBlockState((world.getBlockState(BlockPos.containing(x, y - 1, z))))) == Direction.SOUTH) {
									{
										Entity _ent = entity;
										if (!_ent.level().isClientSide() && _ent.getServer() != null) {
											_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
													_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tp @s ~ ~ ~0.05 0 ~");
										}
									}
								} else if ((getDirectionFromBlockState((world.getBlockState(BlockPos.containing(x, y - 1, z))))) == Direction.EAST) {
									{
										Entity _ent = entity;
										if (!_ent.level().isClientSide() && _ent.getServer() != null) {
											_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
													_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tp @s ~0.05 ~ ~ -90 ~");
										}
									}
								} else if ((getDirectionFromBlockState((world.getBlockState(BlockPos.containing(x, y - 1, z))))) == Direction.WEST) {
									{
										Entity _ent = entity;
										if (!_ent.level().isClientSide() && _ent.getServer() != null) {
											_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
													_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tp @s ~-0.05 ~ ~ 90 ~");
										}
									}
								}
							}
						} else if (entity.getPersistentData().getBoolean("slow") || CraftDefenseModVariables.MapVariables.get(world).act > 900 && CraftDefenseModVariables.MapVariables.get(world).act <= 910
								|| entity.getPersistentData().getBoolean("tank")) {
							if ((getDirectionFromBlockState((world.getBlockState(BlockPos.containing(x, y - 1, z))))) == Direction.NORTH) {
								{
									Entity _ent = entity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
												_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tp @s ~ ~ ~-0.02 180 ~");
									}
								}
							} else if ((getDirectionFromBlockState((world.getBlockState(BlockPos.containing(x, y - 1, z))))) == Direction.SOUTH) {
								{
									Entity _ent = entity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
												_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tp @s ~ ~ ~0.02 0 ~");
									}
								}
							} else if ((getDirectionFromBlockState((world.getBlockState(BlockPos.containing(x, y - 1, z))))) == Direction.EAST) {
								{
									Entity _ent = entity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
												_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tp @s ~0.02 ~ ~ -90 ~");
									}
								}
							} else if ((getDirectionFromBlockState((world.getBlockState(BlockPos.containing(x, y - 1, z))))) == Direction.WEST) {
								{
									Entity _ent = entity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
												_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tp @s ~-0.02 ~ ~ 90 ~");
									}
								}
							}
						} else if (entity.getPersistentData().getBoolean("fast") && !entity.getPersistentData().getBoolean("tank")
								&& !(CraftDefenseModVariables.MapVariables.get(world).act > 900 && CraftDefenseModVariables.MapVariables.get(world).act <= 910) && !entity.getPersistentData().getBoolean("slow")) {
							if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == CraftDefenseModBlocks.PATH_BLOCK_WAY.get()) {
								if ((getDirectionFromBlockState((world.getBlockState(BlockPos.containing(x, y - 1, z))))) == Direction.NORTH) {
									{
										Entity _ent = entity;
										if (!_ent.level().isClientSide() && _ent.getServer() != null) {
											_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
													_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tp @s ~ ~ ~-0.1 180 ~");
										}
									}
								} else if ((getDirectionFromBlockState((world.getBlockState(BlockPos.containing(x, y - 1, z))))) == Direction.SOUTH) {
									{
										Entity _ent = entity;
										if (!_ent.level().isClientSide() && _ent.getServer() != null) {
											_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
													_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tp @s ~ ~ ~0.1 0 ~");
										}
									}
								} else if ((getDirectionFromBlockState((world.getBlockState(BlockPos.containing(x, y - 1, z))))) == Direction.EAST) {
									{
										Entity _ent = entity;
										if (!_ent.level().isClientSide() && _ent.getServer() != null) {
											_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
													_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tp @s ~0.1 ~ ~ -90 ~");
										}
									}
								} else if ((getDirectionFromBlockState((world.getBlockState(BlockPos.containing(x, y - 1, z))))) == Direction.WEST) {
									{
										Entity _ent = entity;
										if (!_ent.level().isClientSide() && _ent.getServer() != null) {
											_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
													_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tp @s ~-0.1 ~ ~ 90 ~");
										}
									}
								}
							}
						}
					} else if (CraftDefenseModVariables.MapVariables.get(world).gameSpeed == 3) {
						WalkSys3xProcedure.execute(world, x, y, z, entity);
					} else {
						WalkSys2xProcedure.execute(world, x, y, z, entity);
					}
					if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == CraftDefenseModBlocks.PATH_BLOCK_LEFT_CURVE.get()) {
						if ((getDirectionFromBlockState((world.getBlockState(BlockPos.containing(x, y - 1, z))))) == Direction.NORTH) {
							{
								Entity _ent = entity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tp @s ~-1 ~ ~-0.5 ~-90 ~");
								}
							}
						} else if ((getDirectionFromBlockState((world.getBlockState(BlockPos.containing(x, y - 1, z))))) == Direction.SOUTH) {
							{
								Entity _ent = entity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tp @s ~1 ~ ~0.5 ~-90 ~");
								}
							}
						} else if ((getDirectionFromBlockState((world.getBlockState(BlockPos.containing(x, y - 1, z))))) == Direction.EAST) {
							{
								Entity _ent = entity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tp @s ~0.5 ~ ~-1 ~-90 ~");
								}
							}
						} else if ((getDirectionFromBlockState((world.getBlockState(BlockPos.containing(x, y - 1, z))))) == Direction.WEST) {
							{
								Entity _ent = entity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tp @s ~-0.5 ~ ~1 ~-90 ~");
								}
							}
						}
					}
					if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == CraftDefenseModBlocks.PATH_BLOCK_RIGHT_CURVE.get()) {
						if ((getDirectionFromBlockState((world.getBlockState(BlockPos.containing(x, y - 1, z))))) == Direction.NORTH) {
							{
								Entity _ent = entity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tp @s ~1 ~ ~-0.5 ~90 ~");
								}
							}
						} else if ((getDirectionFromBlockState((world.getBlockState(BlockPos.containing(x, y - 1, z))))) == Direction.SOUTH) {
							{
								Entity _ent = entity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tp @s ~-1 ~ ~0.5 ~90 ~");
								}
							}
						} else if ((getDirectionFromBlockState((world.getBlockState(BlockPos.containing(x, y - 1, z))))) == Direction.EAST) {
							{
								Entity _ent = entity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tp @s ~0.5 ~ ~1 ~90 ~");
								}
							}
						} else if ((getDirectionFromBlockState((world.getBlockState(BlockPos.containing(x, y - 1, z))))) == Direction.WEST) {
							{
								Entity _ent = entity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tp @s ~-0.5 ~ ~-1 ~90 ~");
								}
							}
						}
					}
				}
			}
		}
	}

	private static Direction getDirectionFromBlockState(BlockState blockState) {
		Property<?> prop = getPropertyByName(blockState, "facing");
		if (prop instanceof DirectionProperty dp)
			return blockState.getValue(dp);
		prop = getPropertyByName(blockState, "axis");
		return prop instanceof EnumProperty ep && ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) blockState.getValue(ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
	}

	private static Property<?> getPropertyByName(BlockState state, String name) {
		for (Property<?> property : state.getProperties()) {
			if (property.getName().equals(name)) {
				return property;
			}
		}
		return null;
	}
}