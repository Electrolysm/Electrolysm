package mods.Electrolysm.electro.physics.power.ingame;

import mods.Electrolysm.electro.electrolysmCore;
import mods.Electrolysm.electro.physics.power.ingame.entity.TileEntityWire;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class electWire extends BlockContainer {

	public electWire(int id, Material mat) {
		super(id, Material.cloth);
		// TODO Auto-generated constructor stub
	this.setCreativeTab(electrolysmCore.TabElectrolysmPhysics);
	this.setUnlocalizedName("electric Wire");
	this.setStepSound(soundClothFootstep);
	this.setBlockBounds(0.30F, 0.30F, 0.30F, 0.70F, 0.70F, 0.70F);
	}
	
	//You don't want the normal render type, or it wont render properly.
	@Override
	public int getRenderType() {
        	return -1;
	}

	//It's not an opaque cube, so you need this.
	@Override
	public boolean isOpaqueCube() {
			return false;
	}

	//It's not a normal block, so you need this too.
	public boolean renderAsNormalBlock() {
        return false;
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return new TileEntityWire();
	}

}
