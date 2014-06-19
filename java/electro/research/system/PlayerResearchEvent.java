package electro.research.system;

import electro.research.common.SavePlayerScanData;
import net.minecraft.item.ItemStack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Clarky158 on 19/06/2014.
 */
public class PlayerResearchEvent
{
    public static void callScanEvent(String username)
    {
        Research research = null;
        if((research = onScanEvent(username)) != null)
        {
            //saveActiveResearch
            if(!(SavePlayerScanData.ResearchData.hasPlayerUnlocked(username, research.getName())))
            {
                new SavePlayerScanData.ResearchData(username, research.getName());
                System.out.println(research.getName());
            }
        }
    }

    public static Research onScanEvent(String username)
    {
        String check = "";
        Research unlocked = null;
        List<String> unlocalisedNames = SavePlayerScanData.ScanData.getUserData(username);

        HashMap<String, String> researchRequire = ResearchRegistry.getRequireMap();
        HashMap<String, String> researchMap = ResearchRegistry.getResearchMap();

        for(Map.Entry<String, String>  set : researchMap.entrySet())
        {
            String researchName = set.getKey();
            String researchString = researchMap.get(researchName);
            Research research = ResearchRegistry.getResearch(researchName);
            unlocked = research;

            String requireString = researchRequire.get(researchString);
            String[] requirementArray = ResearchRegistry.getRequirementsFromStringAsArray(requireString);

            for(int i = 0; i < requirementArray.length; i++)
            {
                String require = requirementArray[i];

                if(unlocalisedNames.contains(require + ",") || unlocalisedNames.contains(require + ",,"))
                {
                    check = check + "true";
                }
                else
                {
                    check = check + "false";
                }
            }

            if(check.contains("false"))
            {
                return null;
            }
            else
            {
                return unlocked;
            }
        }

        unlocked = null;
        check = "";
        return null;
    }
}
