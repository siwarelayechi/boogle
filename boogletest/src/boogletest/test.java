package boogletest;

import java.util.Scanner;

public class test {

	public static Scanner s;

	public static void main(String[] args) {
		
		s = new Scanner(System.in);
		String fichier = "C:\\Users\\Ayachi\\Desktop\\ods5.txt";//Declaration de fichier qui contient le chemin du dictionnaire
		String chaine;//Declaration de la chaine saisie 
		String ch1="***";
		int t=0,test=0;//Declaration et initialisation des variables de test
		String x;//Declaration de variable qui represente le choix de l'utilisateur 

		
		
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("{                BOGGLE                   }");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	
/*le boucle do while permet de repeter le jeu pour l'utilisateur au tant de fois qu'il souhaite */				
				
do{			
	System.out.println("*/Tapez 0 si vous voulez quitter  ");
	System.out.println("*/Tapez 1 si vous voulez jouer ");
	x=s.next();
		/*Switch va permert de realiser le choix du joueur si x=1 le jeu commence 
		 * si x=0 il quitte */
		  switch (x)
			{case "0" :
			{System.out.println("vous avez quitter ! ");
			break;}
			
			case "1" : 		
			{t=0;
			User u = new User();// instancier la classe User qui va representer le joueur
			Computer c = new Computer ();// instancier la classe Computer  qui va representer l'ordinateur 
			Boogle B = new Boogle ();//  instancier la classe Boogle  qui va representer le jeu boggle
			
			System.out.println("Il faut identifier le maximum possible des mots \nPour Sortir  il faut juste  tapez '***' ");
			B.creation_plateau();
			B.afficher_plateau();
			System.out.println("Donnez une chaine ");
			/*le boucle do while permet le joueur de saisir des chaine tant qu'il n'a pas saisie ****/	
			do{
				chaine=s.next();
				if (chaine.equals(ch1)) {t=1;}
				else{
					// la chaine saisie qui n'egale pas � '***' sera verifier en lanceant l'appel de la fonction verif 
					// si le mot dans les conditions demand�s , il sera ajouter dans la liste de l'utilisateur
					u.verif(u.getList_mot_j(), chaine.toUpperCase(), u.getPlateau() ,fichier  );}
				}while (t==0);
			u.affiche_resultat_user();//affichage de la resultat du joueur
			c.found(u.getPlateau(), fichier);// recherche des mots par l'ordinateur 
			c.affiche_resultat_pc(u.getList_mot_j());//affichage de la resultat de l'ordinateur 
			if (c.getScore() > u.getScore())// tester qui a gangne ?
			{System.out.println("L'ordinateur a gagn�! \n Essayez une autre fois");}
			else System.out.println("Bravo ! Vous avez gagn�!");
			break ;}
		
			default : {System.out.println(" Il faut taper 1 ou 0!");
			break;}}
		
		System.out.println("Vous �tes sur vous-voulez quitter maintenant \n Si oui Tapez  :0 \n Sinon  Tapez :1 ");
		test=s.nextInt();
		}while(test==1);
	}
}
	

