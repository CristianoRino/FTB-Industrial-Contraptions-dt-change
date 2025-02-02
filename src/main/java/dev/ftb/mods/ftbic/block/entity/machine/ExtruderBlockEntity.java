package dev.ftb.mods.ftbic.block.entity.machine;

import dev.ftb.mods.ftbic.block.FTBICElectricBlocks;
import dev.ftb.mods.ftbic.recipe.MachineRecipeResults;
import dev.ftb.mods.ftbic.recipe.RecipeCache;

public class ExtruderBlockEntity extends MachineBlockEntity {
	public ExtruderBlockEntity() {
		super(FTBICElectricBlocks.EXTRUDER);
	}

	@Override
	public MachineRecipeResults getRecipes(RecipeCache cache) {
		return cache.extruding;
	}
}