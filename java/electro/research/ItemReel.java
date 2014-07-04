package electro.research;

import electro.Electrolysm;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

/**
 * Created by Clarky158 on 02/07/2014.
 */
public class ItemReel extends Item
{
    public ItemReel(){
        super();

        this.setCreativeTab(Electrolysm.TabElectrolysm);
        this.setMaxStackSize(1);
        this.setUnlocalizedName("ItemReel");
    }

    @Override
    public void registerIcons(IIconRegister reg)
    {
        this.itemIcon = reg.registerIcon("electrolysm:itemReel");
    }

    int sciValue = 0;
    int engValue = 0;

    public int[] getValueArray()
    {
        int sci = sciValue;
        int eng = engValue;
        return new int[] {sci, eng};
    }

    public int getSciPoints()
    {
        return sciValue;
    }

    public int getEngPoints()
    {
        return engValue;
    }

}
