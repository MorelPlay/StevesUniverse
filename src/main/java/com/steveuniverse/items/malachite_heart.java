package com.steveuniverse.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class malachite_heart extends Item{
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer){

		for(int counter = 1; counter <= 1; counter++){
		if(entityplayer.inventory.getCurrentItem().stackSize == 1){
//		entityplayer.inventory.addItemStackToInventory(new ItemStack( ModItems.malachite_hydro, 1));
//		entityplayer.inventory.addItemStackToInventory(new ItemStack( ModItems.lapis_wings, 1));
		entityplayer.inventory.addItemStackToInventory(new ItemStack( ModItems.jasper_crashhelmet, 1));
		
}
}
		return itemstack;
	}
	
	public boolean hasEffect(ItemStack itemstack)
	{
		 return true;
	}
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5) {
	  super.onUpdate(stack, world, entity, par4, par5);
	  EntityPlayer player = (EntityPlayer) entity;
	  ItemStack equipped = player.getCurrentEquippedItem();
	  if(equipped == stack) {
			  player.addPotionEffect(new PotionEffect(21, 1000, 9));
		}
	} 
}