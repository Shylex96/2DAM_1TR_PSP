package bolsa;

import java.awt.TextField;
import java.util.Random;

public class Hilo extends Thread
{
	TextField txtField;
	double valor;
	Random aleatorio = new Random();
	int subirBajar;
	double incrementoDecremento;
	String valorActual;
	double nuevoValor;

	Hilo(TextField t, double v)
	{
		this.txtField = t;
		this.valor = v;
		this.txtField.setText(v+"");
	}
	public void run()
	{
		while(true)
		{
			incrementoDecremento = aleatorio.nextDouble(10);
			valorActual = this.txtField.getText().replaceAll(",",".");
			subirBajar = aleatorio.nextInt(3);
			if(subirBajar == 0)
			{
				nuevoValor =
						Double.parseDouble(valorActual)+incrementoDecremento;
			}
			else if(subirBajar == 1)
			{
				nuevoValor = Double.parseDouble(valorActual)-
						incrementoDecremento;
				if(nuevoValor<=0)
				{
					nuevoValor = 0.01;
				}
			}
			else
			{
				nuevoValor = Double.parseDouble(valorActual);
			}
			txtField.setText(String.format("%.2f",nuevoValor));
			try
			{
				Thread.sleep(aleatorio.nextInt(2000));
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}
