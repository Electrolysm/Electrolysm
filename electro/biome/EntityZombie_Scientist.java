package assets.electrolysm.electro.biome;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityZombie_Scientist extends EntityMob {
    
	private float moveSpeed;
	
    public EntityZombie_Scientist(World par1World) {
        super(par1World);
        this.moveSpeed = 0.35F;
        this.setAIMoveSpeed(this.moveSpeed);
        this.getNavigator().setAvoidsWater(false);
        this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityPlayer.class, this.moveSpeed, false));
        this.tasks.addTask(2, new EntityAIWander(this, this.moveSpeed));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
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
    
    public int getAttackStrength(Entity par1Entity) {
        return 14;
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
        switch (this.rand.nextInt(3))
        {
            case 0:
                return (Item.potato.itemID);
            case 1:
            	return (Item.rottenFlesh.itemID);
        }
        return Item.rottenFlesh.itemID;
    }
    
    
}