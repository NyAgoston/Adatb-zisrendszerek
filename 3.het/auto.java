package java_filekezeles;

import java.io.Serializable;

public class auto implements Serializable{
	private static final long serialVersionUID = 1L;
	String rendszam;
	String tipus;
	int ar;
	
	public auto(String rendszam, String tipus, int ar) {
		super();
		this.rendszam = rendszam;
		this.tipus = tipus;
		this.ar = ar;
	}

	@Override
	public String toString() {
		return "auto [rendszam=" + rendszam + ", tipus=" + tipus + ", ar=" + ar + "]";
	}
	
	
}
