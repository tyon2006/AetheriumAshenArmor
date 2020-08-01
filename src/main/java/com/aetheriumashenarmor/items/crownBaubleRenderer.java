package com.aetheriumashenarmor.items;

import org.lwjgl.opengl.GL11;

import com.aetheriumashenarmor.ConfigManager;

import baubles.api.BaubleType;
import baubles.api.BaublesApi;
import baubles.api.render.IRenderBauble.Helper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import v0id.aw.common.item.AWItems;
import v0id.aw.lib.AWConsts;

public class crownBaubleRenderer implements LayerRenderer<EntityPlayer> {

	protected final RenderPlayer renderer;
	protected static final ResourceLocation awCrownResource = new ResourceLocation (AWConsts.modid, "inventory");
	protected static ModelBiped model;
	
	public crownBaubleRenderer(RenderPlayer renderPlayer) {
		this.renderer = renderPlayer;
	}
	
	@Override
	public void doRenderLayer(EntityPlayer player, float limbSwing, float limbSwingAmount,
			float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		// TODO Auto-generated method stub
		if (!baubles.common.Config.renderBaubles || player.getActivePotionEffect(MobEffects.INVISIBILITY) != null) return;
		
		int i = player.getBrightnessForRender();
        int j = i % 65536;
        int k = i / 65536;
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float) j, (float) k);
		
		if (ConfigManager.doBaublizeCrown) {
			ItemStack headBauble = BaublesApi.getBaublesHandler(player).getStackInSlot(4);
			if (!headBauble.isEmpty()) {
				if (headBauble.getItem() == AWItems.CROWN) {
					renderCrown(player, partialTicks, awCrownResource);
				}
			}
		}
	}
	
	protected void renderCrown(EntityPlayer player, float partialTicks, ResourceLocation belt) {
		GlStateManager.pushMatrix();
		GL11.glColor3ub((byte) 255, (byte) 255, (byte) 255);
		GlStateManager.color(1F, 1F, 1F, 1F);
		
		Minecraft.getMinecraft().renderEngine.bindTexture(belt);
		Helper.rotateIfSneaking(player);
		
		GlStateManager.translate(0F, 0.2F, 0F);

		float s = 1.05F / 16F;
		GlStateManager.scale(s, s, s);
		
		if (model == null) model = new ModelBiped();
		model.bipedHead.render(1F);
		
		GlStateManager.popMatrix();
	}

	@Override
	public boolean shouldCombineTextures() {
		// TODO Auto-generated method stub
		return false;
	}

}
