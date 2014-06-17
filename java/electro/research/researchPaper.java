package electro.research;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import assets.electrolysm.electro.electrolysmCore;
import electro.block.machines.tile.TileEntityWorkBench;
import electro.common.CommonProxy;
import electro.handlers.ResearchHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class researchPaper extends Item
{
    private String message = "Research Complete!";
    private boolean finished;
    private int numberOfSub = 1;
    @SideOnly(Side.CLIENT)
    private Icon[] icons;

    public researchPaper(int id)
    {
        super(id);
        this.setCreativeTab(electrolysmCore.TabElectrolysm);
        this.setUnlocalizedName("researchPaper");
        this.setMaxStackSize(1);
    }

    public String getUnlocalizedName(ItemStack stack)
    {
        return "researchNote" + stack.getItemDamage();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister red)
    {
        icons = new Icon[CommonProxy.RESEARCH_NOTES.length];

        for (int i = 0; i < icons.length; i++)
        {
            icons[i] = red.registerIcon("electrolysm:" + CommonProxy.RESEARCH_NOTES[i]);
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIconFromDamage(int dmg)
    {
        return icons[1];
    }

    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
    {
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x,
                             int y, int z, int par7, float par8, float par9, float par10)
    {
        return false;
    }
}