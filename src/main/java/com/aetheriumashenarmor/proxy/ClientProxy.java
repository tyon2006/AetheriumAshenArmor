package com.aetheriumashenarmor.proxy;

import java.util.Map;

import com.aetheriumashenarmor.items.crownBaubleRenderer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class ClientProxy extends CommonProxy{
	
	public static RenderPlayer render;

	@Override
	@SideOnly(Side.CLIENT)
	public void init(FMLInitializationEvent event) {

		if(Side.CLIENT.isClient()) {
	        Map<String, RenderPlayer> skinMap = Minecraft.getMinecraft().getRenderManager().getSkinMap();
			RenderPlayer render;
			render = skinMap.get("default");
			render.addLayer(new crownBaubleRenderer(render));
	
			render = skinMap.get("slim");
			render.addLayer(new crownBaubleRenderer(render));
			
			super.init(event);
		}
	}
}

