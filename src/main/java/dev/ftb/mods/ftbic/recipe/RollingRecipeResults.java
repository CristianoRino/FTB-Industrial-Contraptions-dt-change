package dev.ftb.mods.ftbic.recipe;

import dev.ftb.mods.ftbic.FTBIC;
import dev.ftb.mods.ftbic.FTBICConfig;
import dev.ftb.mods.ftbic.util.CraftingMaterial;
import dev.ftb.mods.ftbic.util.FTBICUtils;
import dev.ftb.mods.ftbic.util.IngredientWithCount;
import dev.ftb.mods.ftbic.util.StackWithChance;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;

import java.util.List;

public class RollingRecipeResults extends SimpleMachineRecipeResults {
	public RollingRecipeResults() {
		super(FTBICRecipes.ROLLING);
	}

	@Override
	protected void addAdditionalRecipes(Level level, List<MachineRecipe> list) {
		for (CraftingMaterial m : FTBICConfig.MATERIALS.values()) {
			Item plate = FTBICConfig.getItemFromTag(m.plate);
			Item gear = FTBICConfig.getItemFromTag(m.gear);

			if (FTBICConfig.ADD_PLATE_RECIPES && plate != Items.AIR) {
				ResourceLocation id = plate.getRegistryName();

				if (id != null && !FTBICUtils.NO_AUTO_RECIPE.contains(plate)) {
					if (!m.ingot.getValues().isEmpty()) {
						MachineRecipe recipe = new MachineRecipe(recipeSerializer.get(), new ResourceLocation(FTBIC.MOD_ID, "rolling/generated/plate_from_ingot/" + id.getNamespace() + "/" + id.getPath()));
						recipe.inputItems.add(new IngredientWithCount(Ingredient.of(m.ingot), 1));
						recipe.outputItems.add(new StackWithChance(new ItemStack(plate, 2), 1D));
						list.add(recipe);
					}

					if (!m.gem.getValues().isEmpty()) {
						MachineRecipe recipe = new MachineRecipe(recipeSerializer.get(), new ResourceLocation(FTBIC.MOD_ID, "rolling/generated/plate_from_gem/" + id.getNamespace() + "/" + id.getPath()));
						recipe.inputItems.add(new IngredientWithCount(Ingredient.of(m.gem), 1));
						recipe.outputItems.add(new StackWithChance(new ItemStack(plate, 2), 1D));
						list.add(recipe);
					}
				}
			}

			if (FTBICConfig.ADD_GEAR_RECIPES && gear != Items.AIR) {
				ResourceLocation id = gear.getRegistryName();

				if (id != null && !FTBICUtils.NO_AUTO_RECIPE.contains(gear)) {
					if (!m.plate.getValues().isEmpty()) {
						MachineRecipe recipe = new MachineRecipe(recipeSerializer.get(), new ResourceLocation(FTBIC.MOD_ID, "rolling/generated/gear_from_plate/" + id.getNamespace() + "/" + id.getPath()));
						recipe.inputItems.add(new IngredientWithCount(Ingredient.of(m.plate), 4));
						recipe.outputItems.add(new StackWithChance(new ItemStack(gear), 1D));
						list.add(recipe);
					} else if (!m.gem.getValues().isEmpty()) {
						MachineRecipe recipe = new MachineRecipe(recipeSerializer.get(), new ResourceLocation(FTBIC.MOD_ID, "rolling/generated/gear_from_gem/" + id.getNamespace() + "/" + id.getPath()));
						recipe.inputItems.add(new IngredientWithCount(Ingredient.of(m.gem), 2));
						recipe.outputItems.add(new StackWithChance(new ItemStack(gear), 1D));
						list.add(recipe);
					}
				}
			}
		}
	}
}
