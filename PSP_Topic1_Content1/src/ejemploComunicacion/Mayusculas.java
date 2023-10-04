package ejemploComunicacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Mayusculas
{
	public static void main(String[] args) throws IOException
	{
		// Creamos el stream enlazado con el teclado
		InputStreamReader entrada = new InputStreamReader(System.in);
		
		// Creamos el buffer correspondiente
		BufferedReader teclado = new BufferedReader (entrada);
		
		// Leemos del buffer
		String cadena = teclado.readLine();
		
		// Escribimos en la salida del programa, la cadena transformada
		System.out.println(cadena.toUpperCase());
	}
}