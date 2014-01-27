package assets.electrolysm.electro.powerSystem;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import assets.electrolysm.api.powerSystem.TileEntityPlug;
import assets.electrolysm.api.powerSystem.usageMachine.TileEntityEnergyMachine;
import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.block.te.TileEntityIronFrame;
import assets.electrolysm.electro.powerSystem.generators.te.TileEntityGenerator;
import assets.electrolysm.electro.powerSystem.te.TileEntityTeslaTower;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import java.math.BigDecimal;
import cpw.mods.fml.relauncher.SideOnly;

public class energyMeter extends Item {

	public energyMeter(int par1) {
		super(par1);

		this.setCreativeTab(electrolysmCore.TabElectrolysm);
		this.setUnlocalizedName("energyMeter");
		this.setMaxStackSize(1);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg)
	{
		this.itemIcon = reg.registerIcon("electrolysm:" + "energyMeter");
	}
	
	
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x,
    		int y, int z, int par7, float par8, float par9, float par10)
    {
    	if(world.isRemote)
    	{
	    	if(player.isSneaking())
	    	{
	    		TileEntity worldTE = world.getBlockTileEntity(x, y, z);
	    		if(worldTE instanceof TileEntityGenerator)
	    		{
	    			TileEntityGenerator te = (TileEntityGenerator)worldTE;
	    			this.printGeneratorMessage(world, String.valueOf(te.getSendTeU(world, x, y, z)));
	    			return true;
	    		}
	    		else if(worldTE instanceof TileEntityTeslaTower)
	    		{
	    			TileEntityTeslaTower te = (TileEntityTeslaTower)worldTE;
	    			this.printTowerMessage(world, x, y, z,te);
	    			return true;
	    		}
	    		else if(worldTE instanceof TileEntityPlug)
	    		{
	    			TileEntityPlug te = (TileEntityPlug)worldTE;
	    			this.printPlugMessage(world, x, y, z, te);
	    			return true;
	    		}
	    		else if(worldTE instanceof TileEntityEnergyMachine)
	    		{
	    			TileEntityEnergyMachine te = (TileEntityEnergyMachine)worldTE;
	    			this.printMachineMessage(world, x, y, z, te);
	    			return true;
	    		}
	    		else if(worldTE instanceof TileEntityIronFrame)
	    		{
	    			TileEntityIronFrame te = (TileEntityIronFrame)worldTE;
	    			if(te.isTowerBase(world, x, y, z))
	    			{
		    			this.printIronFrameMessage(world, x, y, z, te, true);
		    			return true;
	    			}
	    			else
	    			{
	    				this.printIronFrameMessage(world, x, y, z, te, false);
	    				return true; 
	    			}
	    		}
	    		else
	    		{
	    			return false;
	    		}
	    	}
    	}
    	return false;
    }
	
    @SideOnly(Side.CLIENT)
    private void printIronFrameMessage(World world, int x, int y, int z, TileEntityIronFrame te, boolean isTowerBase) 
    {
    	String message;
    	
		if(world.isRemote)
		{
			if(isTowerBase)
			{
				if(te.isEarthed(world, x, y, z))
				{
					message = "This Iron Frame is currently Earthed.";
				}
				else
				{
					message = "This Iron Frame isn't currently Earthed.";
				}
			}
			else
			{
				message = "This Iron Frame is not the base of a Tesla Tower.";
			}
			FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage(message);
		}
	}

	@SideOnly(Side.CLIENT)
    private void printMachineMessage(World world, int x, int y, int z, TileEntityEnergyMachine te) 
    {
    	if(world.isRemote)
    	{
    		String message1 = "This machine is requires " + te.getActivationEnergy() + " TeU";
    		String message2 = "This machine is using " + te.getActivationEnergy() + "TeU";
    		String messageOn = "This machine is currently working";
    		String messageOff =  "This machine isn't currently working";
    		
    		if(te.isWorking())
    		{
	    		FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage(message2);	
	    		FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage(messageOn);	
    		}
    		else
    		{
	    		FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage(message1);	
	    		FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage(messageOff);	
    		}

    	}
    	else
    	{
    		
    	}
    }
    
    @SideOnly(Side.CLIENT)
    private void printGeneratorMessage(World world, String powerSend) 
    {
    	if(world.isRemote)
    	{
    		String message = "This generator is producing " + powerSend + " TeU";
    		
    		FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage(message);	
    	}
    	else
    	{
    		
    	}
    }
    
    @SideOnly(Side.CLIENT)
    private void printTowerMessage(World world, int x, int y, int z, TileEntityTeslaTower te) 
    {
		String message = "";
        String persentTransmit = "";

    	if(world.isRemote)
    	{
    		if(te.isTowerFormed(world, x, y, z))
    		{	
    			if(te.canDistributeRedstone(world, x, y, z))
    			{
    	    		/*message = "This Tesla Tower is transmitting " +
    	    				String.valueOf(te.getRecievingTeU(world, x, y, z)) + " TeU";
    	    				*/
                    message = "This Tesla Tower is currently storing " + te.getStoredEnergy() + "/" +
                            te.getMaxStoredEnergy() + "(" + this.getPersentage(te) + ")";
                    persentTransmit = "This Tesla Tower is currently opperating at " +
                            te.getPersentageOp(world, x, y, z) + "%";

                }
    			else if(te.canDistribute(world, x, y, z) && !(te.canDistributeRedstone(world, x, y, z)))
    			{
    				message = "This Tesla Tower is formed, but is recieving a redstone signal";
    			}
    			else
    			{
    				message = "This Tesla Tower is formed, but isnt transmitting energy!";
    			}
    		}
    		else
    		{
    			message = "This Tesla Tower isn't correctly formed!";
    		}

            String keyCodeMessgae = "The key code for this Tesla Tower is " + te.getKeyCode(world, x, y, z);

    		FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage(message);
            FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage(keyCodeMessgae);
            FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage(persentTransmit);
    	}
    	else
    	{
    		
    	}
    }

    public String getPersentage(TileEntityTeslaTower te)
    {
        float max = te.getMaxStoredEnergy();
        float stored = te.getStoredEnergy();
        float persent = ((stored * 100) / max);
        persent = persent * 10;
        persent = Math.round(persent);

        return ((persent / 10) + "%");
    }

    
    @SideOnly(Side.CLIENT)
    private void printPlugMessage(World world, int x, int y, int z, TileEntityPlug te) 
    {
    	if(world.isRemote)
    	{
    		String message = "This plug is recieving " + String.valueOf(te.getRecievedTeUAfterResistance(world, x, y, z))
    				+ " TeU";
    		
    		FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage(message);	
    	}
    	else
    	{
    		
    	}
    }
}
