package mods.Electrolysm.electro.machines;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.Electrolysm.electro.electrolysmCore;
import mods.Electrolysm.electro.machines.entities.tile.TileEntityCrusher;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Crusher extends BlockContainer {
	
	@SideOnly(Side.CLIENT)
    private Icon furnaceIconTop;
    @SideOnly(Side.CLIENT)
    private Icon furnaceIconFront;

	public Crusher(int par1, Material par2Material) {
		super(par1, Material.iron);
		// TODO Auto-generated constructor stub
	this.setCreativeTab(electrolysmCore.TabElectrolysm);
	this.setUnlocalizedName("crusher");
	this.setHardness(3);
	}
	

	@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return new TileEntityCrusher();
	}
	
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
	        {
		
	  TileEntity te = world.getBlockTileEntity(x, y, z);
	  
	  if(te == null)
	  {
	   return false;
	  }
	  if(player.isSneaking())
	  {
		  return false;
	  }
	                player.openGui(electrolysmCore.GUIinstance, 0, world, x, y, z);
	  return true;
	        }
	
	
	@SideOnly(Side.CLIENT)

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public Icon getIcon(int par1, int par2)
    {
        return par1 == 1 ? this.furnaceIconTop : (par1 == 0 ? this.furnaceIconTop : (par1 != par2 ? this.blockIcon : this.furnaceIconFront));
    }

    @SideOnly(Side.CLIENT)

    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("Electrolysm:" + "crusherSide");
        this.furnaceIconFront = par1IconRegister.registerIcon("Electrolysm:" + "crusherSide");
        this.furnaceIconTop = par1IconRegister.registerIcon("Electrolysm:" + "crusherTop");
    }
    
    public boolean canConnectRedstone(IBlockAccess world, int x, int y, int z, int side)
    {
        return true;
    }
}
