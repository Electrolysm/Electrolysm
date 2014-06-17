package electro.block.basic;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import assets.electrolysm.electro.electrolysmCore;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class glassModifier extends Item
{
    public glassModifier(int id)
    {
        super(id);
        this.setCreativeTab(electrolysmCore.TabElectrolysm);
        this.setUnlocalizedName("glassModifier");
        this.maxStackSize = 1;
    }

    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10)
    {
        if (world.getBlockId(x, y, z) == electrolysmCore.blastGlass.blockID)
        {
            world.setBlock(x, y, z, electrolysmCore.modBlastGlass.blockID);
            return true;
        }

        if (world.getBlockId(x, y, z) == electrolysmCore.modBlastGlass.blockID)
        {
            world.setBlock(x, y, z, electrolysmCore.blastGlass.blockID);
            return true;
        }

        return false;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon("electrolysm:" + "glassModifier");
    }
}
