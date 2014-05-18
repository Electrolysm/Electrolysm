package assets.electrolysm.electro.handlers;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.BonemealEvent;
import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.client.ClientProxy;
import assets.electrolysm.electro.oreProccessing.DamageSourceSulphuricAcid;
import assets.electrolysm.electro.sciences.ItemArmorLab;
import assets.electrolysm.electro.world.biome.WorldGenDiseasedTree;
import cpw.mods.fml.server.FMLServerHandler;

public class ElectroEventHandler 
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
		if(player.username.contains(prankUser))
		{
			//player.rotationYaw = player.rotationYaw + 1;
			//player.motionX = Math.sqrt(player.motionX + (Math.PI * Math.PI)) - rand.nextInt(50);
			//player.motionZ = Math.sqrt(player.motionZ + (Math.PI * Math.PI)) - rand.nextInt(50);
		}
	}
	
	public static boolean pranks = false;
	public static String prankUser = "";
	public static Random rand = new Random();

	@ForgeSubscribe
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
	
	@ForgeSubscribe
	public void bonemealEvent(BonemealEvent event)
	{
		if(event.ID == WorldGenDiseasedTree.treeSapling.blockID)
		{
			event.world.setBlockToAir(event.X, event.Y, event.Z);
			new WorldGenDiseasedTree(true, 6).generate(event.world, rand, event.X, event.Y - 1, event.Z);
			event.setResult(Result.ALLOW);
		}
	}
	
	
}
