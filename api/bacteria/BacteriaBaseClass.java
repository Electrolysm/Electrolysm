package mods.Electrolysm.api.bacteria;

import mods.Electrolysm.electro.electrolysmCore;
import net.minecraft.block.material.Material;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BacteriaBaseClass extends Item{

	public String nameBefore = "adv." + this.getClass();
	public String name = nameBefore.replace("mods.Electrolysm.electro.bacteria.", "");
	public EnumRarity textColour;
	
	public BacteriaBaseClass(int par1) {
		super(par1);
		// TODO Auto-generated constructor stub
		this.setUnlocalizedName(name);
		this.setCreativeTab(electrolysmCore.TabElectrolysm);
	}
	
	/**
	 * The colour of the item name (eg. with golden apples)
	*/
	public EnumRarity getRarity(ItemStack is){ 
		try{
			if(name.contains("1")){
				textColour = EnumRarity.rare;
			}
			if(name.contains("2")){
				textColour = EnumRarity.common;
			}
			if(name.contains("3")){
				textColour = EnumRarity.common;
			}
			if(name.contains("4")){
				textColour = EnumRarity.uncommon;
			}
			if(name.contains("5")){
				textColour = EnumRarity.epic;
			}
			if(name.contains("6")){
				textColour = EnumRarity.rare;
			}
			
		}catch (IndexOutOfBoundsException e) {
	        // this should never happen...
	        return null;
		}
			return textColour;
		}


}
