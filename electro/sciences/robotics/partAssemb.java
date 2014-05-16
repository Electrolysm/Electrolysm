package assets.electrolysm.electro.sciences.robotics;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import assets.electrolysm.electro.electrolysmCore;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class partAssemb extends Block
{
    public partAssemb(int id, Material mat)
    {
        super(id, Material.iron);
        // TODO Auto-generated constructor stub
        this.setCreativeTab(electrolysmCore.TabElectrolysm);
        this.setUnlocalizedName("partAssemb");
    }
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("Electrolysm:" + this.getUnlocalizedName().replace("item.", ""));
    }
}
