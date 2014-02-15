package assets.electrolysm.electro.block.basic;

import java.util.List;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import assets.electrolysm.electro.electrolysmCore;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class blastProof extends BlockContainer {

	@SideOnly(Side.CLIENT)
	public Icon iconBrick;
	
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
    public void registerIcons(IconRegister reg)
    {
		if(!(this.getUnlocalizedName().contains("Glass")))
		{
	        this.blockIcon = reg.registerIcon("electrolysm:" + this.getUnlocalizedName().replace("tile.", ""));
	        this.iconBrick = reg.registerIcon("electrolysm:" + "blastProofBrick");
		}
    }

	@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return null;
	}



}
