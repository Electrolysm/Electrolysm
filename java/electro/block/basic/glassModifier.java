package electro.block.basic;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electro.electrolysmCore;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class glassModifier extends Item
{
    public glassModifier()
    {
        super();
        this.setCreativeTab(electrolysmCore.TabElectrolysm);
        this.setUnlocalizedName("glassModifier");
        this.maxStackSize = 1;
    }

    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10)
    {
        if (world.getBlock(x, y, z) == electrolysmCore.blastGlass)
        {
            world.setBlock(x, y, z, electrolysmCore.modBlastGlass);
            return true;
        }

        if (world.getBlock(x, y, z) == electrolysmCore.modBlastGlass)
        {
            world.setBlock(x, y, z, electrolysmCore.blastGlass);
            return true;
        }

        return false;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon("electrolysm:" + "glassModifier");
    }
}
