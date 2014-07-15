package electro.handlers.version;

import api.items.Fetcher;
import electro.Electrolysm;

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
