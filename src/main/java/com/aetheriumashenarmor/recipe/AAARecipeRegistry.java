package com.aetheriumashenarmor.recipe;
import com.aetheriumashenarmor.init.ModItems;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import teamroots.embers.recipe.RecipeRegistry;
import v0id.aw.common.fluid.AWFluids;
import teamroots.embers.recipe.ItemStampingRecipe;
import teamroots.embers.RegistryManager;

@Mod.EventBusSubscriber
public class AAARecipeRegistry{
	
	@SubscribeEvent
	public static void init(RegistryEvent.Register<IRecipe> event){
		
		Ingredient stampBar = Ingredient.fromItem(RegistryManager.stamp_bar);
		Ingredient ashenGogglesIngredient = Ingredient.fromItem(RegistryManager.ashen_cloak_head);
		Ingredient ashenChestPlate = Ingredient.fromItem(RegistryManager.ashen_cloak_chest);
		Ingredient ashenLeggings = Ingredient.fromItem(RegistryManager.ashen_cloak_legs);
		Ingredient ashenBoots = Ingredient.fromItem(RegistryManager.ashen_cloak_boots);
		
		FluidStack aetheriumGasFluidStack = new FluidStack(AWFluids.FLUID_AETHERIUM_GAS, 750);
		ItemStack aetheriumHelmetItemStack = new ItemStack(ModItems.AETHERIUM_ASHEN_HELMET);
		ItemStampingRecipe aetheriumHelmetRecipe = new ItemStampingRecipe(ashenGogglesIngredient, aetheriumGasFluidStack,stampBar,aetheriumHelmetItemStack);
		RecipeRegistry.stampingRecipes.add(aetheriumHelmetRecipe);		
		
		//RecipeRegistry.stampingRecipes.add(new ItemStampingRecipe(ashenGoggles, aetheriumGas,stampBar,new ItemStack(ModItems.AETHERIUM_ASHEN_HELMET,1)));
		RecipeRegistry.stampingRecipes.add(new ItemStampingRecipe(ashenChestPlate, new FluidStack(AWFluids.FLUID_AETHERIUM_GAS, 750),stampBar,new ItemStack(ModItems.AETHERIUM_ASHEN_CHESTPLATE,1)));
		RecipeRegistry.stampingRecipes.add(new ItemStampingRecipe(ashenLeggings, new FluidStack(AWFluids.FLUID_AETHERIUM_GAS, 750),stampBar,new ItemStack(ModItems.AETHERIUM_ASHEN_LEGGINGS,1)));
		RecipeRegistry.stampingRecipes.add(new ItemStampingRecipe(ashenBoots, new FluidStack(AWFluids.FLUID_AETHERIUM_GAS, 750),stampBar,new ItemStack(ModItems.AETHERIUM_ASHEN_BOOTS,1)));

	}
}