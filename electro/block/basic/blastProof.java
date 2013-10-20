package assets.electrolysm.electro.block.basic;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import assets.electrolysm.electro.electrolysmCore;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class blastProof extends BlockContainer {

	public blastProof(int par1, Material par2Material) {
		super(par1, Material.iron);
		this.setUnlocalizedName("blastProof");
		this.setBlockUnbreakable();
		this.setCreativeTab(electrolysmCore.TabElectrolysm);
		this.setResistance(6000000.0F);
		this.setHardness(9000);
		}

	@Override
	@SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
		if(!(this.getUnlocalizedName().contains("Glass")))
		{
	        this.blockIcon = par1IconRegister.registerIcon("electrolysm:" + this.getUnlocalizedName().replace("tile.", ""));
		}
    }

	@Override
	public TileEntity createNewTileEntity(World world) {
		return null;
	}


}
