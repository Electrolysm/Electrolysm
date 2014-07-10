package electro.assemblySystem.crafting;

import api.LoggerHandler;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;

/**
 * Created by Ben on 10/07/2014.
 */
public class TileEntityMatrix extends TileEntityMatrixInventory
{
    public float height;
    public boolean isConstruct = false;

    @Override
    public void updateEntity() {

        height = 0F;
    }

    public void setIsConstuct(boolean construst)
    {
        isConstruct = construst;
    }

    public boolean getIsConstruct()
    {
        return isConstruct;
    }

    public List<ItemStack> getCraftedAbleItems()
    {
        return null;
    }
}