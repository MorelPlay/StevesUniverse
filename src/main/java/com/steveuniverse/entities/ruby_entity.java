package com.steveuniverse.entities;

import com.steveuniverse.blocks.ModBlocks;

import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveIndoors;
import net.minecraft.entity.ai.EntityAIMoveTowardsTarget;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAIRestrictOpenDoor;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ruby_entity extends EntityMob{


	public ruby_entity(World u) {
		super(u);
	this.isImmuneToFire = true;
    this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
    this.tasks.addTask(6, new EntityAIWander(this, 0.3D));
    this.tasks.addTask(7, new EntityAIWatchClosest(this, sapphire_entity.class, 8.0F));
    this.tasks.addTask(7, new EntityAILookIdle(this));
    this.tasks.addTask(4, new EntityAIAttackOnCollide(this, 0.4D, true));
    this.tasks.addTask(4, new EntityAIOpenDoor(this, true));
    this.tasks.addTask(3, new EntityAIRestrictOpenDoor(this));
    this.tasks.addTask(2, new EntityAIMoveIndoors(this));
    
	}
	@Override
	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(16.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.0D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(5D);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(200.0D);
    }

	@Override
	protected boolean isAIEnabled(){
		return true;
	}
	
	@Override
	protected String getLivingSound()
    {
        return null;
    }

    @Override
    protected String getHurtSound()
    {
        return null;
    }

    @Override
    protected String getDeathSound()
    {
        return null;
    }
    protected boolean isHurtByFire()
    {
    	return false;
    }
    
    protected boolean canDespawn()
    {
    	return false;
    }
    
    public void onLivingUpdate()
    {
        super.onLivingUpdate();

        int i = MathHelper.floor_double(this.posX);
        int j = MathHelper.floor_double(this.posZ);

        for (i = 0; i < 4; ++i)
        {
            j = MathHelper.floor_double(this.posX + (double)((float)(i % 2 * 2 - 1) * 0.25F));
            int k = MathHelper.floor_double(this.posY);
            int l = MathHelper.floor_double(this.posZ + (double)((float)(i / 2 % 2 * 2 - 1) * 0.25F));

            if (this.worldObj.getBlockMetadata(j, k, l) == 0 && ModBlocks.ash_block.canPlaceBlockAt(this.worldObj, j, k, l))
            {
                this.worldObj.setBlock(j, k, l, ModBlocks.ash_block);
            }
        }
    }
    
   
    	
   
    
    @Override
    public EnumCreatureAttribute getCreatureAttribute()
    {
        return null;
    }
    
   
}

