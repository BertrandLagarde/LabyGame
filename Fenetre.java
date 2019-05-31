import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame {
	private Panneau pan;

	public Fenetre(Grid grid) {
		// On donne les attributs global de la fenêtre
		this.setTitle("Labyrinthe");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize((grid.getNbColumns() + 1) * 40 - 20, (grid.getNbLines() + 1) * 40);
		this.setLocationRelativeTo(null);
		// On dit à la fenêtre que sont contenu sera issu de la classe Panneau
		pan = new Panneau(grid);
		this.setContentPane(pan);
		this.setVisible(true);
		EcouteurFenetre EF = new EcouteurFenetre(this, pan, grid); // Création d'un écouteur sur la fenetre appellé EF,
																	// transmissions de l'instance de l'objet courant et
																	// de l'objet pan et la grille
		this.addKeyListener(EF); // Ajout de l'écouteur à la classe actuelle

		// Initialisation de la position des TP et des Pions
		// Dans le cas où l'on voudrait modifier l'emplacement des TP il faudrait
		// modifier ici et dans EcouteurFenetre (a ameliorer)
		pan.setPos1X(17);
		pan.setPos1Y(17);
		pan.setPos2X(17);
		pan.setPos2Y(17 + (grid.getNbLines() - 1) * 40);
		pan.setPosTP1X(grid.getNbColumns() / 2 * 40 + 15);
		pan.setPosTP1Y(grid.getNbLines() / 2 * 40 + 15);
		pan.setPosTP2X(grid.getNbColumns() / 2 * 40 + 15);
		pan.setPosTP2Y(17);
		pan.setPosTP3X(grid.getNbColumns() / 2 * 40 + 15);
		pan.setPosTP3Y(grid.getNbLines() * 40 - 25);
	}
}
