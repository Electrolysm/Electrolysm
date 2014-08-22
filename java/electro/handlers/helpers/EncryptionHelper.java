package electro.handlers.helpers;

/**
 * Created by Clarky158 on 19/06/2014.
 */
public class EncryptionHelper
{
    private static String[] alphabet = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    private static int[] position = new int[]      {1 , 2, 3, 4, 5, 4, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 21, 32, 33, 34, 35};
    private static String key = "mouse";

    public static String encode(String data1)
    {
        String data = data1.toLowerCase();
        String repeatingKey = "";
        String[] encodedString = data.split("");
        int stringCharactors = data.length() + 1;

        for(int i = 0; i < (stringCharactors); i++)
        {
            repeatingKey = repeatingKey + key;
        }

        for(int l = 0; l < stringCharactors; l++)
        {
            for(int i = 0; i < alphabet.length; i++)
            {
                if(data.split("")[l].contains(alphabet[i]))
                {
                    int value = i + position[l];
                    if(value >= alphabet.length)
                    {
                        value = value - alphabet.length;
                    }
                    encodedString[l] = alphabet[value];
                }
            }
        }
        String result= "";
        for(int w = 0; w < stringCharactors; w++)
        {
            result = result + encodedString[w];
        }

        return result;
    }

    public static String decode(String data)
    {
        String repeatingKey = "";
        String[] encodedString = data.split("");
        int stringCharactors = data.length() + 1;

        for(int i = 0; i < (stringCharactors); i++)
        {
            repeatingKey = repeatingKey + key;
        }

        for(int l = 0; l < stringCharactors; l++)
        {
            for(int i = 0; i < alphabet.length; i++)
            {
                if(data.split("")[l].contains(alphabet[i]))
                {
                    int value = i - position[l];
                    if(value >= alphabet.length)
                    {
                        value = value - alphabet.length;
                    }
                    if(value < 0)
                    {
                        value = alphabet.length + value;
                    }
                    encodedString[l] = alphabet[value];
                }
            }
        }
        String result= "";
        for(int w = 0; w < stringCharactors; w++)
        {
            result = result + encodedString[w];
        }

        return result;
    }

    public static String encodeWithKey(String data1, String alternateKey)
    {
        String data = data1.toLowerCase();
        String repeatingKey = "";
        String[] encodedString = data.split("");
        int stringCharactors = data.length() + 1;

        for(int i = 0; i < (stringCharactors); i++)
        {
            repeatingKey = repeatingKey + alternateKey;
        }

        for(int l = 0; l < stringCharactors; l++)
        {
            for(int i = 0; i < alphabet.length; i++)
            {
                if(data.split("")[l].contains(alphabet[i]))
                {
                    int value = i + position[l];
                    if(value >= alphabet.length)
                    {
                        value = value - alphabet.length;
                    }
                    encodedString[l] = alphabet[value];
                }
            }
        }
        String result= "";
        for(int w = 0; w < stringCharactors; w++)
        {
            result = result + encodedString[w];
        }

        return result;
    }
}
