package assets.electrolysm.electro.handlers;

import java.util.EnumSet;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

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
				if(VersionCheck.chatMessage != null)
				{
					this.printChatMessage(VersionCheck.chatMessage);
					times = 100;
				}
			}
	}
		return null;
	}
	
	@SideOnly(Side.CLIENT)
	public void printChatMessage(String message)
	{
		FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage(message);
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub5
		return null;
	}

}
