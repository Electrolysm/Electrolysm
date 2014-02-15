package assets.electrolysm.electro.research;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import assets.electrolysm.electro.electrolysmCore;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;

public class idifier extends Block {

	@SideOnly(Side.CLIENT)
	private Icon blockTop;
	
	public idifier(int id, Material mat) {
		super(id, Material.iron);

		this.setUnlocalizedName("idifier");
		this.setCreativeTab(electrolysmCore.TabElectrolysm);
		this.setHardness(3.14159F);
	}
	//idifierTop
	//idifierSide
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister reg)
	{
		this.blockIcon = reg.registerIcon("electrolysm:" + "idifierSide");
		this.blockTop = reg.registerIcon("electrolysm:" + "idifierTop");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta)
	{
		if(side == 1 || side == 0)
		{
			return this.blockTop;
		}
		else
		{
			return this.blockIcon;
		}
	}

}
