package organizacion;

import java.util.ArrayList;
import java.util.Iterator;

public class ContenedorG <T> implements Iterable<T>
{
	public ArrayList<T> plantel;
	
	
	public ContenedorG()
	{
		plantel = new ArrayList<T>();
	}
	
	public void agregarIntegrante(T persona)
	{
		plantel.add(persona);
	}
	
	public void eliminarIntegrante(T persona)
	{
		plantel.remove(persona);
	}
	
	public String listarFederacion()
	{
		String rta = "";
		
		for (T integrante : plantel) 
		{
			rta += integrante.toString();
		}
		return rta;
	}

	@Override
	public Iterator<T> iterator() 
	{
		return plantel.iterator();
	}
}
