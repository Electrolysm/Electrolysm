package electro.handlers;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class DownloadHandler
{
    public static String down_file;
    public static int amountOnlineNames;

	public static void downloadSkinByUsername(String username)
    {
		down_file = "config/electrolysm/username.png";
		downloadLabSkin();
        try
        {
            URL website = new URL("http://skins.minecraft.net/MinecraftSkins/" + username + ".png");
            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
            FileOutputStream fos = new FileOutputStream(down_file.replace("username", username + ""));
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
	
	public static void downloadTechTree()
    {
		down_file = "config/electrolysm/techTree.png";
		downloadLabSkin();
        try
        {
            URL website = new URL("https://raw.githubusercontent.com/Electrolysm/Electrolysm/master/electro/research/system/Tech%20Tree.png");
            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
            FileOutputStream fos = new FileOutputStream(down_file);
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
	
	public static void downloadLabSkin()
	{
		try
        {
            URL website = new URL("https://raw.githubusercontent.com/Electrolysm/Electrolysm/master/textures/models/armor/labCoat.png");
            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
            FileOutputStream fos = new FileOutputStream(down_file.replace("username", "labCoat"));
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
	}
	
	public static void copyFileToLocation(File aFile, File[] files, String path)
	{
		addFilesToZip(aFile, files, path);
	}
	
	private static void addFilesToZip(File source, File[] files, String path)
	{
	    try
	    {
	        File tmpZip = File.createTempFile(source.getName(), null);
	        tmpZip.delete();
	        if(!source.renameTo(tmpZip))
	        {
	            throw new Exception("Could not make temp file (" + source.getName() + ")");
	        }
	        byte[] buffer = new byte[4096];
	        ZipInputStream zin = new ZipInputStream(new FileInputStream(tmpZip));
	        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(source));
	        for(int i = 0; i < files.length; i++)
	        {
	            InputStream in = new FileInputStream(files[i]);
	            out.putNextEntry(new ZipEntry(path + files[i].getName()));
	            for(int read = in.read(buffer); read > -1; read = in.read(buffer))
	            {
	                out.write(buffer, 0, read);
	            }
	            out.closeEntry();
	            in.close();
	        }
	        for(ZipEntry ze = zin.getNextEntry(); ze != null; ze = zin.getNextEntry())
	        {
	            if(!zipEntryMatch(ze.getName(), files, path))
	            {
	                out.putNextEntry(ze);
	                for(int read = zin.read(buffer); read > -1; read = zin.read(buffer))
	                {
	                    out.write(buffer, 0, read);
	                }
	                out.closeEntry();
	            }
	        }
	        out.close();
	        tmpZip.delete();
	    }catch(Exception e)
	    {
	        e.printStackTrace();
	    }
	}

	private static boolean zipEntryMatch(String zeName, File[] files, String path){
	    for(int i = 0; i < files.length; i++){
	        if((path + files[i].getName()).equals(zeName)){
	            return true;
	        }
	    }
	    return false;
	}

    public static void downloadResearchData()
    {
        File file = new File("mods/Electrolysm/data");

        try
        {
            file.mkdirs();

            String url = "https://github.com/Electrolysm/Electrolysm/blob/1.7.2/resources/assets/research_data/data_resources.zip?raw=true";
            URL website = new URL(url);
            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
            FileOutputStream fos = new FileOutputStream(new File(file, "/data_resources.zip"));
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        }
        catch(FileNotFoundException e) { }
        catch (MalformedURLException e) { }
        catch (IOException e){ }
    }

    public static void downloadAndExtractResearchData()
    {
        downloadResearchData();
        String filex = "mods/Electrolysm/data/";
        String zipLocation = filex + "data_resources.zip";

        try
        {
            //String destinationname = "d:\\servlet\\testZip\\";
            byte[] buf = new byte[1024];
            ZipInputStream zipinputstream = null;
            ZipEntry zipentry;
            zipinputstream = new ZipInputStream(
                    new FileInputStream(zipLocation));

            zipentry = zipinputstream.getNextEntry();
            while (zipentry != null)
            {
                //for each entry to be extracted
                String entryName = zipentry.getName();
                System.out.println("entryname "+entryName);
                int n;
                FileOutputStream fileoutputstream;
                File newFile = new File(entryName);
                String directory = newFile.getParent();

                if(directory == null)
                {
                    if(newFile.isDirectory())
                        break;
                }

                fileoutputstream = new FileOutputStream(
                        filex+entryName);

                while ((n = zipinputstream.read(buf, 0, 1024)) > -1)
                    fileoutputstream.write(buf, 0, n);

                fileoutputstream.close();
                zipinputstream.closeEntry();
                zipentry = zipinputstream.getNextEntry();

            }//while

            zipinputstream.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
