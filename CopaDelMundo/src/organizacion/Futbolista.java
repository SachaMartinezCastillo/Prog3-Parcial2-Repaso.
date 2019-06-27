package organizacion;

import javax.print.attribute.standard.JobHoldUntil;

import org.json.JSONException;
import org.json.JSONObject;

import Interfaces.Jugando;

public class Futbolista extends Integrantes implements Jugando
{
	private int numero;
	private String puesto;	
	
	
	public Futbolista(String nombre, String apellido, int edad, int number, String position)
	{
		super(nombre, apellido, edad);
		setNumero(number);
		setPuesto(position);
	}

	
	public int getNumero() {
		return numero;
	}

	private void setNumero(int numero) {
		this.numero = numero;
	}

	public String getPuesto() {
		return puesto;
	}

	private void setPuesto(String puesto) {
		this.puesto = puesto;
	}


	
	@Override
	public String toString() 
	{
		return super.toString() + "\nFutbolista numero: " + numero + "\npuesto: " + puesto + "\n\n\n";
	}

	@Override
	public String enJuego() 
	{
		return  "el futbolista "+ getNombre() +" esta en partido\n";
	}
	
	
	public JSONObject convertir() throws JSONException
	{
		JSONObject jsonObject = super.convertir();
		jsonObject.put("numero casaca", getNumero());
		jsonObject.put("puesto", getPuesto());
		return jsonObject;
	}
	
	
	
}
