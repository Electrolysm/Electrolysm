package electro.research;

import electro.research.common.SavePlayerScanData;
import electro.research.pointsSystem.ResearchPoint;
import electro.research.system.PlayerResearchEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by Clarky158 on 18/06/2014.
 */
public class scanner extends Item
{
    public scanner()
    {
        super();
        this.setUnlocalizedName("scanner");
        this.setMaxStackSize(1);
    }

    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y,
                             int z, int par7, float par8, float par9, float par10)
    {
        //System.out.println(ResearchPoint.getPoints(new ItemStack(world.getBlock(x, y, z), 1, world.getBlockMetadata(x, y, z))));
        new SavePlayerScanData.ScanData(player.getDisplayName(), (new ItemStack(world.getBlock(x, y, z))).getUnlocalizedName());
        PlayerResearchEvent.callScanEvent(player.getDisplayName());
        return false;
    }


}
