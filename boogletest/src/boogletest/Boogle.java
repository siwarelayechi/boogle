package boogletest;

import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Boogle {
	public boolean m;
	public boolean stop;
	public static char[][] plateau;
/*initialisation d'une matrice statique chaque ligne presente un d�*/ 
	public static char[][] d�={{'B','A','J','O','Q','M'},
	{'R','A','L','E','S','C'},
	{'L','I','B','A','R','T'},
	{'T','O','K','U','E','N'},
	{'R','O','F','I','A','X'},
	{'A','V','E','Z','D','N'},
	{'N','U','L','E','G','Y'},
	{'M','E','D','A','P','C'},
	{'S','U','T','E','L','P'},
	{'H','E','F','S','I','E'},
	{'R','O','M','A','S','I'},
	{'G','I','N','E','V','T'},
	{'R','U','E','I','L','W'},
	{'R','E','N','I','S','H'},
	{'T','I','E','A','A','O'},
	{'D','O','N','E','S','T'}};
//constructeur Boogle sert � initialiser le plateau 
	public Boogle()	
{ plateau= new char[4][4];}
//getPlateau permet d'acceder au plateau
public char[][] getPlateau() {
	return Boogle.plateau;
}
//setPlateau permet de modifie le plateau 
public void setPlateau(char[][] p) {
	Boogle.plateau = p;}

/*la fonction creation_plateau sert � creer le plateau � travers  la matrice staitique 'd�'*/
public void creation_plateau()
	{ char [][]p=new char [4][4];
	 
	int c=0;//represente la ligne de la plateau
	int t=0 ;// represente la colonne de la plateau
	int i=0; // represente la ligne de la matrice statique 'd�'
	int d=0; //position d'une choisie al�atoirement � partir de la matrice 'd�'   
	int r;// variable de test
	Random random = new Random();
	
	r=0;
	while((i<16)&&(c<4))// on commence par parcourir le plateau et la matrice d� 
	{d = random.nextInt(6);//d renvoie une postion de 0 �5 � l'aide de la fonction random 
	p[c][t]=d�[i][d];//affectation de la lettre dans le plateau
	if (r==3)//lorsque r atteint 3 on incremente i c'est � dire on passer au d� suivant   
	{i++;// incrementation i c'est � dire on passer au d� suivant 
	c++;// incrementation de c pour passer � la ligne suivante dans le plateau
	t=0;// reinitialisation de t � zero pour quelle commence de la premiere case du plateau 
	r=0;}
	else 
	{i++;//sinon incrementaion de i pour passer au d� suivant
	t++; // incrementation de t pour passer � la case suivante du plateau
	r++;}}
	setPlateau(p);}//affecter le plateau intermidiaire 'p' au plateau 


/*Affiche le plateau creer 
 * d'une maniere organis�e*/
public void afficher_plateau()
{
   System.out.println("****************");
	for (int k=0;k<4;k++)
	{System.out.print("*");
		for (int j=0;j<4;j++)
	{System.out.print("  "+getPlateau()[k][j]);}
	System.out.println("  *");}
	System.out.println("****************");}

/*cette fonction verifie l'appartion de la chaine donn� dans le dictionnaire 
 * elle renvoie 1 si la chaine existe dans le dictionnaire sinon 0*/
public  int   apparition_ds_dict(String fichier,String ch )
 {
	 int trouve=0; 
	 //BufferReader :permet de lire les donn�es d'un fichier ligne par ligne 
	 //FileReader : ouvrir le fichier � partir de son chemin  
	   try (BufferedReader buffer = new BufferedReader(new FileReader(fichier))) {
			String line;
		 trouve =0;
		 // parcour du fichier ligne par ligne avec buffer.readline()
		 //tant que ligne n'est pas et on n'a pas encore trouv� la chaine 
			while (((line = buffer.readLine()) != null) && trouve==0)
				{if (ch.equals(line.toUpperCase()))//test� chaque ligne avec la chaine donn� 
				{trouve=1;}}
			buffer.close();}//fermer le fichier 
	   	catch (IOException e)// si le traitement n'excute pas noramalement catch va apparaitre o� l'exception est faite  
			{e.printStackTrace();}
	  
	return trouve;}

/*cette fonction cherche la chaine donn� dans le  plateau 
 * si elle renvoie 1 la chaine existe sinon 0 */
public int appartient_ds_plateau (String ch,char [][] getPlateau)
 {int [][]used=new int [6][6];//creation d'une matrice pour les lettre visit�es 
 int t =0;// resultat
 int l=0;// la ligne du plateau
 int c;// la colonne du plateau 
  int i=0;// postion de la lettre 
   boolean r=false;
   // on parcour le plateau jusqu'a trouver la premiere letter de la chaine donn� 
 	while((l<4)) 
 	{c=0;
 	while((c<4))
	 	{
	 		if (Boogle.plateau[l][c]==ch.charAt(i))// si la premiere lettre est trouv�e	
			 	{m=true;
			 	stop=false;
			 	used[l][c]=1;//on la marque comme visit� en affectant 1 en utilsant les memes coordonn�es  	
			 	r=appartenir( Boogle.plateau,used,ch,l,c,i+1,m ,stop);// on appel la fonction appartenir qu' est recursive  
			 	}
	 		if (r)
	 		{c=4; // si la chaine trouv� on quitte la boucle 
	 		 l=4;
	 		 }
	 	    else 
	 		c++;
	 	}
 	l++;
 	}
 	if (r==true ) // si r egale true t re�oit 1 
 	{t=1;}
 	
 return t;}

/* cette fonction est recursive elle prend comme parametre le plateau la chaine les coordonn�es de la premiere 
 * lettre de la chaine la postion de la lettre suivante (lors de la premier appel )
 * elle verfie l'existance de la lettre suivante dans les adjacents de la  lettre donn�e  */
public boolean appartenir(char [][] plateau,int [][] used,String ch,int l,int c, int i,boolean m,boolean stop)
{
	 if (i<ch.length()&&(m))// on teste si la postion de la lettre suivante ne depasse pas la longueur de la chaine
{	 
		 
	 	 /*elle verfie l'existance de la lettre suivante avec les adjacents de la  lettre donn�e  
		 en utilisant 8 conditions qui varie selon la postion de la lettre donn�*/
	 if (((l-1)>=0) &&((c-1)>=0)&& ch.charAt(i)==Boogle.plateau[l-1][c-1]&& used[l-1][c-1]==0&&m&&!this.stop)
	 {// si l'un des adjacents egale � la lettre suivante dans la chaine 
	// il est marqu� comme utilis�
	 used[l-1][c-1]=1;
		 appartenir(plateau,used,ch,l-1,c-1,i+1,m,this.stop);
		 /*on lance un autre appel en lui donnant les coordonn�es 
		 de la lettre trouv� et l'indice de la lettre suivante */
		 }
		 
	 if (((l-1)>=0) &&((c+1)<4)&& ch.charAt(i)==Boogle.plateau[l-1][c+1]&& used[l-1][c+1]==0&&m&&!this.stop)
	 {used[l-1][c+1]=1;
	 appartenir(plateau,used,ch,l-1,c+1,i+1,m,this.stop);
	 }
	 if (((l+1<4) &&((c+1<4))&& ch.charAt(i)==Boogle.plateau[l+1][c+1]&& used[l+1][c+1]==0&&m&&!this.stop))
	 {used[l+1][c+1]=1;
	 appartenir(plateau,used,ch,l+1,c+1,i+1,m,this.stop);
	}
	 if (((l+1)<4) &&((c-1)>=0)&& ch.charAt(i)==Boogle.plateau[l+1][c-1]&& used[l+1][c-1]==0&&m&&!this.stop)
	 {used[l+1][c-1]=1;
	 appartenir(plateau,used,ch,l+1,c-1,i+1,m,this.stop);
	 }
    if ((((l-1)>=0) && ch.charAt(i)==Boogle.plateau[l-1][c]&& used[l-1][c]==0&&m&&!this.stop))
    {
    used[l-1][c]=1;
	 appartenir(plateau,used,ch,l-1,c,i+1,m,this.stop);
	 }
    if ((((c-1)>=0)&& ch.charAt(i)==Boogle.plateau[l][c-1]&& used[l][c-1]==0&&m&&!this.stop))
    {used[l][c-1]=1;
	 appartenir(plateau,used,ch,l,c-1,i+1,m,this.stop);
	 }
  	 if ((((l+1)<4) && ch.charAt(i)==Boogle.plateau[l+1][c]&& used[l+1][c]==0&&m&&!this.stop))
  	{used[l+1][c]=1;
	 appartenir(plateau,used,ch,l+1,c,i+1,m,this.stop);
	}
  	 if ((((c+1)<4)&& ch.charAt(i)==Boogle.plateau[l][c+1]&& used[l][c+1]==0&&m&&!this.stop))
  	{used[l][c+1]=1;
	 appartenir(plateau,used,ch,l,c+1,i+1,m,this.stop);
	}
  	 }
	 
/* si l'indice de lettre suivante � cherche n'atteint pas la longueur de la chaine
 * c'est � dire on n'a pas encore trouv� la chaine et m re�oit faux*/	   

if (i!=ch.length()&&!this.stop)
	
m=false;
else this.stop=true;
	 
	 
	 
return m;} 
 
}

