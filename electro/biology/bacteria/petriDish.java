package mods.Electrolysm.electro.biology.bacteria;

import java.util.Random;

import mods.Electrolysm.electro.electrolysmCore;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class petriDish extends Block{

	public petriDish(int id, Material material) {
		super(id, Material.glass);
		// TODO Auto-generated constructor stub
		this.setCreativeTab(electrolysmCore.TabElectrolysmBiology);
		this.setHardness(0);
	}
	
	 public int idDropped(int par1, Random rand, int par3)
	    {
		  switch (rand.nextInt(4))
		  {
          case 0:
              return (Bacteria.bacteriaFusoR.itemID);
          case 1:
              return (Bacteria.GemmigerR.itemID);
          case 2:
              return (Bacteria.nitrospiraeR.itemID);
          case 3:
        	  return Bacteria.agarResin.itemID;
		  }
		  return 0;
	}
}
