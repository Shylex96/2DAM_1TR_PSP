package exercise08;

public class Palabra implements Runnable
{
	String palabra;
	Thread hilo;
	
	Palabra(String pal)
	{
		palabra = pal;
		hilo = new Thread(this);
	}
	
	public void start() {
		hilo.start();
	}
	
	public void join() {
	    try {
	        hilo.join();
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	}
	
	//El m�todo run() comprobar� si la palabra es un pal�ndromo.
	public void run()
	{
		boolean palindromo = true;
		int i = 0;
		int j = palabra.length() - 1;
		while(palindromo && i < j)
		{
			if(palabra.charAt(i) == palabra.charAt(j))
			{
				++i;
				--j;
			}
			else
			{
				palindromo = false;
			}
		}
		if(palindromo)
			System.out.println("La palabra " + palabra + " s� es un pal�ndromo.");
		else
			System.out.println("La palabra " + palabra + " no es un pal�ndromo.");
	}
}