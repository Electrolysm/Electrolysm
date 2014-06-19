package electro.world.biome;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import electro.electrolysmCore;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockTreeLeaves extends BlockLeaves {

	public static int type;
	public String name;
	
	@SideOnly(Side.CLIENT)
	private IIcon[] icon;
	
	public BlockTreeLeaves(int type1) {
		super();
		
		this.setCreativeTab(electrolysmCore.TabElectrolysm);
		this.setStepSound(Block.soundTypeGrass);
		this.setTickRandomly(true);
		this.setHardness(0.2F);
		this.setLightOpacity(1);
		this.type = type1;
	}

    @Override
    public String[] func_150125_e() { return null; }

	@Override
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
		if(type == 0 || name == "treeLog")
		{
			if(side == 0 || side == 1)
			{
				 return icon[2];
			}
			else
			{
				return icon[1];
			}
		}
		else
		{
			return icon[0];
		}
    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister reg)
    {
		icon = new IIcon[3];
		
		String MOD_ID = "electrolysm:";
		icon[0] = reg.registerIcon(MOD_ID + "treeLeaves");
		icon[1] = reg.registerIcon(MOD_ID + "treeLog1");
		icon[2] = reg.registerIcon(MOD_ID + "treeLog2");
    }
	
	@Override
    public boolean isOpaqueCube()
    {
        return false;
    }
    
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return 0;
    }

}