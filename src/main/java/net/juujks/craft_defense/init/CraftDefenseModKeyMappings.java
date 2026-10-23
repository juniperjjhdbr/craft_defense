/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.juujks.craft_defense.init;

import org.lwjgl.glfw.GLFW;

import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.juujks.craft_defense.network.ToggleGameSpeedMessage;
import net.juujks.craft_defense.network.SkipWaveKeybindMessage;
import net.juujks.craft_defense.network.PlayerLevelKeybindMessage;
import net.juujks.craft_defense.network.OpenQuestsMessage;

@EventBusSubscriber(Dist.CLIENT)
public class CraftDefenseModKeyMappings {
	public static final KeyMapping SKIP_WAVE_KEYBIND = new KeyMapping("key.craft_defense.skip_wave_keybind", GLFW.GLFW_KEY_V, "key.category.craft_defense.mtd") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new SkipWaveKeybindMessage(0, 0));
				SkipWaveKeybindMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping PLAYER_LEVEL_KEYBIND = new KeyMapping("key.craft_defense.player_level_keybind", GLFW.GLFW_KEY_B, "key.category.craft_defense.mtd") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new PlayerLevelKeybindMessage(0, 0));
				PlayerLevelKeybindMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping TOGGLE_GAME_SPEED = new KeyMapping("key.craft_defense.toggle_game_speed", GLFW.GLFW_KEY_N, "key.category.craft_defense.mtd") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new ToggleGameSpeedMessage(0, 0));
				ToggleGameSpeedMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping OPEN_QUESTS = new KeyMapping("key.craft_defense.open_quests", GLFW.GLFW_KEY_M, "key.category.craft_defense.mtd") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new OpenQuestsMessage(0, 0));
				OpenQuestsMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(SKIP_WAVE_KEYBIND);
		event.register(PLAYER_LEVEL_KEYBIND);
		event.register(TOGGLE_GAME_SPEED);
		event.register(OPEN_QUESTS);
	}

	@EventBusSubscriber(Dist.CLIENT)
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(ClientTickEvent.Post event) {
			if (Minecraft.getInstance().screen == null) {
				SKIP_WAVE_KEYBIND.consumeClick();
				PLAYER_LEVEL_KEYBIND.consumeClick();
				TOGGLE_GAME_SPEED.consumeClick();
				OPEN_QUESTS.consumeClick();
			}
		}
	}
}