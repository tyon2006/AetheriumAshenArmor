package com.aetheriumashenarmor.init;


import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

//import teamroots.embers.item.ItemArmorBase;
import com.aetheriumashenarmor.items.*;

@Mod.EventBusSubscriber
public class ModItems {

	public static final ArmorMaterial ARMOR_MATERIAL_AETHERIUM = EnumHelper.addArmorMaterial("armor_material_aetherium", "aw:ingot_aether", 
			15, new int[] {5, 5, 5, 5}, 10, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 2.0f);
	
	public static final Item AETHERIUM_ASHEN_BOOTS = new ItemAetheriumAshenCloak(ARMOR_MATERIAL_AETHERIUM, 1, EntityEquipmentSlot.FEET);
	public static final Item AETHERIUM_ASHEN_HELMET = new ItemAetheriumAshenCloak(ARMOR_MATERIAL_AETHERIUM, 1, EntityEquipmentSlot.HEAD);
	public static final Item AETHERIUM_ASHEN_CHESTPLATE = new ItemAetheriumAshenCloak(ARMOR_MATERIAL_AETHERIUM, 1, EntityEquipmentSlot.CHEST);
	public static final Item AETHERIUM_ASHEN_LEGGINGS = new ItemAetheriumAshenCloak(ARMOR_MATERIAL_AETHERIUM, 2, EntityEquipmentSlot.LEGS);
	
	
	@SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(AETHERIUM_ASHEN_BOOTS);
        event.getRegistry().register(AETHERIUM_ASHEN_HELMET);
        event.getRegistry().register(AETHERIUM_ASHEN_CHESTPLATE);
        event.getRegistry().register(AETHERIUM_ASHEN_LEGGINGS);
    }

	
}
