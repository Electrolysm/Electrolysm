package electro.oreProccessing;

import java.util.List;

import assets.electrolysm.electro.electrolysmCore;
import electro.block.GlassBlockConnectedMeta;
import electro.common.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class electrolChamber extends GlassBlockConnectedMeta
{
    public String className = "" + this.getClass();
    public String unlocalName = className.replace("assets.electrolysm.electro", "");
    public String textureName = unlocalName.replace(".", "/");

    public electrolChamber(int par1, String location, boolean hasAlpha,
                           String[] textures)
    {
        super(par1, location, hasAlpha, textures);
        this.setCreativeTab(electrolysmCore.TabElectrolysm);
        this.setUnlocalizedName(unlocalName);
        this.setHardness(6.0F);
        this.setStepSound(Block.soundMetalFootstep);
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister)
    {
        for (int i = 0; i < textures.length; i++)
        {
            icons[i][0] = par1IconRegister.registerIcon("electrolysm:electrol/" + folder + "/electrol");
            icons[i][1] = par1IconRegister.registerIcon("electrolysm:electrol/" + folder + "/glass_1_d");
            icons[i][2] = par1IconRegister.registerIcon("electrolysm:electrol/" + folder + "/glass_1_u");
            icons[i][3] = par1IconRegister.registerIcon("electrolysm:electrol/" + folder + "/glass_1_l");
            icons[i][4] = par1IconRegister.registerIcon("electrolysm:electrol/" + folder + "/glass_1_r");
            icons[i][5] = par1IconRegister.registerIcon("electrolysm:electrol/" + folder + "/glass_2_h");
            icons[i][6] = par1IconRegister.registerIcon("electrolysm:electrol/" + folder + "/glass_2_v");
            icons[i][7] = par1IconRegister.registerIcon("electrolysm:electrol/" + folder + "/glass_2_dl");
            icons[i][8] = par1IconRegister.registerIcon("electrolysm:electrol/" + folder + "/glass_2_dr");
            icons[i][9] = par1IconRegister.registerIcon("electrolysm:electrol/" + folder + "/glass_2_ul");
            icons[i][10] = par1IconRegister.registerIcon("electrolysm:electrol/" + folder + "/glass_2_ur");
            icons[i][11] = par1IconRegister.registerIcon("electrolysm:electrol/" + folder + "/glass_3_d");
            icons[i][12] = par1IconRegister.registerIcon("electrolysm:electrol/" + folder + "/glass_3_u");
            icons[i][13] = par1IconRegister.registerIcon("electrolysm:electrol/" + folder + "/glass_3_l");
            icons[i][14] = par1IconRegister.registerIcon("electrolysm:electrol/" + folder + "/glass_3_r");
            icons[i][15] = par1IconRegister.registerIcon("electrolysm:electrol/" + folder + "/glass_4");
        }
    }

    public void getSubItems(int id, CreativeTabs creativeTab, List list)
    {
        list.add(new ItemStack(this));
    }
}
