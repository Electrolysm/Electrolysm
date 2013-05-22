package mods.Electrolysm.electro;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class solarCollector extends Block {

	public solarCollector(int par1) {
		super(par1, Material.iron);
		// TODO Auto-generated constructor stub
	
	this.setUnlocalizedName("SolarCollector");
	this.setCreativeTab(electrolysmCore.TabElectrolysm);
	
	}
	private String TextureName;
	private Icon top;
	private Icon sides;
	@SideOnly(Side.CLIENT)
    private Icon furnaceIconTop;
    @SideOnly(Side.CLIENT)
    private Icon furnaceIconFront;
	
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
        this.blockIcon = par1IconRegister.registerIcon("electrolysm:matterMachine");
        this.furnaceIconFront = par1IconRegister.registerIcon("electrolysm:solarCollectorFront");
        this.furnaceIconTop = par1IconRegister.registerIcon("electrolysm:solarCollectorTop");
    }
}
