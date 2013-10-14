package assets.electrolysm.electro.robotics;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.robotics.tile.TileEntitySoldering;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class soldering extends BlockContainer {

	public soldering(int id, Material mat) {
		super(id, Material.iron);
		// TODO Auto-generated constructor stub
		this.setCreativeTab(electrolysmCore.TabElectrolysm);
		this.setUnlocalizedName("soldering");
	}
	@Override
	@SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("Electrolysm:" + this.getUnlocalizedName().replace("item.", ""));
    }
	@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return new TileEntitySoldering();
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
