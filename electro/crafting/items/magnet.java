package assets.electrolysm.electro.crafting.items;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import assets.electrolysm.electro.electrolysmCore;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class magnet extends Block {

	@SideOnly(Side.CLIENT)
	private Icon topIcon;
	
	public magnet(int par1, Material par2Material) {
		super(par1, Material.iron);

		this.setCreativeTab(electrolysmCore.TabElectrolysm);
		this.setUnlocalizedName("rareEarthMagnet");
		this.setHardness(5F);
        this.setResistance(50F);
	}
	
	
    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IconRegister reg)
    {
        this.blockIcon = reg.registerIcon("electrolysm:" + "rareEarthMagnetSide");
        this.topIcon = reg.registerIcon("electrolysm:" + "rareEarthMagnetTop");
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public Icon getIcon(int side, int meta)
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
