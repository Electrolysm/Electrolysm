package electrolysm.electro.handlers;

import electrolysm.electro.Electrolysm;
import net.minecraft.item.ItemStack;
import electrolysm.api.specialFuel.SpecialFuelHandler;
import electrolysm.electro.common.CommonProxy;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Names
{
    public static void addName()
    {
        for(int i = 0; i < (SpecialFuelHandler.getFuelList().size() + 1); i++)
        {
            LanguageRegistry.addName(new ItemStack(Electrolysm.electroContain, 1, i), "Electromagenetic Containment Unit");
        }
        
        for(int i = 0; i < 3; i++)
        {
        	String[] tier = {"Stone", "Iron", "Diamond"};
        	LanguageRegistry.addName(new ItemStack(Electrolysm.grindStone, 1, i), tier[i] + " Crushing Stone");
        }
        for (int i = 0; i < CommonProxy.FLUIDS.length; i++)
        {
            LanguageRegistry.addName(new ItemStack(Electrolysm.fluidStorage, 1, i),
                                     "Strengthened Fluid Storage Capsule");
        }
        for (int i = 0; i < CommonProxy.DUSTS.length; i++)
        {
            LanguageRegistry.addName(new ItemStack(Electrolysm.dusts, 1, i), CommonProxy.DUSTS[i] + " Dust");
            LanguageRegistry.addName(new ItemStack(Electrolysm.impureDusts, 1, i), "Impure " +
                                     CommonProxy.DUSTS[i] + " Dust");
            LanguageRegistry.addName(new ItemStack(Electrolysm.crystal, 1, i), CommonProxy.DUSTS[i] + " Sulphate Crystal");
        }
    }
}
