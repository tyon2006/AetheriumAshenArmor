package com.aetheriumashenarmor;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = AetheriumAshenArmor.MODID, name = AetheriumAshenArmor.NAME, version = AetheriumAshenArmor.VERSION)
public class AetheriumAshenArmor
{
    public static final String MODID = "aetheriumashenarmor";
    public static final String NAME = "Aetherium Ashen Armor";
    public static final String VERSION = "1.0";

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        //MinecraftForge.EVENT_BUS.register(ItemArmorBase.class);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        //logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
        
    }
}
