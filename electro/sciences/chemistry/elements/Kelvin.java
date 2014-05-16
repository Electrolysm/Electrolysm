package assets.electrolysm.electro.sciences.chemistry.elements;

public class Kelvin
{
	private static int temp;
	
    public Kelvin(int temperature)
    {
        temp = checkForValidTemp(temperature);
    }
    
    public static int checkForValidTemp(int tempurature)
    {
      if(temp < 0)
      {
          return tempurature;
      }
      else
      {
          return 0;
      }
    }
    
    public static int getKelvinTemp()
    {
        return temp;
    }
    
    public static int convertToCentigrade()
    {
        return (temp - 273);
    }
    
    //public static convertTo
}
