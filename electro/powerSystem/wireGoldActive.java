package assets.electrolysm.electro.powerSystem;

import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import assets.electrolysm.api.power.wireBaseClass;
import assets.electrolysm.electro.electrolysmCore;

public class wireGoldActive extends wireBaseClass {

	public wireGoldActive(int id, Material mat) {
		super(id, Material.cloth);

		this.setUnlocalizedName("wireGoldActive");
	}
	
	@Override
	public void setNetorkPower(World world, int x, int y, int z)
	{
		
	}
}
