import javax.swing.JFrame;

public class main {
	public static void main(String[] args) {
		Grid grid;
		int nbLines = 11;
		int nbColumns = 19;
		grid = new Grid(nbLines, nbColumns);
		grid.afficher();
		Fenetre fen = new Fenetre(grid);
	}
}