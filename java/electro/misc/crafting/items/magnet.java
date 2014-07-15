package electro.misc.crafting.items;

import electro.Electrolysm;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class magnet extends Block {

	@SideOnly(Side.CLIENT)
	private IIcon topIcon;
	
	public magnet() {
		super(Material.iron);

		this.setCreativeTab(Electrolysm.TabElectrolysm);
		this.setHardness(5F);
        this.setResistance(50F);
	}
	
	
    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister reg)
    {
        this.blockIcon = reg.registerIcon("electrolysm:" + "rareEarthMagnetSide");
        this.topIcon = reg.registerIcon("electrolysm:" + "rareEarthMagnetTop");
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int meta)
    {
    	if(side == 0 || side == 1)
    	{
    		return this.topIcon;
    	}
    	else
    	{
    		return this.blockIcon;
    	}
    }

}
