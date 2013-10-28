package assets.electrolysm.electro.world;

import assets.electrolysm.electro.electrolysmCore;
import net.minecraft.block.BlockOre;
import net.minecraft.client.renderer.texture.IconRegister;

public class graphite extends BlockOre {

	public graphite(int id) {
		super(id);
		
		this.setCreativeTab(electrolysmCore.TabElectrolysm);
		this.setUnlocalizedName("graphite");
		this.setHardness(5.0F);
		this.setResistance(5.0F);
	}

	
	public void registerIcons(IconRegister reg)
    {
		this.blockIcon = reg.registerIcon("electrolysm:" + "graphite");
    }
    
}
