package mods.Electrolysm.electro.advAtomics.lasers;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.Electrolysm.electro.electrolysmCore;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;

public class laserCase extends Block {
	
	public String nameBefore = "adv." + this.getClass();
	public String name = nameBefore.replace("adv.class mods.Electrolysm.electro.advAtomics.lasers.", "");
	public static Material material = Material.iron;
	public static int hardness = 3;
	
	@SideOnly(Side.CLIENT)
    private Icon top;
    @SideOnly(Side.CLIENT)
    private Icon front;
    @SideOnly(Side.CLIENT)
    private Icon sides;
    public String topID = "_top";
    public String sideID = "_sides";
    public String  frontID = "_front";
	
	public laserCase(int par1, Material par2Material) {
		super(par1, material);
		// TODO Auto-generated constructor stub
	
	this.setUnlocalizedName(name);
	this.setCreativeTab(electrolysmCore.TabElectrolysm);
	this.setHardness(hardness);

	}
	
	
	
    @SideOnly(Side.CLIENT)
	public Icon getIcon(int par1, int par2)
    {
        return par1 == 1 ? this.top : (par1 == 0 ? this.top : (par1 != par2 ? this.sides : this.front));
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.sides = par1IconRegister.registerIcon("Electrolysm:" + name + sideID);
        this.front = par1IconRegister.registerIcon("Electrolysm:" + name + frontID);
        this.top = par1IconRegister.registerIcon("Electrolysm:" + name + topID);
    }

}
