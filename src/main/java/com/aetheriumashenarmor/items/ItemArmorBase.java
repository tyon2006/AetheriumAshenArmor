package com.aetheriumashenarmor.items;
import net.minecraft.item.Item;

import com.aetheriumashenarmor.AetheriumAshenArmor;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.client.model.ModelLoader;
import teamroots.embers.Embers;
import teamroots.embers.item.IModeledItem;

public class ItemArmorBase extends ItemArmor implements IModeledItem {

	public ItemArmorBase(ArmorMaterial material, int reduction, EntityEquipmentSlot slot, String name, boolean addToTab) {
		super(material, reduction, slot);
		switch(slot){
		case CHEST: {
			setUnlocalizedName(name+"_chest");
			break;
		}
		case FEET:{
			setUnlocalizedName(name+"_boots");
			break;
		}
		case HEAD:{
			setUnlocalizedName(name+"_head");
			break;
		}
		case LEGS:{
			setUnlocalizedName(name+"_legs");
			break;
		}
		default:
			break;
		}
		this.setMaxStackSize(1);
		
		setRegistryName("AetheriumAshenArmor:"+getUnlocalizedName().substring(5));
		if (addToTab){
			setCreativeTab(CreativeTabs.COMBAT);
		}
	}
	
	public void initModel(){
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName().toString()));
	}
}

