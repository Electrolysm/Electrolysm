package assets.electrolysm.electro.handlers;

import java.util.EnumSet;
import java.util.Random;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import assets.electrolysm.electro.research.system.ResearchRegistry;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TickHandler implements ITickHandler
{
    private static int times = 0;

    @Override
    public void tickStart(EnumSet<TickType> type, Object... tickData)
    {
        // TODO Auto-generated method stub
    }

    @Override
    public void tickEnd(EnumSet<TickType> type, Object... tickData)
    {
        // TODO Auto-generated method stub
    }

    public void runTestCode()
    {
        new ResearchRegistry(true);
    }

    public static boolean canRun = false;
    public static EntityLivingBase target = null;
    public static EntityLivingBase entity = null;
    
    @Override
    public EnumSet<TickType> ticks()
    {
        //this.runTestCode();

    	this.runEntityExplosion();

    	//System.out.println(ResearchRegistry.getResearchWithName("electrolysis"));

    	if (FMLClientHandler.instance().getClient().inGameHasFocus)
        {
            if (times <= 0)
            {
                if (VersionCheck.chatMessage != null)
                {
                    this.printChatMessage(VersionCheck.chatMessage);
                    times = 100;
                }
/*
                if (NewsCheck.chatMessage != null)
                {
                    this.printChatMessage("Electrolysm News: " + NewsCheck.chatMessage);
                    times = 100;
                }*/
            }
        }

        return null;
    }
    
    int time = 0;
    Random rand = new Random();
    
    private void runEntityExplosion() 
    {  
		if(target != null && target.getHealth() < 1)
		{
        	time = 0;
        	target = null;
        	entity = null;
        	canRun = false;
        	return;
		}        	
    	
    	if(target != null && this.canRun && entity != null)
    	{
    		World world = target.worldObj;
    		System.out.println(target.getDistanceToEntity(entity));
    		
    		if(target.getDistanceToEntity(entity) >= 10 && !(target instanceof EntityHorse))
    		{
    			//this.dropInventory(target);
    			
            	world.createExplosion(target, target.posX + 0.1, target.posY + 0.1, target.posZ + 0.1, 10, true);
            	target.setHealth(target.getHealth() - 5);
            	time = 0;
            	target = null;
            	entity = null;
            	canRun = false;
    		}
    		else
    		{
    			if(entity instanceof EntityPlayerMP)
    			{
    				if(time == 10000)
    				{
    					time = 0;
    					EntityPlayerMP player = (EntityPlayerMP)entity;
    					player.sendChatToPlayer(ChatMessageComponent.createFromText(
    							"Get further from the target!! Your in danger!!").setColor(EnumChatFormatting.RED));
    				}
    				else
    				{
    					time = time + 1;
    				}
    			}
    		}
    	}
	}

	private void dropInventory(EntityLivingBase livingTarget) 
	{
		if(livingTarget instanceof EntityPlayerMP)
		{
			EntityPlayerMP player = (EntityPlayerMP)livingTarget;
			for(int i = 0; i < 9; i++)
			{
				ItemStack stack = player.inventory.getStackInSlot(i);
				player.inventory.setInventorySlotContents(i, null);
				//player.dropPlayerItem(stack);
				livingTarget.dropItemWithOffset(stack.itemID, stack.stackSize, 2F);
			}
		}
	}

	@SideOnly(Side.CLIENT)
    public void printChatMessage(String message)
    {
        FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage(message);
    }

    @Override
    public String getLabel()
    {
        // TODO Auto-generated method stub5
        return null;
    }
}
