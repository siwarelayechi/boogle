package boogletest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
 
public class Computer extends Boogle   {
	
public ArrayList<String> list_mot_pc;// Declaration d'une liste dynamique qui va contenir les mots touvés par l'ordinateur
private int  score;// le score de l'ordinateur

//constructeur Computer  sert à initialiser la liste list_mot_pc et le score
public Computer() {
	list_mot_pc=new ArrayList<String>();
	score=0;}
// getScore permet d'acceder au score
public int getScore() {
	return score;}
// setScore permet de modifier le score
public void setScore(int score) {
	this.score = score;
}

/*la fonction found permet de verifier si les mots  du dictionnaire existe dans le plateau ou non
*si un mot du dictionnaire existe dans le plateau il sera ajouter dans la liste */
public ArrayList<String> found (char[][] plateau , String fichier )
	{ try (BufferedReader buffer = new BufferedReader(new FileReader(fichier))) {
		String line;
		while (((line = buffer.readLine()) != null) )
			{ /* parcour du fichier ligne par ligne avec buffer.readline()
			 *on fait un appel à la fonction apprtient_ds_plateau pour checher le mot donné par le dictionnaire
			dans le plateau */
			if (appartient_ds_plateau(line.toUpperCase(),plateau) ==1)
			{list_mot_pc.add(line.toUpperCase());}}// le mot est trouvé est ajouté à la liste 
		buffer.close();}//fermer le dictionnaire 
		catch (IOException e) {
		e.printStackTrace();}
	return list_mot_pc;}
	

/* cette fonction permet d'afficher les mots trouvés par l'ordinateur à conditions que les mots n'existe pas dans
 * la liste de l'utilisateur et la taille du mot ne soit pas inferieur à 3 aussi elle affiche les points de chaque mot 
 * et le score total qui est la somme des points */
	

public void affiche_resultat_pc (ArrayList<String> list_mot_j){
	int s=0;
	if (list_mot_pc.size()==0){System.out.println("la liste du mot est vide \n l'ordinateur n'a identifié aucun mot  ");}
		else { 
		 System.out.println("\n\n\n~~~~~~~~~~~~~~~~~~~ Resultat de l'ordinateur ~~~~~~~~~~~~~~~");
		 System.out.println("------------------------------------------------");
		 System.out.println("|Mot              Taille du Mot      Point     |");
		 System.out.println("------------------------------------------------");
		for (int i=0;i<list_mot_pc.size();i++)
		{if ((list_mot_pc.get(i).length()>3)&&(list_mot_j.contains(list_mot_pc.get(i)))==false)
		{System.out.println("|"+list_mot_pc.get(i)+ "                  "+list_mot_pc.get(i).length()+"              "+(list_mot_pc.get(i).length()-2));}
		s+=(list_mot_pc.get(i).length()-2) ;
		setScore(s);}
	    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");}
	    System.out.println("************Score Total de l'ordinateur est: "+getScore()+"************");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
