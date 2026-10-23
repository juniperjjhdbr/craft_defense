/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.juujks.craft_defense.init;

import org.joml.Vector3f;
import org.joml.Quaternionf;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.juujks.craft_defense.client.gui.*;

@EventBusSubscriber(Dist.CLIENT)
public class CraftDefenseModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(CraftDefenseModMenus.UPGRADE_UNIT_GUI.get(), UpgradeUnitGUIScreen::new);
		event.register(CraftDefenseModMenus.REWARD_GUI.get(), RewardGUIScreen::new);
		event.register(CraftDefenseModMenus.RAID_MANAGER_GUI.get(), RaidManagerGUIScreen::new);
		event.register(CraftDefenseModMenus.RAID_MANAGER_GUI_2.get(), RaidManagerGUI2Screen::new);
		event.register(CraftDefenseModMenus.RAID_MANAGER_GUI_3.get(), RaidManagerGUI3Screen::new);
		event.register(CraftDefenseModMenus.UNIT_MACHINE_GUI.get(), UnitMachineGUIScreen::new);
		event.register(CraftDefenseModMenus.WELCOME_GUI.get(), WelcomeGUIScreen::new);
		event.register(CraftDefenseModMenus.QUEUE_GUI.get(), QueueGUIScreen::new);
		event.register(CraftDefenseModMenus.RAID_MANAGER_GUI_4.get(), RaidManagerGUI4Screen::new);
		event.register(CraftDefenseModMenus.BLUE_PORTAL_GUI.get(), BluePortalGUIScreen::new);
		event.register(CraftDefenseModMenus.TRAIT_REROLLER_GUI.get(), TraitRerollerGUIScreen::new);
		event.register(CraftDefenseModMenus.RAID_MACHINE_GUI_5.get(), RaidMachineGUI5Screen::new);
		event.register(CraftDefenseModMenus.EVOLUTION_CRYSTAL_GUI.get(), EvolutionCrystalGUIScreen::new);
		event.register(CraftDefenseModMenus.CANDY_GUI.get(), CandyGUIScreen::new);
		event.register(CraftDefenseModMenus.RAID_MANAGER_GUI_6.get(), RaidManagerGUI6Screen::new);
		event.register(CraftDefenseModMenus.RAID_MANAGER_GUI_7.get(), RaidManagerGUI7Screen::new);
		event.register(CraftDefenseModMenus.CRAFT_DEFENSE_CONFIG_GUI.get(), CraftDefenseConfigGUIScreen::new);
		event.register(CraftDefenseModMenus.UNIT_INFO_GUI.get(), UnitInfoGUIScreen::new);
		event.register(CraftDefenseModMenus.PLAYER_LEVEL_GUI.get(), PlayerLevelGUIScreen::new);
		event.register(CraftDefenseModMenus.QUESTS_GUI.get(), QuestsGUIScreen::new);
		event.register(CraftDefenseModMenus.RAID_MANAGER_GUI_8.get(), RaidManagerGUI8Screen::new);
		event.register(CraftDefenseModMenus.CHALLENGES_GUI.get(), ChallengesGUIScreen::new);
		event.register(CraftDefenseModMenus.UNIT_INCUBATOR_GUI.get(), UnitIncubatorGUIScreen::new);
		event.register(CraftDefenseModMenus.UNIT_RECYCLER_GUI.get(), UnitRecyclerGUIScreen::new);
		event.register(CraftDefenseModMenus.UNIT_EVOLVER_GUI.get(), UnitEvolverGUIScreen::new);
		event.register(CraftDefenseModMenus.MISSION_GUI.get(), MissionGUIScreen::new);
		event.register(CraftDefenseModMenus.FREE_UNITS_GUI.get(), FreeUnitsGUIScreen::new);
	}

	public interface ScreenAccessor {
		void updateMenuState(int elementType, String name, Object elementState);
	}

	public static void renderEntityInInventoryFollowsAngle(GuiGraphics guiGraphics, int x, int y, int scale, float angleXComponent, float angleYComponent, LivingEntity entity) {
		Quaternionf pose = new Quaternionf().rotateZ((float) Math.PI);
		Quaternionf cameraOrientation = new Quaternionf().rotateX(angleYComponent * 20 * ((float) Math.PI / 180F));
		pose.mul(cameraOrientation);
		float f2 = entity.yBodyRot;
		float f3 = entity.getYRot();
		float f4 = entity.getXRot();
		float f5 = entity.yHeadRotO;
		float f6 = entity.yHeadRot;
		entity.yBodyRot = 180.0F + angleXComponent * 20.0F;
		entity.setYRot(180.0F + angleXComponent * 40.0F);
		entity.setXRot(-angleYComponent * 20.0F);
		entity.yHeadRot = entity.getYRot();
		entity.yHeadRotO = entity.getYRot();
		InventoryScreen.renderEntityInInventory(guiGraphics, x, y, scale, new Vector3f(0, 0, 0), pose, cameraOrientation, entity);
		entity.yBodyRot = f2;
		entity.setYRot(f3);
		entity.setXRot(f4);
		entity.yHeadRotO = f5;
		entity.yHeadRot = f6;
	}
}