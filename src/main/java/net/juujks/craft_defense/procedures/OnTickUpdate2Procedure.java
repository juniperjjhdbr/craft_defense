package net.juujks.craft_defense.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.juujks.craft_defense.network.CraftDefenseModVariables;
import net.juujks.craft_defense.init.CraftDefenseModParticleTypes;
import net.juujks.craft_defense.init.CraftDefenseModEntities;
import net.juujks.craft_defense.entity.*;

import java.util.Comparator;

public class OnTickUpdate2Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity nearestEnemy = null;
		String priority = "";
		double powerfulChance = 0;
		double nearestDistSq = 0;
		double dx = 0;
		double dz = 0;
		double distSq = 0;
		double yaw = 0;
		double bestScore = 0;
		double score = 0;
		double finalDamage = 0;
		double playerLookX = 0;
		double playerLookZ = 0;
		double dx2 = 0;
		double dz2 = 0;
		double dist = 0;
		double nx = 0;
		double nz = 0;
		double dot = 0;
		double dy2 = 0;
		double playerLookY = 0;
		double ny = 0;
		double dx3 = 0;
		double dz3 = 0;
		double dist3 = 0;
		double nx2 = 0;
		double nz2 = 0;
		double pdx = 0;
		double pdy = 0;
		double pdz = 0;
		double blazeAttackTicks = 0;
		boolean found = false;
		boolean attackedThisTick = false;
		boolean isCritial = false;
		boolean foundMarker = false;
		boolean isWatched = false;
		boolean foundRMarker = false;
		boolean rangeMarkerSpawned = false;
		boolean blazeAttacked = false;
		entity.getPersistentData().putBoolean("unit", true);
		if (entity instanceof PiglinUnitEntity) {
			VillagerOnTickUpdateProcedure.execute(world, x, y, z, entity);
		}
		if (!world.isClientSide()) {
			if (!(entity instanceof SlimeUnitEntity)) {
				if (entity instanceof LivingEntity _livingEntity4 && _livingEntity4.getAttributes().hasAttribute(Attributes.SCALE))
					_livingEntity4.getAttribute(Attributes.SCALE).setBaseValue(0.5);
			}
			ShowEntityTestProcedure.execute(world, x, y, z, entity);
			DmgP2Procedure.execute(world, x, y, z, entity);
			CallCommonProcedure.execute(entity);
			CallRareProcedure.execute(entity);
			CallEpicProcedure.execute(entity);
			CallLegendaryProcedure.execute(entity);
			DamageClientProcedure.execute(entity);
			WolfBuffProcedure.execute(world, x, y, z, entity);
			CallMythicProcedure.execute(entity);
			AerialUnitsPProcedure.execute(entity);
			bestScore = -1000000000;
			nearestDistSq = entity.getPersistentData().getDouble("range") * (entity.getPersistentData().getDouble("range") + 1);
			priority = entity.getPersistentData().getString("priority");
			entity.getPersistentData().putString("priorityText", priority);
			if ((priority).equals("")) {
				priority = "first";
			}
			if (CraftDefenseModVariables.MapVariables.get(world).gameSpeed == 1) {
				entity.getPersistentData().putDouble("cooldown", (entity.getPersistentData().getDouble("cooldown") + 1));
			} else if (CraftDefenseModVariables.MapVariables.get(world).gameSpeed == 2) {
				entity.getPersistentData().putDouble("cooldown", (entity.getPersistentData().getDouble("cooldown") + 2));
			} else {
				entity.getPersistentData().putDouble("cooldown", (entity.getPersistentData().getDouble("cooldown") + 3));
			}
			CreeperExplosionProcedure.execute(world, x, y, z, entity);
			{
				final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
				for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate((entity.getPersistentData().getDouble("range")) / 2d), e -> true).stream()
						.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
					if (entityiterator.getPersistentData().getBoolean("attackable") && entityiterator.getPersistentData().getDouble("powerful") <= entity.getPersistentData().getDouble("level")
							&& (!entityiterator.getPersistentData().getBoolean("aerial") || entity.getPersistentData().getBoolean("canHitAerial"))) {
						dx = entityiterator.getX() - entity.getX();
						dz = entityiterator.getZ() - entity.getZ();
						distSq = dx * dx + dz * dz;
						if ((priority).equals("nearest")) {
							score = 0 - distSq;
						} else if ((priority).equals("furthest")) {
							score = distSq;
						} else if ((priority).equals("strongest")) {
							score = entityiterator.getPersistentData().getDouble("powerful");
							if (score == 0) {
								score = entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1;
							}
						} else if ((priority).equals("weakest")) {
							score = entityiterator.getPersistentData().getDouble("powerful");
							if (score == 0) {
								score = entityiterator instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1;
							}
							score = 0 - score;
						} else if ((priority).equals("aerial")) {
							if (entityiterator.getPersistentData().getBoolean("aerial")) {
								score = 0 - distSq;
							} else {
								score = -1000000000;
							}
						} else if ((priority).equals("first")) {
							score = entityiterator.getPersistentData().getDouble("pathProgress");
						} else if ((priority).equals("last")) {
							score = 0 - entityiterator.getPersistentData().getDouble("pathProgress");
						} else {
							score = entityiterator.getPersistentData().getDouble("pathProgress");
						}
						if (entityiterator.isAlive() && score > bestScore) {
							bestScore = score;
							nearestDistSq = distSq;
							nearestEnemy = entityiterator;
							found = true;
						}
					}
				}
			}
			{
				final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
				for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
					if (entityiterator instanceof Player) {
						playerLookX = entityiterator.getLookAngle().x;
						playerLookY = entityiterator.getLookAngle().y;
						playerLookZ = entityiterator.getLookAngle().z;
						dx2 = entity.getX() - entityiterator.getX();
						dy2 = (entity.getY() + 0.5) - (entityiterator.getY() + 1.62);
						dz2 = entity.getZ() - entityiterator.getZ();
						dist = Math.sqrt(dy2 * dy2 + dx2 * dx2 + dz2 * dz2);
						nx = dx2 / dist;
						ny = dy2 / dist;
						nz = dz2 / dist;
						dot = playerLookY * ny + playerLookX * nx + playerLookZ * nz;
						if (dot >= 0.95) {
							isWatched = true;
						}
					}
				}
			}
			if (entity instanceof EndermanUnitEntity) {
				if (!(entity.getPersistentData().getDouble("cooldown") >= 20 * entity.getPersistentData().getDouble("spa")) && found) {
					if (nearestEnemy.getPersistentData().getBoolean("stunned") && entity.getPersistentData().getDouble("stunTimer") < 60) {
						if (entity instanceof EndermanUnitEntity) {
							((EndermanUnitEntity) entity).setControllerAnimation("procedure", "idle2");
						}
					} else {
						if (entity instanceof EndermanUnitEntity) {
							((EndermanUnitEntity) entity).setControllerAnimation("procedure", "idle");
						}
						nearestEnemy.getPersistentData().putBoolean("stunned", true);
					}
				}
			}
			if (entity.getPersistentData().getDouble("cooldown") >= 20 * entity.getPersistentData().getDouble("spa") && found) {
				entity.getPersistentData().putDouble("cooldown", 0);
				if (entity instanceof SteveEntity) {
					((SteveEntity) entity).setControllerAnimation("procedure", "attack");
				}
				if (entity instanceof AlexEntity) {
					((AlexEntity) entity).setControllerAnimation("procedure", "attack");
				}
				if (entity instanceof ZombieUnitEntity) {
					((ZombieUnitEntity) entity).setControllerAnimation("procedure", "zombie.attack");
				}
				if (entity instanceof CreeperUnitEntity animatable)
					animatable.setTexture("creeper");
				if (entity instanceof ZombifiedPiglinUnitEntity) {
					((ZombifiedPiglinUnitEntity) entity).setControllerAnimation("procedure", "attack");
				}
				if (entity instanceof PiglinUnitEntity) {
					((PiglinUnitEntity) entity).setControllerAnimation("procedure", "attack");
				}
				if (entity instanceof PufferfishUnitEntity) {
					((PufferfishUnitEntity) entity).setControllerAnimation("procedure", "attack");
				}
				if (entity instanceof IronGolemUnitEntity) {
					((IronGolemUnitEntity) entity).setControllerAnimation("procedure", "attack");
				}
				if (entity instanceof HuskUnitEntity) {
					((HuskUnitEntity) entity).setControllerAnimation("procedure", "attack");
				}
				if (entity instanceof BreezeUnitEntity) {
					((BreezeUnitEntity) entity).setControllerAnimation("procedure", "attack");
				}
				if (entity instanceof FrostbiteUnitEntity) {
					((FrostbiteUnitEntity) entity).setControllerAnimation("procedure", "attack");
				}
				if (entity instanceof DrownedUnitEntity) {
					entity.getPersistentData().putDouble("animCooldown", 1);
					if (CraftDefenseModVariables.MapVariables.get(world).gameSpeed == 1) {
						if (entity instanceof DrownedUnitEntity) {
							((DrownedUnitEntity) entity).setControllerAnimation("procedure", "attack");
						}
					} else {
						if (entity instanceof DrownedUnitEntity) {
							((DrownedUnitEntity) entity).setControllerAnimation("procedure", "attack2x");
						}
					}
				}
				if (nearestEnemy.getPersistentData().getBoolean("stunned") && entity.getPersistentData().getDouble("stunTimer") < 60) {
					if (entity instanceof EndermanUnitEntity) {
						((EndermanUnitEntity) entity).setControllerAnimation("procedure", "empty");
					}
					if (entity instanceof EndermanUnitEntity) {
						((EndermanUnitEntity) entity).setControllerAnimation("procedure", "attack2");
					}
				} else {
					if (entity instanceof EndermanUnitEntity) {
						((EndermanUnitEntity) entity).setControllerAnimation("procedure", "empty");
					}
					if (entity instanceof EndermanUnitEntity) {
						((EndermanUnitEntity) entity).setControllerAnimation("procedure", "attack");
					}
				}
				if (entity instanceof SteveEntity || entity instanceof CaveSpiderUnitEntity || entity instanceof ZombifiedPiglinUnitEntity || entity instanceof PiglinUnitEntity || entity instanceof IronGolemUnitEntity
						|| entity instanceof HuskUnitEntity || entity instanceof ZombieUnitEntity || entity instanceof WolfUnitEntity || entity instanceof SpiderUnitEntity) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.attack.sweep")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.attack.sweep")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.SWEEP_ATTACK, (nearestEnemy.getX()), (nearestEnemy.getY() + 1), (nearestEnemy.getZ()), 1, 0, 1, 0, 0.2);
				}
				if (entity instanceof WitchUnitEntity) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_bottle.throw")), SoundSource.NEUTRAL, 1, 0);
						} else {
							_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_bottle.throw")), SoundSource.NEUTRAL, 1, 0, false);
						}
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.ENCHANTED_HIT, (nearestEnemy.getX()), (nearestEnemy.getY() + 1), (nearestEnemy.getZ()), 20, 0, 0, 0, 0.2);
				}
				if (entity instanceof BreezeUnitEntity) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.breeze.shoot")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.breeze.shoot")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.GUST, (nearestEnemy.getX()), (nearestEnemy.getY() + 1), (nearestEnemy.getZ()), 20, 0, 0, 0, 0.2);
				}
				if (entity instanceof PufferfishUnitEntity) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.puffer_fish.blow_up")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.puffer_fish.blow_up")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
				}
				if (entity instanceof CreeperUnitEntity || entity instanceof ChargedCreeperUnitEntity) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.explode")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.explode")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.EXPLOSION, x, y, z, 5, 6, 1, 6, 1);
				}
				if (entity instanceof SlimeUnitEntity || entity instanceof MagmaCubeUnitEntity) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.slime.jump")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.slime.jump")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.ITEM_SLIME, (nearestEnemy.getX()), (nearestEnemy.getY() + 1), (nearestEnemy.getZ()), 20, 0, 0, 0, 1);
				}
				if (entity instanceof AlexEntity || entity instanceof StrayUnitEntity || entity instanceof SnowGolemUnitEntity || entity instanceof BoggedUnitEntity) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.arrow.shoot")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.arrow.shoot")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.CRIT, (nearestEnemy.getX()), (nearestEnemy.getY()), (nearestEnemy.getZ()), 10, 0, 0, 0, 0.2);
				}
				if (entity instanceof SnowGolemUnitEntity) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.arrow.shoot")), SoundSource.NEUTRAL, 1, 0);
						} else {
							_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.arrow.shoot")), SoundSource.NEUTRAL, 1, 0, false);
						}
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.CRIT, (nearestEnemy.getX()), (nearestEnemy.getY()), (nearestEnemy.getZ()), 10, 0, 0, 0, 0.2);
				}
				if (entity instanceof PillagerUnitEntity) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.crossbow.shoot")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.crossbow.shoot")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.CRIT, (nearestEnemy.getX()), (nearestEnemy.getY()), (nearestEnemy.getZ()), 10, 0, 0, 0, 0.2);
				}
				dx = nearestEnemy.getX() - entity.getX();
				dz = nearestEnemy.getZ() - entity.getZ();
				yaw = Math.atan2(dz, dx) * (180 / Math.PI) - 90;
				{
					Entity _ent = entity;
					_ent.setYRot((float) yaw);
					_ent.setXRot(0);
					_ent.setYBodyRot(_ent.getYRot());
					_ent.setYHeadRot(_ent.getYRot());
					_ent.yRotO = _ent.getYRot();
					_ent.xRotO = _ent.getXRot();
					if (_ent instanceof LivingEntity _entity) {
						_entity.yBodyRotO = _entity.getYRot();
						_entity.yHeadRotO = _entity.getYRot();
					}
				}
				if (entity instanceof CreeperUnitEntity || entity instanceof ChargedCreeperUnitEntity || entity instanceof PufferfishUnitEntity) {
					{
						final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
						for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate((entity.getPersistentData().getDouble("range")) / 2d), e -> true).stream()
								.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
							if (entityiterator.getPersistentData().getDouble("powerful") <= entity.getPersistentData().getDouble("level") && entityiterator.getPersistentData().getBoolean("attackable")) {
								entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), (float) entity.getPersistentData().getDouble("damage"));
								if (entity instanceof PufferfishUnitEntity) {
									entityiterator.getPersistentData().putBoolean("poison", true);
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MobEffects.POISON, 100, 64, true, true));
								}
							}
						}
					}
					AddTotalDamageProcedure.execute(world, entity);
				} else {
					if (nearestEnemy.getPersistentData().getDouble("powerful") <= entity.getPersistentData().getDouble("level")) {
						if (entity instanceof BlazeUnitEntity || entity instanceof AlexEntity || entity instanceof SkeletonUnitEntity || entity instanceof StrayUnitEntity || entity instanceof SnowGolemUnitEntity || entity instanceof DrownedUnitEntity
								|| entity instanceof BoggedUnitEntity) {
							if (entity instanceof BlazeUnitEntity) {
								entity.getPersistentData().putDouble("blazeAttackTicks", 15);
							} else {
								if (entity instanceof AlexEntity || entity instanceof SkeletonUnitEntity || entity instanceof StrayUnitEntity || entity instanceof SnowGolemUnitEntity || entity instanceof DrownedUnitEntity
										|| entity instanceof BoggedUnitEntity) {
									pdx = nearestEnemy.getX() - x;
									pdy = (nearestEnemy.getY() + 0.5) - (y + 0.5);
									pdz = nearestEnemy.getZ() - z;
									if (entity instanceof AlexEntity || entity instanceof SkeletonUnitEntity || entity instanceof StrayUnitEntity || entity instanceof BoggedUnitEntity) {
										if (world instanceof ServerLevel projectileLevel) {
											Projectile _entityToSpawn = initArrowProjectile(new ArrowProjectileEntity(CraftDefenseModEntities.ARROW_PROJECTILE.get(), projectileLevel), entity, 0, true, false, true, AbstractArrow.Pickup.DISALLOWED);
											_entityToSpawn.setPos(x, (y + 0.5), z);
											_entityToSpawn.shoot(pdx, pdy, pdz, 2, 0);
											projectileLevel.addFreshEntity(_entityToSpawn);
										}
									} else if (entity instanceof SnowGolemUnitEntity) {
										if (world instanceof ServerLevel projectileLevel) {
											Projectile _entityToSpawn = initArrowProjectile(new SnowballProjectileEntity(CraftDefenseModEntities.SNOWBALL_PROJECTILE.get(), projectileLevel), entity, 0, true, false, true,
													AbstractArrow.Pickup.DISALLOWED);
											_entityToSpawn.setPos(x, (y + 0.5), z);
											_entityToSpawn.shoot(pdx, pdy, pdz, 2, 0);
											projectileLevel.addFreshEntity(_entityToSpawn);
										}
									} else {
										if (world instanceof ServerLevel projectileLevel) {
											Projectile _entityToSpawn = initArrowProjectile(new WindChargeProjectileEntity(CraftDefenseModEntities.WIND_CHARGE_PROJECTILE.get(), projectileLevel), entity, 0, true, false, true,
													AbstractArrow.Pickup.DISALLOWED);
											_entityToSpawn.setPos(x, (y + 0.5), z);
											_entityToSpawn.shoot(pdx, pdy, pdz, 2, 0);
											projectileLevel.addFreshEntity(_entityToSpawn);
										}
									}
									AddTotalDamageProcedure.execute(world, entity);
								}
							}
						} else {
							if (nearestEnemy.getPersistentData().getBoolean("aerial") == false) {
								if (entity instanceof RavagerUnitEntity || entity instanceof EndermanUnitEntity) {
									finalDamage = entity.getPersistentData().getDouble("damage");
									entity.getPersistentData().putDouble("finalDamage", (entity.getPersistentData().getDouble("damage")));
									if (Math.random() <= 0.25) {
										finalDamage = entity.getPersistentData().getDouble("damage") * 1.5;
										entity.getPersistentData().putDouble("finalDamage", (entity.getPersistentData().getDouble("damage") * 1.5));
										isCritial = true;
										if (entity instanceof RavagerUnitEntity) {
											if (world instanceof ServerLevel _level)
												_level.sendParticles(ParticleTypes.CRIT, (nearestEnemy.getX()), (nearestEnemy.getY()), (nearestEnemy.getZ()), 20, 0, 0, 0, 0.2);
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.attack.crit")), SoundSource.NEUTRAL,
															1, 1);
												} else {
													_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.attack.crit")), SoundSource.NEUTRAL, 1, 1, false);
												}
											}
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.ravager.attack")), SoundSource.NEUTRAL, 1,
															1);
												} else {
													_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.ravager.attack")), SoundSource.NEUTRAL, 1, 1, false);
												}
											}
										}
										if (entity instanceof EndermanUnitEntity) {
											if (world instanceof ServerLevel _level)
												_level.sendParticles(ParticleTypes.CRIT, (nearestEnemy.getX()), (nearestEnemy.getY()), (nearestEnemy.getZ()), 20, 0, 0, 0, 0.2);
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.attack.crit")), SoundSource.NEUTRAL,
															1, 1);
												} else {
													_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.attack.crit")), SoundSource.NEUTRAL, 1, 1, false);
												}
											}
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.enderman.scream")), SoundSource.NEUTRAL, 1,
															1);
												} else {
													_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.enderman.scream")), SoundSource.NEUTRAL, 1, 1, false);
												}
											}
										}
									} else {
										isCritial = false;
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.attack.sweep")), SoundSource.NEUTRAL, 1,
														1);
											} else {
												_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.attack.sweep")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
									}
									if (world instanceof ServerLevel _level)
										_level.sendParticles(ParticleTypes.SWEEP_ATTACK, (nearestEnemy.getX()), (nearestEnemy.getY() + 1), (nearestEnemy.getZ()), 1, 0, 1, 0, 0.2);
									nearestEnemy.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), (float) finalDamage);
									AddTotalFinalDamageProcedure.execute(world, entity);
								} else {
									if ((entity.getPersistentData().getString("attackType")).equals("circleAOE")) {
										entity.getPersistentData().putDouble("aoeCount", 0);
										{
											final Vec3 _center = new Vec3((nearestEnemy.getX()), (nearestEnemy.getY()), (nearestEnemy.getZ()));
											for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate((entity.getPersistentData().getDouble("aoeRange") * 2) / 2d), e -> true).stream()
													.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
												if (entityiterator.getPersistentData().getDouble("powerful") <= entity.getPersistentData().getDouble("level") && entityiterator.getPersistentData().getBoolean("attackable")
														&& !(entityiterator == nearestEnemy)) {
													entity.getPersistentData().putDouble("aoeCount", (entity.getPersistentData().getDouble("aoeCount") + 1));
												}
											}
										}
										entity.getPersistentData().putDouble("aoeCount", (entity.getPersistentData().getDouble("aoeCount") + 1));
										entity.getPersistentData().putDouble("splitDamage", (entity.getPersistentData().getDouble("damage") / entity.getPersistentData().getDouble("aoeCount")));
										if (entity instanceof FrostbiteUnitEntity) {
											finalDamage = entity.getPersistentData().getDouble("damage");
											entity.getPersistentData().putDouble("finalDamage", (entity.getPersistentData().getDouble("damage")));
											if (Math.random() <= 0.25) {
												finalDamage = entity.getPersistentData().getDouble("damage") * 1.5;
												entity.getPersistentData().putDouble("finalDamage", (entity.getPersistentData().getDouble("damage") * 1.5));
												isCritial = true;
											} else {
												isCritial = false;
												if (world instanceof Level _level) {
													if (!_level.isClientSide()) {
														_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.attack.sweep")),
																SoundSource.NEUTRAL, 1, 1);
													} else {
														_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.attack.sweep")), SoundSource.NEUTRAL, 1, 1,
																false);
													}
												}
											}
											if (world instanceof ServerLevel _level)
												_level.sendParticles(ParticleTypes.SWEEP_ATTACK, (nearestEnemy.getX()), (nearestEnemy.getY() + 1), (nearestEnemy.getZ()), 1, 0, 1, 0, 0.2);
											entity.getPersistentData().putDouble("splitDamage", (entity.getPersistentData().getDouble("finalDamage") / entity.getPersistentData().getDouble("aoeCount")));
										}
										{
											final Vec3 _center = new Vec3((nearestEnemy.getX()), (nearestEnemy.getY()), (nearestEnemy.getZ()));
											for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate((entity.getPersistentData().getDouble("aoeRange") * 2) / 2d), e -> true).stream()
													.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
												if (entityiterator.getPersistentData().getDouble("powerful") <= entity.getPersistentData().getDouble("level") && entityiterator.getPersistentData().getBoolean("attackable")) {
													entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), (float) entity.getPersistentData().getDouble("splitDamage"));
													if (entity instanceof FrostbiteUnitEntity) {
														if (isCritial) {
															if (world instanceof ServerLevel _level)
																_level.sendParticles(ParticleTypes.CRIT, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 20, 0, 0, 0, 0.2);
															if (world instanceof ServerLevel _level)
																_level.sendParticles((SimpleParticleType) (CraftDefenseModParticleTypes.SNOW_FLAKE.get()), (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 10, 0, 0, 0, 0.1);
															if (world instanceof ServerLevel _level)
																_level.sendParticles((SimpleParticleType) (CraftDefenseModParticleTypes.SNOW_FLAKE_2.get()), (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 10, 0, 0, 0, 0.1);
															if (world instanceof Level _level) {
																if (!_level.isClientSide()) {
																	_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.glass.break")),
																			SoundSource.NEUTRAL, 1, 1);
																} else {
																	_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.glass.break")), SoundSource.NEUTRAL, 1, 1,
																			false);
																}
															}
															if (world instanceof Level _level) {
																if (!_level.isClientSide()) {
																	_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.attack.crit")),
																			SoundSource.NEUTRAL, 1, 1);
																} else {
																	_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.attack.crit")), SoundSource.NEUTRAL,
																			1, 1, false);
																}
															}
															entityiterator.getPersistentData().putBoolean("stunned", true);
														}
													}
													if (entity instanceof BreezeUnitEntity) {
														entityiterator.getPersistentData().putDouble("lastPathX", (entityiterator.getX()));
														entityiterator.getPersistentData().putDouble("lastPathY", (entityiterator.getY()));
														entityiterator.getPersistentData().putDouble("lastPathZ", (entityiterator.getZ()));
														dx3 = entityiterator.getX() - entity.getX();
														dz3 = entityiterator.getZ() - entity.getZ();
														dist3 = Math.sqrt(dx3 * dx3 + dz3 * dz3);
														nx2 = dx3 / dist3;
														nz2 = dz3 / dist3;
														entityiterator.getPersistentData().putDouble("knockbackDX", nx2);
														entityiterator.getPersistentData().putDouble("knockbackDZ", nz2);
														entityiterator.getPersistentData().putBoolean("knockback", true);
														entityiterator.getPersistentData().putDouble("knockbackTime", 8);
													}
												}
											}
										}
										entity.getPersistentData().putDouble("aoeMarkerX", (nearestEnemy.getX()));
										entity.getPersistentData().putDouble("aoeMarkerY", (nearestEnemy.getY()));
										entity.getPersistentData().putDouble("aoeMarkerZ", (nearestEnemy.getZ()));
										entity.getPersistentData().putBoolean("needsMarkerUpdate", true);
										AddTotalDamageProcedure.execute(world, entity);
									} else {
										nearestEnemy.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), (float) entity.getPersistentData().getDouble("damage"));
										AddTotalDamageProcedure.execute(world, entity);
									}
									if (entity instanceof WitchUnitEntity) {
										if (nearestEnemy instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MobEffects.POISON, 100, 32, true, true));
										nearestEnemy.getPersistentData().putBoolean("poison", true);
									}
									if (entity instanceof MagmaCubeUnitEntity) {
										nearestEnemy.getPersistentData().putDouble("burningTick", 100);
									}
									if (entity instanceof CaveSpiderUnitEntity) {
										if (nearestEnemy instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MobEffects.POISON, 100, 64, true, true));
										nearestEnemy.getPersistentData().putBoolean("poison", true);
									}
									if (entity instanceof StrayUnitEntity || entity instanceof SnowGolemUnitEntity || entity instanceof FrostbiteUnitEntity || entity instanceof SlimeUnitEntity) {
										nearestEnemy.getPersistentData().putBoolean("slow", true);
									}
								}
							} else if (nearestEnemy.getPersistentData().getBoolean("aerial")) {
								if (entity instanceof PillagerUnitEntity) {
									nearestEnemy.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), (float) entity.getPersistentData().getDouble("damage"));
									AddTotalDamageProcedure.execute(world, entity);
								}
								if (entity instanceof BlazeUnitEntity) {
									entity.getPersistentData().putDouble("blazeAttackTicks", 15);
								}
							}
						}
					}
				}
			}
			if (entity instanceof BlazeUnitEntity) {
				if (entity.getPersistentData().getDouble("blazeAttackTicks") > 0) {
					entity.getPersistentData().putDouble("blazeAttackTicks", (entity.getPersistentData().getDouble("blazeAttackTicks") - CraftDefenseModVariables.MapVariables.get(world).gameSpeed));
					if (entity.getPersistentData().getDouble("blazeAttackTicks") % 5 == 0) {
						if (found) {
							if (nearestEnemy.getPersistentData().getBoolean("attackable")) {
								pdx = nearestEnemy.getX() - x;
								pdy = (nearestEnemy.getY() + 0.5) - (y + 0.5);
								pdz = nearestEnemy.getZ() - z;
								if (world instanceof ServerLevel projectileLevel) {
									Projectile _entityToSpawn = initArrowProjectile(new BlazeUnitProjectileEntity(CraftDefenseModEntities.BLAZE_UNIT_PROJECTILE.get(), projectileLevel), entity, 0, true, true, false, AbstractArrow.Pickup.DISALLOWED);
									_entityToSpawn.setPos(x, (y + 0.5), z);
									_entityToSpawn.shoot(pdx, pdy, pdz, 2, 0);
									projectileLevel.addFreshEntity(_entityToSpawn);
								}
								AddTotalDamageProcedure.execute(world, entity);
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.blaze.shoot")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.blaze.shoot")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
							}
						}
					}
				}
			}
			if (entity.getPersistentData().getDouble("animCooldown") >= 1) {
				entity.getPersistentData().putDouble("animCooldown", (entity.getPersistentData().getDouble("animCooldown") + CraftDefenseModVariables.MapVariables.get(world).gameSpeed));
				if (entity.getPersistentData().getDouble("animCooldown") >= 6) {
					if (found) {
						if (nearestEnemy.getPersistentData().getBoolean("attackable")) {
							pdx = nearestEnemy.getX() - x;
							pdy = (nearestEnemy.getY() + 0.5) - (y + 0.5);
							pdz = nearestEnemy.getZ() - z;
							if (world instanceof ServerLevel projectileLevel) {
								Projectile _entityToSpawn = initArrowProjectile(new TridentProjectileEntity(CraftDefenseModEntities.TRIDENT_PROJECTILE.get(), projectileLevel), entity, 0, true, false, true, AbstractArrow.Pickup.DISALLOWED);
								_entityToSpawn.setPos(x, (y + 0.5), z);
								_entityToSpawn.shoot(pdx, pdy, pdz, 2, 0);
								projectileLevel.addFreshEntity(_entityToSpawn);
							}
							AddTotalDamageProcedure.execute(world, entity);
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.drowned.shoot")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.drowned.shoot")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
						}
					}
					entity.getPersistentData().putDouble("animCooldown", 0);
				}
			}
		}
	}

	private static AbstractArrow initArrowProjectile(AbstractArrow entityToSpawn, Entity shooter, float damage, boolean silent, boolean fire, boolean particles, AbstractArrow.Pickup pickup) {
		entityToSpawn.setOwner(shooter);
		entityToSpawn.setBaseDamage(damage);
		if (silent)
			entityToSpawn.setSilent(true);
		if (fire)
			entityToSpawn.igniteForSeconds(100);
		if (particles)
			entityToSpawn.setCritArrow(true);
		entityToSpawn.pickup = pickup;
		return entityToSpawn;
	}
}