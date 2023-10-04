package ejemploComunicacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
public class MayusculasPadre
{
	public static void main(String[] args) throws IOException
	{
		System.out.print("Introducir texto: ");
		InputStreamReader entrada = new InputStreamReader(System.in);
		BufferedReader teclado = new BufferedReader (entrada);
		String texto = teclado.readLine();
		
		// Ruta y argumentos para lanzar aplicación hija
		String arg1 = "java";
		String arg2 = "-jar";
		String arg3 = "C:\\Users\\Studium\\Desktop\\DAM\\PSP\\PSP_Topic1_Content1\\src\\EjemploComunicacion\\Mayusculas.jar";
		String[] param = { arg1, arg2, arg3 };
		Process process = new ProcessBuilder(param).start();
		
		// Escribir en la escucha del proceso
		OutputStream os = process.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(os);
		PrintWriter pw = new PrintWriter(osw);
		
		// Aquí exactamente enviamos el texto leído en esta clase a la hija
		pw.print(texto);
		pw.close();
		
		// Capturar la salida del proceso
		InputStream is = process.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String linea = br.readLine();
		System.out.println("Línea transformada por la hija:" + linea);
		br.close();
	}
}
