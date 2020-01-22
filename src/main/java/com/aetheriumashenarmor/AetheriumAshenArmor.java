package com.aetheriumashenarmor;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = AetheriumAshenArmor.MODID, name = AetheriumAshenArmor.NAME, version = AetheriumAshenArmor.VERSION, dependencies = "required-after:embers")
public class AetheriumAshenArmor
{
    public static final String MODID = "aetheriumashenarmor";
    public static final String NAME = "Aetherium Ashen Armor";
    public static final String VERSION = "1.0";

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {

    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        
    }
}
