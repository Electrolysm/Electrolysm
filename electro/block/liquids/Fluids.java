package assets.electrolysm.electro.block.liquids;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import assets.electrolysm.electro.common.CommonProxy;

public class Fluids
{/*
    public static Map<String, Integer> registryFluids = FluidRegistry.getRegisteredFluidIDs();
    public static Set<String> fluidNames = registryFluids.keySet();
    public static Object[] fluidNamesArray = fluidNames.toArray();
    public static int fluidID;
    //   meta    fluid
    public static Map<Integer, Fluid> fluids = new HashMap();
    public static Set<String> registryNames = FluidRegistry.getRegisteredFluidIDs().keySet();
    public static Map<String, Integer> HOLDABLE_FLUIDS = new HashMap();
    public static Map<Integer, String> FLUID_NAME = new HashMap();
    
    
	public static void registerStuff()
    {
    	for(int i = 0; i < CommonProxy.FLUIDS.length; i++)
    	{
    		HOLDABLE_FLUIDS.put(CommonProxy.FLUIDS[i], CommonProxy.FLUID_IDS[i]);
    	}
    	
        for(int i = 0; i < fluidNamesArray.length; i++)
        {
        	fluidID = FluidRegistry.getFluidID((String)(fluidNamesArray[i]));
        	HOLDABLE_FLUIDS.put((String)(fluidNamesArray[i]), fluidID);
        }
        
        int biggest;
        if(HOLDABLE_FLUIDS.size() < registryNames.toArray().length)
        {
        	biggest = HOLDABLE_FLUIDS.size();
        }
        else
        {
        	biggest = registryNames.toArray().length;
        }
        
        for(int i = 0; i < biggest; i++)
        {
        	fluids.put(i, FluidRegistry.getFluid((String)(registryNames.toArray()[i])));
        }
		for(int i = 0; i < fluidNamesArray.length; i++)
		{
			System.out.println(fluidNamesArray[i] + " Fluid Storage");
		}
		
		reverseHoldingFluids();
		
		for(int i = 0; i < HOLDABLE_FLUIDS.size(); i++)
		{
			System.out.println(FLUID_NAME.get(i));
		}
    }


	private static void reverseHoldingFluids() 
	{
	     Set<String> names = HOLDABLE_FLUIDS.keySet();
	     Set<Integer> meta = fluids.keySet();
	     int sizes;
	     
	     if(meta.size() < names.size())
	     {
	    	 sizes = meta.size();
	     }
	     else
	     {
	    	 sizes = names.size();
	     }
	     System.out.println(sizes);
	     for(int i = 0; i < sizes; i++)
	     {
	    	 FLUID_NAME.put(Integer.parseInt((String.valueOf(meta.toArray()[i]))),(String) names.toArray()[i]);
	     }

	} */
}
