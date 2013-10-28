package assets.electrolysm.electro.world;

import assets.electrolysm.electro.electrolysmCore;
import net.minecraft.block.BlockOre;
import net.minecraft.client.renderer.texture.IconRegister;

public class copperOre extends BlockOre {

	public copperOre(int id) {
		super(id);
		
		this.setCreativeTab(electrolysmCore.TabElectrolysm);
		this.setUnlocalizedName("CopperOre");
		this.setHardness(3.0F);
		this.setResistance(10.0F);
		this.setStepSound(soundStoneFootstep);

	}

	
	public void registerIcons(IconRegister reg)
    {
		this.blockIcon = reg.registerIcon("electrolysm:" + "CopperOre");
    }
    
}
	


