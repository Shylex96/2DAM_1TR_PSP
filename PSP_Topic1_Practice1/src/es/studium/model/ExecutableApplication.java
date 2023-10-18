package es.studium.model;

public class ExecutableApplication {
	private String name;
	private String path;

	public ExecutableApplication(String name, String path) {
		this.name = name;
		this.path = path;
	}

	public String getName() {
		return name;
	}

	public String getPath() {
		return path;
	}
}
