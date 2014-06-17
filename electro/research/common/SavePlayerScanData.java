package assets.electrolysm.electro.research.common;

import assets.electrolysm.api.LoggerHandler;
import cpw.mods.fml.common.Mod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import org.lwjgl.Sys;

import java.io.*;
import java.util.*;

/**
 * Created by Clarky158 on 16/06/2014.
 */
public class SavePlayerScanData
{
    static String fileLocation = "config/Electrolysm/Research/";

    public SavePlayerScanData(String username, String newData)
    {
        try
        {
            if(this.getUserData(username) != null)
            {
                if (!this.dataAlreadyExists(newData + ",", this.getUserData(username)))
                {
                    HashMap<String, List<String>> map = new HashMap<String, List<String>>();
                    List<String> list = this.getUserData(username);
                    if(newData.contains(",")) { list.add(newData); }else{ list.add(newData + ","); }
                    map.put(username, list);
                    this.saveData(map, username);
                    //this.getPlayerData("Clarky158");
                }
            }
            else
            {
                this.makeFile(username);
                this.reRun(username, newData);
            }
        }
        catch(FileNotFoundException e)
        {
            LoggerHandler.severe("Failed to find file with name: " + username + ".txt");
        }
    }

    public void reRun(String username, String newData)
    {
        System.out.println("reRun");
        new SavePlayerScanData(username, newData);
    }

    public void makeFile(String username)
    {
        try {
            File file = new File(fileLocation + username + ".txt");
            file.createNewFile();
        }
        catch(IOException e)
        {
            LoggerHandler.severe("Failed to create file with name: " + username + ".txt");
        }
    }

    public static boolean hasPlayerScanned(String username, String unlocalName)
    {
        List<String> list = getPlayerData(username).get(username);
        return dataAlreadyExists(unlocalName, list);
    }

    public static boolean dataAlreadyExists(String newData, List<String> list)
    {
        System.out.println(newData + "." + newData.replace(" ", ""));
        Object[] arrayList = list.toArray();
        for (int i = 0; i < arrayList.length; i++)
        {
            if (list.contains(newData.replace(" ", "")) || ((String)arrayList[i]).contains(newData))
            {
                return true;
            }
        }

        return false;
    }

    public List<String> getUserData(String username)
    {
        if(this.getPlayerData(username) != null) {
            HashMap<String, List<String>> hashMap = this.getPlayerData(username);
            List<String> listData = hashMap.get(username);
            return listData;
        }
        return null;
    }

    public static HashMap<String, List<String>> getPlayerData(String username)
    {
        try
        {
            File file = new File(fileLocation + username + ".txt");
            BufferedReader in = new BufferedReader(new FileReader(file));

            String username1 = "";
            String[] values = new String[0];
            while (in.ready()) {
                String text = in.readLine();
                username1 = text.split(" - ")[0].replace("[", "").replace(" ", "");
                values = text.split(" - ")[1].replace("[", "").replace("]", "").split(", ");
            }
            in.close();

            //System.out.println(username1.contains(username));
            List<String> list1 = new ArrayList<String>();
            for (int i = 0; i < values.length; i++) {
                list1.add(values[i]);
            }
            //System.out.println(list1);
            HashMap<String, List<String>> hashMap = new HashMap<String, List<String>>();
            hashMap.put(username, list1);

            return hashMap;
        }
        catch(IOException e)
        {
            //e.printStackTrace();
            LoggerHandler.severe("Failed to find file with name: " + username + ".txt");
        }

        return null;
    }

    public void saveData(HashMap<String, List<String>> map, String username) throws FileNotFoundException
    {
        File file = new File(fileLocation + username + ".txt");
        int mapSize = map.size();
        PrintWriter writer = new PrintWriter(file);

        for(int i = 0; i < mapSize; i++)
        {
            writer.println("[" + username + " - " + map.get(username) + "]");
        }
        writer.close();
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
