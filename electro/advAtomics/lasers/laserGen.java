package mods.Electrolysm.electro.advAtomics.lasers;

import cpw.mods.fml.client.FMLClientHandler;
import mods.Electrolysm.electro.electrolysmCore;
import mods.Electrolysm.electro.advAtomics.lasers.TileEntity.TileEntityLaserGen;
import mods.Electrolysm.electro.data.TickRunning;
import mods.Electrolysm.electro.data.data;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class laserGen extends laserCase {

	public static String working;
	int help;
	int check;
	TileEntityLaserGen tileEntity;
	
	public laserGen(int par1, Material par2Material) {
		super(par1, par2Material);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return new TileEntityLaserGen();
	}

    public boolean onBlockActivated(World worldObj, int xCoord, int yCoord, int zCoord, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
    if(player.isSneaking()){
    if(help < 1){
   	 FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage("Some lasers cannot be "
    + "seen with the naked eye; " 
    + "I think this is one of those!");
    }
    }else{
    if(help < 1){
    if(tileEntity.built){
    	this.working = "online.";
    }else{
    	this.working = "offline.";
    }
	 FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage("The laser power system is " + this.working);
    }
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
}
