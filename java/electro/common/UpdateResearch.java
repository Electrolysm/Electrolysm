package electro.common;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;
import electro.handlers.ResearchHandler;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;

public class UpdateResearch implements ICommand
{
    private List aliases;
    public UpdateResearch()
    {
        this.aliases = new ArrayList();
        this.aliases.add("updateResearch");
    }

    @Override
    public String getCommandName()
    {
        return "researchUpdater";
    }

    @Override
    public String getCommandUsage(ICommandSender icommandsender)
    {
        return "/updateResearch";
    }

    @Override
    public List getCommandAliases()
    {
        return this.aliases;
    }

    @Override
    public void processCommand(ICommandSender icommandsender, String[] astring)
    {
        EntityPlayer player;
        //icommandsender.sendChatToPlayer(ChatMessageComponent.createFromText("Updating research...").setColor(EnumChatFormatting.GREEN));
        //icommandsender.sendChatToPlayer(ChatMessageComponent.createFromText("Research has been updated").setColor(EnumChatFormatting.GREEN));
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