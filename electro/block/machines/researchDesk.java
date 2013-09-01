package assets.electrolysm.electro.block.machines;

import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.block.machines.tile.TileEntityResearchDesk;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

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
}
