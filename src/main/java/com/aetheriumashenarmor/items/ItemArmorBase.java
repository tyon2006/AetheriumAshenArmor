package com.aetheriumashenarmor.items;
import v0id.aw.common.creativetabs.*;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.client.model.ModelLoader;
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
		
		this.setRegistryName("aetheriumashenarmor:"+getUnlocalizedName().substring(5));
		if (addToTab){
			setCreativeTab(AWTabs.TAB_AW);
		}
	}
	
	public void initModel(){
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(),"inventory"));
	}
	
	
}

