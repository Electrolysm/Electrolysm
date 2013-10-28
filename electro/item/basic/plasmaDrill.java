package assets.electrolysm.electro.item.basic;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;
import assets.electrolysm.electro.electrolysmCore;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class plasmaDrill extends ItemTool{

    public static final Block[] blocksEffectiveAgainst = new Block[] {Block.cobblestone, Block.stoneDoubleSlab, Block.stoneSingleSlab, Block.stone, Block.sandStone, Block.cobblestoneMossy, Block.oreIron, Block.blockIron, Block.oreCoal, Block.blockGold, Block.oreGold, Block.oreDiamond, Block.blockDiamond, Block.ice, Block.netherrack, Block.oreLapis, Block.blockLapis, Block.oreRedstone, Block.oreRedstoneGlowing, Block.rail, Block.railDetector, Block.railPowered, Block.railActivator, Block.obsidian};

	public plasmaDrill(int id, float par2, EnumToolMaterial toolMaterial, Block[] block) {
		super(id, par2, EnumToolMaterial.EMERALD, block);
		
		this.setCreativeTab(electrolysmCore.TabElectrolysm);
		this.setUnlocalizedName("plasmaDrill");
		
		this.toolMaterial = EnumToolMaterial.EMERALD;
        this.maxStackSize = 1;
        this.damageVsEntity = 20;
        this.efficiencyOnProperMaterial = 20;

	}

	 @SideOnly(Side.CLIENT)
	    public void registerIcons(IconRegister par1IconRegister)
	    {
	        this.itemIcon = par1IconRegister.registerIcon("electrolysm:" + "plasmaDrill");
	    }

	 @Override
	 public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
	    {
	        return 20.0F;
	    }
	 
	 @Override
	    public float getStrVsBlock(ItemStack stack, Block block, int meta) 
	    {
	        return 20.0F;
	    }
	 
	 @Override
	 public boolean canHarvestBlock(Block par1Block)
	 {
		 return true;
	 }
	 
	 public int getItemEnchantability()
    {
		 return 30;
	}
	    
	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
	{
	  	return true;
	}
	
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10)
    {
    	if(world.getBlockId(x, y, z) == electrolysmCore.blastProof.blockID)
    	{
    		world.setBlockToAir(x, y, z);
    		world.playSoundAtEntity(player, "dig.stone4", 1, 1);
    		return true;
    	}
    	if(world.getBlockId(x, y, z) == electrolysmCore.blastDoor.blockID)
    	{
    		world.setBlockToAir(x, y, z);
    		world.playSoundAtEntity(player, "dig.stone4", 1, 1);
    		return true;
    	}
    	if(world.getBlockId(x, y, z) == electrolysmCore.blastGlass.blockID)
    	{
    		world.setBlockToAir(x, y, z);
    		world.playSoundAtEntity(player, "dig.glass1", 1, 1);
    		return true;
    	}
    	if(world.getBlockId(x, y, z) == electrolysmCore.modBlastGlass.blockID)
    	{
    		world.setBlockToAir(x, y, z);
    		world.playSoundAtEntity(player, "dig.glass1", 1, 1);
    		return true;
    	}
    	
    	return false;
    }


}
