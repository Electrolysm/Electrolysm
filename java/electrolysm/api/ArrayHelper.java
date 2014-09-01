package electrolysm.api;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Clarky158 on 01/09/2014.
 */
public class ArrayHelper {

    public static List asList(int[] ints){
        List list = new ArrayList();
        for (int i = 0; i < ints.length; i++) {
            list.add(i, ints[i]);
        }
        return list;
    }

    public static List asList(String[] var1){
        List list = new ArrayList();
        for (int i = 0; i < var1.length; i++) {
            list.add(i, var1[i]);
        }
        return list;
    }

    public static List asList(boolean[] var1){
        List list = new ArrayList();
        for (int i = 0; i < var1.length; i++) {
            list.add(i, var1[i]);
        }
        return list;
    }

    public static List asList(float[] var1){
        List list = new ArrayList();
        for (int i = 0; i < var1.length; i++) {
            list.add(i, var1[i]);
        }
        return list;
    }

    public static List asList(Object[] var1){
        List list = new ArrayList();
        for (int i = 0; i < var1.length; i++) {
            list.add(i, var1[i]);
        }
        return list;
    }
}
