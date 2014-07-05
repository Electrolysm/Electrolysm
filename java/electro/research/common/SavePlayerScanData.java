package electro.research.common;

import cpw.mods.fml.common.Mod;
import electro.handlers.helpers.EncryptionHelper;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import org.lwjgl.Sys;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.io.*;
import java.security.*;
import java.util.*;

/**
 * Created by Clarky158 on 16/06/2014.
 */
public class SavePlayerScanData
{
    static String fileLocation1 = "config/Electrolysm/Research";
    static String fileLocation = "config/Electrolysm/Research/";

    public static class ScanData {
        public ScanData(String username, String newData) {
            try {
                if (this.getUserData(username) != null) {
                    if (!this.dataAlreadyExists(newData + ",", this.getUserData(username))) {
                        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
                        List<String> list = this.getUserData(username);
                        if (newData.contains(",")) {
                            list.add(newData);
                        } else {
                            list.add(newData + ",");
                        }
                        map.put(username, list);
                        this.saveData(map, username);
                        //this.getPlayerData("Clarky158");
                    }
                } else {
                    this.makeFile(username);
                    this.reRun(username, newData);
                }
            } catch (FileNotFoundException e) {
                //LoggerHandler.severe("Failed to find file with name: " + username + ".txt");
            }
        }

        public void reRun(String username, String newData) {
            //System.out.println("reRun");
            new ScanData(username, newData);
        }

        public static void makeFile(String username) {
            try {
                File file = new File(fileLocation + username + ".txt");
                File fileDIR = new File(fileLocation1);
                fileDIR.mkdir();
                file.createNewFile();
            } catch (IOException e) {
                //LoggerHandler.severe("Failed to create file with name: " + username + ".txt");
            }
        }

        public static boolean hasPlayerScanned(String username, String unlocalName) {
            HashMap<String, List<String>> map = getPlayerData(username);
            if(map != null) {
                return dataAlreadyExists(unlocalName, map.get(username));
            } else {
                makeFile(username);
                return false;
            }

        }

