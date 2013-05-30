package mods.Electrolysm.electro.machines;

import java.util.Random;

import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import mods.Electrolysm.electro.electrolysmCore;
import mods.Electrolysm.electro.machines.entities.tile.TileEntityMagmaticExtractor;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class magmaticExtractor extends BlockContainer {
	
	private static boolean keepInventory = false;
	private String TextureName;
	private Icon top;
	private Icon sides;
	@SideOnly(Side.CLIENT)
    private Icon furnaceIconTop;
    @SideOnly(Side.CLIENT)
    private Icon furnaceIconFront;

	public magmaticExtractor(int id, String textureName) {
		super(id, Material.rock);
		TextureName = textureName;
		setTickRandomly(true);
		this.setCreativeTab(electrolysmCore.TabElectrolysm);
		this.setUnlocalizedName("magmaticExtractor");
		this.setHardness(10);

	}

	public String getTextureName() {
		return this.TextureName;
	}

	@Override
	public TileEntity createNewTileEntity(World var1) {
		return new TileEntityMagmaticExtractor();
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
        this.blockIcon = par1IconRegister.registerIcon("Electrolysm:magnaticExtractor");
        this.furnaceIconFront = par1IconRegister.registerIcon("Electrolysm:magnaticExtractor");
        this.furnaceIconTop = par1IconRegister.registerIcon("Electrolysm:magnaticExtractorTop");
    }


	@Override
	public void breakBlock(World world, int x, int y, int z, int i, int j) {
		if (!keepInventory) {
			dropItems(world, x, y, z);
		}
		super.breakBlock(world, x, y, z, i, j);
	}

	private void dropItems(World world, int x, int y, int z) {
		Random rand = new Random();

		TileEntity tile_entity = world.getBlockTileEntity(x, y, z);

		if (!(tile_entity instanceof IInventory)) {
			return;
		}

		IInventory inventory = (IInventory) tile_entity;

		for (int i = 0; i < inventory.getSizeInventory(); i++) {
			ItemStack item = inventory.getStackInSlot(i);

			if (item != null && item.stackSize > 0) {
				float rx = rand.nextFloat() * 0.6F + 0.1F;
				float ry = rand.nextFloat() * 0.6F + 0.1F;
				float rz = rand.nextFloat() * 0.6F + 0.1F;

				EntityItem entity_item = new EntityItem(world, x + rx, y + ry,
						z + rz, new ItemStack(item.itemID, item.stackSize,
								item.getItemDamage()));

				if (item.hasTagCompound()) {
					item.setTagCompound((NBTTagCompound) item.getTagCompound()
							.copy());
				}

				float factor = 0.5F;

				entity_item.motionX = rand.nextGaussian() * factor;
				entity_item.motionY = rand.nextGaussian() * factor + 0.2F;
				entity_item.motionZ = rand.nextGaussian() * factor;
				world.spawnEntityInWorld(entity_item);
				item.stackSize = 0;
			}
		}
	}
/*
	public String getTextureFile() {
		return TextureHandler.MACHINE_TEXTURE_A;
	}
*/
	public boolean isHeatProvided(World world, int x, int y, int z) {
		if (world.getBlockId(x, y - 1, z) == Block.lavaStill.blockID
				|| world.getBlockId(x, y - 1, z) == Block.lavaMoving.blockID) {
			return true;
		}
		return false;
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
			 //world.setBlock(x, y, z, BlocksHelper.geothermalOvenActive.blockID);
		 }
		 else
		 {
			// world.setBlock(x, y, z, BlocksHelper.geothermalOven.blockID);
		 }
		 
		 keepInventory = false;
		 world.setBlockMetadataWithNotify(x, y, z, metadata, 2);
		 
		 if(tile != null)
		 {
			 tile.validate();
			 world.setBlockTileEntity(x, y, z, tile);
		 }
	}
}
