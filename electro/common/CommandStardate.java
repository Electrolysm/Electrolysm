package assets.electrolysm.electro.common;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.WorldServer;
import net.minecraft.world.storage.WorldInfo;

public class CommandStardate extends CommandDate
{
	private List aliases;
	public CommandStardate()
	{
		this.aliases = new ArrayList();
		this.aliases.add("stardate");
	}

	@Override
	public String getCommandName()
  	{
		return "Gets Current stardate";
  	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender)
	{
  	  return "/stardate";
  	}

  	@Override
  	public List getCommandAliases()
  	{
  	  return this.aliases;
 	}

	 @Override
	 public void processCommand(ICommandSender icommandsender, String[] in)
	 {
		 WorldServer worldserver = MinecraftServer.getServer().worldServers[0];
         WorldInfo worldinfo = worldserver.getWorldInfo();
         
		 String message = "";
		 String line1 = "";
		 String line2 = "";
		 String line3 = "";
		 String line4 = "";
		 String line5 = "";
		 String command = "";
		 
		 if(in.length > 0)
		 {
			 if(in[0].equals("help"))
			 {
				 message = this.help()[0];
				 line1 = this.help()[1];
				 line2 = this.help()[2];
				 line3 = this.help()[3];
				 line4 = this.help()[4];
				 line5 = this.help()[5];
				 command = "help";
			 }
		 }
		 else
		 {
			message = "Stardate: " + this.getStarDate(worldinfo.getWorldTotalTime());
			command = "stardate";
		 }
		 
         icommandsender.sendChatToPlayer(ChatMessageComponent.createFromText(message)
        		 .setColor(this.getColourFromCommand(command)));
	 }

	private EnumChatFormatting getColourFromCommand(String command) 
	{
		//EnumChatFormatting
		try
		{
			if(command.equals("help"))
			{
				return EnumChatFormatting.RED;
			}
			else if(command.equals("stardate"))
			{
				return EnumChatFormatting.BLUE;
			}
			else if(command.equals("register"))
			{
				return EnumChatFormatting.LIGHT_PURPLE;
			}
			else
			{
				return EnumChatFormatting.RED;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	private String[] help() 
	{
		String[] returnString = new String[6];
		return returnString;
	}
}
