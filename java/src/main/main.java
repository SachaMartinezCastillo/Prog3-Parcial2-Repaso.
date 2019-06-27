package main;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class main {

	public static void main(String[] args) 
	{
		HashMap<String, Integer> hashMap = new HashMap<>();
		
		hashMap.put("1", 2);
		hashMap.put("1", 3);
		hashMap.put("2", 44);
		
		//System.out.println(hashMap.containsKey("3"));
	//	System.out.println(hashMap.containsValue(3));
		
		System.out.println(hashMap.get("3"));
		
		Integer valor = hashMap.get("3");
		//valor.intValue(); null pointer
		
		Set < Entry<String, Integer> > entradas = hashMap.entrySet();
		
		Iterator it = entradas.iterator();
		
		while (it.hasNext())
		{
			Entry<String, Integer> entradaDelSet = (Entry<String, Integer>) it.next();
			System.out.println(entradaDelSet.getKey()+"-"+entradaDelSet.getValue());
		}
		
		
		

	}

}
