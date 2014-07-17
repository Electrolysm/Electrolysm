package electro.misc.crafting;

import java.util.Random;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.BaseAttributeMap;
import net.minecraft.potion.Potion;
import electro.oreProccessing.DamageSourceSulphuricAcid;

public class acidBurns extends Potion {

	public acidBurns(int id, boolean par2, int par3) {
		super(id, par2, par3);
		
		this.setPotionName("Acidic Burns");
		this.setIconIndex(6, 0);
	}
	
	@Override
    public void performEffect(EntityLivingBase entity, int par2)
    {
    	Random rand = new Random();
		entity.attackEntityFrom(new DamageSourceSulphuricAcid("death.attack.sulphuricBurn"), rand.nextInt(3));
    }

	
	@Override
    public void affectEntity(EntityLivingBase entity, EntityLivingBase par2EntityLivingBase, 
    		int par3, double par4)
	{
		Random rand = new Random();
		entity.attackEntityFrom(new DamageSourceSulphuricAcid("death.attack.sulphuricBurn"), rand.nextInt(8));
    }
	
	
    public boolean isInstant()
    {
    	return true;
    }
    
    public void applyAttributesModifiersToEntity(EntityLivingBase entity, BaseAttributeMap par2BaseAttributeMap, int par3)
    {
    	Random rand = new Random();
		entity.attackEntityFrom(new DamageSourceSulphuricAcid("death.attack.sulphuricBurn"), rand.nextInt(8));
    }
}
