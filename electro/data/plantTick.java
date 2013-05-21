package mods.Electrolysm.electro.data;

import java.util.EnumSet;

import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class plantTick implements ITickHandler{

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		// TODO Auto-generated method stub
		data.plantGrowTick = data.plantGrowTick + 1;
	
		if (data.plantGrowTick == 1000){
			data.plantStage = data.plantStage + 1;
			data.plantGrowTick = 0;
		}
		if(data.plantStage > 3){
			data.plantStage = 3;
		}
	}
	

	@Override
	public EnumSet<TickType> ticks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return null;
	}

}
