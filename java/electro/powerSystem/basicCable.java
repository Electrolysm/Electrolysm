package electro.powerSystem;

import cpw.mods.fml.common.registry.LanguageRegistry;
import electro.Electrolysm;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;


public class basicCable extends Block
{
    public basicCable()
    {
        super(Material.cloth);
        this.setCreativeTab(Electrolysm.TabElectrolysm);
        this.setHardness(5F);
        LanguageRegistry.addName(this, "Energy Transport");
        setHarvestLevel("pickaxe",1);
        setStepSound(soundTypeCloth);
    }
}