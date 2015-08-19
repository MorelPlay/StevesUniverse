package com.steveuniverse.items;

import com.steveuniverse.entities.EntityWhip;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class amethyst_whip extends Item {
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		EntityWhip whip = new EntityWhip(player.worldObj, player);
		whip.setThrower(player);
		if (!player.worldObj.isRemote) {
			player.worldObj.spawnEntityInWorld(whip);
		}
		return stack;
	}

}
