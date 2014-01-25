package assets.electrolysm.electro.common;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.WorldServer;
import net.minecraft.world.storage.WorldInfo;

public class CommandDate implements ICommand
{
	private List aliases;
	public CommandDate()
	{
		this.aliases = new ArrayList();
		this.aliases.add("date");
	}

	@Override
	public String getCommandName()
  	{
		return "Gets Current date statistics";
  	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender)
	{
  	  return "/date";
  	}

  	@Override
  	public List getCommandAliases()
  	{
  	  return this.aliases;
 	}

	 @Override
	 public void processCommand(ICommandSender icommandsender, String[] in)
	 {
	 }

	 private String getDate(long time) 
	 {
		 long seconds = time / 20;
		 long minutes = seconds / 60;
		 long days = minutes / 20;
		 long years = (long) (days / 365.25);
		 
		 return "Seconds - " + seconds + " - Minutes - " + minutes + " - Days - " + days + " - Years - " + years; 
	 }
	 
	 

	@Override
	 public boolean canCommandSenderUseCommand(ICommandSender icommandsender)
  	 {
  	      return true;
  	 }

	 @Override
  	public List addTabCompletionOptions(ICommandSender icommandsender, String[] astring)
  	{
		 return null;
  	}

	 @Override
  	public boolean isUsernameIndex(String[] astring, int i)
  	{
  		  return false;
  	}

	 @Override
  	public int compareTo(Object o)
  	{
		 return 0;
  	}
}