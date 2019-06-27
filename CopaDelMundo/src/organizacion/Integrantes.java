package organizacion;

import org.json.JSONException;
import org.json.JSONObject;

public abstract class Integrantes 
{
	private String nombre;
	private String apellido;
	private int edad;
	

	public Integrantes(String nombre, String apellido, int edad) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
	}

	
	public String getNombre()
	{
		return nombre;
	}

	private void setNombre(String name) 
	{
		nombre = name;
	}

	public String getApellido() 
	{
		return apellido;
	}

	private void setApellido(String surname) 
	{
		apellido = surname;
	}

	public int getEdad() 
	{
		return edad;
	}

	private void setEdad(int age) 
	{
		edad = age;
	}

	
	@Override
	public String toString() 
	{
		return "Integrante\nnombre:" + nombre + " \napellido=" + apellido + "\nedad=" + edad;
	}
	
	
	public JSONObject convertir() throws JSONException
	{
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("nombre", getNombre());
		jsonObject.put("apellido", getApellido());
		jsonObject.put("edad", getEdad());
		return jsonObject;
	}
	
	
	
	
}
