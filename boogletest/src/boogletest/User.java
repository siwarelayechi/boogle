package boogletest;

import java.util.*;
public class User extends Boogle  {
	
private int score;// le score de l'utlisateur
public ArrayList<String> list_mot_j;// Declaration d'une liste dynamique qui va contenir les mots touv�s par l'utilisateur

/*constructure User sert  initialiser la liste list_mot_j et le score*/
public User(){
	list_mot_j= new ArrayList<String>();
	score=0;}
//getList_mot_j permet d'acceder � list_mot_j
public ArrayList<String> getList_mot_j() {
	return list_mot_j;
}
// getScore permet d'acceder au score
public int getScore() {
	return score;
}
//setScore permet de modifier le score
public void setScore(int score) {
	this.score = score;
}
/*la fonction existe_ds_liste renvoie 1 si la chaine donn�e n'existe pas dans la liste des mot trouv�s 
 * sinon elle renvoie 0*/
public int exist_ds_liste (ArrayList<String> list_mot_j, String ch)
{int t=1;
	if (list_mot_j.size()==0)// si la liste est vide , la fonction renvoie 1
		   {return 1;}
	//on test l'existance de la chaine dans la liste avec list_mot_j.contains(ch) 
	 else {if (list_mot_j.contains(ch)){t=0;}
		     }
return t;}	

/*la fonction permet d'ajouter le mot donn� par l'utilisateur s'il verifie les conditions suivantes 
 * la taille du  mot ne doit pas etre inferieur � 3 
 * le mot ne doit pas exister dans la liste des mots trouv�s 
 * le mot doit appartenir dans le dictionnaire */
public ArrayList<String> verif (ArrayList<String> list_mot_j,String ch,char[][] plateau ,String fichier )
{if (ch.length()>=3)//le test du taille 
	/*verification des condition on faisant un appel au fonction 
	 * exist_ds_liste,appartient_ds_plateau,apparition_ds_dict*/
	if ((exist_ds_liste(list_mot_j,ch)==1)&&appartient_ds_plateau ( ch,plateau)==1&&apparition_ds_dict( fichier, ch )==1)
	{list_mot_j.add(ch);}//l'ajout du mot 
	return list_mot_j;}


/* cette fonction permet d'afficher les mots trouv�s par l'utlisateur aussi elle affiche les points de chaque mot 
 * et le score total qui est la somme des points */
 public void affiche_resultat_user ()
 {int s=0;
 if (list_mot_j.size()==0){System.out.println("la liste du mot est vide\n il n'ya aucun mot qui verifie les conditions ! ");}
 else{
	 System.out.println("~~~~~~~~~~~~~~~~~~~Votre Resultat~~~~~~~~~~~~~~~");	 
	 System.out.println("~-----------------------------------------------");
 	 System.out.println("|Mot              Taille du Mot      Point     |");
	 System.out.println("------------------------------------------------");
	 for ( int i =0;i<list_mot_j.size();i++)
	{System.out.println("|"+list_mot_j.get(i)+ "                  "+list_mot_j.get(i).length()+"              "+(list_mot_j.get(i).length()-2));
	s +=(list_mot_j.get(i).length()-2);
	setScore(s);}
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println("*********Votre Score Total est: "+getScore()+" ************");}
 }
 
}
	   
	   



