package com.aetheriumashenarmor.init;


import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import com.aetheriumashenarmor.items.*;

@Mod.EventBusSubscriber
public class ModItems {

	public static final ArmorMaterial ARMOR_MATERIAL_AETHERIUM = EnumHelper.addArmorMaterial("armor_material_aetherium", "aw:ingot_aether", 
			15, new int[] {4, 6, 8, 4}, 10, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 2.0f);
	
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
	
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public static void registerModels(ModelRegistryEvent event) {
        ((ItemArmorBase) AETHERIUM_ASHEN_BOOTS).initModel();
        ((ItemArmorBase) AETHERIUM_ASHEN_HELMET).initModel();
        ((ItemArmorBase) AETHERIUM_ASHEN_CHESTPLATE).initModel();
        ((ItemArmorBase) AETHERIUM_ASHEN_LEGGINGS).initModel();
	}

	
}
