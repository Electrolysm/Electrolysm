package assets.electrolysm.electro.research.common;

/**
 * Created by Clarky158 on 16/06/2014.
 */
public class ScanData
{
    private static Object[] data;

    public ScanData(Object[] data1)
    {
        data = data1;
    }

    public static Object[] getData()
    {
        return data;
    }

    public static void setData(Object[] data1)
    {
        data = data1;
    }

    public static void addToData(Object singleData)
    {
        data[data.length] = singleData;
    }

    public ScanData mixWith(ScanData addData)
    {
        for(int i = 0; i < addData.getData().length; i++)
        {
            Object[] data2 = new Object[this.data.length + addData.getData().length];
            data2[data.length + i] = addData.getData()[i];
        }
        return new ScanData(this.data);
    }
}
