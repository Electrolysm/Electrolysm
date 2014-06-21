package electro.world;

import electro.Electrolysm;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class Yttrium extends Block {

	public Yttrium() {
		super(Material.iron);

		this.setCreativeTab(Electrolysm.TabElectrolysm);
		this.setHardness(12F);
		this.setResistance(12F);
	}

	@Override
    public void registerBlockIcons(IIconRegister reg)
    {
        this.blockIcon = reg.registerIcon("electrolysm:" + "Yttrium");
    }

}
