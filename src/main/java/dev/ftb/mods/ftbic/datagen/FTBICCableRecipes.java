package dev.ftb.mods.ftbic.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Consumer;

public class FTBICCableRecipes extends FTBICRecipesGen {
	public FTBICCableRecipes(DataGenerator generator) {
		super(generator);
	}

	@Override
	public void add(Consumer<FinishedRecipe> consumer) {
		// Wire from metal

		ShapedRecipeBuilder.shaped(COPPER_WIRE, 6)
				.unlockedBy("has_item", has(COPPER_INGOT))
				.group(MODID + ":copper_wire")
				.pattern("MMM")
				.define('M', COPPER_INGOT)
				.save(consumer, shapedLoc("copper_wire"));

		ShapedRecipeBuilder.shaped(ALUMINUM_WIRE, 6)
				.unlockedBy("has_item", has(ALUMINUM_INGOT))
				.group(MODID + ":aluminum_wire")
				.pattern("MMM")
				.define('M', ALUMINUM_INGOT)
				.save(consumer, shapedLoc("aluminum_wire"));

		ShapedRecipeBuilder.shaped(GOLD_WIRE, 6)
				.unlockedBy("has_item", has(GOLD_INGOT))
				.group(MODID + ":gold_wire")
				.pattern("MMM")
				.define('M', GOLD_INGOT)
				.save(consumer, shapedLoc("gold_wire"));

		ShapedRecipeBuilder.shaped(ENDERIUM_WIRE, 6)
				.unlockedBy("has_item", has(ENDERIUM_INGOT))
				.group(MODID + ":enderium_wire")
				.pattern("MMM")
				.define('M', ENDERIUM_INGOT)
				.save(consumer, shapedLoc("enderium_wire"));

		// Cable from metal + rubber

		ShapedRecipeBuilder.shaped(LV_CABLE, 6)
				.unlockedBy("has_item", has(RUBBER))
				.group(MODID + ":lv_cable")
				.pattern("RRR")
				.pattern("MMM")
				.pattern("RRR")
				.define('R', RUBBER)
				.define('M', COPPER_INGOT)
				.save(consumer, shapedLoc("lv_cable"));

		ShapedRecipeBuilder.shaped(MV_CABLE, 6)
				.unlockedBy("has_item", has(RUBBER))
				.group(MODID + ":mv_cable")
				.pattern("RRR")
				.pattern("MMM")
				.pattern("RRR")
				.define('R', RUBBER)
				.define('M', ALUMINUM_INGOT)
				.save(consumer, shapedLoc("mv_cable"));

		ShapedRecipeBuilder.shaped(HV_CABLE, 6)
				.unlockedBy("has_item", has(RUBBER))
				.group(MODID + ":hv_cable")
				.pattern("RRR")
				.pattern("MMM")
				.pattern("RRR")
				.define('R', RUBBER)
				.define('M', GOLD_INGOT)
				.save(consumer, shapedLoc("hv_cable"));

		ShapedRecipeBuilder.shaped(EV_CABLE, 6)
				.unlockedBy("has_item", has(RUBBER))
				.group(MODID + ":ev_cable")
				.pattern("RRR")
				.pattern("MMM")
				.pattern("RRR")
				.define('R', RUBBER)
				.define('M', ENDERIUM_INGOT)
				.save(consumer, shapedLoc("ev_cable"));

		// Cable from wire + rubber

		ShapelessRecipeBuilder.shapeless(LV_CABLE)
				.unlockedBy("has_item", has(RUBBER))
				.group(MODID + ":lv_cable")
				.requires(COPPER_WIRE)
				.requires(RUBBER)
				.save(consumer, shapelessLoc("lv_cable"));

		ShapelessRecipeBuilder.shapeless(MV_CABLE)
				.unlockedBy("has_item", has(RUBBER))
				.group(MODID + ":mv_cable")
				.requires(ALUMINUM_WIRE)
				.requires(RUBBER)
				.save(consumer, shapelessLoc("mv_cable"));

		ShapelessRecipeBuilder.shapeless(HV_CABLE)
				.unlockedBy("has_item", has(RUBBER))
				.group(MODID + ":hv_cable")
				.requires(GOLD_WIRE)
				.requires(RUBBER)
				.save(consumer, shapelessLoc("hv_cable"));

		ShapelessRecipeBuilder.shapeless(EV_CABLE)
				.unlockedBy("has_item", has(RUBBER))
				.group(MODID + ":ev_cable")
				.requires(ENDERIUM_WIRE)
				.requires(RUBBER)
				.save(consumer, shapelessLoc("ev_cable"));

		// Glass cable

		ShapedRecipeBuilder.shaped(IV_CABLE, 6)
				.unlockedBy("has_item", has(ENERGY_CRYSTAL))
				.group(MODID + ":iv_cable")
				.pattern("GGG")
				.pattern(" C ")
				.pattern("GGG")
				.define('G', GLASS)
				.define('C', ENERGY_CRYSTAL)
				.save(consumer, shapedLoc("iv_cable"));

		// Burnt cable

		ShapelessRecipeBuilder.shapeless(SCRAP)
				.unlockedBy("has_item", has(BURNT_CABLE))
				.group(MODID + ":scrap")
				.requires(BURNT_CABLE)
				.save(consumer, shapelessLoc("scrap_from_burnt_cable"));

		// Wire extruding

		MachineRecipeBuilder.extruding()
				.unlockedBy("has_item", has(COPPER_PLATE))
				.inputItem(Ingredient.of(COPPER_PLATE))
				.outputItem(new ItemStack(COPPER_WIRE, 2))
				.save(consumer, extrudingLoc("copper_wire"));

		MachineRecipeBuilder.extruding()
				.unlockedBy("has_item", has(GOLD_PLATE))
				.inputItem(Ingredient.of(GOLD_PLATE))
				.outputItem(new ItemStack(GOLD_WIRE, 2))
				.save(consumer, extrudingLoc("gold_wire"));

		MachineRecipeBuilder.extruding()
				.unlockedBy("has_item", has(ALUMINUM_PLATE))
				.inputItem(Ingredient.of(ALUMINUM_PLATE))
				.outputItem(new ItemStack(ALUMINUM_WIRE, 2))
				.save(consumer, extrudingLoc("aluminum_wire"));

		MachineRecipeBuilder.extruding()
				.unlockedBy("has_item", has(ENDERIUM_PLATE))
				.inputItem(Ingredient.of(ENDERIUM_PLATE))
				.outputItem(new ItemStack(ENDERIUM_WIRE, 2))
				.save(consumer, extrudingLoc("enderium_wire"));
	}
}