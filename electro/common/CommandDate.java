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
		 WorldServer worldserver = MinecraftServer.getServer().worldServers[0];
         WorldInfo worldinfo = worldserver.getWorldInfo();
		 String message = "";
		 
		 if(in.length >= 2)
		 {
			 if(in[0] != null && in[1] != null)
			 {
				 if(in[0].equals("minecraft"))
				 {
					 if(in[1].equals("date"))
					 {
						 message = "Date:  " + this.getDate(worldinfo.getWorldTotalTime());
					 }
					 else if(in[1].equals("stardate"))
					 {
						 message = "Stardate: " + this.getStarDate(worldinfo.getWorldTotalTime());
					 }
					 else
					 {
						 message = "Incorrect syntax - /date [minecraft / irl] [date / stardate]";
				         icommandsender.sendChatToPlayer(ChatMessageComponent.createFromText(message)
				        		 .setColor(EnumChatFormatting.RED));
						 return;
					 }
				 }/*
				 else if(in[0].equals("irl"))
				 {
					 if(in[1].equals("date"))
					 {
						 message = "Date:";
					 }
					 else if(in[1].equals("stardate"))
					 {
						 message = "Stardate:";
					 }
					 else
					 {
					  		message = "Incorrect syntax - /date [minecraft / irl] [date / stardate]";
			         		icommandsender.sendChatToPlayer(ChatMessageComponent.createFromText(message)
			        		 		.setColor(EnumChatFormatting.RED));
					 		return;
					 }
				 }*/
				 else
				 {
					 message = "Incorrect syntax - /date [minecraft / irl] [date / stardate]";
			         icommandsender.sendChatToPlayer(ChatMessageComponent.createFromText(message)
			        		 .setColor(EnumChatFormatting.RED));
					 return;
				 }
			 }
			 else
			 {
				 message = "Incorrect syntax - /date [minecraft / irl] [date / stardate]";
		         icommandsender.sendChatToPlayer(ChatMessageComponent.createFromText(message)
		        		 .setColor(EnumChatFormatting.RED));
				 return; 
			 }
		 }
		 else
		 {
			 message = "Incorrect syntax - /date [minecraft / irl] [date / stardate]";
	         icommandsender.sendChatToPlayer(ChatMessageComponent.createFromText(message)
	        		 .setColor(EnumChatFormatting.RED));
			 return;
		 }
		 
		 
         icommandsender.sendChatToPlayer(ChatMessageComponent.createFromText(message).setColor(EnumChatFormatting.GREEN));
	 }

	 private String getDate(long time) 
	 {
		 long seconds = time / 20;
		 long minutes = seconds / 60;
		 long days = minutes / 20;
		 long years = (long) (days / 365.25);
		 
		 return "Seconds - " + seconds + " - Minutes - " + minutes + " - Days - " + days + " - Years - " + years; 
	 }
	 
	 private String getStarDate(long time)
	 {
		 long seconds = time / 20;
		 long minutes = seconds / 60;
		 long days = minutes / 20;
		 long years = (long) (days / 365.25);
		 
		 long starYears = years + 2200;
		 long starDays = (long) (days - (years * 365.25));
		 if(years > 0)
		 {
			 return starYears + "." + starDays;
		 }
		 else
		 {
			 return "2200." + starDays;
		 }
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