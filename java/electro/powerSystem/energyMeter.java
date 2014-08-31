package electro.powerSystem;

import electrolysm.api.powerSystem.interfaces.IPowerCore;
import electrolysm.api.powerSystem.meter.IMeterable;
import electrolysm.api.powerSystem.prefab.TileEntityGenerator;
import electrolysm.api.powerSystem.tesla.TETeslaTower;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electro.Electrolysm;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;

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
        if (world.isRemote)
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
                if(worldTE instanceof IPowerCore)
                {
                    IPowerCore core = (IPowerCore)worldTE;
                    this.printMessagePowerCore(core);
                    return true;
                }
                if(worldTE instanceof TileEntityGenerator)
                {
                    TileEntityGenerator te = (TileEntityGenerator)worldTE;
                    this.printMessageGenerator(world.getBlock(x, y, z), te);
                    return true;
                }
                if(worldTE instanceof TETeslaTower){
                    TETeslaTower te = (TETeslaTower) worldTE;
                    this.printMessageTesla(te);
                    return true;
                }
            }
        }

        return false;
    }

    private void printMessageTesla(TETeslaTower te) {
        String teu = "Transmitting: %VALUE%TeU";
        String freq = "Frequency: %VALUE%";

        FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage(
                new ChatComponentTranslation(teu.replace("%VALUE%", String.valueOf(te.getTransmitPower()))));
        FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage(
                new ChatComponentTranslation(freq.replace("%VALUE%", String.valueOf(te.getFreqency()))));
    }

    private void printMessageGenerator(Block block, TileEntityGenerator te)
    {
        String message = "This generator can produce: " + "VALUE" + "TeU";
        int teu = PowerUsage.getTeUFromBlock(block);

        FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage(
            new ChatComponentTranslation(message.replace("VALUE", String.valueOf(teu))));
    }

    private void printMessagePowerCore(IPowerCore core) {

        String message = "This core is holding: " + "VALUE" + "TeU";
        String messageAmps = "This core has " + "VALUE" + " Amps";

        if(!core.isCreative()) {
            FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage(
                    new ChatComponentTranslation(message.replace("VALUE", String.valueOf(core.getTeU()))));
            FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage(
                    new ChatComponentTranslation(messageAmps.replace("VALUE", String.valueOf(core.getAmps()))));
        }
        else
        {
            FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage(
                    new ChatComponentTranslation(message.replace("VALUE", "Infinite")));
            FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage(
                    new ChatComponentTranslation(messageAmps.replace("VALUE", String.valueOf(0))));
        }
    }

    private void printOreMessage(World world, int x, int y, int z, IMeterable te)
	{
		Block block = te.getBlock();
        int teu = PowerUsage.getTeUFromBlock(block);
		String message = "This machine requires: " + teu + "TeU";
		
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