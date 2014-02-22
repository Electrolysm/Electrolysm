package assets.electrolysm.electro.handlers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import net.minecraft.item.ItemStack;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.research.Research;

public class ResearchHandler
{
    public static String down_file = "config/electrolysm/research.xml";
    public static String down_file_names = down_file.replace("research", "names");
    public static int amountOnlineNames;

    @SuppressWarnings("resource")
    public static void downloadOnlineData()
    {
        //Research Data Download
        try
        {
            URL website = new URL("https://raw.github.com/Clarky158/Electrolysm/master/research.xml");
            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
            FileOutputStream fos = new FileOutputStream(down_file);
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        //Research Note Data
        try
        {
            URL website = new URL("https://raw.github.com/Clarky158/Electrolysm/master/names.xml");
            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
            FileOutputStream fos = new FileOutputStream(down_file_names);
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void getStoredResearch()
    {
        try
        {
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(new File(down_file));
            // normalize text representation
            doc.getDocumentElement().normalize();
            NodeList listOfResearch = doc.getElementsByTagName("research");
            int totalResearch = listOfResearch.getLength();

            for (int s = 0; s < listOfResearch.getLength(); s++)
            {
                Node firstPersonNode = listOfResearch.item(s);

                if (firstPersonNode.getNodeType() == Node.ELEMENT_NODE)
                {
                    //Input Item ID
                    Element firstPersonElement = (Element)firstPersonNode;
                    NodeList firstNameList = firstPersonElement.getElementsByTagName("input");
                    Element firstNameElement = (Element)firstNameList.item(0);
                    NodeList textFNList = firstNameElement.getChildNodes();
                    //Output Item ID
                    NodeList lastNameList = firstPersonElement.getElementsByTagName("output");
                    Element lastNameElement = (Element)lastNameList.item(0);
                    NodeList textLNList = lastNameElement.getChildNodes();
                    //Required Card ID
                    NodeList cardList = firstPersonElement.getElementsByTagName("cardID");
                    Element cardElement = (Element)lastNameList.item(0);
                    NodeList cardLNList = lastNameElement.getChildNodes();
                    int inputID = Integer.parseInt(((Node)textFNList.item(0)).getNodeValue().trim());
                    ItemStack output = new ItemStack(electrolysmCore.researchPaper, 1,
                                                     Integer.parseInt(((Node)textLNList.item(0)).getNodeValue().trim()));
                    int cardID = Integer.parseInt(((Node)textLNList.item(0)).getNodeValue().trim());
                    Research.onlineResearch(inputID, output, cardID);
                }//end of if clause
            }//end of for loop with s var
        }
        catch (SAXParseException err)
        {
            System.out.println("** Parsing error" + ", line "
                               + err.getLineNumber() + ", uri " + err.getSystemId());
            System.out.println(" " + err.getMessage());
        }
        catch (SAXException e)
        {
            Exception x = e.getException();
            ((x == null) ? e : x).printStackTrace();
        }
        catch (Throwable t)
        {
            t.printStackTrace();
        }

        //System.exit (0);
    }//end of main

    public static String getStoredNames(int inputMeta)
    {
        try
        {
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(new File(down_file_names));
            // normalize text representation
            doc.getDocumentElement().normalize();
            NodeList listOfNames = doc.getElementsByTagName("names");
            int totalResearch = listOfNames.getLength();

            for (int s = 0; s < totalResearch; s++)
            {
                Node firstPersonNode = listOfNames.item(s);

                if (firstPersonNode.getNodeType() == Node.ELEMENT_NODE)
                {
                    //-------input id
                    Element firstPersonElement = (Element)firstPersonNode;
                    NodeList firstNameList = firstPersonElement.getElementsByTagName("infoData");
                    Element firstNameElement = (Element)firstNameList.item(0);
                    NodeList textFNList = firstNameElement.getChildNodes();
                    String result1 = ((Node)textFNList.item(0)).getNodeValue().trim();

                    if (result1.contains(inputMeta + ""))
                    {
                        String result = result1.replace(inputMeta + "", "");
                        return result;
                    }
                }
            }
        }
        catch (SAXParseException err)
        {
            System.out.println("** Parsing error" + ", line "
                               + err.getLineNumber() + ", uri " + err.getSystemId());
            System.out.println(" " + err.getMessage());
        }
        catch (SAXException e)
        {
            Exception x = e.getException();
            ((x == null) ? e : x).printStackTrace();
        }
        catch (Throwable t)
        {
            t.printStackTrace();
        }

        return null;
    }

    public static int getAmountOfStoredNames()
    {
        try
        {
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(new File(down_file_names));
            // normalize text representation
            doc.getDocumentElement().normalize();
            NodeList listOfNames = doc.getElementsByTagName("names");
            int totalNames = listOfNames.getLength();
            return totalNames;
        }
        catch (SAXParseException err)
        {
            System.out.println("** Parsing error" + ", line "
                               + err.getLineNumber() + ", uri " + err.getSystemId());
            System.out.println(" " + err.getMessage());
        }
        catch (SAXException e)
        {
            Exception x = e.getException();
            ((x == null) ? e : x).printStackTrace();
        }
        catch (Throwable t)
        {
            t.printStackTrace();
        }

        return 0;
    }
}
