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
}
