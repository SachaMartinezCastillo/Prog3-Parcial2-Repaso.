package organizacion;

import conversionDatos.ConvertirDatos;

public class Main {

	public static void main(String[] args) 
	{
		Federacion argentina = new Federacion("Argentina", "25/5/1910", 2);
		Futbolista j1 = new Futbolista("pedro", "juarez", 21, 10, "Delantero");
		Futbolista j2 = new Futbolista("juan", "juarez", 21, 10, "Delantero");
		Futbolista j3 = new Futbolista("lucas", "juarez", 21, 10, "Delantero");
		Futbolista j4 = new Futbolista("andy", "juarez", 21, 10, "Delantero");
		Futbolista j5 = new Futbolista("charly", "juarez", 21, 10, "Delantero");
		argentina.agregarFutbolista(j1);
		argentina.agregarFutbolista(j2);
		argentina.agregarFutbolista(j3);
		argentina.agregarFutbolista(j4);
		
		System.out.println(argentina.MostrarFutbolistas());
		
		argentina.eliminarFutbolista(j3);
		argentina.agregarFutbolista(j5);

		System.out.println(j5.enJuego());
		
		Entrenador e1 = new Entrenador("gonza", "benoffi", 31, "4-4-2", "conservador");
		Entrenador e2 = new Entrenador("karina", "janeDoe", 28, "4-3-3", "todo Ataque");
		
		argentina.agregarEntrenador(e1);
		argentina.agregarEntrenador(e2);
		
		System.out.println(argentina.MostrarFed());
		
		
		
		
		System.out.println("\n\n\nMacanas moment");
		
		ConvertirDatos macanas = new ConvertirDatos();
		macanas.federacionAJSONobject(argentina);
		System.out.println(macanas.mostrarJSONobject());
		System.out.println("0sdfgjkgbhvjfkasdg");
		System.out.println(macanas.getObjeto().toString());
		
	}

}
