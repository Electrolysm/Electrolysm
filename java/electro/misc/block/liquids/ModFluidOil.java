package electro.misc.block.liquids;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class ModFluidOil extends Fluid {

	public ModFluidOil()
	{
        super("Crude Oil");
        this.setDensity(1000);
        this.setViscosity(1000);
        this.isGaseous = false;
        FluidRegistry.registerFluid(this);
    }

}
