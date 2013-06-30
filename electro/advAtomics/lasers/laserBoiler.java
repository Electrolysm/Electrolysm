package mods.Electrolysm.electro.advAtomics.lasers;

import ic2.api.Direction;
import ic2.api.energy.tile.IEnergySource;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.Electrolysm.electro.electrolysmCore;
import mods.Electrolysm.electro.advAtomics.lasers.TileEntity.TileEntityLaserBoiler;
import mods.Electrolysm.electro.advAtomics.lasers.TileEntity.TileEntityLaserGen;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class laserBoiler extends laserCase implements IEnergySource{

	public static String frontOn;
	public static int help;
	TileEntityLaserBoiler te;
	public static String powerOutMessage = "Currently outputting- " + TileEntityLaserBoiler.canProduce + " -- " + TileEntityLaserBoiler.powerOutput + "--" + TileEntityLaserBoiler.ticksOn;
	
	public laserBoiler(int par1, Material par2Material) {
		super(par1, Material.iron);
		// TODO Auto-generated constructor stub
	}
	
	
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
    	this.blockIcon = par1IconRegister.registerIcon("Electrolysm:" + "laserCase" + "_sides");
        this.top = par1IconRegister.registerIcon("Electrolysm:" + "laserCase" + "_top");
        this.front = par1IconRegister.registerIcon("Electrolysm:" + "laserBoiler_Active");
    }
    
	@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return new TileEntityLaserBoiler();
	}

	@Override
    public boolean onBlockActivated(World worldObj, int xCoord, int yCoord, int zCoord, EntityPlayer player, int par6, float par7, float par8, float par9)
	{
    	if(help < 1){
    		FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage(this.powerOutMessage);
    	}
    	if(help > 1){
            help = 0;
        }
        help = help + 1;
       
       if(help >= 2){
           help = 0;
       	}
		return null != null;
    }
    


	@Override
	public boolean emitsEnergyTo(TileEntity receiver, Direction direction) {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isAddedToEnergyNet() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public int getMaxEnergyOutput() {
		// TODO Auto-generated method stub
		return 200;
	}
}
