package electro.powerSystem;

import cpw.mods.fml.common.registry.LanguageRegistry;
import electro.Electrolysm;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;


public class advancedCable extends Block
{
    public advancedCable()
    {
        super(Material.cloth);
        this.setCreativeTab(Electrolysm.TabElectrolysm);
        this.setHardness(5F);
        setHarvestLevel("pickaxe",1);
        setStepSound(soundTypeCloth);
    }
}