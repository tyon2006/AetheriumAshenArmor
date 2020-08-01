package com.aetheriumashenarmor.recipe;
import com.aetheriumashenarmor.init.ModItems;
import com.aetheriumashenarmor.ConfigManager;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;

import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import teamroots.embers.recipe.RecipeRegistry;
import v0id.aw.common.fluid.AWFluids;

import teamroots.embers.RegistryManager;

@Mod.EventBusSubscriber
public class AAARecipeRegistry{
	
	@SubscribeEvent
	public static void init(RegistryEvent.Register<IRecipe> event){
		
		Ingredient stampBar = Ingredient.fromItem(RegistryManager.stamp_bar);
		Ingredient ashenGoggles = Ingredient.fromItem(RegistryManager.ashen_cloak_head);
		Ingredient ashenChestPlate = Ingredient.fromItem(RegistryManager.ashen_cloak_chest);
		Ingredient ashenLeggings = Ingredient.fromItem(RegistryManager.ashen_cloak_legs);
		Ingredient ashenBoots = Ingredient.fromItem(RegistryManager.ashen_cloak_boots);
		
		if (ConfigManager.doRegisterStamperRecipe) {
			FluidStack aetheriumGasFluidStack = new FluidStack(AWFluids.FLUID_AETHERIUM_GAS, ConfigManager.stamperRecipeGasAmount);
			RecipeRegistry.stampingRecipes.add(new NBTItemStampingRecipe(ashenGoggles, aetheriumGasFluidStack, stampBar, new ItemStack(ModItems.AETHERIUM_ASHEN_HELMET,1)));
			RecipeRegistry.stampingRecipes.add(new NBTItemStampingRecipe(ashenChestPlate, aetheriumGasFluidStack, stampBar,new ItemStack(ModItems.AETHERIUM_ASHEN_CHESTPLATE,1)));
			RecipeRegistry.stampingRecipes.add(new NBTItemStampingRecipe(ashenLeggings, aetheriumGasFluidStack, stampBar,new ItemStack(ModItems.AETHERIUM_ASHEN_LEGGINGS,1)));
			RecipeRegistry.stampingRecipes.add(new NBTItemStampingRecipe(ashenBoots, aetheriumGasFluidStack, stampBar,new ItemStack(ModItems.AETHERIUM_ASHEN_BOOTS,1)));
		}
	}
}