package electro.research.system;

public class LinedString
{
	private static String[] LineData;
	
	public LinedString(String[] data)
	{
		LineData = data;
	}
	
	public static String[] getLineData()
	{
		return LineData;
	}
	
	public static String getDataFromLine(int lineNo)
	{
		return LineData[lineNo];
	}
	
	public static void setLineData(String[] lineData)
	{
		LineData = lineData;
	}
}
