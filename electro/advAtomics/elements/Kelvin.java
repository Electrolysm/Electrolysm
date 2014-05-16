package *;

public class Kelvin
{
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
    
    public static convertToCentigrade()
    {
        return (temp - 273);
    }
    
    //public static convertTo
}
