package mods.Electrolysm.electro.biology.bacteria.tier1;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.Electrolysm.api.bacteria.trateList;
import mods.Electrolysm.electro.electrolysmCore;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class bacteriaFuso1 extends Item {

	public String nameBefore = "adv." + this.getClass();
	public String name = nameBefore.replace("mods.Electrolysm.electro.bacteria.", "");
	public EnumRarity textColour;
	public String tier = "tier";
	public boolean error;
	World world;
	EntityBacteria bacteriaEntity = new EntityBacteria(world);
	NBTTagCompound NBTTagCompound = new NBTTagCompound();
	
	//Trates
	public static String trate1;

	
	public bacteriaFuso1(int par1) {
		super(par1);
		// TODO Auto-generated constructor stub
		this.setUnlocalizedName(name);
		this.setCreativeTab(electrolysmCore.TabElectrolysmBiology);
		this.setFirstTrate(itemRand, itemID);
		this.setMaxStackSize(1);
		}
	
	@Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon("Electrolysm:" + name);	
	}
	/*
	@SideOnly(Side.CLIENT)

    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) 
    {
		bacteriaEntity.readFromNBT(NBTTagCompound);
		Object whatIngot = bacteriaEntity.trate1;

		par3List.add(whatIngot );
    }*/
	
	/**
	 * The colour of the item name (eg. with golden apples)
	*/
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack is){ 
		try{
			if(name.contains(this.tier + "1")){
				textColour = EnumRarity.common;
			}
			if(name.contains(this.tier + "2")){
				textColour = EnumRarity.common;
			}
			if(name.contains(this.tier + "3")){
				textColour = EnumRarity.common;
			}
			if(name.contains(this.tier + "4")){
				textColour = EnumRarity.uncommon;
			}
			if(name.contains(this.tier + "5")){
				textColour = EnumRarity.epic;
			}
			if(name.contains(this.tier + "6")){
				textColour = EnumRarity.rare;
			}
			
		}catch (IndexOutOfBoundsException e) {
	        // this should never happen...
	        this.error = true;
			return EnumRarity.common;
		}
			return textColour;
		}
	
	
	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
    {
		int chosenTrate = 1;
		this.setFirstTrate(itemRand, chosenTrate );
		return false;
    }
	
	
	public static void setFirstTrate(Random random, int chosenTrate){
		
			chosenTrate = random.nextInt(6);
			trate1 = trateList.trates1[chosenTrate];
			
		System.out.println(trate1);
		}
	}

		
    
