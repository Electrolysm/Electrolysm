package electro.research.system;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ResearchTextRegistry 
{
    private static String researchDataLocation = "mods/Electrolysm/data/";

	public static String[] getTextInFile(File file)
	{
        try
        {
            BufferedReader in = new BufferedReader(new FileReader(file));

            String[] values = new String[0];
            while (in.ready())
            {
                String text = in.readLine();
                return text.split("#");
            }
            in.close();
        }
        catch (FileNotFoundException e)
        {
            try {
                BufferedReader in = new BufferedReader(new FileReader(new File(researchDataLocation + "placeHolder.txt")));

                String[] values = new String[0];
                while (in.ready()) {
                    String text = in.readLine();
                    return text.split("#");
                }
                in.close();
            }
            catch (FileNotFoundException ex) { }
            catch (IOException ex) { }
        }
        catch (IOException e) { }

        return null;
	}
	
	public static String[] getInfoFromResearch(Research research)
	{
        String researchName = research.getName();
        File file = new File(researchDataLocation + researchName + ".txt");
        return getTextInFile(file);
	}
}
