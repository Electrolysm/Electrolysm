package electro.misc.item.tools;

import api.powerSystem.prefab.TEPowerCore;
import api.powerSystem.prefab.TileEntityGenerator;
import api.powerSystem.prefab.TileEntityMachine;
import api.powerSystem.prefab.TileEntityRelay;
import electro.Electrolysm;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by Clarky158 on 30/07/2014.
 * <p/>
 * Electrolysm is an open source Minecraft mod
 * released under version 3 of the GNU Lesser
 * General Public License. This means that
 * the source of this mod is publicly available
 * and you have certain rights with respective
 * to the code.
 */
public class ItemInsulatedScrewdriver extends Item
{
    public ItemInsulatedScrewdriver()
    {
        super();
        this.setUnlocalizedName("ItemInsulatedScrewdriver");
        this.setMaxStackSize(1);
        this.setCreativeTab(Electrolysm.TabElectrolysm);
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side,
                             float hitX, float hitY, float hitZ)
    {
        TileEntity worldTE = world.getTileEntity(x, y, z);
        Block block = world.getBlock(x, y, z);
        if(player.isSneaking())
        {
            if(worldTE instanceof TEPowerCore || worldTE instanceof TileEntityMachine || worldTE instanceof TileEntityGenerator ||
                    worldTE instanceof TileEntityRelay) {
                block.dropBlockAsItem(world, x, y, z, 0, 1);
                world.setBlockToAir(x, y, z);
                return true;
            }

        }else
        {
            if(worldTE instanceof TileEntityRelay)
            {
                TileEntityRelay te = ((TileEntityRelay) worldTE);
                te.setSide(side);
                return true;
            }
        }

        return false;
    }

    @Override
    public void registerIcons(IIconRegister reg) {
        itemIcon = reg.registerIcon("electrolysm:insulatedScrewdriver");
    }
}
