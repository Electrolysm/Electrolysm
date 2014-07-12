package electro.world.biome;

import electro.Electrolysm;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockTreeLog extends BlockLog {

	public static int type;
	public String name;
	
	@SideOnly(Side.CLIENT)
	private IIcon[] icon;
	
	public BlockTreeLog(int type1, String unlocalName) {
		super();
		
		this.setCreativeTab(Electrolysm.TabElectrolysm);
		this.setStepSound(Block.soundTypeWood);
        this.setBlockName("diseasedLog");
		this.setHardness(2.0F);
		this.type = type1;
		name = unlocalName;
	}

	@Override
    public int onBlockPlaced(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9)
    {
    	return 0;
    }
	
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
	
    public boolean isOpaqueCube()
    {
        return false;
    }
/*
    @Override
    public int idDropped(Item item, Random par2Random, int par3)
    {
        return WorldGenDiseasedTree.treeLog;
    }*/

}
