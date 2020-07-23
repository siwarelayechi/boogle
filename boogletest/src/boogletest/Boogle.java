package boogletest;

import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Boogle {
	public boolean m;
	public boolean stop;
	public static char[][] plateau;
/*initialisation d'une matrice statique chaque ligne presente un dé*/ 
	public static char[][] dé={{'B','A','J','O','Q','M'},
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
//constructeur Boogle sert à initialiser le plateau 
	public Boogle()	
{ plateau= new char[4][4];}
//getPlateau permet d'acceder au plateau
public char[][] getPlateau() {
	return Boogle.plateau;
}
//setPlateau permet de modifie le plateau 
public void setPlateau(char[][] p) {
	Boogle.plateau = p;}

/*la fonction creation_plateau sert à creer le plateau à travers  la matrice staitique 'dé'*/
public void creation_plateau()
	{ char [][]p=new char [4][4];
	 
	int c=0;//represente la ligne de la plateau
	int t=0 ;// represente la colonne de la plateau
	int i=0; // represente la ligne de la matrice statique 'dé'
	int d=0; //position d'une choisie aléatoirement à partir de la matrice 'dé'   
	int r;// variable de test
	Random random = new Random();
	
	r=0;
	while((i<16)&&(c<4))// on commence par parcourir le plateau et la matrice dé 
	{d = random.nextInt(6);//d renvoie une postion de 0 à5 à l'aide de la fonction random 
	p[c][t]=dé[i][d];//affectation de la lettre dans le plateau
	if (r==3)//lorsque r atteint 3 on incremente i c'est à dire on passer au dé suivant   
	{i++;// incrementation i c'est à dire on passer au dé suivant 
	c++;// incrementation de c pour passer à la ligne suivante dans le plateau
	t=0;// reinitialisation de t à zero pour quelle commence de la premiere case du plateau 
	r=0;}
	else 
	{i++;//sinon incrementaion de i pour passer au dé suivant
	t++; // incrementation de t pour passer à la case suivante du plateau
	r++;}}
	setPlateau(p);}//affecter le plateau intermidiaire 'p' au plateau 


/*Affiche le plateau creer 
 * d'une maniere organisée*/
public void afficher_plateau()
{
   System.out.println("****************");
	for (int k=0;k<4;k++)
	{System.out.print("*");
		for (int j=0;j<4;j++)
	{System.out.print("  "+getPlateau()[k][j]);}
	System.out.println("  *");}
	System.out.println("****************");}

/*cette fonction verifie l'appartion de la chaine donné dans le dictionnaire 
 * elle renvoie 1 si la chaine existe dans le dictionnaire sinon 0*/
public  int   apparition_ds_dict(String fichier,String ch )
 {
	 int trouve=0; 
	 //BufferReader :permet de lire les données d'un fichier ligne par ligne 
	 //FileReader : ouvrir le fichier à partir de son chemin  
	   try (BufferedReader buffer = new BufferedReader(new FileReader(fichier))) {
			String line;
		 trouve =0;
		 // parcour du fichier ligne par ligne avec buffer.readline()
		 //tant que ligne n'est pas et on n'a pas encore trouvé la chaine 
			while (((line = buffer.readLine()) != null) && trouve==0)
				{if (ch.equals(line.toUpperCase()))//testé chaque ligne avec la chaine donné 
				{trouve=1;}}
			buffer.close();}//fermer le fichier 
	   	catch (IOException e)// si le traitement n'excute pas noramalement catch va apparaitre où l'exception est faite  
			{e.printStackTrace();}
	  
	return trouve;}

/*cette fonction cherche la chaine donné dans le  plateau 
 * si elle renvoie 1 la chaine existe sinon 0 */
public int appartient_ds_plateau (String ch,char [][] getPlateau)
 {int [][]used=new int [6][6];//creation d'une matrice pour les lettre visitées 
 int t =0;// resultat
 int l=0;// la ligne du plateau
 int c;// la colonne du plateau 
  int i=0;// postion de la lettre 
   boolean r=false;
   // on parcour le plateau jusqu'a trouver la premiere letter de la chaine donné 
 	while((l<4)) 
 	{c=0;
 	while((c<4))
	 	{
	 		if (Boogle.plateau[l][c]==ch.charAt(i))// si la premiere lettre est trouvée	
			 	{m=true;
			 	stop=false;
			 	used[l][c]=1;//on la marque comme visité en affectant 1 en utilsant les memes coordonnées  	
			 	r=appartenir( Boogle.plateau,used,ch,l,c,i+1,m ,stop);// on appel la fonction appartenir qu' est recursive  
			 	}
	 		if (r)
	 		{c=4; // si la chaine trouvé on quitte la boucle 
	 		 l=4;
	 		 }
	 	    else 
	 		c++;
	 	}
 	l++;
 	}
 	if (r==true ) // si r egale true t reçoit 1 
 	{t=1;}
 	
 return t;}

/* cette fonction est recursive elle prend comme parametre le plateau la chaine les coordonnées de la premiere 
 * lettre de la chaine la postion de la lettre suivante (lors de la premier appel )
 * elle verfie l'existance de la lettre suivante dans les adjacents de la  lettre donnée  */
public boolean appartenir(char [][] plateau,int [][] used,String ch,int l,int c, int i,boolean m,boolean stop)
{
	 if (i<ch.length()&&(m))// on teste si la postion de la lettre suivante ne depasse pas la longueur de la chaine
{	 
		 
	 	 /*elle verfie l'existance de la lettre suivante avec les adjacents de la  lettre donnée  
		 en utilisant 8 conditions qui varie selon la postion de la lettre donné*/
	 if (((l-1)>=0) &&((c-1)>=0)&& ch.charAt(i)==Boogle.plateau[l-1][c-1]&& used[l-1][c-1]==0&&m&&!this.stop)
	 {// si l'un des adjacents egale à la lettre suivante dans la chaine 
	// il est marqué comme utilisé
	 used[l-1][c-1]=1;
		 appartenir(plateau,used,ch,l-1,c-1,i+1,m,this.stop);
		 /*on lance un autre appel en lui donnant les coordonnées 
		 de la lettre trouvé et l'indice de la lettre suivante */
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
	 
/* si l'indice de lettre suivante à cherche n'atteint pas la longueur de la chaine
 * c'est à dire on n'a pas encore trouvé la chaine et m reçoit faux*/	   

if (i!=ch.length()&&!this.stop)
	
m=false;
else this.stop=true;
	 
	 
	 
return m;} 
 
}

