package assets.electrolysm.electro.oreProccessing;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.common.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class nettedBlock extends Block {

	@SideOnly(Side.CLIENT)
	private Icon[] nettedIcon;
	
	public nettedBlock(int id, Material mat) {
		super(id, Material.rock);

		this.setUnlocalizedName("nettedBlock");
		this.setHardness((float) (1.5 + 0.8));
	}
    
    @Override
    public void getSubBlocks(int id, CreativeTabs creativeTab, List list)
    {
        for (int i = 0; i < 6; i++)
        {
            list.add(new ItemStack(electrolysmCore.nettedBlock, 1, i));
        }
    }

    public int idDropped(int par1, Random par2Random, int par3)
   {
	   return 0;
   }
    
    //		"Copper", "Tin", "Iron", "Gold", "Silver", "Lead"};
    //METAs		0		   1	  2		  3			4		5

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister reg)
    {
        nettedIcon = new Icon[6];

        nettedIcon[0] = reg.registerIcon("electrolysm:netted/" + "netted" + "CopperOre");
        nettedIcon[1] = reg.registerIcon("electrolysm:netted/" + "netted" + "TinOre");
        nettedIcon[2] = reg.registerIcon("electrolysm:netted/" + "netted" + "IronOre");
        nettedIcon[3] = reg.registerIcon("electrolysm:netted/" + "netted" + "GoldOre");
        nettedIcon[4] = reg.registerIcon("electrolysm:netted/" + "netted" + "SilverOre");
        nettedIcon[5] = reg.registerIcon("electrolysm:netted/" + "netted" + "LeadOre");

    }

    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIcon(int side, int meta)
    {
        return nettedIcon[meta];
    }
}
