import java.io.File;
import java.util.Scanner;

public class Ejercicio1_3 {
	
	private static int nivel = 0;
	private static int cuentaElementos = 0;
	
	public static void ejercicio1_2() {
		File dirActual = new File(".");
		
		File[] contenido = dirActual.listFiles();
		System.out.println("Ficheros en el directorio de trabajo actual '" + dirActual.getAbsolutePath() + "' : " + contenido.length);
		for (File itemFile: contenido) {
			System.out.println(itemFile.getName() + (itemFile.isDirectory()?"\td":"\tf"));
		}
	}
	
	public static void ejercicio3() {
		Scanner scn = new Scanner (System.in);
		
		System.out.println ("Por favor introduzca el nombre del fichero o directorio:");
	    String nombre = "."+ System.getProperty("file.separator") + scn.nextLine (); 
	    File f = new File(nombre);
	    if (f.exists()) {
	    	 if (f.isFile()) {
	    		 trataFichero(f);
	    	 }else {
	    		 
	    		 trataDirectorio(f);
	    	 }
	    }else {
	    	 System.out.println("El fichero o directorio no existe");
	    }
	}
	
	public static void trataDirectorio(File f) {
		
		File[] contenido = f.listFiles();
		cuentaElementos = contenido.length;
		++nivel;
		StringBuilder cad = new StringBuilder();
		for (int i=0; i<=nivel; i++)
			cad.append("\t");
		System.out.println(cad.append("d\t" + f.getName() + "\t\t" + contenido.length + " elementos"));
		for (File itemFile: contenido) {
			 if (itemFile.isFile()) {
	    		 trataFichero(itemFile);
	    	 }else {
	    		 trataDirectorio(itemFile);
	    	 }
    		 --cuentaElementos;
		}
	}

	public static void trataFichero(File f) {
		StringBuilder cad = new StringBuilder();
		for (int i=0; i<=nivel; i++)
			cad.append("\t");
		System.out.println(cad.append("f\t" + f.getName() + "\t(" + f.length() + "bytes)\t" + (f.canRead()?"r":"-") + (f.canWrite()?"w":"-") + (f.canExecute()?"x":"-")));
	}
	
	public static void main(String[] args) {
		
		ejercicio1_2();
		ejercicio3();
	}

}
