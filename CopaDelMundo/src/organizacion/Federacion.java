package organizacion;

import Excepciones.PlantillaLlenaExcception;
import Excepciones.YaHayDtException;

public class Federacion 
{
	private String nombreFed;
	private String fechaFundacion;
	private int cantCopasMundiales;
	private ContenedorG<Integrantes> plantel;
	
	private static final int Max_Futbolistas = 3;
	
	public Federacion(String nombre, String fecha, int cant)
	{
		nombreFed = nombre;
		fechaFundacion = fecha;
		cantCopasMundiales = cant;
		plantel = new ContenedorG<Integrantes>();
	}
	
	private void agregarIntegrante(Integrantes persona)
	{
		plantel.agregarIntegrante(persona);
	}
	
	public void agregarFutbolista(Integrantes persona)	//deberia poner integrante o futbolsita como parametro?
	{
		if(persona instanceof Futbolista)
		{
			try {
					if(plantillaLlena() == false)
					{
						agregarIntegrante(persona);
					}
			} catch (PlantillaLlenaExcception e) {
				System.out.println(e.getMessage());
			}
		}	
	}
	
	public ContenedorG<Integrantes> getPlantel()
	{
		return plantel;
	}

	public void eliminarFutbolista(Futbolista jugador)
	{
		plantel.eliminarIntegrante(jugador);
	}
	
	public String MostrarFutbolistas()
	{
		String retorno = "";
		for (Integrantes persona : plantel) 
		{
			if(persona instanceof Futbolista)
			{
				Futbolista aux = (Futbolista)persona;
				retorno = retorno + aux.toString();
			}
		}	
		return retorno;
	}
	
	public boolean plantillaLlena() throws PlantillaLlenaExcception
	{
		boolean aux = false;
		int contador = 0;
		for (Integrantes persona : plantel) 
		{
			if (persona instanceof Futbolista)
			{
				contador++;
			}
		}
		
		if(contador >= Max_Futbolistas)
		{
			aux = true;
			throw new PlantillaLlenaExcception("\nEl plantel ya tiene 23 jugadores\n");
		}
		return aux;		
	}
	
	public String MostrarFed()
	{
		return plantel.listarFederacion();
	}

	
	
	public boolean existeEntrenador() throws YaHayDtException
	{
		boolean aux = false;
		
		for (Integrantes persona : plantel) 
		{
			if(persona instanceof Entrenador)
			{
				aux = true;
				throw new YaHayDtException("\nEl plantel ya tiene entrenador men");
			}
		}
		
		return aux;
	}
	
	public void agregarEntrenador(Integrantes persona)
	{
		try {
			if(existeEntrenador() == false)
			{
				plantel.agregarIntegrante(persona);
			}
		} catch (YaHayDtException e) 
		{
			System.out.println(e.getMessage());
		}
	}

	
	
	
	public String getNombreFed() {
		return nombreFed;
	}
	

	public void setNombreFed(String nombreFed) {
		this.nombreFed = nombreFed;
	}
	

	public String getFechaFundacion() {
		return fechaFundacion;
	}
	

	public void setFechaFundacion(String fechaFundacion) {
		this.fechaFundacion = fechaFundacion;
	}
	

	public int getCantCopasMundiales() {
		return cantCopasMundiales;
	}
	

	public void setCantCopasMundiales(int cantCopasMundiales) {
		this.cantCopasMundiales = cantCopasMundiales;
	}
	
	
	
	
	
}
































/*
 * 	private HashMap<String, Integrantes> plantilla;
	
	public Federacion()
	{
		int tipoIntegrante;
		plantilla = new HashMap();
	}
	
	public void agregarIntegrante(Integrantes persona)
	{
		if(persona instanceof Futbolista)
		{
			agregarFutbolista((Futbolista) persona);
		}
	}
	
	public void agregarFutbolista(Futbolista jugador)
	{
		plantilla.put("Futbolista", jugador);
	}
	
	public void eliminarFutbolista(Futbolista jugador)
	{
		plantilla.remove("Futbolista", jugador);
	}
	
	public String MostrarFutbolistas()
	{
		Iterator it = plantilla.entrySet().iterator();
		
		while(it.hasNext())
		{
			Map<String, Integrantes>.Entry<String, Integrantes> me = (Map.Entry<String, Integrantes>) it.hasNext();
		}
		
		return null;
	}
 * 
 */




