package notepadKiller;

import java.io.IOException;

public class NotepadKiller {

	public static void main(String[] args) {

		try {

			if (args != null) {
				int pid = Integer.parseInt(args[0]);
				Runtime.getRuntime().exec("cmd /c taskkill /pid " + pid);
			} else {
				System.out.println("Hay que indicar por parámetro el PID");
			}
		} catch (IOException e) {
			System.err.println("Se ha producido un error " +e);
		}

	}

}
