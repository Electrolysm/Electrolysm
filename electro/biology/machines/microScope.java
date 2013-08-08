package mods.Electrolysm.electro.biology.machines;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.Electrolysm.electro.electrolysmCore;
import mods.Electrolysm.electro.basic.handlers.data;
import mods.Electrolysm.electro.basic.machines.entities.tile.TileEntityMatterMachine;
import mods.Electrolysm.electro.biology.entity.TileEntityMicroscope;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class microScope extends BlockContainer {

	private static final String itemIDName = "microScope";

	public microScope(int par1) {
		super(par1, Material.iron);
		// TODO Auto-generated constructor stub
	
	this.setCreativeTab(electrolysmCore.TabElectrolysmPhysics);
	this.setUnlocalizedName(itemIDName);
	this.setHardness(3);
	
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return new TileEntityMicroscope();
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

	//This is the icon to use for showing the block in your hand.
	public void registerIcons(IconRegister icon) {
        this.blockIcon = icon.registerIcon("Electrolysm:" + "petriDish");
	}
}