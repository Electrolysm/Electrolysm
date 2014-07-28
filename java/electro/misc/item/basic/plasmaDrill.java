package electro.misc.item.basic;

import java.util.List;
import java.util.Random;

import electro.Electrolysm;
import electro.machines.advMachines.te.TileEntityCharger;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class plasmaDrill extends ItemTool
{
    @SideOnly(Side.CLIENT)
    public IIcon itemIconBroken;
    public int breakingPoint = 1555;

    public plasmaDrill()
    {
        super(25f, ToolMaterial.EMERALD, Block.blockRegistry.getKeys());
        this.setCreativeTab(Electrolysm.TabElectrolysm);
        this.setUnlocalizedName("plasmaDrill");
        this.toolMaterial = ToolMaterial.EMERALD;
        this.maxStackSize = 1;
        this.efficiencyOnProperMaterial = 20;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister reg)
    {
        this.itemIcon = reg.registerIcon("electrolysm:" + "plasmaDrill");
        this.itemIconBroken = reg.registerIcon("electrolysm:" + "brokenDrill");
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIconFromDamage(int dmg)
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
    public float getDigSpeed(ItemStack stack, Block block, int meta)
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
        if (world.getBlock(x, y, z) == Electrolysm.blastProof)
        {
            world.setBlockToAir(x, y, z);
            world.playSoundAtEntity(player, "dig.stone4", 1, 1);
            return true;
        }

        if (world.getBlock(x, y, z) == Electrolysm.blastDoor)
        {
            world.setBlockToAir(x, y, z);
            world.playSoundAtEntity(player, "dig.stone4", 1, 1);
            return true;
        }

        if (world.getBlock(x, y, z) == Electrolysm.blastGlass)
        {
            world.setBlockToAir(x, y, z);
            world.playSoundAtEntity(player, "dig.glass1", 1, 1);
            return true;
        }

        if (world.getBlock(x, y, z) == Electrolysm.modBlastGlass)
        {
            world.setBlockToAir(x, y, z);
            world.playSoundAtEntity(player, "dig.glass1", 1, 1);
            return true;
        }

        TileEntity worldTE = world.getTileEntity(x, y, z);
        Random rand = new Random();

        if (worldTE instanceof TileEntityCharger)
        {
            TileEntityCharger te = (TileEntityCharger)worldTE;

            if (/*gui.canWork(world, x, y, z) && */!(player.capabilities.isCreativeMode))
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

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World world, Block par3, int par4, int par5, int par6,
                                    EntityLivingBase livingBase)
    {
        if (stack.getItemDamage() != 0)
        {
            if ((double)par3.getBlockHardness(world, par4, par5, par6) != 0.0D)
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

    @Override
    public void getSubItems(Item item, CreativeTabs tab, List list)
    {
        list.add(new ItemStack(this, 1, 0));
        list.add(new ItemStack(this, 1, 1));
        list.add(new ItemStack(this, 1, 1554));
    }

    @Override
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
