package electrolysm.electro.handlers.version;

import electrolysm.electro.handlers.DownloadHandler;
import electrolysm.electro.handlers.helpers.ColourEnumHelper;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import java.io.File;
import org.w3c.dom.Document;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

public class VersionCheck
{
    private static String message;

    public static void check(String modID, ElectrolysmVersion version)
    {
        String currentVersion = null;
        DownloadHandler.downloadVersionData();

        try {

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse (new File("config/electrolysm/version.xml"));

            // normalize text representation
            doc.getDocumentElement ().normalize ();
            //System.out.println ("Root element of the doc is " +
            //        doc.getDocumentElement().getNodeName());


            NodeList listOfPersons = doc.getElementsByTagName("version-" + version.getMODID());
            int totalPersons = listOfPersons.getLength();
            //System.out.println("Total no of people : " + totalPersons);

            for(int s=0; s<listOfPersons.getLength() ; s++){
                Node firstPersonNode = listOfPersons.item(s);
                if(firstPersonNode.getNodeType() == Node.ELEMENT_NODE){
                    Element firstPersonElement = (Element)firstPersonNode;
                    //System.out.println(version.getMCVersion() + ":mc-1.7.10");
                    //-------
                    NodeList firstNameList = firstPersonElement.getElementsByTagName(version.getMCVersion());
                    Element firstNameElement = (Element)firstNameList.item(0);
                    NodeList textFNList = firstNameElement.getChildNodes();
                    //System.out.println("First Name : " +
                    //        ((Node)textFNList.item(0)).getNodeValue().trim());
                    currentVersion = ((Node)textFNList.item(0)).getNodeValue().trim();
                }//end of if clause
            }//end of for loop with s var
        }catch (SAXParseException err) {
            System.out.println ("** Parsing error" + ", line "
                    + err.getLineNumber () + ", uri " + err.getSystemId ());
            System.out.println(" " + err.getMessage ());
        }catch (SAXException e) {
            Exception x = e.getException ();
            ((x == null) ? e : x).printStackTrace ();
        }catch (Throwable t) {
            t.printStackTrace ();
        }
        //System.exit (0);
        versionCheck(currentVersion, version);
        //System.out.println(message);
        //System.exit(0);
    }

    public static String getUpdateURL(String version, String modID)
    {
        String url = null;
        DownloadHandler.downloadVersionData();

        try {

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse (new File("config/electrolysm/version.xml"));

            // normalize text representation
            doc.getDocumentElement ().normalize ();

            NodeList listOfPersons = doc.getElementsByTagName(modID);
            for(int s=0; s<listOfPersons.getLength() ; s++)
            {
                Node firstPersonNode = listOfPersons.item(s);
                if(firstPersonNode.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element firstPersonElement = (Element)firstPersonNode;
                    //-------
                    NodeList firstNameList = firstPersonElement.getElementsByTagName(version);
                    Element firstNameElement = (Element)firstNameList.item(0);

                    NodeList textFNList = firstNameElement.getChildNodes();
                    url = ((Node)textFNList.item(0)).getNodeValue().trim();
                }//end of if clause


            }//end of for loop with s var


        }catch (SAXParseException err) {
            System.out.println ("** Parsing error" + ", line "
                    + err.getLineNumber () + ", uri " + err.getSystemId ());
            System.out.println(" " + err.getMessage ());

        }catch (SAXException e) {
            Exception x = e.getException ();
            ((x == null) ? e : x).printStackTrace ();

        }catch (Throwable t) {
            t.printStackTrace ();
        }

        return url;
    }

    public static void versionCheck(String currentVersion, ElectrolysmVersion version)
    {
        System.out.println(currentVersion);
        if(currentVersion == null) { return; }

        boolean equals = version.getMODVersion().replace(" ", "").equals(currentVersion.replace(" ", ""));
        System.out.println(equals);
        if(!equals)
        {
            String url = getUpdateURL("mod-" + currentVersion.replace(" ", ""), "version-" + version.getMODID());
            setMessageWithURL(url);
        }
        else
        {
            setMessage(null);
        }
    }

    public static void setMessage(String message1)
    {
        message = message1;
    }

    public static void setMessageWithURL(String url)
    {
        String messageString = ColourEnumHelper.GREY + "The latest version of Electrolysm is available at: " +
                ColourEnumHelper.YELLOW;
        message = messageString + url;
    }

    public static String getMessage()
    {
        return message;
    }
}
