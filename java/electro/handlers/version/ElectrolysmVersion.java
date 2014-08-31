package electro.handlers.version;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ben on 15/07/2014.
 */
public class ElectrolysmVersion
{
    List<String> dataList = new ArrayList<String>();

    public ElectrolysmVersion(String modID, String modVersion, String mcVersion)
    {
        dataList.add(modID);
        dataList.add(modVersion);
        dataList.add("mc-" + mcVersion);
       // System.out.println("....l....".replace("l", mcVersion));
        //System.exit(0);
    }

    public String getMODID()
    {
        return dataList.get(0);
    }

    public String getMODVersion()
    {
        return dataList.get(1);
    }

    public String getMCVersion()
    {
        return dataList.get(2);
    }

    public void register()
    {
        this.register(this.dataList.get(0), this);
    }

    public void register(String modID, ElectrolysmVersion version)
    {
        String checkID = "version-" + modID;
        VersionCheck.check(checkID, version);
    }
}
