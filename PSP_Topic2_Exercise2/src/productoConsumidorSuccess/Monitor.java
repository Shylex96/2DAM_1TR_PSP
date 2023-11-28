package productoConsumidorSuccess;

class Monitor
{
	private int pilaNumeros[] = new int[6]; // Tamaño de la pila o buffer
	private int segNum = 0;
	private boolean pilaLlena = false;
	private boolean pilaVacia = true;
	
	public synchronized int coger()
	{
		// Si la pila se encuentra vacía envía el hilo a la pila de espera
		while(pilaVacia) // Sale cuando pilaVacia es false
		{
			try
			{
				wait();
			}
			catch( InterruptedException e){}
		}
		// Disminuye segNum porque coge un número y habrá un número menos en la pila
		segNum--;
		// Si no quedan números
		if(segNum == 0)
		{
			pilaVacia = true; // La pila se encuentra vacía
		}
		pilaLlena = false; // La pila no está llena porque hemos consumido un número
		notify();
		// Devuelve el número al hilo consumidor
		return( pilaNumeros[segNum] );
	}
	public synchronized void dejar(int num)
	{
		// Si la pila está llena, no entran más números, enviamos el hilo a la pila de espera
		while(pilaLlena) // Si pilaLlena es false, podrá continuar produciendo
		{
			try
			{
				wait();
			}
			catch( InterruptedException e){}
		}
		// Añadimos el nuevo número en la pila al primer lugar disponible
		pilaNumeros[segNum] = num;
		// Aumentamos los números de la pila
		segNum++;
		// Miramos si la pila está llena
		if( segNum == 6 )
		{
			pilaLlena = true;
		}
		pilaVacia = false; // Es false porque acaban de producir un número
		notify();
	}
}