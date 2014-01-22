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
         
		 String message = "Stardate: " + this.getStarDate(worldinfo.getWorldTotalTime());
		 
         icommandsender.sendChatToPlayer(ChatMessageComponent.createFromText(message).setColor(EnumChatFormatting.GREEN));
	 }
}
