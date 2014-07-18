package electro.powerSystem;

import api.powerSystem.interfaces.IPowerCore;
import api.powerSystem.meter.IMeterable;
import electro.Electrolysm;
import electro.handlers.helpers.CollectorHelper;
import electro.research.te.TileEntityCollector;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;
import api.powerSystem.PowerUsage;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class energyMeter extends Item
{
    public energyMeter()
    {
        super();
        this.setCreativeTab(Electrolysm.TabElectrolysm);
        this.setUnlocalizedName("energyMeter");
        this.setMaxStackSize(1);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister reg)
    {
        this.itemIcon = reg.registerIcon("electrolysm:" + "energyMeter");
    }

    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x,
                             int y, int z, int par7, float par8, float par9, float par10)
    {
        if (!world.isRemote)
        {
            if (player.isSneaking())
            {
                TileEntity worldTE = world.getTileEntity(x, y, z);

                if(worldTE instanceof IMeterable)
                {
                	//TileEntity for Ore Proccessing
                	IMeterable te = (IMeterable)worldTE;
                	
                	this.printOreMessage(world, x, y, z, te);
                	return true;
                }
                if(worldTE instanceof TileEntityCollector)
                {
                    TileEntityCollector te = (TileEntityCollector)worldTE;

                    this.printMessageCollector(CollectorHelper.getEnvironmentalData(world, x, y, z));
                    return true;
                }
                if(worldTE instanceof IPowerCore)
                {
                    IPowerCore core = (IPowerCore)worldTE;
                    this.printMessagePowerCore(core);
                }
            }
        }

        return false;
    }

    private void printMessagePowerCore(IPowerCore core) {

        String message = "This core is holding: " + core.getTeU() + "TeU";

        FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage(
                new ChatComponentTranslation(message));
    }

    private void printOreMessage(World world, int x, int y, int z, IMeterable te)
	{
		Block block = te.getBlock();
		String message = "This machine requires: " + PowerUsage.getTeUFromMap(block) + "TeU";
		
		FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage(
                new ChatComponentTranslation(message));
	}

    private void printMessageCollector(Object[] objects)
    {
        String rain = "Rainfall: " + Float.valueOf(objects[1].toString());
        String temp = "Temperature: " + Float.valueOf(objects[2].toString());
        String humidity = "Has High Humidity: " + Boolean.valueOf(objects[3].toString());

        FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage(
                new ChatComponentTranslation(rain));
        FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage(
                new ChatComponentTranslation(temp));
        FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage(
                new ChatComponentTranslation(humidity));
    }
	
}