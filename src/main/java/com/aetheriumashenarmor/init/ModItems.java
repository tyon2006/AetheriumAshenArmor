package com.aetheriumashenarmor.init;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
//import teamroots.embers.item.ItemArmorBase;
import com.aetheriumashenarmor.items.ItemArmorBase;

public class ModItems {

	public static final ArmorMaterial ARMOR_MATERIAL_AETHERIUM = EnumHelper.addArmorMaterial("armor_material_aetherium", "aw:ingot_aether", 
			15, new int[] {5, 5, 5, 5}, 10, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 2.0f);
	
	public static final Item AETHERIUM_ASHEN_BOOTS = new ItemArmorBase(ARMOR_MATERIAL_AETHERIUM, 1, EntityEquipmentSlot.FEET, "aetherium_ashen", false);

	
}
