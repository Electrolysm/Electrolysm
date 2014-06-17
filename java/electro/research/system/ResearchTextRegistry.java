package electro.research.system;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ResearchTextRegistry 
{
	private static final HashMap<Research, List<LinedString>> textMap = new HashMap<Research, List<LinedString>>();
	
	public static void addResearchText(Research research, LinedString hint, LinedString details)
	{
		textMap.put(research, Arrays.asList(hint, details));
	}
	
	public static void addResearchTextFromFile(Research research, File file)
	{
		addResearchText(research, new LinedString(getTextInFile(file).get(0)), new LinedString(getTextInFile(file).get(1)));
	}
	
	public static void addResearchTextFromFolder(Research research, File folder)
	{
		addResearchTextFromFile(research, new File(folder, "dataResearch_" + research.getName() + ".txt"));
	}
	
	public static List<String[]> getTextInFile(File file)
	{
		try 
		{
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			
			while ((line = bufferedReader.readLine()) != null) 
			{
				stringBuffer.append(line);
				stringBuffer.append("(splitCodec6742)");
			}
			fileReader.close();

			String[] TwoTexts = (stringBuffer.toString().split("(##########)" + "(splitCodec6742)"));
			String[] hintByLine = (TwoTexts[0].toString().split("(splitCodec6742)"));
			String[] infoByLine = (TwoTexts[1].toString().split("(splitCodec6742)"));
			
			return Arrays.asList(hintByLine, infoByLine);
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}

		return null;
	}
	
	public static List<LinedString> getInfoFromResearch(Research research)
	{
		if(textMap.get(research) != null)
		{
			return textMap.get(research);
		}
		else
		{
			return null;
		}
	}
	
	public static HashMap<Research, List<LinedString>> getTextMap()
	{
		return textMap;
	}
}
