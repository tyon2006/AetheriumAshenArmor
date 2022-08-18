package com.aetheriumashenarmor.items;

import com.aetheriumashenarmor.AetheriumAshenArmor;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import teamroots.embers.Embers;
import teamroots.embers.item.IModeledItem;

public class AetherItemBase extends Item implements IModeledItem {
	
	public AetherItemBase(String name, boolean addToTab) {
		super();
		setUnlocalizedName(name);
		setRegistryName(AetheriumAshenArmor.MODID+":"+name);
		if (addToTab) {
			setCreativeTab(Embers.tab);
		}
	}

	@Override
	public void initModel() {
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName().toString()));		
	}
	


}
