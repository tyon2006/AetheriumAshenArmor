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
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.layers.LayerArmorBase;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import v0id.aw.common.item.AWItems;
import v0id.aw.lib.AWConsts;

//public class crownBaubleRenderer implements LayerRenderer<EntityPlayer> {
public class crownBaubleRenderer implements LayerRenderer<EntityPlayer> {

	protected final RenderPlayer renderer;
	protected static final ResourceLocation awCrownResource = new ResourceLocation (AWConsts.modid, "textures/armor/aether_crown.png");
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
					this.renderCrown(player, limbSwing, limbSwingAmount, partialTicks, ageInTicks, netHeadYaw, headPitch, scale);
				}
			}
		}
		/*
		GlStateManager.pushMatrix();
		GlStateManager.rotate(180, 0, 0, 1);
		GlStateManager.scale(0.6, 0.6, 0.6);
		GlStateManager.rotate((ageInTicks) / 20.0F * (180F / (float)Math.PI), 0.0F, 1.0F, 0.0F);
		GlStateManager.translate(0, player.height - 0.3, 0);
		Minecraft.getMinecraft().getRenderItem().renderItem(new ItemStack(AWItems.CROWN), ItemCameraTransforms.TransformType.FIXED);
		GlStateManager.popMatrix();*/
		
	}
	

	
	protected void renderCrown(EntityPlayer player, float limbSwing, float limbSwingAmount,
			float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		
		model.setModelAttributes(this.renderer.getMainModel());

        this.renderer.bindTexture(awCrownResource);
		model.setLivingAnimations(player, limbSwing, limbSwingAmount, partialTicks);
		model.bipedHead.showModel = true;
		model.bipedHeadwear.showModel = true;
		model.bipedHead.render(1);
		
	}

	@Override
	public boolean shouldCombineTextures() {
		// TODO Auto-generated method stub
		return false;
	}

}
