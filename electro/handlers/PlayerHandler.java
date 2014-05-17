package assets.electrolysm.electro.handlers;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.client.ClientProxy;
import assets.electrolysm.electro.oreProccessing.DamageSourceSulphuricAcid;
import assets.electrolysm.electro.sciences.ItemArmorLab;

public class PlayerHandler 
{
	@ForgeSubscribe
	public void onEntityUpdate(LivingUpdateEvent event) 
	{
		if (event.entityLiving.isPotionActive(electrolysmCore.acidBurns)) 
		{
			if (event.entityLiving.worldObj.rand.nextInt(20) == 0) 
			{
				event.entityLiving.attackEntityFrom(new DamageSourceSulphuricAcid("DSAcidBurns"), 2);
			}
		}
		
		if(event.entityLiving instanceof EntityPlayer && this.isPlayerWearingLabCoat((EntityPlayer)event.entityLiving))
		{
			ClientProxy.putData((EntityPlayer)event.entityLiving, true);
		}
		else
		{
			ClientProxy.putData((EntityPlayer)event.entityLiving, false);
		}
	}
	
	public static boolean isPlayerWearingLabCoat(EntityPlayer player)
	{
		ItemStack labCoat = player.getCurrentArmor(1);
	    return (labCoat != null) && ((labCoat.getItem() instanceof ItemArmorLab));
	}
	
	public static void ellio98(EntityPlayer player)
	{
		if(player.username.contains("ellio98"))
		{
			//player.rotationYaw = player.rotationYaw + 1;
			//player.motionX = Math.sqrt(player.motionX + (Math.PI * Math.PI)) - rand.nextInt(50);
			//player.motionZ = Math.sqrt(player.motionZ + (Math.PI * Math.PI)) - rand.nextInt(50);
		}
	}
	
	public static boolean trollEllio98 = false;;
	public static Random rand = new Random();
}
