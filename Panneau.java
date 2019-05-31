import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Panneau extends JPanel {
	Grid grid;
	private Boolean winJ1 = false;
	private Boolean winJ2 = false;
	private int pos1X;
	private int pos1Y;
	private int pos2X;
	private int pos2Y;
	private int posTP1X;
	private int posTP1Y;
	private int posTP2X;
	private int posTP2Y;
	private int posTP3X;
	private int posTP3Y;

	public Panneau(Grid grid) {
		this.grid = grid; // recuperation de la grille instancié dans le main
	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.black);
		// dessin du fond
		g.fillRect(0, 0, (grid.getNbColumns() + 1) * 40, (grid.getNbLines() + 1) * 40);
		g.setColor(Color.white);
		// dessin des murs
		// reste à changer les system.out.print par de l'affichage de lignes
		for (int i = 0; i < grid.getNbLines(); i++) {
			g.fillRect(0, i * 40, 5, 40);
			System.out.print("|");
			for (int j = 0; j < grid.getNbColumns(); j++) {
				System.out.print("   ");
				if (grid.getBox(i, j).getRight()) {
					g.fillRect((j + 1) * 40, i * 40, 5, 40);
					System.out.print("|");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
			System.out.print("+");
			for (int j = 0; j < grid.getNbColumns(); j++) {
				if (grid.getBox(i, j).getDown()) {
					System.out.print("---+");
					g.fillRect(j * 40, (i + 1) * 40, 40, 5);
				} else {
					System.out.print("   +");
				}
			}
			System.out.println();
		}

		g.setColor(Color.YELLOW);
		// dessin des pion
		g.fillOval(pos1X, pos1Y, 17, 17);
		g.setColor(Color.BLUE);
		g.fillOval(pos2X, pos2Y, 17, 17);
		// dessin des TP
		g.setColor(Color.GREEN);
		g.fillOval(posTP1X, posTP1Y, 17, 17);
		g.fillOval(posTP2X, posTP2Y, 17, 17);
		g.fillOval(posTP3X, posTP3Y, 17, 17);
		g.setColor(Color.WHITE);
		g.fillOval(grid.getNbColumns() * 40 - 25, grid.getNbLines() / 2 * 40 + 15, 17, 17);
		// cas où le joueur 1 l'emporte
		if (winJ1) {
			g.setColor(Color.YELLOW);
			g.fillOval(grid.getNbColumns() / 2 * 40 - 170, grid.getNbLines() / 2 * 40 - 170, 370, 370);
		}
		if (winJ2) {
			g.setColor(Color.BLUE);
			g.fillOval(grid.getNbColumns() / 2 * 40 - 170, grid.getNbLines() / 2 * 40 - 170, 370, 370);
		}
	}

	// Creation des getters et des setters
	public int getPos1X() {
		return pos1X;
	}

	public void setPos1X(int pos1X) {
		this.pos1X = pos1X;
	}

	public int getPos2X() {
		return pos2X;
	}

	public void setPos2X(int pos2X) {
		this.pos2X = pos2X;
	}

	public int getPos1Y() {
		return pos1Y;
	}

	public void setPos1Y(int pos1Y) {
		this.pos1Y = pos1Y;
	}

	public int getPos2Y() {
		return pos2Y;
	}

	public void setPos2Y(int pos2Y) {
		this.pos2Y = pos2Y;
	}

	public int getPosTP1X() {
		return posTP1X;
	}

	public void setPosTP1X(int posTP1X) {
		this.posTP1X = posTP1X;
	}

	public int getPosTP1Y() {
		return posTP1Y;
	}

	public void setPosTP1Y(int posTP1Y) {
		this.posTP1Y = posTP1Y;
	}

	public int getPosTP2X() {
		return posTP2X;
	}

	public void setPosTP2X(int posTP2X) {
		this.posTP2X = posTP2X;
	}

	public int getPosTP2Y() {
		return posTP2Y;
	}

	public void setPosTP2Y(int posTP2Y) {
		this.posTP2Y = posTP2Y;
	}

	public int getPosTP3X() {
		return posTP3X;
	}

	public void setPosTP3X(int posTP3X) {
		this.posTP3X = posTP3X;
	}

	public int getPosTP3Y() {
		return posTP3Y;
	}

	public void setPosTP3Y(int posTP3Y) {
		this.posTP3Y = posTP3Y;
	}

	public Boolean getWinJ1() {
		return winJ1;
	}

	public void setWinJ1(Boolean winJ1) {
		this.winJ1 = winJ1;
	}

	public Boolean getWinJ2() {
		return winJ2;
	}

	public void setWinJ2(Boolean winJ2) {
		this.winJ2 = winJ2;
	}
}
