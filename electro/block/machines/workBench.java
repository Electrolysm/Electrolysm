package assets.electrolysm.electro.block.machines;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.block.machines.tile.TileEntityWorkBench;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class workBench extends BlockContainer {

	public workBench(int id, Material mat) {
		super(id, Material.iron);
		// TODO Auto-generated constructor stub
		this.setCreativeTab(electrolysmCore.TabElectrolysm);
		this.setUnlocalizedName("workBench");
	}
    
    	@Override
    	@SideOnly(Side.CLIENT)
        public void registerIcons(IconRegister par1IconRegister)
        {
            this.blockIcon = par1IconRegister.registerIcon("electrolysm:" + "ItemWorkBench");
        }
    	
    	@Override	
		public TileEntity createNewTileEntity(World world) {
			// TODO Auto-generated method stub
			return new TileEntityWorkBench();
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
		
		/**
	     * Called upon block activation (right click on the block.)
	     */
	    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	    {
	        if (par1World.isRemote)
	        {
	            return true;
	        }
	        else
	        {
	            par5EntityPlayer.displayGUIWorkbench(par2, par3, par4);
	            return true;
	        }
	    }

}
