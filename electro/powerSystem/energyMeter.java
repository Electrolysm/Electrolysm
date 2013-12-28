package assets.electrolysm.electro.powerSystem;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.powerSystem.generators.te.TileEntityGenerator;
import assets.electrolysm.electro.powerSystem.te.TileEntityPlug;
import assets.electrolysm.electro.powerSystem.te.TileEntityTeslaTower;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
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
    		}/*
    		else if(worldTE instanceof TileEntityMachine)
    		{
    			TileEntityMachine te = (TileEntityMachine)worldTE;
    			this.printMachineMessage(world, x, y, z, te);
    			return true;
    		}*/
    		else
    		{
    			return false;
    		}
    	}
    	return false;
    }
	/*
    @SideOnly(Side.CLIENT)
    private void printMachineMessage(World world, int x, int y, int z, TileEntityMachine te) 
    {
    	if(world.isRemote)
    	{
    		String message = "This machine is using " + te.powerUsing() + " TeU";
    		
    		FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage(message);	
    	}
    	else
    	{
    		
    	}
    }*/
    
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
		
    	if(world.isRemote)
    	{
    		if(te.isTowerFormed(world, x, y, z))
    		{	
    			if(te.canDistributeRedstone(world, x, y, z))
    			{
    	    		message = "This Tesla Tower is transmitting " + 
    	    				String.valueOf(te.getRecievingTeU(world, x, y, z)) + " TeU";
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
    		
    		FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage(message);	
    	}
    	else
    	{
    		
    	}
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
