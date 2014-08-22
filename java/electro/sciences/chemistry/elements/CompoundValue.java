package electro.sciences.chemistry.elements;

public interface CompoundValue {
	
	public AtomValue[] getContainingElements();

	public boolean canDecomposeAtTemp(Kelvin temp);
	
	public boolean canDecompose();
}
