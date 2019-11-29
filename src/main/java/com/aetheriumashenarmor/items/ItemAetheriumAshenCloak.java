package com.aetheriumashenarmor.items;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.ISpecialArmor;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import teamroots.embers.api.item.IInflictorGem;
import teamroots.embers.api.item.IInflictorGemHolder;
import teamroots.embers.api.item.IInfoGoggles;
import teamroots.embers.model.ModelAshenCloak;

public class ItemAetheriumAshenCloak extends ItemArmorBase implements IInflictorGemHolder, IInfoGoggles, ISpecialArmor {

	public ItemAetheriumAshenCloak(ArmorMaterial material, int reduction, EntityEquipmentSlot slot) {
		super(material, reduction, slot, "ashen_cloak", true);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type){
		return "aetheriumashenarmor:textures/models/armor/robe.png";
	}

	@SideOnly(Side.CLIENT)
	@Override
	public ModelBiped getArmorModel(EntityLivingBase living, ItemStack stack, EntityEquipmentSlot slot, ModelBiped _default){
		return new ModelAshenCloak(slot);
	}

	@Override
	public int getGemSlots(ItemStack holder) {
		return 7;
	}

	@Override
	public boolean canAttachGem(ItemStack holder, ItemStack gem) {
		return gem.getItem() instanceof IInflictorGem;
	}

	@Override
	public void attachGem(ItemStack holder, ItemStack gem, int slot) {
		if (!holder.hasTagCompound()) {
			holder.setTagCompound(new NBTTagCompound());
		}
		holder.getTagCompound().setTag("gem"+slot, gem.writeToNBT(new NBTTagCompound()));
	}

	@Override
	public ItemStack detachGem(ItemStack holder, int slot) {
		if (holder.hasTagCompound() && holder.getTagCompound().hasKey("gem"+slot)) {
			ItemStack gem = new ItemStack(holder.getTagCompound().getCompoundTag("gem"+slot));
			holder.getTagCompound().removeTag("gem"+slot);
			return gem;
		}
		return ItemStack.EMPTY;
	}

	@Override
	public void clearGems(ItemStack holder) {
		NBTTagCompound tagCompound = holder.getTagCompound();
		if(tagCompound == null)
			return;
		for (int i = 1; i <= getGemSlots(holder); i ++){
			if (tagCompound.hasKey("gem"+i)){
				tagCompound.removeTag("gem"+i);
			}
		}
	}

	@Override
	public ItemStack[] getAttachedGems(ItemStack holder) { //Potentially default???
		ItemStack[] stacks = new ItemStack[getGemSlots(holder)];
		for(int i = 1; i <= stacks.length; i++) {
			if(holder.hasTagCompound())
				stacks[i-1] = new ItemStack(holder.getTagCompound().getCompoundTag("gem"+i));
			else
				stacks[i-1] = ItemStack.EMPTY;
		}
		return stacks;
	}

	@Override
	public void setDamage(ItemStack stack, int damage) {
		super.setDamage(stack, Math.min(damage,getMaxDamage(stack) - 1));
	}

	private boolean isBroken(ItemStack armor) {
		return armor.getItemDamage() >= armor.getMaxDamage() - 1;
	}

    private boolean isProtectiveCloakPiece(ItemStack armor)
    {
        if(armor.getItem() instanceof ItemAetheriumAshenCloak)
        {
            ItemAetheriumAshenCloak cloak = (ItemAetheriumAshenCloak) armor.getItem();
            return cloak.isBroken(armor);
        }
        //return false; //this doesnt work
        return false;
    }

	@Override
	public ArmorProperties getProperties(EntityLivingBase player, ItemStack armor, DamageSource source, double damage,
			int slot) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void damageArmor(EntityLivingBase entity, ItemStack stack, DamageSource source, int damage, int slot) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean shouldDisplayInfo(EntityPlayer arg0, ItemStack arg1, EntityEquipmentSlot arg2) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public float getTotalDamageResistance(EntityLivingBase arg0, DamageSource arg1, ItemStack arg2) {
		// TODO Auto-generated method stub
		return 1;
	}
}