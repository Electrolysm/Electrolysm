package electro.sciences.chemistry.elements;

public class  AtomValue implements ElementValue, CompoundValue
{
      public AtomValue()
      {
      
      }
      
      public String getElementName()
      {
          return null;      
      }

	public boolean canBondWith(ElementValue elementValue) 
	{
		return false;
	}
	
	public ElementValue bondWith(ElementValue elementValue) 
	{
		return null;
	}

	@Override
	public AtomValue[] getContainingElements() {
		return null;
	}

	@Override
	public boolean canDecomposeAtTemp(Kelvin temp) {
		return false;
	}

	@Override
	public boolean canDecompose() {
		return false;
	}
}
