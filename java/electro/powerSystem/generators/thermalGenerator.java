package electro.powerSystem.generators;

import cpw.mods.fml.common.registry.LanguageRegistry;
import electro.Electrolysm;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;


public class thermalGenerator extends Block
{
    public thermalGenerator()
    {
        super(Material.iron);
        this.setCreativeTab(Electrolysm.TabElectrolysm);
        this.setHardness(5F);
        LanguageRegistry.addName(this, "Uses Thermal Energy To Produce Electricity ");
        setHarvestLevel("pickaxe",2);
        setStepSound(soundTypeMetal);
    }
}