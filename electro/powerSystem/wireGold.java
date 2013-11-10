package assets.electrolysm.electro.powerSystem;

import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import assets.electrolysm.api.power.wireBaseClass;
import assets.electrolysm.electro.electrolysmCore;

public class wireGold extends wireBaseClass
{
	public boolean power;

	public wireGold(int id, Material mat) {
		super(id, Material.cloth);

		this.setCreativeTab(electrolysmCore.TabElectrolysm);
		this.setUnlocalizedName("wireGold");
	}
	
	public void getPower(World world, int x, int y, int z)
	{
		//this block sits here and looks pretty :)
	}

}
