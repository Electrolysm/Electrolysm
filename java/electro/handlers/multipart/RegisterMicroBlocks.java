package electro.handlers.multipart;

import codechicken.multipart.MultiPartRegistry;
import codechicken.multipart.TMultiPart;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ben on 18/07/2014.
 */
public class RegisterMicroBlocks
        implements MultiPartRegistry.IPartFactory
{
    public static RegisterMicroBlocks instance = new RegisterMicroBlocks();

    public static Map<Integer, IMicroBlock> mParts = new HashMap();
    public static Map<String, Integer> mIds = new HashMap();

    public static void register(IMicroBlock block)
    {
        mParts.put(Integer.valueOf(block.getMetadata()), block);
        mIds.put(block.getType(), Integer.valueOf(block.getMetadata()));
    }

    public static void register()
    {
        String[] s = new String[mParts.size()];

        for (int i = 0; i < mParts.size(); i++)
        {
            s[i] = ((IMicroBlock)mParts.get(Integer.valueOf(i))).getType();
            ((IMicroBlock)mParts.get(Integer.valueOf(i))).registerPassThroughs();
        }

        MultiPartRegistry.registerParts(instance, s);
    }

    public TMultiPart createPart(String arg0, boolean arg1)
    {
        return ((IMicroBlock)mParts.get(mIds.get(arg0))).newPart(arg1);
    }

    static
    {
        register(new PartCable());
    }
}