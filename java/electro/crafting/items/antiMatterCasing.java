package electro.crafting.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electro.electrolysmCore;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class antiMatterCasing extends Block {

	public antiMatterCasing() {
		super(Material.iron);

		this.setCreativeTab(electrolysmCore.TabElectrolysm);
        this.setResistance(75F);
        this.setHardness(5.125F);
        this.stepSound = this.soundTypeGlass;
	}
	
    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister reg)
    {
        this.blockIcon = reg.registerIcon("electrolysm:" + "antiMatterGlass");
    }
    
    //It's not an opaque cube, so you need this.
    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    //It's not a normal block, so you need this too.
    public boolean renderAsNormalBlock()
    {
        return false;
    }

}
