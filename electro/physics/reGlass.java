package mods.Electrolysm.electro.physics;

import java.util.Random;

import mods.Electrolysm.electro.electrolysmCore;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class reGlass extends Block {

	public reGlass(int id, Material mat) {
		super(id, Material.iron);
		this.setHardness(12);
		this.setResistance(30);
		this.setCreativeTab(electrolysmCore.TabElectrolysmPhysics);
		this.setUnlocalizedName("reglass");
		this.setStepSound(Block.soundGlassFootstep);
		//setTextureFile("/mods/Electrolysm/textures/models/connectedtextures_glass_viewer.png")
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister reg)
	{
			this.blockIcon = reg.registerIcon("Electrolysm:" + this.getUnlocalizedName().replace("tile.", ""));
	}
	 
	 @Override
	 public int quantityDropped(Random par1Random)
	    {
	        return 1;
	    }
		
	 @Override        
     public boolean isOpaqueCube()
	 {
  	   return false;
   	 }
	 
  	public boolean renderAsNomalBlock()
  	{
  		return false;
    }

}
