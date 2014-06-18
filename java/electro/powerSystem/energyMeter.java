package electro.powerSystem;

import api.powerSystem.meter.IMeterable;
import electro.electrolysmCore;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;
import api.powerSystem.PowerUsage;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.awt.color.ICC_ColorSpace;

public class energyMeter extends Item
{
    public energyMeter()
    {
        super();
        this.setCreativeTab(electrolysmCore.TabElectrolysm);
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
            }
        }

        return false;
    }

	private void printOreMessage(World world, int x, int y, int z, IMeterable te) 
	{
		Block block = te.getBlock();
		String message = "This machine requires: " + PowerUsage.getTeUFromMap(block) + "TeU";
		
		FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage(
                IChatComponent.Serializer.func_150699_a(message));
	}
	
}