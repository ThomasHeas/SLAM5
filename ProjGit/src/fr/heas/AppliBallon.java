package fr.heas;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Random;
import javax.swing.JFrame;


	/**
	 * Animation d'un ballon dans une fen�tre graphique. Un ballon est dessin� �
	 * l'int�rieur d'une fen�tre et se d�place. Chaque fois que l'un des bords est
	 * atteint, le ballon change de direction.
	 * 
	 */

	public class AppliBallon extends JFrame implements MouseMotionListener{
		//donne l'etat de l'application
		private boolean cestfini;
		
		/**
		 * Construit une fen�tre avec une barre de titre
		 * @param nom Titre de la fen�tre
		 */
		public AppliBallon (String nom){
			super(nom);
			cestfini = false;
		}
		
		public static void main(String[] args) {

			// la fen�tre graphique
			AppliBallon laFenetre = new AppliBallon	("Ballon anim�");
			laFenetre.addMouseMotionListener(laFenetre);

			laFenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//place la fen�tre aux coord. du point de l'�cran
			laFenetre.setLocation(new Point(150, 150));
			//d�finit la taille de la fen�tre
			laFenetre.setSize(512, 512);

			// cr�� la zone de dessin et la place dans la fen�tre
			Dessin d = new Dessin();
			laFenetre.add(d);

			// affiche la fen�tre
			laFenetre.setVisible(true);

			// creation d'un objet BallonRondSauteur
			BallonRondSauteur 	leBallon = new BallonRondSauteur( new Random().nextInt(400)  , new Random().nextInt(400));

			// on rajoute cet objet � la z�ne de dessin
				d.ajouterObjet(leBallon);

			// la boucle d'animation
			// c'est une boucle infinie, le programme se ferme lorsque la souris
			//  passe sur la fen�tre ou lors d'un clic dans la case de fermeture.
			while ( ! laFenetre.cestfini) {
				leBallon.deplacerSansRebond();

				// la zone de dessin se r�affiche
				d.repaint();

				// pause en ms pour voir le deplacement
				d.pause(200);
			}
			System.exit(0);
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			cestfini = true;
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			cestfini = true;
		}

	} // AppliBallon
