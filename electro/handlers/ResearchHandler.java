package assets.electrolysm.electro.handlers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import assets.electrolysm.electro.research.Research;

public class ResearchHandler{

	public static String down_file = "config/research.xml";
	
	@SuppressWarnings("resource")
	public static void downloadOnlineResearch()
	{
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
	}
		
    public static void getStoredResearch(){
    try {

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse (new File(down_file));

            // normalize text representation
            doc.getDocumentElement ().normalize ();
            System.out.println ("Root element of the doc is " + 
                 doc.getDocumentElement().getNodeName());


            NodeList listOfResearch = doc.getElementsByTagName("research");
            int totalResearch = listOfResearch.getLength();
            System.out.println("Total No. of online research : " + totalResearch);

            for(int s = 0; s < listOfResearch.getLength(); s++)
            {
                Node firstPersonNode = listOfResearch.item(s);
               
                if(firstPersonNode.getNodeType() == Node.ELEMENT_NODE)
                {
                    //-------input id
                    Element firstPersonElement = (Element)firstPersonNode;
                    NodeList firstNameList = firstPersonElement.getElementsByTagName("input");
                    Element firstNameElement = (Element)firstNameList.item(0);

                    NodeList textFNList = firstNameElement.getChildNodes();
                    System.out.println("Input Item: " + 
                           ((Node)textFNList.item(0)).getNodeValue().trim());

                    //-------output meta
                    NodeList lastNameList = firstPersonElement.getElementsByTagName("output");
                    Element lastNameElement = (Element)lastNameList.item(0);

                    NodeList textLNList = lastNameElement.getChildNodes();
                    System.out.println("Output Item: " + 
                           ((Node)textLNList.item(0)).getNodeValue().trim());

                    //------card id required
                    NodeList cardIDList = firstPersonElement.getElementsByTagName("cardID");
                    Element cardIDElement = (Element)cardIDList.item(0);

                    NodeList textLmList = cardIDElement.getChildNodes();
                    System.out.println("Card ID required: " + 
                           ((Node)textLmList.item(0)).getNodeValue().trim());

                    //------
                    //Adding to research!
                    Research.researchList.put(((Node)textFNList.item(0)).getNodeValue().trim(),
                    		((Node)textLNList.item(0)).getNodeValue().trim());
                    Research.cardIDList.put(((Node)textLNList.item(0)).getNodeValue().trim(),
                    		((Node)textLmList.item(0)).getNodeValue().trim());
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

    }//end of main


}