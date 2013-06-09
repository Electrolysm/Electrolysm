package mods.Electrolysm.electro.machines;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.Electrolysm.electro.electrolysmCore;
import mods.Electrolysm.electro.machines.entities.tile.TileEntityForge;
import mods.Electrolysm.electro.machines.entities.tile.TileEntityMagmaticExtractor;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class Forge extends BlockContainer {
	
	private static boolean keepInventory = false;
	
	private static String IDName = "forge";
	
	private String TextureName;
	private Icon top;
	private Icon sides;
	@SideOnly(Side.CLIENT)
    private Icon furnaceIconTop;
    @SideOnly(Side.CLIENT)
    private Icon furnaceIconFront;
   private boolean active;
    
	public Forge(int par1, boolean par2) {
		super(par1, Material.iron);
		// TODO Auto-generated constructor stub
	this.active = par2;
	this.setCreativeTab(electrolysmCore.TabElectrolysm);
	this.setUnlocalizedName("Forge");
	this.setHardness(3);
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



	public static void updateFurnaceBlockState(boolean b, World worldObj,
			int xCoord, int yCoord, int zCoord) {
		// TODO Auto-generated method stub
		
	}
	

	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving, ItemStack par6ItemStack)
	{
	        int l = MathHelper.floor_double((double)(par5EntityLiving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
	
	        if (l == 0)
		    {
	            par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
	        }
	        
		    if (l == 1)
	        {
	            par1World.setBlockMetadataWithNotify(par2, par3, par4, 5, 2);
	        }
	
		    if (l == 2)
	        {
	            par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
	        }
	
		    if (l == 3)
		    {
	           par1World.setBlockMetadataWithNotify(par2, par3, par4, 4, 2);
		    }
	 }
	
	public static void updateState(boolean active, World world, int x, int y, int z)
	{
		 int metadata = world.getBlockMetadata(x, y, z);
		 TileEntityMagmaticExtractor tile = (TileEntityMagmaticExtractor)world.getBlockTileEntity(x, y, z);
		 
		 keepInventory = true;
		 if(active)
		 {
		 }
		 else
		 {
		 }
		 
		 keepInventory = false;
		 world.setBlockMetadataWithNotify(x, y, z, metadata, 2);
		 
		 if(tile != null)
		 {
			 tile.validate();
			 world.setBlockTileEntity(x, y, z, tile);
		 }
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
        this.blockIcon = par1IconRegister.registerIcon("Electrolysm:" + IDName);
        this.furnaceIconFront = par1IconRegister.registerIcon("Electrolysm:" + IDName + "Front0");
        this.furnaceIconTop = par1IconRegister.registerIcon("Electrolysm:" + IDName);

    }
	

}