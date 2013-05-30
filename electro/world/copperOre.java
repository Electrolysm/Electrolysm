package mods.Electrolysm.electro.world;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.Electrolysm.electro.electrolysmCore;
import mods.Electrolysm.electro.data.data;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class copperOre extends Block {

	private static final String itemIDName = "copperOre";

	public copperOre(int par1) {
		super(par1, Material.iron);
		// TODO Auto-generated constructor stub
	
	this.setCreativeTab(electrolysmCore.TabElectrolysm);
	this.setUnlocalizedName(itemIDName);
	this.setHardness(3);
	}

    
     
    public int quantityDroppedWithBonus(int par1, Random par2Random)
    {
        return this.quantityDropped(par2Random) + par2Random.nextInt(par1 + 4);
    }

  
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return electrolysmCore.copperDust.itemID;
    }
	
	
	
	@Override
	public void registerIcons(IconRegister reg)
	{
			this.blockIcon = reg.registerIcon("Electrolysm:" + itemIDName);
	}


}