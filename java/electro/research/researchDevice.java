package electro.research;

import api.items.RecipeStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electro.Electrolysm;
import electro.handlers.GUIHandler;
import electro.research.common.SavePlayerScanData;
import electro.research.system.PlayerResearchEvent;
import electro.research.system.ResearchRegistry;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Clarky158on 21/06/2014.
 */
public class researchDevice extends Item
{
    public researchDevice()
    {
        super();
        this.setUnlocalizedName("researchDevice");
        this.setMaxStackSize(1);
        this.setCreativeTab(Electrolysm.TabElectrolysm);
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8,
                             float par9, float par10)

    {
        this.gainBasics(player, world);
        this.unlockALL(player, world);
        return false;
    }

    private void unlockALL(EntityPlayer player, World world) {
        LinkedHashMap<String, String> map = ResearchRegistry.getResearchMap();
        for(Map.Entry<String, String> entryMap : map.entrySet()){

        }
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {
        if (!player.isSneaking())
        {
            int x = (int)player.posX;
            int y = (int)player.posY;
            int z = (int)player.posZ;
            player.openGui(Electrolysm.GUIInstance, GUIHandler.id_bookIDCard, world, x, y, z);

            return stack;
        }
        this.gainBasics(player, world);
        return stack;
    }

    public void gainBasics(EntityPlayer player, World world)
    {
        if(!(this.hasBlockBeenScanned(player.getDisplayName(), "device")))
        {
            new SavePlayerScanData.ScanData(player.getDisplayName(), "device");
            //System.out.println("basics");
        }
        if(world.isRemote) {
            PlayerResearchEvent.callScanEvent(player, player.getDisplayName(), world.isRemote);
        } else {
            PlayerResearchEvent.callScanEvent(player, player.getDisplayName(), world.isRemote);
        }
    }

    public static boolean hasBlockBeenScanned(String username, String newData)
    {
        if (SavePlayerScanData.ScanData.dataAlreadyExists(newData + ",", SavePlayerScanData.ScanData.getUserData(username)))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @SideOnly(Side.CLIENT)
    IIcon[] icons;

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister reg)
    {
        icons = new IIcon[2];
        icons[0] = reg.registerIcon("electrolysm:device_off");
        icons[1] = reg.registerIcon("electrolysm:device_active");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int dmg)
    {
        if(use) { return icons[1]; } else { return icons[0]; }
    }

    boolean use = false;

    public void setUse(boolean useage)
    {
        this.use = useage;
    }
}
