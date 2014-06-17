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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canDecomposeAtTemp(Kelvin temp) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canDecompose() {
		// TODO Auto-generated method stub
		return false;
	}
}
