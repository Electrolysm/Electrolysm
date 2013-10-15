package assets.electrolysm.electro.block.machines;

import net.minecraft.block.Block;
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

public class workBench extends Block/*Container*/ {

	public workBench(int id, Material mat) {
		super(id, Material.iron);
		// TODO Auto-generated constructor stub
		this.setCreativeTab(electrolysmCore.TabElectrolysm);
		this.setUnlocalizedName("workBench");
		this.setHardness(4);
	}
    
    	@Override
    	@SideOnly(Side.CLIENT)
        public void registerIcons(IconRegister par1IconRegister)
        {
            this.blockIcon = par1IconRegister.registerIcon("electrolysm:" + "ItemWorkBench");
        }
    	
		public int getRenderType() {
	        	return -1;	
		}

		@Override
		public boolean isOpaqueCube() {
				return false;
		}

		public boolean renderAsNormalBlock() {
	        return false;
		}

/*
		@Override
		public TileEntity createNewTileEntity(World world) {
			// TODO Auto-generated method stub
			return new TileEntityWorkBench();
		}*/
		
		public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
		{
			if(player.isSneaking())
			{
				return false;
			}else{
	            player.openGui(electrolysmCore.GUIInstance, 0, world, x, y, z);
	            return true;
			}
		}
}
