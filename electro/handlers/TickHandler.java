package assets.electrolysm.electro.handlers;

import java.util.EnumSet;

import assets.electrolysm.electro.block.basic.te.TileEntityBlastDoor;
import assets.electrolysm.electro.client.ClientProxy;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class TickHandler implements ITickHandler{
	
	private static int times = 0;

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		// TODO Auto-generated method stub

	}

	@Override
	public EnumSet<TickType> ticks() {
		
		if(FMLClientHandler.instance().getClient().inGameHasFocus)
		{
			if(times <= 0)
			{
				FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage(VersionCheck.chatMessage);
				System.out.print(VersionCheck.chatMessage + "test");
				times = 100;
			}
	}
		return null;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub5
		return null;
	}

}
