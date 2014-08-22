package electrolysm.electro.oreProccessing;

import java.util.Random;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.IChatComponent;

public class DamageSourceSulphuricAcid extends DamageSource 
{

	public DamageSourceSulphuricAcid(String string) 
	{
		super(string);
	}
	
	public static DamageSource causeSulphuricBurn(EntityPlayer player)
    {
		/*
		player.addPotionEffect(new PotionEffect(Potion.harm.id, 1, 0, false));
		player.addPotionEffect(new PotionEffect(Potion.blindness.id, 1, 100, false));
		player.addPotionEffect(new PotionEffect(Potion.poison.id, 1, 0, false));
		*/
        return new EntityDamageSource("sulphuricBurn", player);
    }

	@Override
	public IChatComponent func_151519_b(EntityLivingBase entity)
    {
		Random rand = new Random();
		String message1 = " was burned to death by sulphuric acid!";
		String message2 = " died because of acid burns!";
		String message3 = " was killed by acid burns!";
		String[] message = {message1, message2, message3};
		
		if(entity instanceof EntityPlayer)
		{
			return new ChatComponentTranslation(((EntityPlayer)entity).getDisplayName() + message[rand.nextInt(2)]);
		}
		else
		{
			return new ChatComponentTranslation("Someone died due to acidic burns! But who was it?");
		}
    }
}
