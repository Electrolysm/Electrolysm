package electrolysm.electro.handlers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class NewsCheck
{
    private static String line;
    public static boolean checkDone;
    public static String chatMessage;
    public static String version;

    public static void check()
    {
        //LoggerHandler.info(("Starting News Check"));
        URL url = null;
        String inputLine = "";

        try
        {
            url = new URL("https://raw.github.com/Clarky158/Electrolysm/master/news.xml");
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }

        BufferedReader in;

        try
        {
            URLConnection con = url.openConnection();
            con.setReadTimeout(1000);   //1 second
            in = new BufferedReader(new InputStreamReader(con.getInputStream()));

            while ((inputLine = in.readLine()) != null)
            {
                //System.out.println("[Electrolysm]" + inputLine);
                line = "[Electrolysm]" + inputLine;
            }

            in.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        if (line != null)
        {
            chatMessage = line.replace("[Electrolysm]", "");
        }

        //System.out.println("[Electrolysm]" + version);
        //LoggerHandler.info("Ended News Check");
        checkDone = true;
    }
}
