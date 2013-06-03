package mods.Electrolysm.electro.advAtomics.Nano;

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
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class nanoBlock extends Block {

	private static final String itemIDName = "nanoBlock";

	
	public nanoBlock(int par1) {
		super(par1, Material.iron);
		// TODO Auto-generated constructor stub
	
	this.setCreativeTab(electrolysmCore.TabElectrolysm);
	this.setUnlocalizedName(itemIDName);
	this.setHardness(40);
	this.setResistance(10);
	this.setLightValue(0.2F);
	this.isOpaqueCube();
	this.setLightOpacity(1);
	}

	
	public Icon getIcon(int par1, int par2)
	{
		return this.blockIcon;
	}
    
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("Electrolysm:" + itemIDName + "0");

    }
    
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return electrolysmCore.nanoTech.itemID;
    }
    
    public int quantityDroppedWithBonus(int par1, Random par2Random)
    {
        return 4;
    }
    
}