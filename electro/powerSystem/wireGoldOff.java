package assets.electrolysm.electro.powerSystem;

import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import assets.electrolysm.api.power.wireBaseClass;

public class wireGoldOff extends wireBaseClass {

	public wireGoldOff(int id, Material mat) {
		super(id, Material.cloth);

		this.setUnlocalizedName("wireGoldOff");
	}

	@Override
	public void setNetorkPower(World world, int x, int y, int z)
	{

	}
}
