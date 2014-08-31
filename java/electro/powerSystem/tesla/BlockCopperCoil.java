package electro.powerSystem.tesla;

import electro.Electrolysm;
import electro.misc.block.GlassBlockConnected;
import electro.misc.block.GlassBlockConnectedMeta;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

import java.util.List;

/**
 * Created by Clarky158 on 30/08/2014.
 */
public class BlockCopperCoil extends GlassBlockConnectedMeta {
    public BlockCopperCoil(String name, String... textures) {
        super(null, false, Material.iron, textures);
        this.setHardness(1.235F);
        this.setBlockName(name);
        this.setCreativeTab(Electrolysm.TabElectrolysm);
    }

    @Override
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        for (int i = 0; i < textures.length; i++)
        {
            folder = "copper";
            icons[i][0] = par1IconRegister.registerIcon("electrolysm:coil/" + folder + "/glass");
            icons[i][1] = par1IconRegister.registerIcon("electrolysm:coil/" + folder + "/glass_1_d");
            icons[i][2] = par1IconRegister.registerIcon("electrolysm:coil/" + folder + "/glass_1_u");
            icons[i][3] = par1IconRegister.registerIcon("electrolysm:coil/" + folder + "/glass_1_l");
            icons[i][4] = par1IconRegister.registerIcon("electrolysm:coil/" + folder + "/glass_1_r");
            icons[i][5] = par1IconRegister.registerIcon("electrolysm:coil/" + folder + "/glass_2_h");
            icons[i][6] = par1IconRegister.registerIcon("electrolysm:coil/" + folder + "/glass_2_v");
            icons[i][7] = par1IconRegister.registerIcon("electrolysm:coil/" + folder + "/glass_2_dl");
            icons[i][8] = par1IconRegister.registerIcon("electrolysm:coil/" + folder + "/glass_2_dr");
            icons[i][9] = par1IconRegister.registerIcon("electrolysm:coil/" + folder + "/glass_2_ul");
            icons[i][10] = par1IconRegister.registerIcon("electrolysm:coil/" + folder + "/glass_2_ur");
            //icons[i][11] = par1IconRegister.registerIcon("electrolysm:coil/" + folder + "/glass_3_d");
            //icons[i][12] = par1IconRegister.registerIcon("electrolysm:coil/" + folder + "/glass_3_u");
            //icons[i][13] = par1IconRegister.registerIcon("electrolysm:coil/" + folder + "/glass_3_l");
            //icons[i][14] = par1IconRegister.registerIcon("electrolysm:coil/" + folder + "/glass_3_r");
            icons[i][11] = par1IconRegister.registerIcon("electrolysm:coil/" + folder + "/glass");
            icons[i][12] = par1IconRegister.registerIcon("electrolysm:coil/" + folder + "/glass");
            icons[i][13] = par1IconRegister.registerIcon("electrolysm:coil/" + folder + "/glass");
            icons[i][14] = par1IconRegister.registerIcon("electrolysm:coil/" + folder + "/glass");
            icons[i][15] = par1IconRegister.registerIcon("electrolysm:coil/" + folder + "/glass_4");
        }
    }

    public void getSubItems(int id, CreativeTabs creativeTab, List list)
    {
        list.add(new ItemStack(this));
    }
}
