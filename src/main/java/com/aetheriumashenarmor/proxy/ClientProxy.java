package com.aetheriumashenarmor.proxy;


public class ClientProxy extends CommonProxy{
	
	/* Uncomment this when crown renderer code is complete
	public static RenderPlayer render;
	@Override
	@SideOnly(Side.CLIENT)
	public void init(FMLInitializationEvent event) {

		if(ConfigManager.doRenderBaublizedCrown == true) {
	        Map<String, RenderPlayer> skinMap = Minecraft.getMinecraft().getRenderManager().getSkinMap();
			RenderPlayer render;
			render = skinMap.get("default");
			render.addLayer(new crownBaubleRenderer(render));
	
			render = skinMap.get("slim");
			render.addLayer(new crownBaubleRenderer(render));
			
			super.init(event);
		}
	}
	*/
}

