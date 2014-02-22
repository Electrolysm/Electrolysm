package assets.electrolysm.electro.block.basic;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import assets.electrolysm.electro.electrolysmCore;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class stoneObsidian extends Block
{
    public stoneObsidian(int id, Material mat)
    {
        super(id, Material.ground);
        this.setUnlocalizedName("stoneObsidian");
        this.setCreativeTab(electrolysmCore.TabElectrolysm);
        this.setHardness(10F);
        GameRegistry.registerBlock(this);
        LanguageRegistry.addName(this, "Obsidian Embedded Stone");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister reg)
    {
        this.blockIcon = reg.registerIcon("electrolysm:" + "stoneObsidian");
    }
}
