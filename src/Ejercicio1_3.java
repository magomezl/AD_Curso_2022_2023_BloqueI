import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

// https://github.com/magomezl/AD_Curso_2022_2023_BloqueI.git

public class Ejercicio1_3 {
	
	private static ArrayList<Integer> cuentaNivel = new ArrayList<Integer>();
	private static ArrayList<Integer> cuentaElementos = new ArrayList<Integer>();
	private static int nivel = 0;
	
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
		int elementos = contenido.length;
		cuentaElementos.add(nivel, contenido.length);
		cuentaNivel.add(nivel, nivel);
		
		StringBuilder cad = new StringBuilder();
		
		if ( cuentaElementos.get(nivel)>0) {
			//System.out.println("cuentaElementos.get(nivel) " + cuentaElementos.get(nivel));
			for (int i=0; i<cuentaNivel.get(nivel); i++) {
					//System.out.println("un tabulador");
					cad.append("\t");
			}
		}
		
		System.out.println(cad.append("d\t" + f.getName() + "\t\t" + contenido.length + " elementos"));
		for (File itemFile: contenido) {
			
			 if (itemFile.isFile()) {
	    		 trataFichero(itemFile);
	    		 cuentaElementos.add(nivel, --elementos);
	    	 }else {
	    		 ++nivel;
	    		 cuentaElementos.add(nivel, --elementos);
	    		 
	    		 trataDirectorio(itemFile);
	    	 }
		}
	}

	public static void trataFichero(File f) {
		StringBuilder cad = new StringBuilder();
		if ( cuentaElementos.get(nivel)>0) {
			for (int i=0; i<cuentaNivel.get(nivel); i++) {
					cad.append("\t");
			}
		}
		System.out.println(cad.append("f\t" + f.getName() + "\t(" + f.length() + "bytes)\t" + (f.canRead()?"r":"-") + (f.canWrite()?"w":"-") + (f.canExecute()?"x":"-")));
	}
	
	public static void main(String[] args) {
		
		ejercicio1_2();
		ejercicio3();
	}

}
