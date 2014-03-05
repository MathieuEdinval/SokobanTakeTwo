package com.supinfo.sokoban;

public class Plateau {
								//ATTRIBUTS
	int hauteurPlateau;
	int largeurPlateau;
	int nb_cibles;
	
	String nomPlateau;

	Case  plateau[][];
	
	
	
								//CONSTRUCTEUR
	
	Plateau(){
		hauteurPlateau = 8;
		largeurPlateau = 8;
		nb_cibles =1;
		nomPlateau="temp";
		plateau = new Case[largeurPlateau][hauteurPlateau];
		
		for(int i = 0; i < largeurPlateau; i++) {
			
			for(int j =0; j < hauteurPlateau; j++) {
				plateau[i][j] = new Case();
			}
		}
	}
	
							//METHODE
	
	//La m�thode changerTaillePlateau permet de changer la taille du plateau lors d'un changement de niveau par exemple :
	public void changerTaillePlateau(int nlleHauteur, int nlleLargeur){
		
		//On commence par lib�rer l'espace pr�c�dement allou� a notre plateau de case :
		for(int i = 0; i < largeurPlateau; i++) {
			
			for(int j =0; j < hauteurPlateau; j++) {
				plateau[i][j] = null;
			}
		}
		
		plateau =null;
		
		//L'on lui attribue ensuite un nouvel espace m�moire afin de changer sa taille :
		
		plateau = new Case [nlleLargeur][nlleHauteur];
		
		for(int i = 0; i < nlleLargeur ; i++){
			for( int j =0 ; j < nlleHauteur ; j++){
				plateau[i][j] = new Case();
			}
		}
	}
	
	
							//GETTERS ET SETTERS
	

	public int getHauteurPlateau() {
		return hauteurPlateau;
	}

	public void setHauteurPlateau(int hauteurPlateau) {
		this.hauteurPlateau = hauteurPlateau;
	}

	public int getNb_cibles() {
		return nb_cibles;
	}

	public void setNb_cibles(int nb_cibles) {
		this.nb_cibles = nb_cibles;
	}

	public String getNomPlateau() {
		return nomPlateau;
	}

	public void setNomPlateau(String nomPlateau) {
		this.nomPlateau = nomPlateau;
	}

}