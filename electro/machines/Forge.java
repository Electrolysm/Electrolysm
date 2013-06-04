package mods.Electrolysm.electro.machines;

import mods.Electrolysm.electro.electrolysmCore;
import mods.Electrolysm.electro.machines.entities.tile.TileEntityForge;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class Forge extends BlockContainer {

	public Forge(int par1, Material par2Material) {
		super(par1, Material.iron);
		// TODO Auto-generated constructor stub
	this.setCreativeTab(electrolysmCore.TabElectrolysm);
	this.setUnlocalizedName("Forge");
	}
	
	
	
	@Override
	public void registerIcons(IconRegister reg)
	{
			this.blockIcon = reg.registerIcon("Electrolysm:Forge");
	}



	@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return new TileEntityForge();
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player,
	        int par6, float par7, float par8, float par9)
	        {
	  TileEntity te = world.getBlockTileEntity(x, y, z);
	  if(te == null || player.isSneaking())
	  {
	   return false;
	  }
	                player.openGui(electrolysmCore.GUIinstance, 0, world, x, y, z);
	  return true;
	        }
	

}