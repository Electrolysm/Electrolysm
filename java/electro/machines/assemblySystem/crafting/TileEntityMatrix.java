package electro.machines.assemblySystem.crafting;

import electro.handlers.network.MessageMatrix;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import java.util.List;

/**
 * Created by Ben on 10/07/2014.
 */
public class TileEntityMatrix extends TileEntityMatrixInventory
{
    public float height;
    public boolean isConstruct = false;

    @Override
    public void updateEntity() {

        new MessageMatrix(this);
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

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);

        nbt.setBoolean("isConstruct", isConstruct);
        nbt.setFloat("height", height);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);

        isConstruct = nbt.getBoolean("isConstruct");
        height = nbt.getFloat("isConstruct");
    }
}