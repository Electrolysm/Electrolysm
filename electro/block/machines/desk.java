package assets.electrolysm.electro.block.machines;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.block.machines.tile.TileEntityDesk;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class desk extends BlockContainer {

	public desk(int id, Material mat) {
		super(id, Material.iron);
		this.setCreativeTab(electrolysmCore.TabElectrolysm);
		this.setUnlocalizedName("desk");
		this.setHardness(4);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return new TileEntityDesk();
	}
	
	@SideOnly(Side.CLIENT)
    public boolean addBlockHitEffects(World worldObj, MovingObjectPosition target, EffectRenderer effectRenderer)
    {
        return true;
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
