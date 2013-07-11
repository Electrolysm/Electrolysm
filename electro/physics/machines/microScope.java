package mods.Electrolysm.electro.physics.machines;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.Electrolysm.electro.electrolysmCore;
import mods.Electrolysm.electro.data.data;
import mods.Electrolysm.electro.machines.entities.tile.TileEntityMatterMachine;
import mods.Electrolysm.electro.physics.data.elements;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class microScope extends BlockContainer {

	private static final String itemIDName = "microScope";

	public microScope(int par1) {
		super(par1, Material.iron);
		// TODO Auto-generated constructor stub
	
	this.setCreativeTab(electrolysmCore.TabElectrolysmPhysics);
	this.setUnlocalizedName(itemIDName);
	this.setHardness(3);
	
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return null; //new TileEntityMicroscope();
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