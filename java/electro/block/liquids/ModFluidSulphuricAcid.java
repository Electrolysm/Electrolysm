package electro.block.liquids;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class ModFluidSulphuricAcid extends Fluid
{
    public ModFluidSulphuricAcid()
    {
        super("Sulphuric Acid");
        this.setDensity(10);
        this.setViscosity(120);
        this.isGaseous = true;
        FluidRegistry.registerFluid(this);
    }
}
