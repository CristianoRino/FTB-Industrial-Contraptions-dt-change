package dev.ftb.mods.ftbic.net;

import dev.ftb.mods.ftbic.FTBIC;
import me.shedaniel.architectury.networking.simple.MessageType;
import me.shedaniel.architectury.networking.simple.SimpleNetworkManager;

public interface FTBICNet {
	SimpleNetworkManager NET = SimpleNetworkManager.create(FTBIC.MOD_ID);

	MessageType MOVE_LASER = NET.registerS2C("move_laser", MoveLaserMessage::new);
	MessageType SELECT_TELEPORTER = NET.registerC2S("select_teleporter", SelectTeleporterMessage::new);
	MessageType SELECT_CRAFTING_RECIPE = NET.registerC2S("select_crafting_recipe", SelectCraftingRecipeMessage::new);

	static void init() {
	}
}
