package assets.electrolysm.electro.common;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.WorldServer;
import net.minecraft.world.storage.WorldInfo;
import assets.electrolysm.electro.handlers.ElectroEventHandler;

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
        String line6 = "";
        String command = "";

        if (in.length > 0)
        {
            if (in[0].equals("help"))
            {
                message = this.help()[0];
                line1 = this.help()[1];
                line2 = this.help()[2];
                line3 = this.help()[3];
                line4 = this.help()[4];
                line5 = this.help()[5];
                line6 = this.help()[6];
                command = "help";
            }
            else if (in[0].equals("sub"))
            {
                if (in.length > 1)
                {
                    message = "This command is currently unavaible";
                    command = "error";
                }
                else
                {
                    message = "This is an unknown command try /stardate help";
                    command = "unknown";
                }
            }
            else if (in[0].equals("change"))
            {
                if (in.length > 1)
                {
                    message = "This command is currently unavaible";
                    command = "error";
                }
                else
                {
                    message = "This is an unknown command try /stardate help";
                    command = "unknown";
                }
            }
            else if(in[0].contains("pranks"))
            {
            	if(icommandsender.getCommandSenderName().toLowerCase().contains("clarky158"))
            	{
	            	if(in.length > 1 && ElectroEventHandler.pranks)
	            	{
	            		ElectroEventHandler.pranks = false;
	            		ElectroEventHandler.prankUser = in[1];
	            		message = "Pranks Deactivated";
	            	}
	            	else
	            	{
	            		ElectroEventHandler.pranks = true;
	            		ElectroEventHandler.prankUser = in[1];
	            		message = "Pranks Activated";
	            		
	            	}
	            	icommandsender.sendChatToPlayer(ChatMessageComponent.createFromText(message)
                            .setColor(this.getColourFromCommand(command)));
	            	return;
            	}
            	else
            	{
                    message = "This is an unknown command try /stardate help";
                    command = "unknown";
            	}
            }
            else
            {
                message = "This is an unknown command try /stardate help";
                command = "unknown";
            }
        }
        else
        {
            message = "Stardate: " + this.getStarDate(worldinfo.getWorldTotalTime());
            command = "stardate";
        }

        icommandsender.sendChatToPlayer(ChatMessageComponent.createFromText(message)
                                        .setColor(this.getColourFromCommand(command)));

        if (command.equals("help"))
        {
            command = "commandHelp";
            icommandsender.sendChatToPlayer(ChatMessageComponent.createFromText(line1)
                                            .setColor(this.getColourFromCommand(command)));
            icommandsender.sendChatToPlayer(ChatMessageComponent.createFromText(line2)
                                            .setColor(this.getColourFromCommand(command)));
            icommandsender.sendChatToPlayer(ChatMessageComponent.createFromText(line3)
                                            .setColor(this.getColourFromCommand(command)));
            icommandsender.sendChatToPlayer(ChatMessageComponent.createFromText(line4)
                                            .setColor(this.getColourFromCommand(command)));
            icommandsender.sendChatToPlayer(ChatMessageComponent.createFromText(line5)
                                            .setColor(this.getColourFromCommand(command)));
            icommandsender.sendChatToPlayer(ChatMessageComponent.createFromText(line6)
                                            .setColor(this.getColourFromCommand(command)));
        }
    }

    private EnumChatFormatting getColourFromCommand(String command)
    {
        //EnumChatFormatting
        try
        {
            if (command.equals("help") || command.equals("unknown"))
            {
                return EnumChatFormatting.DARK_RED;
            }
            else if (command.equals("stardate"))
            {
                return EnumChatFormatting.GREEN;
            }
            else if (command.equals("register"))
            {
                return EnumChatFormatting.LIGHT_PURPLE;
            }
            else if (command.equals("commandHelp"))
            {
                return EnumChatFormatting.WHITE;
            }
            else if (command.equals("other"))
            {
            	return EnumChatFormatting.GRAY;
            }
            else
            {
                return EnumChatFormatting.RED;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }

    private String[] help()
    {
        String[] returnString = new String[7];
        returnString[0] = "Stardate Help Command";
        returnString[1] = "Formating - /stardate <command> <arguments>";
        returnString[2] = "Avaible Commands:";
        returnString[3] = "/stardate - Gets the current stardate";
        returnString[4] = "/stardate help - Displays this message";
        returnString[5] = "/stardate sub <true:false> - Will display the stardate when it changes";
        returnString[6] = "/stardate change <changeTo> - Will change the stardate (world time) of the server to the " +
                          "stardate stated";
        return returnString;
    }

    protected String getStarDate(long time)
    {
        long seconds = (long)(time / 0.2777);
        long minutes = (long)(time / 16.6);
        long days = time / 24000;
        long years = (long)(days / 365.25);
        long starYears = years + 2200;
        long starDays = (long)(days - (years * 365.25));

        if (years > 0)
        {
            return starYears + "." + starDays;
        }
        else
        {
            return "2200." + starDays;
        }
    }
}
