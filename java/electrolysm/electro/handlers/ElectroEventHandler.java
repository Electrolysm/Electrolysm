package electrolysm.electro.handlers;

import java.io.IOException;
import java.util.Random;

import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import electrolysm.electro.Electrolysm;
import electrolysm.electro.oreProccessing.DamageSourceSulphuricAcid;
import electrolysm.electro.sciences.ItemArmorLab;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.BonemealEvent;
import electrolysm.electro.world.biome.WorldGenDiseasedTree;

public class ElectroEventHandler 
{
	@SubscribeEvent
	public void onEntityUpdate(LivingUpdateEvent event) 
	{
		if (event.entityLiving.isPotionActive(Electrolysm.acidBurns))
		{
			if (event.entityLiving.worldObj.rand.nextInt(20) == 0) 
			{
				event.entityLiving.attackEntityFrom(new DamageSourceSulphuricAcid("DSAcidBurns"), 2);
			}
		}
		if(event.entityLiving instanceof EntityPlayer)
		{
			if(pranks)
			{
				this.ellio98((EntityPlayer)event.entityLiving);
			}
		}
	}
	
	public static boolean isPlayerWearingLabCoat(EntityPlayer player)
	{
		ItemStack labCoat = player.getCurrentArmor(1);
	    return (labCoat != null) && ((labCoat.getItem() instanceof ItemArmorLab));
	}
	
	public static void ellio98(EntityPlayer player)
	{
		if(player.getDisplayName().contains(prankUser))
		{
			//player.rotationYaw = player.rotationYaw + 1;
			//player.motionX = Math.sqrt(player.motionX + (Math.PI * Math.PI)) - rand.nextInt(50);
			//player.motionZ = Math.sqrt(player.motionZ + (Math.PI * Math.PI)) - rand.nextInt(50);
		}
	}
	
	public static boolean pranks = true;
	public static String prankUser = "";
	public static Random rand = new Random();

	@SubscribeEvent
	public void onUpdateEvent(LivingUpdateEvent event) throws IOException
	{/*
		if(event.entity instanceof EntityPlayer)
		{
			String worldName = FMLServerHandler.instance().getServer().getWorldName();
			File dataSaveFile = new File(worldName + "/Electrolysm/Research/");
			dataSaveFile.createNewFile();
			File playerData = new File(dataSaveFile, ((EntityPlayer)event.entity).username + ".txt");
			playerData.createNewFile();
		}*/
	}
	
	@SubscribeEvent
	public void bonemealEvent(BonemealEvent event)
	{
		if(event.block == WorldGenDiseasedTree.treeSapling)
		{
			event.world.setBlockToAir(event.x, event.y, event.z);
			new WorldGenDiseasedTree(true, 6).generate(event.world, rand, event.x, event.y - 1, event.z);
			event.setResult(Event.Result.ALLOW);
		}
	}
	
	
}
