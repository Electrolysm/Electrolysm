package assets.electrolysm.electro.powerSystem;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import assets.electrolysm.api.powerSystem.usageMachine.TileEntityEnergyMachine;
import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.block.te.TileEntityIronFrame;
import assets.electrolysm.electro.oreProccessing.te.TileEntityElectrical;
import assets.electrolysm.electro.powerSystem.generators.te.TileEntityGenerator;
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

                if (worldTE instanceof TileEntityGenerator)
                {
                    TileEntityGenerator te = (TileEntityGenerator)worldTE;
                    //this.printGeneratorMessage(world, String.valueOf(te.getSendTeU(world, x, y, z)));
                    return true;
                }
                else if (worldTE instanceof TileEntityElectrical)
                {
                	TileEntityElectrical te = (TileEntityElectrical)worldTE;
                    this.printMachineMessage(world, x, y, z, te);
                    return true;
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
    private void printMachineMessage(World world, int x, int y, int z, TileEntityElectrical te)
    {
        if (world.isRemote)
        {
            if(te.isActive())
            {
            	String message = "Current Energy Level is: " + te.energy.getEnergy();
                FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage(message);
            }
        }
        else
        {
        }
    }

    @SideOnly(Side.CLIENT)
    private void printGeneratorMessage(World world, String powerSend)
    {
        if (world.isRemote)
        {
            String message = "This generator is producing " + powerSend + " TeU";
            FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage(message);
        }
        else
        {
        }
    }
}
