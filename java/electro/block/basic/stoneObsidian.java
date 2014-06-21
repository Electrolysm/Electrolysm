package electro.block.basic;

import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electro.Electrolysm;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class stoneObsidian extends Block
{
    public stoneObsidian()
    {
        super(Material.ground);
        this.setCreativeTab(Electrolysm.TabElectrolysm);
        this.setHardness(10F);
        LanguageRegistry.addName(this, "Obsidian Embedded Stone");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister reg)
    {
        this.blockIcon = reg.registerIcon("electrolysm:" + "stoneObsidian");
    }
}
