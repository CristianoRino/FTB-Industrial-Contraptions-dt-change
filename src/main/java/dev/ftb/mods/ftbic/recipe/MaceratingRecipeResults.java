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

public class MaceratingRecipeResults extends SimpleMachineRecipeResults {
	public MaceratingRecipeResults() {
		super(FTBICRecipes.MACERATING);
	}

	@Override
	protected void addAdditionalRecipes(Level level, List<MachineRecipe> list) {
		for (CraftingMaterial m : FTBICConfig.MATERIALS.values()) {
			Item dust = FTBICConfig.getItemFromTag(m.dust);

			boolean gemFromOre = false;

			if (FTBICConfig.ADD_GEM_FROM_ORE_RECIPES && !m.gem.getValues().isEmpty() && !m.ore.getValues().isEmpty()) {
				Item gem = FTBICConfig.getItemFromTag(m.gem);
				ResourceLocation id = gem == Items.AIR ? null : gem.getRegistryName();

				if (id != null && !FTBICUtils.NO_AUTO_RECIPE.contains(gem)) {
					MachineRecipe recipe = new MachineRecipe(recipeSerializer.get(), new ResourceLocation(FTBIC.MOD_ID, "macerating/generated/gem_from_ore/" + id.getNamespace() + "/" + id.getPath()));
					recipe.inputItems.add(new IngredientWithCount(Ingredient.of(m.ore), 1));
					recipe.outputItems.add(new StackWithChance(new ItemStack(gem, 2), 1D));
					list.add(recipe);
					gemFromOre = true;
				}
			}

			if (!gemFromOre && FTBICConfig.ADD_DUST_FROM_ORE_RECIPES && dust != Items.AIR && !m.ore.getValues().isEmpty()) {
				ResourceLocation id = dust.getRegistryName();

				if (id != null && !FTBICUtils.NO_AUTO_RECIPE.contains(dust)) {
					MachineRecipe recipe = new MachineRecipe(recipeSerializer.get(), new ResourceLocation(FTBIC.MOD_ID, "macerating/generated/dust_from_ore/" + id.getNamespace() + "/" + id.getPath()));
					recipe.inputItems.add(new IngredientWithCount(Ingredient.of(m.ore), 1));
					recipe.outputItems.add(new StackWithChance(new ItemStack(dust, 2), 1D));
					list.add(recipe);
				}
			}

			if (FTBICConfig.ADD_DUST_FROM_MATERIAL_RECIPES && dust != Items.AIR) {
				ResourceLocation id = dust.getRegistryName();

				if (id != null && !FTBICUtils.NO_AUTO_RECIPE.contains(dust)) {
					if (!m.ingot.getValues().isEmpty()) {
						MachineRecipe recipe = new MachineRecipe(recipeSerializer.get(), new ResourceLocation(FTBIC.MOD_ID, "macerating/generated/dust_from_metal/" + id.getNamespace() + "/" + id.getPath()));
						recipe.inputItems.add(new IngredientWithCount(Ingredient.of(m.ingot), 1));
						recipe.outputItems.add(new StackWithChance(new ItemStack(dust, 1), 1D));
						list.add(recipe);
					}

					if (!m.gem.getValues().isEmpty()) {
						MachineRecipe recipe = new MachineRecipe(recipeSerializer.get(), new ResourceLocation(FTBIC.MOD_ID, "macerating/generated/dust_from_gem/" + id.getNamespace() + "/" + id.getPath()));
						recipe.inputItems.add(new IngredientWithCount(Ingredient.of(m.gem), 1));
						recipe.outputItems.add(new StackWithChance(new ItemStack(dust, 1), 1D));
						list.add(recipe);
					}
				}
			}
		}
	}
}
