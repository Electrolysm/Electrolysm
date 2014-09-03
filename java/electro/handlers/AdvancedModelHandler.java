package electro.handlers;

import electro.common.CommonProxy;
import net.minecraft.client.model.ModelBase;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

/**
 * Created by Clarky158 on 03/09/2014.
 */
public class AdvancedModelHandler
{
    public static class advancedModel{
        public static IModelCustom getModelReceiver(){
            return AdvancedModelLoader.loadModel(CommonProxy.MODELS_OBJ.MODEL_RECEIVER);
        }
        public static IModelCustom getModelReceiverNoSpheres(){
            return AdvancedModelLoader.loadModel(CommonProxy.MODELS_OBJ.MODEL_RECEIVER_NO_SPHERES);
        }
    }
}
