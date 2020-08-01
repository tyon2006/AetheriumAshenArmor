package com.aetheriumashenarmor.proxy;

import java.util.Map;

import com.aetheriumashenarmor.items.crownBaubleRenderer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;


public class ClientProxy extends CommonProxy{

	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);
		
        Map<String, RenderPlayer> skinMap = Minecraft.getMinecraft().getRenderManager().getSkinMap();
		RenderPlayer render;
		render = skinMap.get("default");
		render.addLayer(new crownBaubleRenderer(render));

		render = skinMap.get("slim");
		render.addLayer(new crownBaubleRenderer(render));
	}
}

