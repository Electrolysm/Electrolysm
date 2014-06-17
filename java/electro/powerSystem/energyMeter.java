package electro.powerSystem;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import assets.electrolysm.api.powerSystem.PowerUsage;
import assets.electrolysm.api.powerSystem.meter.IMeterable;
import assets.electrolysm.electro.electrolysmCore;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class energyMeter extends Item
{
    public energyMeter(int par1)
    {
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
        if (world.isRemote)
        {
            if (player.isSneaking())
            {
                TileEntity worldTE = world.getBlockTileEntity(x, y, z);

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
		
		FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage(message);
	}
	
}