        public static boolean dataAlreadyExists(String newData, List<String> list) {
            //System.out.println(newData + "." + newData.replace(" ", ""));
            if(list != null) {
                Object[] arrayList = list.toArray();
                for (int i = 0; i < arrayList.length; i++) {
                    if (list.contains(newData.replace(" ", "")) || ((String) arrayList[i]).contains(newData)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public static List<String> getUserData(String username) {
            if (getPlayerData(username) != null && getPlayerData(username).get(username) != null)
            {
                HashMap<String, List<String>> hashMap = getPlayerData(username);
                List<String> listData = hashMap.get(username);
                return listData;
            }
            else
            {
                makeFile(username);
                return null;
            }
        }

        public static HashMap<String, List<String>> getPlayerData(String username) {

            File file = new File(fileLocation + username + ".txt");
            if(!file.exists()) { makeFile(username); }

            try {
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
            } catch (IOException e) {
                //e.printStackTrace();
                //LoggerHandler.severe("Failed to find file with name: " + username + ".txt");
            }

            return null;
        }

        public void saveData(HashMap<String, List<String>> map, String username) throws FileNotFoundException {
            File file = new File(fileLocation + username + ".txt");
            int mapSize = map.size();
            PrintWriter writer = new PrintWriter(file);

            for (int i = 0; i < mapSize; i++) {
                writer.println("[" + username + " - " + map.get(username) + "]");
            }
            writer.close();
        }

        public String obfString(String username) {
            String sectionSign = "\u00a7";
            return (sectionSign + "k" + username);
        }

        public int getLineNumber(String username) throws IOException {
            FileReader readFile = new FileReader(fileLocation + username + ".txt");
            BufferedReader bf = new BufferedReader(readFile);

            String aLine;
            int numberOfLines = 0;
            while ((aLine = bf.readLine()) != null) {
                numberOfLines++;
            }
            bf.close();
            return numberOfLines;
        }
    }

    //==================================

    public static class ResearchData
    {
        public ResearchData(String user, String name)
        {
            String username = user + "_active";
            String researchName = this.encryptString(name);

            try {
                if (this.getUserData(username) != null) {
                    if (!this.dataAlreadyExists(researchName + ",", this.getUserData(username))) {
                        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
                        List<String> list = this.getUserData(username);
                        if (researchName.contains(",")) {
                            list.add(researchName);
                        } else {
                            list.add(researchName + ",");
                        }
                        map.put(username, list);
                        this.saveData(map, username);
                        //this.getPlayerData("Clarky158");
                    }
                } else {
                    this.makeFile(username);
                    this.reRun(username, researchName);
                }
            } catch (FileNotFoundException e) {
                //LoggerHandler.severe("Failed to find file with name: " + username + ".txt");
            }
        }

        public static String encryptString(String data)
        {
            //System.out.println("encrypt");
            String result = EncryptionHelper.encode(data);
            //System.out.println(result);
            return result;
        }

        public static String decryptString(String data)
        {
            String result = EncryptionHelper.decode(data);
            return result;
        }

        public void reRun(String username, String newData) {
            //System.out.println("reRun");
            new ScanData(username, newData);
        }

        public static void makeFile(String username) {
            try {
                File file = new File(fileLocation + username + ".txt");
                file.createNewFile();
            } catch (IOException e) {
                //LoggerHandler.severe("Failed to create file with name: " + username + ".txt");
            }
        }

        public static boolean hasPlayerUnlocked(String username, String unlocalName)
        {
            if(getPlayerData(username) != null && getPlayerData(username).get(username) != null) {
                List<String> list = getPlayerData(username).get(username);
                return dataAlreadyExists(encryptString(unlocalName), list);
            }
            else {
                makeFile(username);
                return false;
            }
        }

        public static boolean hasPlayerGotTier(String username, int requiredLevel)
        {
            List<String> list = getPlayerData(username).get(username);

            if(list.contains(encryptString(requiredLevel + ",")) || list.contains(encryptString(requiredLevel + ",,")))
            {
                return true;
            }

            return false;
        }



        public static boolean dataAlreadyExists(String newData, List<String> list) {
            //System.out.println(newData + "." + newData.replace(" ", ""));
            Object[] arrayList = list.toArray();
            for (int i = 0; i < arrayList.length; i++)
            {
                //System.out.println((encryptString(newData)));
                if (list.contains((newData.replace(" ", ""))) ||
                        ((String) arrayList[i]).contains((newData)))
                {
                    return true;
                }
            }

            return false;
        }

        public static List<String> getUserData(String username) {
            if (getPlayerData(username) != null) {
                HashMap<String, List<String>> hashMap = getPlayerData(username);
                List<String> listData = hashMap.get(username);
                return listData;
            }
            return null;
        }

        public static HashMap<String, List<String>> getPlayerData(String username) {
            try {
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
            } catch (IOException e) {
                //e.printStackTrace();
                //LoggerHandler.severe("Failed to find file with name: " + username + ".txt");
            }

            return null;
        }

        public void saveData(HashMap<String, List<String>> map, String username) throws FileNotFoundException {
            File file = new File(fileLocation + username + ".txt");
            int mapSize = map.size();
            PrintWriter writer = new PrintWriter(file);

            for (int i = 0; i < mapSize; i++) {
                writer.println("[" + username + " - " + map.get(username) + "]");
            }
            writer.close();
        }

        public String obfString(String username) {
            String sectionSign = "\u00a7";
            return (sectionSign + "k" + username);
        }

        public int getLineNumber(String username) throws IOException {
            FileReader readFile = new FileReader(fileLocation + username + ".txt");
            BufferedReader bf = new BufferedReader(readFile);

            String aLine;
            int numberOfLines = 0;
            while ((aLine = bf.readLine()) != null) {
                numberOfLines++;
            }
            bf.close();
            return numberOfLines;
        }
    }

}
