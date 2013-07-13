package mods.Electrolysm.electro.data;

import java.util.EnumSet;
import java.util.Random;

import mods.Electrolysm.electro.biology.bacteria.tier1.bacteriaFuso1;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class TickRunning implements ITickHandler {

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {

	}

	@Override
	public EnumSet<TickType> ticks() {
		// TODO Auto-generated method stub
		data.tick = data.tick + 1;
		if(data.tick > 20){
			data.tick = 0;
			Random itemRand = new Random();
			int itemID = 1;
			//bacteriaFuso1.setFirstTrate(itemRand, itemID);
		}

		return null;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return null;
	}


}