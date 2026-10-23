package net.juujks.craft_defense.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.Entity;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class QuestDescriptionProcedureProcedure {
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
		if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questType1 == 1) {
			{
				CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
				_vars.quest1h = "- Reach wave " + new java.text.DecimalFormat("##").format(entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).quest2Number1) + "/"
						+ new java.text.DecimalFormat("##").format(entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questNumber1) + " on infinity mode";
				_vars.markSyncDirty();
			}
		} else if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questType1 == 2) {
			{
				CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
				_vars.quest1h = "- Defeat " + new java.text.DecimalFormat("##").format(entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).quest2Number1) + "/"
						+ new java.text.DecimalFormat("##").format(entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questNumber1) + " enemies";
				_vars.markSyncDirty();
			}
		} else if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questType1 == 3) {
			{
				CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
				_vars.quest1h = "- Roll " + new java.text.DecimalFormat("##").format(entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).quest2Number1) + "/"
						+ new java.text.DecimalFormat("##").format(entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questNumber1) + " times";
				_vars.markSyncDirty();
			}
		} else if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questType1 == 4) {
			{
				CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
				_vars.quest1h = "- Win " + new java.text.DecimalFormat("##").format(entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).quest2Number1) + "/"
						+ new java.text.DecimalFormat("##").format(entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questNumber1) + " times";
				_vars.markSyncDirty();
			}
		} else if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questType1 == 5) {
			{
				CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
				_vars.quest1h = "- Play " + new java.text.DecimalFormat("##").format(entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).quest2Number1) + "/"
						+ new java.text.DecimalFormat("##").format(entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questNumber1) + " challenges";
				_vars.markSyncDirty();
			}
		} else {
			{
				CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
				_vars.quest1h = "Quest Completed";
				_vars.markSyncDirty();
			}
		}
		if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questType3 == 1) {
			{
				CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
				_vars.quest3h = "- Reach wave " + new java.text.DecimalFormat("##").format(entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).quest2Number3) + "/"
						+ new java.text.DecimalFormat("##").format(entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questNumber3) + " on infinity mode";
				_vars.markSyncDirty();
			}
		} else if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questType3 == 2) {
			{
				CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
				_vars.quest3h = "- Defeat " + new java.text.DecimalFormat("##").format(entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).quest2Number3) + "/"
						+ new java.text.DecimalFormat("##").format(entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questNumber3) + " enemies";
				_vars.markSyncDirty();
			}
		} else if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questType3 == 3) {
			{
				CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
				_vars.quest3h = "- Roll " + new java.text.DecimalFormat("##").format(entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).quest2Number3) + "/"
						+ new java.text.DecimalFormat("##").format(entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questNumber3) + " times";
				_vars.markSyncDirty();
			}
		} else if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questType3 == 4) {
			{
				CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
				_vars.quest3h = "- Win " + new java.text.DecimalFormat("##").format(entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).quest2Number3) + "/"
						+ new java.text.DecimalFormat("##").format(entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questNumber3) + " times";
				_vars.markSyncDirty();
			}
		} else if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questType3 == 5) {
			{
				CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
				_vars.quest3h = "- Play " + new java.text.DecimalFormat("##").format(entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).quest2Number3) + "/"
						+ new java.text.DecimalFormat("##").format(entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questNumber3) + " challenges";
				_vars.markSyncDirty();
			}
		} else {
			{
				CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
				_vars.quest3h = "Quest Completed";
				_vars.markSyncDirty();
			}
		}
		if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questType6 == 1) {
			{
				CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
				_vars.quest6h = "- Reach wave " + new java.text.DecimalFormat("##").format(entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).quest2Number6) + "/"
						+ new java.text.DecimalFormat("##").format(entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questNumber6) + " on infinity mode";
				_vars.markSyncDirty();
			}
		} else if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questType6 == 2) {
			{
				CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
				_vars.quest6h = "- Defeat " + new java.text.DecimalFormat("##").format(entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).quest2Number6) + "/"
						+ new java.text.DecimalFormat("##").format(entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questNumber6) + " enemies";
				_vars.markSyncDirty();
			}
		} else if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questType6 == 3) {
			{
				CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
				_vars.quest6h = "- Roll " + new java.text.DecimalFormat("##").format(entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).quest2Number6) + "/"
						+ new java.text.DecimalFormat("##").format(entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questNumber6) + " times";
				_vars.markSyncDirty();
			}
		} else if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questType6 == 4) {
			{
				CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
				_vars.quest6h = "- Win " + new java.text.DecimalFormat("##").format(entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).quest2Number6) + "/"
						+ new java.text.DecimalFormat("##").format(entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questNumber6) + " times";
				_vars.markSyncDirty();
			}
		} else if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questType6 == 5) {
			{
				CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
				_vars.quest6h = "- Play " + new java.text.DecimalFormat("##").format(entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).quest2Number6) + "/"
						+ new java.text.DecimalFormat("##").format(entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questNumber6) + " challenges";
				_vars.markSyncDirty();
			}
		} else {
			{
				CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
				_vars.quest6h = "Quest Completed";
				_vars.markSyncDirty();
			}
		}
		if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questType24 == 1) {
			{
				CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
				_vars.quest24h = "- Reach wave " + new java.text.DecimalFormat("##").format(entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).quest2Number24) + "/"
						+ new java.text.DecimalFormat("##").format(entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questNumber24) + " on infinity mode";
				_vars.markSyncDirty();
			}
		} else if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questType24 == 2) {
			{
				CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
				_vars.quest24h = "- Defeat " + new java.text.DecimalFormat("##").format(entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).quest2Number24) + "/"
						+ new java.text.DecimalFormat("##").format(entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questNumber24) + " enemies";
				_vars.markSyncDirty();
			}
		} else if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questType24 == 3) {
			{
				CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
				_vars.quest24h = "- Roll " + new java.text.DecimalFormat("##").format(entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).quest2Number24) + "/"
						+ new java.text.DecimalFormat("##").format(entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questNumber24) + " times";
				_vars.markSyncDirty();
			}
		} else if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questType24 == 4) {
			{
				CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
				_vars.quest24h = "- Win " + new java.text.DecimalFormat("##").format(entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).quest2Number24) + "/"
						+ new java.text.DecimalFormat("##").format(entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questNumber24) + " times";
				_vars.markSyncDirty();
			}
		} else if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questType24 == 5) {
			{
				CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
				_vars.quest24h = "- Play " + new java.text.DecimalFormat("##").format(entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).quest2Number24) + "/"
						+ new java.text.DecimalFormat("##").format(entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questNumber24) + " challenges";
				_vars.markSyncDirty();
			}
		} else {
			{
				CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
				_vars.quest24h = "Quest Completed";
				_vars.markSyncDirty();
			}
		}
	}
}