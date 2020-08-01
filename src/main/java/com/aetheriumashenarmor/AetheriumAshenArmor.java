package com.aetheriumashenarmor;

import com.aetheriumashenarmor.items.crownBaublizer;
import com.aetheriumashenarmor.proxy.ClientProxy;
import com.aetheriumashenarmor.recipe.AAARecipeRegistry;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;

import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


@Mod(modid = AetheriumAshenArmor.MODID, name = AetheriumAshenArmor.NAME, version = AetheriumAshenArmor.VERSION, dependencies = "required-after:embers")
public class AetheriumAshenArmor
{	
    public static final String MODID = "aetheriumashenarmor";
    public static final String NAME = "Aetherium Ashen Armor";
    public static final String VERSION = "1.0.2";

    public boolean baublesLoaded;

    @SidedProxy(clientSide = "com.aetheriumashenarmor.proxy.ClientProxy", serverSide = "com.aetheriumashenarmor.proxy.CommonProxy")
    public static ClientProxy proxy;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {

    	MinecraftForge.EVENT_BUS.register(new ConfigManager());
    	ConfigManager.init(event.getSuggestedConfigurationFile());
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	   if (Loader.isModLoaded("baubles") && ConfigManager.doBaublizeCrown == true) {
               baublesLoaded = true;
               //crownBaublizer.init();
               System.out.println("successfully registered Aetherworks Crown as Bauble.");
               MinecraftForge.EVENT_BUS.register(new crownBaublizer());
               proxy.init(event);
           }
    }
}
