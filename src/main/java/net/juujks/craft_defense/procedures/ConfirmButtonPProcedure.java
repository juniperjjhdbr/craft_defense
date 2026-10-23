package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.juujks.craft_defense.network.CraftDefenseModVariables;
import net.juujks.craft_defense.init.CraftDefenseModMenus;
import net.juujks.craft_defense.init.CraftDefenseModItems;
import net.juujks.craft_defense.configuration.CraftDefenseConfigConfiguration;
import net.juujks.craft_defense.CraftDefenseMod;

public class ConfirmButtonPProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (CraftDefenseConfigConfiguration.XP_CANDY.get()) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu1 ? _menu1.getSlots().get(0).getItem() : ItemStack.EMPTY)
					.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("level") > 0) {
				if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).xpToAdd > 0) {
					{
						final String _tagName = "xp";
						final double _tagValue = ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu3 ? _menu3.getSlots().get(0).getItem() : ItemStack.EMPTY)
								.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("xp") + entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).xpToAdd);
						CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu5 ? _menu5.getSlots().get(0).getItem() : ItemStack.EMPTY),
								tag -> tag.putDouble(_tagName, _tagValue));
					}
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(CraftDefenseModItems.COMMON_XP_CANDY.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).commonCandies, _player.inventoryMenu.getCraftSlots());
					}
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(CraftDefenseModItems.RARE_XP_CANDY.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).rareCandies, _player.inventoryMenu.getCraftSlots());
					}
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(CraftDefenseModItems.EPIC_XP_CANDY.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).epicCandies, _player.inventoryMenu.getCraftSlots());
					}
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(CraftDefenseModItems.LEGENDARY_XP_CANDY.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).legendaryCandies, _player.inventoryMenu.getCraftSlots());
					}
					CraftDefenseMod.queueServerWork(1, () -> {
						if (entity instanceof Player _player)
							_player.closeContainer();
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tellraw @s {\"text\":\"XP added sucesfully!\",\"color\":\"green\"}");
							}
						}
						{
							CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
							_vars.xpToAdd = 0;
							_vars.commonCandies = 0;
							_vars.rareCandies = 0;
							_vars.epicCandies = 0;
							_vars.legendaryCandies = 0;
							_vars.markSyncDirty();
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.burp")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.burp")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
					});
				}
			}
		}
	}
}