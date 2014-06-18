package electro.block.liquids;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class ModFluidPlasma extends Fluid
{
    public ModFluidPlasma()
    {
        super("Plasma");
        this.setDensity(0);
        this.setViscosity(0);
        this.isGaseous = true;
        FluidRegistry.registerFluid(this);
    }
}
