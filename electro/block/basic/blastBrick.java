package assets.electrolysm.electro.block.basic;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.Icon;

public class blastBrick extends blastProof {

	public blastBrick(int id, Material mat) {
		super(id, Material.iron);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta)
	{
		return this.iconBrick;
	}
}
