package com.supinfo.sokoban;
import java.util.Scanner;

public class Play {
	
						//ATTRIBUT
	private int largeurMap; 
	private int hauteurMap;
	private int nb_cibles;
	private int nb_caissesRangees;
	private int score =0;
	private Plateau  plateau = null;
	private Joueur player ;
	Scanner saisieClavier;
	String directionChoisie;
	
						//CONSTRUCTEURS
	
	//Constructeur par defaut
	public Play(){
		
		saisieClavier = new Scanner(System.in);
		
		this.changerNiveau("niv1");
		this.jouer();
	}
	
	//constructeur surcharg� :
	
	public Play(String level){
		
		this.changerNiveau(level);
		this.jouer();
	
	}
	
	
						// METHODES
	
	
	
	public void changerNiveau(String level){		//m�thode permettant de changer un niveau � partir d'un fichier
		
		LoadMap loading = new LoadMap(level);
		plateau = loading.getMap();
		largeurMap = plateau.getLargeurPlateau();
		hauteurMap = plateau.getLargeurPlateau();
		nb_cibles = plateau.getNb_cibles();
		nb_caissesRangees = 0;
		player = new Joueur(plateau.getPlateau(), largeurMap, hauteurMap, plateau.getX_joueur(), plateau.getY_joueur());
		
	}
	
	public void afficherMap(){
		
		plateau.afficherPlateau();
	}
	
	//La m�thode jouer devra etre appel�e dans le main elle permet de faire tourner le jeu
	
	public void jouer(){
		
		boolean victoire = false;
		
		//On boucle tant que l'utilisateur n'a pas gagn� : 
		do{
			
			afficherMap(); //On affiche la map
			
			//player.setDirectionJoueur( SAISIE CLAVIER );
			
			System.out.println("Dans quelle direction aller? HAUT(H)  BAS(B)  GAUCHE(G)  Droite(D)");
			
			directionChoisie = saisieClavier.nextLine();
			
			switch(directionChoisie){
				case "H":
					player.setDirectionJoueur("HAUT");
					break;
				
				case "B":
					player.setDirectionJoueur("BAS");
					break;
				
				case "G":
					player.setDirectionJoueur("GAUCHE");
					break;
				
				case "D":
					player.setDirectionJoueur("DROITE");
					break;
				
				default:
					System.out.println("ERREUR SAISIE");
					break;
			}
			
			score++;
			player.deplacerJoueur(plateau.getPlateau());		//on d�place le joueur sur la map
			chercherCaissesRangees(plateau.getPlateau());		//On cherche les caisse d�j� rang�es
			if(nb_caissesRangees == nb_cibles){		//si toutes les caisses sont rang�es on � gagn� 
				victoire = true;
			}
			
		}
		while(victoire == false); 	//On sort de la boucle si les conditions de victoire sont remplies
	}
	
	public void chercherCaissesRangees(Case map[][]){
		
		nb_caissesRangees = 0;
		
		for(int i =0 ; i < largeurMap; i++){
			for( int j =0; j < hauteurMap; j++){
				if(map[i][j].getContenu() == "B" && map[i][j].getCible() ==1){
					nb_caissesRangees++;
				}
			}
		}
	}
	
	
						// GETTER ET SETTER
	public int getLargeurMap() {
		return largeurMap;
	}

	public void setLargeurMap(int largeurMap) {
		this.largeurMap = largeurMap;
	}

	public int getHauteurMap() {
		return hauteurMap;
	}

	public void setHauteurMap(int hauteurMap) {
		this.hauteurMap = hauteurMap;
	}

	public int getNb_cibles() {
		return nb_cibles;
	}

	public void setNb_cibles(int nb_cibles) {
		this.nb_cibles = nb_cibles;
	}

}
