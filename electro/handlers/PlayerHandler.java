package assets.electrolysm.electro.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import assets.electrolysm.electro.electrolysmCore;
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
	}
	
	public static boolean isPlayerWearingLabCoat(EntityPlayer player)
	{
		ItemStack labCoat = player.getCurrentArmor(2);
	    return (labCoat != null) && ((labCoat.getItem() instanceof ItemArmorLab));
	}
}
