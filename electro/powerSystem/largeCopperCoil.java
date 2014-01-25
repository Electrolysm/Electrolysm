package assets.electrolysm.electro.powerSystem;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.block.GlassBlockConnectedMeta;
import assets.electrolysm.electro.powerSystem.generators.te.TileEntityGenerator;
import assets.electrolysm.electro.powerSystem.te.TileEntityCopperCoil;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class largeCopperCoil extends GlassBlockConnectedMeta {

    public largeCopperCoil(int par1, String location, boolean hasAlpha, String... textures)
    {
	    super(par1, location, hasAlpha, textures);
		this.setCreativeTab(electrolysmCore.TabElectrolysm);
		this.setUnlocalizedName("largeCopperCoil");
		this.setHardness(3F);
	}
	
    @Override
    public void registerIcons (IconRegister par1IconRegister)
    {
        for (int i = 0; i < textures.length; i++)
        {
        	this.folder = "copper";
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
            icons[i][11] = par1IconRegister.registerIcon("electrolysm:coil/" + folder + /*"/glass_3_d"*/ "/glass");
            icons[i][12] = par1IconRegister.registerIcon("electrolysm:coil/" + folder + /*"/glass_3_u"*/ "/glass");
            icons[i][13] = par1IconRegister.registerIcon("electrolysm:coil/" + folder + /*"/glass_3_l"*/ "/glass");
            icons[i][14] = par1IconRegister.registerIcon("electrolysm:coil/" + folder + /*"/glass_3_r"*/ "/glass");
            icons[i][15] = par1IconRegister.registerIcon("electrolysm:coil/" + folder + "/glass_4");
        }
    }

}
