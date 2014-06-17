package electro.world;

import assets.electrolysm.electro.electrolysmCore;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class Yttrium extends Block {

	public Yttrium(int id, Material mat) {
		super(id, Material.iron);

		this.setCreativeTab(electrolysmCore.TabElectrolysm);
		this.setUnlocalizedName("Yttrium");
		this.setHardness(12F);
		this.setResistance(12F);
	}
	
    public void registerIcons(IconRegister reg)
    {
        this.blockIcon = reg.registerIcon("electrolysm:" + "Yttrium");
    }

}
