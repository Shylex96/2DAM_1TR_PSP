package productoConsumidorSuccess;

class Monitor
{
	private int pilaNumeros[] = new int[6]; // Tama�o de la pila o buffer
	private int segNum = 0;
	private boolean pilaLlena = false;
	private boolean pilaVacia = true;
	
	public synchronized int coger()
	{
		// Si la pila se encuentra vac�a env�a el hilo a la pila de espera
		while(pilaVacia) // Sale cuando pilaVacia es false
		{
			try
			{
				wait();
			}
			catch( InterruptedException e){}
		}
		// Disminuye segNum porque coge un n�mero y habr� un n�mero menos en la pila
		segNum--;
		// Si no quedan n�meros
		if(segNum == 0)
		{
			pilaVacia = true; // La pila se encuentra vac�a
		}
		pilaLlena = false; // La pila no est� llena porque hemos consumido un n�mero
		notify();
		// Devuelve el n�mero al hilo consumidor
		return( pilaNumeros[segNum] );
	}
	public synchronized void dejar(int num)
	{
		// Si la pila est� llena, no entran m�s n�meros, enviamos el hilo a la pila de espera
		while(pilaLlena) // Si pilaLlena es false, podr� continuar produciendo
		{
			try
			{
				wait();
			}
			catch( InterruptedException e){}
		}
		// A�adimos el nuevo n�mero en la pila al primer lugar disponible
		pilaNumeros[segNum] = num;
		// Aumentamos los n�meros de la pila
		segNum++;
		// Miramos si la pila est� llena
		if( segNum == 6 )
		{
			pilaLlena = true;
		}
		pilaVacia = false; // Es false porque acaban de producir un n�mero
		notify();
	}
}