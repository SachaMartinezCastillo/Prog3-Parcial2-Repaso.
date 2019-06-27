package conversionDatos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import organizacion.*;

public class ConvertirDatos 
{
	JSONObject objeto;
	
	public ConvertirDatos()
	{
		objeto = new JSONObject();
	}
	
	private JSONObject arregloAJSONarray(Federacion fed) throws JSONException
	{
		JSONObject integrantes = new JSONObject();
		
		JSONArray arregloFutbolista = new JSONArray();
		JSONArray arregloEntrenado = new JSONArray();
		
		for (Integrantes persona : fed.getPlantel()) 
		{
			
			if (persona instanceof Futbolista)
			
					arregloFutbolista.put(persona.convertir());
			
			if (persona instanceof Entrenador)
				
					arregloEntrenado.put(persona.convertir());
			
	
			
		}	
		
		integrantes.put("fut", arregloFutbolista);
		integrantes.put("entrenador", arregloEntrenado);
		
		return integrantes;
		
	}
	
	public JSONObject federacionAJSONobject(Federacion fed)
	{
		try {
			objeto.put("Nombre", fed.getNombreFed());
			objeto.put("Fecha", fed.getFechaFundacion());
			objeto.put("Cant Copas", fed.getCantCopasMundiales());
			objeto.put("Integrantes", arregloAJSONarray(fed));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objeto;
	}
	
	public String mostrarJSONobject()
	{
		return objeto.toString();
	}

	public JSONObject getObjeto()
	{
		return objeto;
	}


	public Federacion JSONobjectAjava()
	{
		Federacion fed = null;
		
		try {
				String nombreFed = objeto.getString("Nombre");
				String fecha = objeto.getString("Fecha");
				int copas = objeto.getInt("Cant Copas");
				JSONObject objArreglo = objeto.getJSONObject("Integrantes");
				JSONArray arregloFut = objArreglo.getJSONArray("fut");
				JSONArray arregloEnt = objArreglo.getJSONArray("entrenador");

				fed = new Federacion(nombreFed, fecha, copas);

				
				for (int i = 0; i < arregloFut.length(); i++) 
				{
					JSONObject aux = arregloFut.getJSONObject(i);
					
					String nombre = aux.getString("nombre");
					String apellido = aux.getString("apellido");
					int edad = aux.getInt("edad");
					int casaca = aux.getInt("numero casaca");
					String puesto = aux.getString("puesto");
					
					Futbolista jugador = new Futbolista(nombre, apellido, edad, casaca, puesto);
					fed.agregarFutbolista(jugador);
				}
				
				for (int j = 0; j < arregloEnt.length(); j++) 
				{
					JSONObject entrenador = arregloEnt.getJSONObject(j);
					String nombreE = entrenador.getString("nombre");
					String apellidoE = entrenador.getString("apellido");
					int edadE = entrenador.getInt("edad");
					String sistema = entrenador.getString("sist. de juego");
					String estilo = entrenador.getString("estilo");
					
					Entrenador dt = new Entrenador(nombreE, apellidoE, edadE, sistema, estilo);
					fed.agregarEntrenador(dt);
				}	
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return fed;
	}





}
