package assets.electrolysm.electro.advAtomics.liquids;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class ModFluidSulphuricAcid extends Fluid
{
    public ModFluidSulphuricAcid()
    {
        super("ModFluidSulphuricAcid");
        this.setDensity(10);
        this.setViscosity(120);
        this.isGaseous = true;
        FluidRegistry.registerFluid(this);
    }
}
