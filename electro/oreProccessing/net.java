package assets.electrolysm.electro.oreProccessing;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;
import assets.electrolysm.electro.electrolysmCore;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class net extends Item {

	public net(int id) {
		super(id);
		
		this.setUnlocalizedName("net");
		this.setCreativeTab(electrolysmCore.TabElectrolysm);
		this.setHasSubtypes(true);
		this.maxStackSize = 1;
	}
	//net
	
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon("electrolysm:" + "net");
    }
	
	//Ore Blocks
    ArrayList<ItemStack> copperOre = OreDictionary.getOres("oreCopper");
    ArrayList<ItemStack> tinOre = OreDictionary.getOres("oreTin");
    ArrayList<ItemStack> silverOre = OreDictionary.getOres("oreSilver");
    ArrayList<ItemStack> leadOre = OreDictionary.getOres("oreLead");
	
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int par7, 
    		float par8, float par9, float par10)
	{
    	System.out.println("test");
    	int id = world.getBlockId(x, y, z);

    	if(id == Block.oreIron.blockID)
    	{
    		this.setBlockWithServerUpdate(world, x, y, z, "ironOre");
        	return true;
    	}
    	if(id == Block.oreGold.blockID)
    	{
    		this.setBlockWithServerUpdate(world, x, y, z, "goldOre");
        	return true;
    	}
    	
    	for (int i = 0; i < copperOre.size(); i++)
        {
            if(id == copperOre.get(i).itemID)
            {
            	this.setBlockWithServerUpdate(world, x, y, z, "copperOre");
            	return true;
            }
        }
        for (int i = 0; i < tinOre.size(); i++)
        {
            if(id == tinOre.get(i).itemID)
            {
            	this.setBlockWithServerUpdate(world, x, y, z, "tinOre");
            	return true;
            }
        }
        for (int i = 0; i < silverOre.size(); i++)
        {
            if(id == silverOre.get(i).itemID)
            {
            	this.setBlockWithServerUpdate(world, x, y, z, "silverOre");
            	return true;
            }
        }
        for (int i = 0; i < leadOre.size(); i++)
        {
            if(id == leadOre.get(i).itemID)
            {
            	this.setBlockWithServerUpdate(world, x, y, z, "leadOre");
            	return true;
            }
        }
		return false;
	}

    //		"Copper", "Tin", "Iron", "Gold", "Silver", "Lead"};
    //METAs		0		   1	  2		  3			4		5
    
    private void setBlockWithServerUpdate(World world, int x, int y, int z, String blockName)
    {
    	int id = electrolysmCore.nettedBlock.blockID;
    	int flag = 1;
    	
    	if(blockName.contains("copperOre"))
    	{
    		world.setBlock(x, y, z, id, 0, flag);
    	}
    	else if(blockName.contains("tinOre"))
    	{
    		world.setBlock(x, y, z, id, 1, flag);
    	}
    	else if(blockName.contains("ironOre"))
    	{
    		world.setBlock(x, y, z, id, 2, flag);
    	}
    	else if(blockName.contains("goldOre"))
    	{
    		world.setBlock(x, y, z, id, 3, flag);
    	}
    	else if(blockName.contains("silverOre"))
    	{
    		world.setBlock(x, y, z, id, 4, flag);
    	}
    	else if(blockName.contains("leadOre"))
    	{
    		world.setBlock(x, y, z, id, 5, flag);
    	}
    	
    	world.markBlockForRenderUpdate(x, y, z);
    	this.update(Side.SERVER, world, x, y, z, id);
    	this.update(Side.CLIENT, world, x, y, z, id);
    }
	private void update(Side side, World world, int x, int y, int z, int blockID) 
	{
		if(side == Side.CLIENT)
		{
			world.markBlockForRenderUpdate(x, y, z);
			world.notifyBlockChange(x, y, z, blockID);
		}
		else
		{
			world.notifyBlockChange(x, y, z, blockID);
		}
	}

}
