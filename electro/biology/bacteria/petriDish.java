package mods.Electrolysm.electro.biology.bacteria;

import java.util.Random;

import mods.Electrolysm.electro.electrolysmCore;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class petriDish extends BlockContainer{

	public petriDish(int id, Material material) {
		super(id, Material.glass);
		// TODO Auto-generated constructor stub
		this.setCreativeTab(electrolysmCore.TabElectrolysmBiology);
		this.setHardness(0);
		this.stepSound = Block.soundGlassFootstep;
		this.setUnlocalizedName("petriDish");
	}
	
	 public int idDropped(int par1, Random rand, int par3)
	    {
		  switch (rand.nextInt(4))
		  {
          case 0:
              return (Bacteria.bacteriaFusoR.itemID);
          case 1:
              return (Bacteria.GemmigerR.itemID);
          case 2:
              return (Bacteria.nitrospiraeR.itemID);
          case 3:
        	  return Bacteria.agarResin.itemID;
		  }
		  return 0;
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return new TileEntityPetriDish();
	}
	
	//You don't want the normal render type, or it wont render properly.
    @Override
    public int getRenderType() {
            return -1;
    }
    
    //It's not an opaque cube, so you need this.
    @Override
    public boolean isOpaqueCube() {
            return false;
    }
    
    //It's not a normal block, so you need this too.
    public boolean renderAsNormalBlock() {
            return false;
    }
    
    //This is the icon to use for showing the block in your hand.
    public void registerIcons(IconRegister icon) {
            this.blockIcon = icon.registerIcon("Electrolysm:" + "petriDish");
    }
}
