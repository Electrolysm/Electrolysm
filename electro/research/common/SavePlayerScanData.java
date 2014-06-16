package assets.electrolysm.electro.research.common;

import cpw.mods.fml.common.Mod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

import java.io.*;
import java.util.Scanner;

/**
 * Created by Clarky158 on 16/06/2014.
 */
public class SavePlayerScanData
{
    String fileLocation = "config/Electrolysm/Research/";

    public SavePlayerScanData(String username, ScanData newData, ScanData oldData)
    {
       this.saveData(username, newData, oldData);
    }
    public SavePlayerScanData(String username, ScanData newData)
    {
        this.saveData(username, newData, this.getCurrentInFile(username));
    }

    public void saveData(String username, ScanData dataOld, ScanData dataNew)
    {
        try
        {
            File file = new File(fileLocation + username + ".txt");
            file.delete();
            Object[] data = dataOld.getData();

            PrintWriter writer = new PrintWriter(file);

            //writer.println(username + ",");
            //writer.println(this.obfString(username));


            for(int i = 0; i < data.length; i++)
            {
                 writer.println(data[i] + ",");
            }
            if(dataNew != null) { writer.println(dataNew.toString() + ","); }
            writer.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

    }

    public ScanData getCurrentInFile(String username)
    {
        Object[] data = null;
        try
        {
            FileReader fr = new FileReader(fileLocation + username + ".txt");
            BufferedReader textReader = new BufferedReader(fr);

            int NoLines = this.getLineNumber(username);
            String[] textData = new String[NoLines];

            System.out.println(NoLines);
            for(int i = 0; i < NoLines; i++)
            {
                textData[i] = textReader.readLine();
                System.out.println(textData[i]);
            }

            textReader.close();

            return new ScanData(textData);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static String obfString(String username)
    {
        String sectionSign = "\u00a7";
        return (sectionSign + "k" + username);
    }

    public int getLineNumber(String username) throws IOException
    {
        FileReader readFile = new FileReader(fileLocation + username + ".txt");
        BufferedReader bf = new BufferedReader(readFile);

        String aLine;
        int numberOfLines = 0;
        while((aLine = bf.readLine()) != null){
            numberOfLines++;
        }
        bf.close();
        return numberOfLines;
    }
}
