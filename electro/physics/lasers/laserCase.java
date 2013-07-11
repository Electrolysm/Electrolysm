package mods.Electrolysm.electro.physics.lasers;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.Electrolysm.electro.electrolysmCore;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class laserCase extends BlockContainer {
	
	public String nameBefore = "adv." + this.getClass();
	public String name = nameBefore.replace("adv.class mods.Electrolysm.electro.advAtomics.lasers.", "");
	public static Material material = Material.iron;
	public static int hardness = 3;
	
	@SideOnly(Side.CLIENT)
    public Icon top;
    @SideOnly(Side.CLIENT)
    public Icon front;
    @SideOnly(Side.CLIENT)
    public Icon sides;

	
	public laserCase(int par1, Material par2Material) {
		super(par1, material);
		// TODO Auto-generated constructor stub
	
	this.setUnlocalizedName(name);
	this.setCreativeTab(electrolysmCore.TabElectrolysmPhysics);
	this.setHardness(hardness);
	this.isOpaqueCube();

	}
	

    @SideOnly(Side.CLIENT)
    public Icon getIcon(int par1, int par2)
    {
        return par1 == 1 ? this.top : (par1 == 0 ? this.top : (par1 != par2 ? this.blockIcon : this.front));
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("Electrolysm:" + "laserCase" + "_sides");
        this.front = par1IconRegister.registerIcon("Electrolysm:" + name + "_front");
        this.top = par1IconRegister.registerIcon("Electrolysm:" + "laserCase" + "_top");
    }

    
    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving, ItemStack par6ItemStack)
	{
	        int l = MathHelper.floor_double((double)(par5EntityLiving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

	        if (l == 0)
		    {
	            par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
	        }

		    if (l == 1)
	        {
	            par1World.setBlockMetadataWithNotify(par2, par3, par4, 5, 2);
	        }

		    if (l == 2)
	        {
	            par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
	        }

		    if (l == 3)
		    {
	           par1World.setBlockMetadataWithNotify(par2, par3, par4, 4, 2);
		    }
	 }
    
    public boolean isOpaqueCube()
    {
        return true;
    }


	@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return null;
	}

}
