package assets.electrolysm.electro.oreProccessing;

import assets.electrolysm.electro.electrolysmCore;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class electrolChamber extends Block{

	public String className = "" + this.getClass();
	public String unlocalName = className.replace("assets.electrolysm.electro", "");
	public String textureName = unlocalName.replace(".", "/");
	
	public electrolChamber(int par1, Material par2Material) {
		super(par1, Material.iron);

	this.setCreativeTab(electrolysmCore.TabElectrolysm);
	this.setUnlocalizedName(unlocalName);
	this.setHardness(6.0F);
	}


}
