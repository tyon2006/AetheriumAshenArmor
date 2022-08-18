package com.aetheriumashenarmor;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;

public class ConfigManager {
	
	public static Configuration config;

	public static boolean doBaublizeCrown = Loader.isModLoaded("baubles");
	public static boolean doRegisterStamperRecipe = Loader.isModLoaded("baubles");
	public static int stamperRecipeGasAmount = 750;
	public static boolean doRenderBaubleCrown = false;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	public static void init(File configFile) {
		// TODO Auto-generated method stub
		if(config == null)
		{
			config = new Configuration(configFile);
			load();
		}
		
	}
	
	public static void load()
	{		
		//config.addCustomCategoryComment("crown", "Controls if the Aetherium Crown is converted to a bauble. True value allows crown to be requipped as a bauble. False value leaves the crown as the defa");
		doBaublizeCrown = config.getBoolean("doBaublizeAetheriumCrown","Config", true, "Controls if the Aetherium Crown is converted to a bauble. True value allows crown to be equipped in the head bauble slot. False value leaves the crown unmodified.");
		doRegisterStamperRecipe = config.getBoolean("Register Stamper Recipes", "Config", true, "Enable this to turn on the stamper recipes for the aetherium armor");
		stamperRecipeGasAmount = config.getInt("Stamper Recipe Aetherium Gas Cost", "config", 750, 0, 1500, "Controls how much aetherium gas must be in the stamper base and will be consumed to complete the recipe");
		doRenderBaubleCrown = config.getBoolean("doRenderBaublizedAetheriumCrown", "Config", false, "Not currently in use. If you know someone whos good at rendering and wants to help, send em my way. ");
		
		if (config.hasChanged())
		{
			config.save();
		}

	}
	
	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event)
	{
		if(event.getModID().equalsIgnoreCase(AetheriumAshenArmor.MODID))
		{
			load();
		}
	}
}
