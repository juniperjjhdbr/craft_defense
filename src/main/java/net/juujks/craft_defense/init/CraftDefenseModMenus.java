/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.juujks.craft_defense.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.registries.Registries;
import net.minecraft.client.Minecraft;

import net.juujks.craft_defense.world.inventory.*;
import net.juujks.craft_defense.network.MenuStateUpdateMessage;
import net.juujks.craft_defense.CraftDefenseMod;

import java.util.Map;

public class CraftDefenseModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, CraftDefenseMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<UpgradeUnitGUIMenu>> UPGRADE_UNIT_GUI = REGISTRY.register("upgrade_unit_gui", () -> IMenuTypeExtension.create(UpgradeUnitGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<RewardGUIMenu>> REWARD_GUI = REGISTRY.register("reward_gui", () -> IMenuTypeExtension.create(RewardGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<RaidManagerGUIMenu>> RAID_MANAGER_GUI = REGISTRY.register("raid_manager_gui", () -> IMenuTypeExtension.create(RaidManagerGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<RaidManagerGUI2Menu>> RAID_MANAGER_GUI_2 = REGISTRY.register("raid_manager_gui_2", () -> IMenuTypeExtension.create(RaidManagerGUI2Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<RaidManagerGUI3Menu>> RAID_MANAGER_GUI_3 = REGISTRY.register("raid_manager_gui_3", () -> IMenuTypeExtension.create(RaidManagerGUI3Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<UnitMachineGUIMenu>> UNIT_MACHINE_GUI = REGISTRY.register("unit_machine_gui", () -> IMenuTypeExtension.create(UnitMachineGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<WelcomeGUIMenu>> WELCOME_GUI = REGISTRY.register("welcome_gui", () -> IMenuTypeExtension.create(WelcomeGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<QueueGUIMenu>> QUEUE_GUI = REGISTRY.register("queue_gui", () -> IMenuTypeExtension.create(QueueGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<RaidManagerGUI4Menu>> RAID_MANAGER_GUI_4 = REGISTRY.register("raid_manager_gui_4", () -> IMenuTypeExtension.create(RaidManagerGUI4Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<BluePortalGUIMenu>> BLUE_PORTAL_GUI = REGISTRY.register("blue_portal_gui", () -> IMenuTypeExtension.create(BluePortalGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TraitRerollerGUIMenu>> TRAIT_REROLLER_GUI = REGISTRY.register("trait_reroller_gui", () -> IMenuTypeExtension.create(TraitRerollerGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<RaidMachineGUI5Menu>> RAID_MACHINE_GUI_5 = REGISTRY.register("raid_machine_gui_5", () -> IMenuTypeExtension.create(RaidMachineGUI5Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<EvolutionCrystalGUIMenu>> EVOLUTION_CRYSTAL_GUI = REGISTRY.register("evolution_crystal_gui", () -> IMenuTypeExtension.create(EvolutionCrystalGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<CandyGUIMenu>> CANDY_GUI = REGISTRY.register("candy_gui", () -> IMenuTypeExtension.create(CandyGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<RaidManagerGUI6Menu>> RAID_MANAGER_GUI_6 = REGISTRY.register("raid_manager_gui_6", () -> IMenuTypeExtension.create(RaidManagerGUI6Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<RaidManagerGUI7Menu>> RAID_MANAGER_GUI_7 = REGISTRY.register("raid_manager_gui_7", () -> IMenuTypeExtension.create(RaidManagerGUI7Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<CraftDefenseConfigGUIMenu>> CRAFT_DEFENSE_CONFIG_GUI = REGISTRY.register("craft_defense_config_gui", () -> IMenuTypeExtension.create(CraftDefenseConfigGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<UnitInfoGUIMenu>> UNIT_INFO_GUI = REGISTRY.register("unit_info_gui", () -> IMenuTypeExtension.create(UnitInfoGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<PlayerLevelGUIMenu>> PLAYER_LEVEL_GUI = REGISTRY.register("player_level_gui", () -> IMenuTypeExtension.create(PlayerLevelGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<QuestsGUIMenu>> QUESTS_GUI = REGISTRY.register("quests_gui", () -> IMenuTypeExtension.create(QuestsGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<RaidManagerGUI8Menu>> RAID_MANAGER_GUI_8 = REGISTRY.register("raid_manager_gui_8", () -> IMenuTypeExtension.create(RaidManagerGUI8Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ChallengesGUIMenu>> CHALLENGES_GUI = REGISTRY.register("challenges_gui", () -> IMenuTypeExtension.create(ChallengesGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<UnitIncubatorGUIMenu>> UNIT_INCUBATOR_GUI = REGISTRY.register("unit_incubator_gui", () -> IMenuTypeExtension.create(UnitIncubatorGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<UnitRecyclerGUIMenu>> UNIT_RECYCLER_GUI = REGISTRY.register("unit_recycler_gui", () -> IMenuTypeExtension.create(UnitRecyclerGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<UnitEvolverGUIMenu>> UNIT_EVOLVER_GUI = REGISTRY.register("unit_evolver_gui", () -> IMenuTypeExtension.create(UnitEvolverGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<MissionGUIMenu>> MISSION_GUI = REGISTRY.register("mission_gui", () -> IMenuTypeExtension.create(MissionGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<FreeUnitsGUIMenu>> FREE_UNITS_GUI = REGISTRY.register("free_units_gui", () -> IMenuTypeExtension.create(FreeUnitsGUIMenu::new));

	public interface MenuAccessor {
		Map<String, Object> getMenuState();

		Map<Integer, Slot> getSlots();

		default void sendMenuStateUpdate(Player player, int elementType, String name, Object elementState, boolean needClientUpdate) {
			getMenuState().put(elementType + ":" + name, elementState);
			if (player instanceof ServerPlayer serverPlayer) {
				PacketDistributor.sendToPlayer(serverPlayer, new MenuStateUpdateMessage(elementType, name, elementState));
			} else if (player.level().isClientSide) {
				if (Minecraft.getInstance().screen instanceof CraftDefenseModScreens.ScreenAccessor accessor && needClientUpdate)
					accessor.updateMenuState(elementType, name, elementState);
				PacketDistributor.sendToServer(new MenuStateUpdateMessage(elementType, name, elementState));
			}
		}

		default <T> T getMenuState(int elementType, String name, T defaultValue) {
			try {
				return (T) getMenuState().getOrDefault(elementType + ":" + name, defaultValue);
			} catch (ClassCastException e) {
				return defaultValue;
			}
		}
	}
}