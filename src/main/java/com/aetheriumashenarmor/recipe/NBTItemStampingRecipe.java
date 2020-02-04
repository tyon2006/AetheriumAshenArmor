package com.aetheriumashenarmor.recipe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fluids.FluidStack;
import teamroots.embers.recipe.ItemStampingRecipe;



public class NBTItemStampingRecipe extends ItemStampingRecipe{

	public NBTItemStampingRecipe(Ingredient input, FluidStack fluid, Ingredient stamp, ItemStack result) {
		super(input, fluid, stamp, result);
	}
	
	@Override
	public ItemStack getResult(TileEntity tile, ItemStack input, FluidStack fluid, ItemStack stamp) {		
		
		NBTTagCompound newTag = null;
		
		if(input.hasTagCompound()) {
		    newTag = input.getTagCompound().copy();
			this.result.setTagCompound(newTag);
			return this.result;
		}
		return this.result;
	}
}
