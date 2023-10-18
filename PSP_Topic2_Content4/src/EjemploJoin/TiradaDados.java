package EjemploJoin;

public class TiradaDados {
	
	private int tiradaDados;
	public TiradaDados(int y)
	{
		tiradaDados = y;
	}
	public int getSumaTirada()
	{
		return tiradaDados;
	}
	public void setSumaTirada(int y)
	{
		tiradaDados += y;
	}
}