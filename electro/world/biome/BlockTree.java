package assets.electrolysm.electro.world.biome;

import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import assets.electrolysm.electro.electrolysmCore;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockTree extends Block {

	public static int type;
	public String name;
	@SideOnly(Side.CLIENT)
	private static Icon[] icon = new Icon[3];
	
	public BlockTree(int par1, int type1, String unlocalName) {
		super(par1, getMaterialFromData(type1));
		
		this.setCreativeTab(electrolysmCore.TabElectrolysm);
		this.setUnlocalizedName(unlocalName);
		this.setStepSound(getStepSound(type1));
		//this.setHardness(if(Block.wood.blockHardness>0) : 1);
		this.type = type1;
		name = unlocalName;
	}

	private StepSound getStepSound(int type1) 
	{
		if(type1 == 0)
		{
			return this.soundWoodFootstep;
		}
		else if(type1 == 1)
		{
			return this.soundGrassFootstep;
		}
		else
		{
			return null;
		}
	}

	private static Material getMaterialFromData(int thingy) 
	{
		if(thingy == 0)
		{
			return Material.wood;
		}
		else if(thingy == 1)
		{
			return Material.leaves;
		}
		else
		{
			return null;
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    public Icon getIcon(int side, int meta)
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
    public void registerIcons(IconRegister reg)
    {
		String MOD_ID = "electrolysm:";
		icon[0] = reg.registerIcon(MOD_ID + "treeLeaves");
		icon[1] = reg.registerIcon(MOD_ID + "treeLog1");
		icon[2] = reg.registerIcon(MOD_ID + "treeLog2");
    }
	
    public boolean isOpaqueCube()
    {
        return false;
    }

}
