package organizacion;

import org.json.JSONException;
import org.json.JSONObject;

import Interfaces.Jugando;

public class Entrenador extends Integrantes implements Jugando
{
	private String sistemaDeJuego;
	private String estilo;	
	
	public Entrenador(String nombre, String apellido, int edad, String sistema, String stilo) {
		super(nombre, apellido, edad);
		setSistemaDeJuego(sistema);
		setEstilo(stilo);
	}

	public String getSistemaDeJuego() {
		return sistemaDeJuego;
	}

	public void setSistemaDeJuego(String sistemaDeJuego) {
		this.sistemaDeJuego = sistemaDeJuego;
	}

	public String getEstilo() {
		return estilo;
	}

	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}


	@Override
	public String toString() 
	{
		return super.toString() + "\nsistemaDeJuego: " + sistemaDeJuego + "\nestilo: " + estilo;
	}

	@Override
	public String enJuego() 
	{
		return "El coach esta en el partido man";
	}
	
	public JSONObject convertir() throws JSONException
	{
		JSONObject jsonObject = super.convertir();
		jsonObject.put("sist. de juego", getSistemaDeJuego());
		jsonObject.put("estilo", getEstilo());
		return jsonObject;
	}
	
}
