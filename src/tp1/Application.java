package tp1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Application {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		String fileName="tp1";
		Network myNetwork = null;
		try {
			System.out.println("Chargement du fichier : "+new java.io.File("../").getCanonicalPath()+ "/" + fileName);
		} catch (IOException e) {
			System.out.println("Erreur lors du chargement du fichier ! ");
			e.printStackTrace();
		}
		BufferedReader readFile=null;
		try {
			readFile = new BufferedReader(new FileReader("/auto_home/bgallean/Bureau/Master/eclipse/IntelligenceArtificielle/"+fileName));
		} catch (FileNotFoundException e) {
			System.out.println("Erreur lors de la lecture du fichier  ! ");
			e.printStackTrace();
		}
		try {
			myNetwork= new Network(readFile);
		} catch (Exception e) {
			System.out.println("Erreur lors du chargement du network ! ");
			e.printStackTrace();
		}
		try {
			readFile.close();
		} catch (IOException e) {
			System.out.println("Erreur lors de la fermeture du fichier ! ");
			e.printStackTrace();
		}
		
		System.out.println(myNetwork.toString());
		
		CSP test = new CSP(myNetwork);
		test.searchSolution();
	}
	
		
}
