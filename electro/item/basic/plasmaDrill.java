package assets.electrolysm.electro.item.basic;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.block.advMachines.te.TileEntityCharger;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class plasmaDrill extends ItemTool
{
    public static final Block[] blocksEffectiveAgainst = new Block[] {Block.cobblestone, Block.stoneDoubleSlab, Block.stoneSingleSlab, Block.stone, Block.sandStone, Block.cobblestoneMossy, Block.oreIron, Block.blockIron, Block.oreCoal, Block.blockGold, Block.oreGold, Block.oreDiamond, Block.blockDiamond, Block.ice, Block.netherrack, Block.oreLapis, Block.blockLapis, Block.oreRedstone, Block.oreRedstoneGlowing, Block.rail, Block.railDetector, Block.railPowered, Block.railActivator, Block.obsidian};

    @SideOnly(Side.CLIENT)
    public Icon itemIconBroken;
    public int breakingPoint = 1555;

    public plasmaDrill(int id, float par2, EnumToolMaterial toolMaterial, Block[] block)
    {
        super(id, par2, EnumToolMaterial.EMERALD, block);
        this.setCreativeTab(electrolysmCore.TabElectrolysm);
        this.setUnlocalizedName("plasmaDrill");
        this.toolMaterial = EnumToolMaterial.EMERALD;
        this.maxStackSize = 1;
        this.damageVsEntity = 15;
        this.efficiencyOnProperMaterial = 20;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister reg)
    {
        this.itemIcon = reg.registerIcon("electrolysm:" + "plasmaDrill");
        this.itemIconBroken = reg.registerIcon("electrolysm:" + "brokenDrill");
    }

    @SideOnly(Side.CLIENT)
    @Override
    public Icon getIconFromDamage(int dmg)
    {
        if (dmg == 0)
        {
            return this.itemIconBroken;
        }
        else
        {
            return this.itemIcon;
        }
    }

    @Override
    public float getStrVsBlock(ItemStack stack, Block block)
    {
        if (stack.getItemDamage() == 0)
        {
            return 0.0F;
        }
        else
        {
            return 20F;
        }
    }

    @Override
    public float getStrVsBlock(ItemStack stack, Block block, int meta)
    {
        if (stack.getItemDamage() == 0)
        {
            return 0.0F;
        }
        else
        {
            return 20F;
        }
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
        return false;
    }

    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10)
    {
        if (world.getBlockId(x, y, z) == electrolysmCore.blastProof.blockID)
        {
            world.setBlockToAir(x, y, z);
            world.playSoundAtEntity(player, "dig.stone4", 1, 1);
            return true;
        }

        if (world.getBlockId(x, y, z) == electrolysmCore.blastDoor.blockID)
        {
            world.setBlockToAir(x, y, z);
            world.playSoundAtEntity(player, "dig.stone4", 1, 1);
            return true;
        }

        if (world.getBlockId(x, y, z) == electrolysmCore.blastGlass.blockID)
        {
            world.setBlockToAir(x, y, z);
            world.playSoundAtEntity(player, "dig.glass1", 1, 1);
            return true;
        }

        if (world.getBlockId(x, y, z) == electrolysmCore.modBlastGlass.blockID)
        {
            world.setBlockToAir(x, y, z);
            world.playSoundAtEntity(player, "dig.glass1", 1, 1);
            return true;
        }

        TileEntity worldTE = world.getBlockTileEntity(x, y, z);
        Random rand = new Random();

        if (worldTE instanceof TileEntityCharger)
        {
            TileEntityCharger te = (TileEntityCharger)worldTE;

            if (/*te.canWork(world, x, y, z) && */!(player.capabilities.isCreativeMode))
            {
                if (stack.getItemDamage() == 0)
                {
                    stack.setItemDamage(1550);

                    if (rand.nextInt(155) == 1)
                    {
                        world.createExplosion(player, x, y, z, 2, true);
                    }

                    return true;
                }
                else if ((stack.getItemDamage() - 10) > 0)
                {
                    stack.damageItem(-10, player);

                    if (rand.nextInt(155) == 1)
                    {
                        world.createExplosion(player, player.posX, player.posY, player.posZ, 2, true);
                    }

                    return true;
                }
                else
                {
                    return false;
                }
            }
            else if (player.capabilities.isCreativeMode)
            {
                stack.setItemDamage(1);
            }
        }

        return false;
    }

    public boolean onBlockDestroyed(ItemStack stack, World world, int par3, int par4, int par5, int par6,
                                    EntityLivingBase livingBase)
    {
        if (stack.getItemDamage() != 0)
        {
            if ((double)Block.blocksList[par3].getBlockHardness(world, par4, par5, par6) != 0.0D)
            {
                stack.damageItem(1, livingBase);
            }
        }

        if (stack.getItemDamage() >=  1555)
        {
            stack.setItemDamage(0);
            return true;
        }

        return true;
    }

    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
    {
        int dmg = stack.getItemDamage();
        int maxDmg = stack.getMaxDamage();
        String persent = this.calculatePersent(maxDmg, this.breakingPoint);
        list.add(persent + " Energy Units Stored");
    }

    public String calculatePersent(int maxDmg, int dmg)
    {
        float persent = ((dmg * 100) / maxDmg);
        persent = persent * 10;
        persent = Math.round(persent);
        return (((persent / 10) - 100) + "%").replace("-", "");
    }
}
