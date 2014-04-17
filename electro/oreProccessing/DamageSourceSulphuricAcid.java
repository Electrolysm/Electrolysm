package assets.electrolysm.electro.oreProccessing;

import java.util.Random;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;

public class DamageSourceSulphuricAcid extends DamageSource 
{

	protected DamageSourceSulphuricAcid(String string) 
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
	public ChatMessageComponent getDeathMessage(EntityLivingBase entity)
    {
		Random rand = new Random();
		String message1 = " was burned to death by sulphuric acid!";
		String message2 = " died because of acid burns!";
		String message3 = " was killed by acid burns!";
		String[] message = {message1, message2, message3};
		
		if(entity instanceof EntityPlayer)
		{
			return ChatMessageComponent.createFromText(((EntityPlayer)entity).username + message[rand.nextInt(2)]);
		}
		else
		{
			return ChatMessageComponent.createFromText("Someone died due to acidic burns! But who was it?");
		}
    }
}
