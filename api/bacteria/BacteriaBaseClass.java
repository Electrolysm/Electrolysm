package mods.Electrolysm.api.bacteria;

import java.awt.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import mods.Electrolysm.electro.electrolysmCore;
import mods.Electrolysm.electro.biology.bacteria.Bacteria;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BacteriaBaseClass extends Item{

	public String nameBefore = "adv." + this.getClass();
	public String name = nameBefore.replace("mods.Electrolysm.electro.bacteria.", "");
	public String tier = "tier";
	public boolean error;
	public static int id;
	public static EnumRarity textColour;
	public static int tierID;
	
	//Trates
	public static String trate1;

	public BacteriaBaseClass(int par1) {
		super(par1);
		// TODO Auto-generated constructor stub
		this.setCreativeTab(electrolysmCore.TabElectrolysmBiology);
		//this.setFirstTrate(itemRand, itemID);
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon("Electrolysm:" + "tier1Bacteria");	
	}

/*
	
	public static void setFirstTrate(Random random, int chosenTrate){
	
	for(int cT = 0; cT < trateList.trates1.length; cT++){
		chosenTrate = random.nextInt(6);
		trate1 = trateList.trates1[chosenTrate];
		
	System.out.println(trate1);
		}	

	}
*/
	
    public Item setTierID(int tier)
    {
        this.tierID = tier;
        return this;
    }
    public int getTierID()
    {
        return this.tierID;
    }
}
