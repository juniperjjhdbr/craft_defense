package net.juujks.craft_defense.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class QuestPProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		double timer3h = 0;
		double timer24h = 0;
		double timer1h = 0;
		double c1 = 0;
		double c3 = 0;
		double c6 = 0;
		double c24 = 0;
		double timer6h = 0;
		{
			CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
			_vars.timeRemaining1 = 60 - entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).minutesPlayed;
			_vars.timeRemaining3 = 180 - entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).minutesPlayed;
			_vars.timeRemaining6 = 360 - entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).minutesPlayed;
			_vars.timeRemaining24 = 1440 - entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).minutesPlayed;
			_vars.time2Remaining3 = 3 - entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).hoursPlayed;
			_vars.time2Remaining6 = 6 - entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).hoursPlayed;
			_vars.time2Remaining24 = 24 - entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).hoursPlayed;
			_vars.timer = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).timer + 1;
			_vars.markSyncDirty();
		}
		if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).timer >= 20) {
			{
				CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
				_vars.secondsPlayed = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).secondsPlayed + 1;
				_vars.timer = 0;
				_vars.markSyncDirty();
			}
			if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).secondsPlayed >= 60) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.minutesPlayed = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).minutesPlayed + 1;
					_vars.secondsPlayed = 0;
					_vars.markSyncDirty();
				}
				if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).minutesPlayed >= 60) {
					{
						CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
						_vars.hoursPlayed = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).hoursPlayed + 1;
						_vars.timeRemaining1 = 60;
						_vars.markSyncDirty();
					}
					timer1h = timer1h + 1;
					timer3h = timer3h + 1;
					timer6h = timer6h + 1;
					timer24h = timer24h + 1;
					{
						CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
						_vars.minutesPlayed = 0;
						_vars.markSyncDirty();
					}
					if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).hoursPlayed >= 3) {
						{
							CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
							_vars.timeRemaining3 = 180;
							_vars.time2Remaining3 = 3;
							_vars.markSyncDirty();
						}
					}
					if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).hoursPlayed >= 6) {
						{
							CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
							_vars.timeRemaining6 = 360;
							_vars.time2Remaining6 = 6;
							_vars.markSyncDirty();
						}
					}
					if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).hoursPlayed >= 24) {
						{
							CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
							_vars.daysPlayed = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).daysPlayed + 1;
							_vars.timeRemaining24 = 1440;
							_vars.time2Remaining24 = 24;
							_vars.hoursPlayed = 0;
							_vars.markSyncDirty();
						}
					}
				}
			}
		}
		if (timer1h == 1) {
			{
				CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
				_vars.questType1 = Mth.nextInt(RandomSource.create(), 1, 5);
				_vars.markSyncDirty();
			}
			if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questType1 == 1) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.questNumber1 = Mth.nextInt(RandomSource.create(), 20, 25);
					_vars.markSyncDirty();
				}
			} else if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questType1 == 2) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.questNumber1 = 500;
					_vars.markSyncDirty();
				}
			} else if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questType1 == 3) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.questNumber1 = 40;
					_vars.markSyncDirty();
				}
			} else if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questType1 == 4) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.questNumber1 = Mth.nextInt(RandomSource.create(), 10, 15);
					_vars.markSyncDirty();
				}
			} else if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questType1 == 5) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.questNumber1 = 5;
					_vars.markSyncDirty();
				}
			}
			timer1h = 0;
			{
				CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
				_vars.quest2Number1 = 0;
				_vars.markSyncDirty();
			}
		}
		if (timer3h == 3) {
			{
				CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
				_vars.questType3 = Mth.nextInt(RandomSource.create(), 1, 4);
				_vars.markSyncDirty();
			}
			if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questType3 == 1) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.questNumber3 = Mth.nextInt(RandomSource.create(), 30, 35);
					_vars.markSyncDirty();
				}
			} else if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questType3 == 2) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.questNumber3 = 1500;
					_vars.markSyncDirty();
				}
			} else if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questType3 == 3) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.questNumber3 = 150;
					_vars.markSyncDirty();
				}
			} else if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questType3 == 4) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.questNumber3 = Mth.nextInt(RandomSource.create(), 25, 30);
					_vars.markSyncDirty();
				}
			} else if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questType3 == 5) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.questNumber3 = 15;
					_vars.markSyncDirty();
				}
			}
			timer3h = 0;
			{
				CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
				_vars.quest2Number3 = 0;
				_vars.markSyncDirty();
			}
		}
		if (timer6h == 6) {
			{
				CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
				_vars.questType6 = Mth.nextInt(RandomSource.create(), 1, 4);
				_vars.markSyncDirty();
			}
			if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questType6 == 1) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.questNumber6 = Mth.nextInt(RandomSource.create(), 40, 45);
					_vars.markSyncDirty();
				}
			} else if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questType6 == 2) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.questNumber6 = 4000;
					_vars.markSyncDirty();
				}
			} else if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questType6 == 3) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.questNumber6 = 300;
					_vars.markSyncDirty();
				}
			} else if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questType6 == 4) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.questNumber6 = Mth.nextInt(RandomSource.create(), 60, 70);
					_vars.markSyncDirty();
				}
			} else if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questType6 == 5) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.questNumber6 = 45;
					_vars.markSyncDirty();
				}
			}
			timer6h = 0;
			{
				CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
				_vars.quest2Number6 = 0;
				_vars.markSyncDirty();
			}
		}
		if (timer24h == 24) {
			{
				CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
				_vars.questType24 = Mth.nextInt(RandomSource.create(), 1, 4);
				_vars.markSyncDirty();
			}
			if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questType24 == 1) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.questNumber24 = 50;
					_vars.markSyncDirty();
				}
			} else if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questType24 == 2) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.questNumber24 = 10000;
					_vars.markSyncDirty();
				}
			} else if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questType24 == 3) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.questNumber24 = 500;
					_vars.markSyncDirty();
				}
			} else if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questType24 == 4) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.questNumber24 = 70;
					_vars.markSyncDirty();
				}
			} else if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questType24 == 5) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.questNumber24 = 60;
					_vars.markSyncDirty();
				}
			}
			timer24h = 0;
			{
				CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
				_vars.quest2Number24 = 0;
				_vars.markSyncDirty();
			}
		}
	}
}