package electro.crafting.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import assets.electrolysm.electro.electrolysmCore;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class antiMatterCasing extends Block {

	public antiMatterCasing(int par1, Material par2Material) {
		super(par1, Material.iron);

		this.setCreativeTab(electrolysmCore.TabElectrolysm);
		this.setUnlocalizedName("antiMatterCasing");
        this.setResistance(75F);
        this.setHardness(5.125F);
        this.stepSound = this.soundGlassFootstep;
	}
	
    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IconRegister reg)
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
