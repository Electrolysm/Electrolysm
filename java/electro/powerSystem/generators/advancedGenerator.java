package electro.powerSystem.generators;

import cpw.mods.fml.common.registry.LanguageRegistry;
import electro.Electrolysm;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;


public class advancedGenerator extends Block
{
    public advancedGenerator()
    {
        super(Material.iron);
        this.setCreativeTab(Electrolysm.TabElectrolysm);
        this.setHardness(2F);
        LanguageRegistry.addName(this, "Produces More Energy Than Generator ");
        setHarvestLevel("pickaxe",1);
        setStepSound(soundTypeMetal);
    }
}