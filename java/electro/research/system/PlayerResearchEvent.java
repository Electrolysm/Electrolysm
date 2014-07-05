package electro.research.system;

import electro.research.common.SavePlayerScanData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import org.apache.commons.lang3.text.WordUtils;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

/**
 * Created by Clarky158 on 19/06/2014.
 */
public class PlayerResearchEvent
{
    public static void callScanEvent(EntityPlayer player, String username)
    {
        //System.out.println(ResearchRegistry.getResearch("turbine").getName());

        Research research = null;
        if((research = onScanEvent(username)) != null)
        {
            //System.out.println("research" + research.getName());
            //saveActiveResearch
            if (!SavePlayerScanData.ResearchData.hasPlayerUnlocked((username + "_active"), research.getName()))
            {
                new SavePlayerScanData.ResearchData(username, research.getName());
                notifyPlayer(player, research);
                //System.out.println(research.getName());
            }
        }
    }

    public static void notifyPlayer(EntityPlayer player, Research research)
    {
        String researchName = WordUtils.capitalize(research.getName().replace("_", " "));
        String message = "You have unlocked the ";
        String messageEnd = " research.";

        IChatComponent all = new ChatComponentTranslation(message + researchName + messageEnd)
                .setChatStyle(new ChatStyle().setColor(EnumChatFormatting.DARK_PURPLE));
        player.addChatMessage((all));
    }

    public static Research onScanEvent(String username)
    {
        String check = "";
        Research unlocked = null;
        Research[] unlockedArray = new Research[ResearchRegistry.getResearchMap().size()];
        List<String> unlocalisedNames = SavePlayerScanData.ScanData.getUserData(username);

        LinkedHashMap<String, String> researchRequire = ResearchRegistry.getRequireMap();
        LinkedHashMap<String, String> researchMap = ResearchRegistry.getResearchMap();

        //System.out.println(researchMap.size());
        if(unlocalisedNames == null) { SavePlayerScanData.ScanData.makeFile(username); return null; }

        for(int p = 0; p < researchMap.size(); p++)
        {
            Set<String> keySet = researchMap.keySet();
            String researchName = String.valueOf(keySet.toArray()[p]);
            String researchString = researchMap.get(researchName);
            Research research = ResearchRegistry.getResearch(researchName);
            unlocked = research;

            //System.out.println("for1." + p + ": " + researchName + "---" + researchRequire.get(researchString));

            if(researchRequire.get(researchString) != null &&
                    !(SavePlayerScanData.ResearchData.hasPlayerUnlocked(username + "_active", researchName)))
            {
                //System.out.println("nullCheck");

                String requireString = researchRequire.get(researchString);
                String[] requirementArray = ResearchRegistry.getRequirementsFromStringAsArray(requireString);

                for (int i = 0; i < requirementArray.length; i++)
                {
                    //System.out.println("for2" + requirementArray[i] + requirementArray.length + ";" + i);
                    String require = requirementArray[i];

                    if (unlocalisedNames.contains(require + ",") || unlocalisedNames.contains(require + ",,"))
                    {
                        //System.out.println("contentCheck");

                        check = check + "true";
                    }
                    else
                    {
                        //System.out.println("contentElse");
                        check = check + "false";
                    }
                }
            }
            else
            {
                check = "false";
            }

            if(check.contains("false"))
            {
                //System.out.println("false");

                unlockedArray[p] = null;
            }
            else
            {
                //System.out.println("unlocked-" + unlocked);

                unlockedArray[p] = unlocked;
                return unlocked;
            }

            check = "";
        }

        for(int i = 0; i < unlockedArray.length; i++)
        {
            //System.out.println("arrayFor");
            if(unlockedArray[i] != null)
            {
                //System.out.println("Unlocked: " + unlockedArray[i].getName());
                return unlockedArray[i];
            }
        }
        return null;
    }
}