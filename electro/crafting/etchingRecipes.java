package assets.electrolysm.electro.crafting;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.powerSystem.TeslaTransmittingServer;
import assets.electrolysm.electro.powerSystem.crystal1;

public class etchingRecipes
{
        //=====================================================
        //                                        Research Behind the Scenes
        //=====================================================
        
    private static final etchingRecipes etchingBase = new etchingRecipes();

    /** The list of smelting results. */
    private Map etchingList = new HashMap();

    public static final etchingRecipes etching()
    {
        return etchingBase;
    }

    private etchingRecipes()
    {
        this.addEtching(Item.diamond.itemID, new ItemStack(electrolysmCore.crystal1));
    }
    
    
    /**
     * Adds a smelting recipe.
     */
    public void addEtching(int inputID, ItemStack output)
    {
        this.etchingList.put(Integer.valueOf(inputID), output);
    }
    
        public ItemStack getEtchedResult(ItemStack item, int stackSize) 
        {
        	if(item != null)
        	{
        		ItemStack result = (ItemStack)this.etchingList.get(item.itemID);
        		
        		if(result != null)
        		{	
        			for(int ii = 0; ii < (TeslaTransmittingServer.crystalList.size() + 1); ii++)
        			{
        				crystal1 crystal = (crystal1)result.getItem();
        				crystal.putPin(this.getCrystalPin(ii));
        				return new ItemStack(result.getItem(), stackSize);
        			}
        		}
        	}
			return null;
        }

		private int getCrystalPin(int metaData) 
		{
			for(int i = 0; i < (TeslaTransmittingServer.crystalList.size() + 1); i++)
			{
				Random rand = new Random();
				int pin = rand.nextInt(99999);
			
				if(TeslaTransmittingServer.crystalList.get(metaData) != null)
				{
					if(Integer.parseInt(String.valueOf(TeslaTransmittingServer.crystalList.get(metaData))) 
							!= pin)
					{
						return pin;
					}
				}
			}
			return 0;
		}
    }