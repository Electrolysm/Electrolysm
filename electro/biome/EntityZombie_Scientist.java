package assets.electrolysm.electro.biome;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityZombie_Scientist extends EntityMob {
    
	private float moveSpeed = 0.35F;
	private String texture;
	
	
    public EntityZombie_Scientist(World par1World) {
        super(par1World);
        this.texture = "/assets/electrolysm/textures/mobs/zombie_Scientist.png";
        this.getNavigator().setAvoidsWater(true);
        this.setAIMoveSpeed(this.moveSpeed);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(7.0D);
    
        tasks.addTask(0, new EntityAISwimming(this));
        tasks.addTask(1, new EntityAIAvoidEntity(this, EntityCreeper.class, 8F, 0.3F, 0.35F));
        tasks.addTask(2, new EntityAIOpenDoor(this, true));
        tasks.addTask(3, new EntityAIWander(this, moveSpeed));
        tasks.addTask(4, new EntityAIPanic(this, 0.38F));
        tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 6F));
        tasks.addTask(6, new EntityAILookIdle(this)); 
        tasks.addTask(7, new EntityAIAttackOnCollide(this, moveSpeed, true));
        targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, false));


    }
  
    @Override
    protected String getLivingSound() {
        return "mob.zombie.say";
    }
    
    @Override
    protected String getHurtSound() {
        return "mob.zombie.hurt";
    }
    
    @Override
    protected String getDeathSound() {
        return "mob.zombie.death";
    }
    
    @Override
    protected void playStepSound(int par1, int par2, int par3, int par4) {
        this.worldObj.playSoundAtEntity(this, null, 0.15F, 1.0F);
    }
    
    public int getTatalArmorValue() {
        return 30;
    }
    
    @Override
    protected boolean isAIEnabled() {
        return true;
    }
    
    public int getMaxHealth() {
        return 25;
    }

    
    @Override
    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.UNDEAD;
    }
    /**
     * These will be bacteria items once they have been added
     */
    
    protected int getDropItemId()
    {
        switch (this.rand.nextInt(1))
        {
            case 0:
                return (Item.potato.itemID);
        }
        return Item.rottenFlesh.itemID;
    }
    
    /**
     * Takes a coordinate in and returns a weight to determine how likely this creature will try to path to the block.
     * Args: x, y, z
     */
    @Override
    public float getBlockPathWeight(int x, int y, int z)
    {
    	if(this.isBurning())
    	{
    		World world = this.worldObj;
    		world.createExplosion(this, x, y, z, 5, true);
    	}
        return 0.5F - this.worldObj.getLightBrightness(x, y, z);
    }
    
    /**
     * Finds the closest player within 16 blocks to attack, or null if this Entity isn't interested in attacking
     * (Animals, Spiders at day, peaceful PigZombies).
     */
    @Override
    protected Entity findPlayerToAttack()
    {
    	return this.entityToAttack;
    }
}