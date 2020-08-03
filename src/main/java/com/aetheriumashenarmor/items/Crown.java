package com.aetheriumashenarmor.items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import v0id.aw.lib.AWConsts;

public class Crown extends ModelBase{
	
	protected static final ResourceLocation crownTexture = new ResourceLocation (AWConsts.modid + ":textures/items/aether_crown.png");
	public ModelRenderer Crown;
	
	public Crown() {
		this.textureWidth = 32;
		this.textureHeight = 32;
		this.Crown = new ModelRenderer(this, 1, 0);
		this.Crown.setRotationPoint(1.0F, 0.0F, 1.0F);
		this.Crown.addBox(-1.0F, -0.0F, -4.05F, 2, 2, 1, 1.0F);
	}
	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
		Minecraft.getMinecraft().renderEngine.bindTexture(crownTexture);
		//System.out.print(crownTexture.toString());
		setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
		this.Crown.render(1);
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		this.Crown.rotateAngleX = 1F;
		this.Crown.rotateAngleY = 4.7F;
		this.Crown.rotateAngleZ = 1F;
	}

	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
	
}
