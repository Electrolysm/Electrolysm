package assets.electrolysm.electro.block.machines;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.block.machines.tile.TileEntityResearchDesk;
import assets.electrolysm.electro.client.ModelResearchDesk;

public class researchDesk extends BlockContainer {

	public researchDesk(int id, Material mat) {
		super(id, Material.iron);
		this.setCreativeTab(electrolysmCore.TabElectrolysm);
		this.setUnlocalizedName("researchDesk");
		this.setHardness(4);
		}

	@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return new TileEntityResearchDesk();
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
			
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
	{
		TileEntityResearchDesk te = new TileEntityResearchDesk();
		if(player.isSneaking())
		{
			return false;
		}
		else if(!player.isSneaking() && !te.isOpen)
		{
            player.openGui(electrolysmCore.GUIInstance, 0, world, x, y, z);
            te.isOpen = true;
            return true;
		}
		else
		{
			return false;
		}
	}
	
	
	public void onBlockPlacedBy(World par1World, int x, int y, int z, EntityLiving par5EntityLiving, ItemStack par6ItemStack)
	{
			ModelResearchDesk model = new ModelResearchDesk();
			ModelRenderer renderer = new ModelRenderer(model);
			Direction dir;
			
	        int l = MathHelper.floor_double((double)(par5EntityLiving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
	
	        if (l == 0)
		    {
	            par1World.setBlockMetadataWithNotify(x, y, z, 2, 2);
	        }
	        
		    if (l == 1)
	        {
	            par1World.setBlockMetadataWithNotify(x, y, z, 5, 2);
	        }
	
		    if (l == 2)
	        {
	            par1World.setBlockMetadataWithNotify(x, y, z, 3, 2);
	        }
	
		    if (l == 3)
		    {
	           par1World.setBlockMetadataWithNotify(x, y, z, 4, 2);
		    }
	 }
}
