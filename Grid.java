public class Grid{
	private Box[][] grid;	
	private int nbLines;
	private int nbColumns;
	
	public void afficher() {
		System.out.print("+");
		for(int j = 0; j < this.nbColumns; j++){
			System.out.print("---+");
		}
		System.out.println();
		
		for(int i = 0; i < this.nbLines; i++){
			System.out.print("|");
			for(int j = 0; j < this.nbColumns; j++){
				System.out.print("   ");
				if (grid[i][j].getRight()) {
					System.out.print("|");
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println();
			System.out.print("+");
			for(int j = 0; j < this.nbColumns; j++){
				if (grid[i][j].getDown()) {
					System.out.print("---+");
				}
				else {
					System.out.print("   +");
				}
			}
			System.out.println();
		}
	}
	
	//Constructeur, à partir du nombre de ligne et de colonne le labyrinthe est généré
	public Grid (int nbLines, int nbColumns){
		grid = new Box[nbLines][nbColumns];
		this.nbLines = nbLines;
		this.nbColumns = nbColumns;
		int candidates []; //tableau contenant l'ID des cellules dont un mur peut être retiré
		candidates = new int [this.nbLines*this.nbColumns];
		int k = 0; //La variable k compte le nombre de mur retiré
		
		for(int i = 0; i < this.nbLines; i++){
			for(int j = 0; j < this.nbColumns; j++){
				int idBox = j*this.nbLines + i+1;
				
				
				// première ligne
				if (i == 0 && j != 0){
					grid[i][j] = new Box(true, true, true, false, idBox, idBox);
				}
				// première colonne
				else if (j == 0 && i != 0){
					grid[i][j] = new Box(true, true, false, true, idBox, idBox);
				}
				// première cellule
				else if (j == 0 && i == 0){
					grid[i][j] = new Box(true, true, true, true, idBox, idBox);
				}
				else{
					grid[i][j] = new Box(true, true, false, false, idBox, idBox);
				}
			}
		}
		
		//le while ci dessous permet de savoir si la construction du labyrinthe est terminée
		while (k < this.nbLines*this.nbColumns-1){
			//la boucle ci-dessous permet d'identifier les cellules dont un mur peut être retiré
			int l = 0;
			for(int i = 0; i < this.nbLines; i++){
				for(int j = 0; j < this.nbColumns; j++){
					
					// Mur droit
					if (j < (this.nbColumns-1) && grid[i][j].getValue() != grid[i][j+1].getValue()) {
						candidates[l] = grid[i][j].getId();
						l = l +1;
					}
					
					// Mur bas, le else if permet d'éviter de répertorier deux fois la même cellule
					else if (i < (this.nbLines-1) && grid[i][j].getValue() != grid[i+1][j].getValue()) {
						candidates[l] = grid[i][j].getId();
						l = l +1;
					}
				}
			}
			
			//chosen est la cellule choisie aléatoirement dans laquelle un mur va être retiré
			int chosen = ToolBox.randomNumber(l+1) - 1;
			int numInf = 0;
			int numSup = 0;
			boolean candidateDown = false;
			boolean candidateRight = false;
			int chosen_id = candidates[chosen];
			
			int chosen_line = (chosen_id-1) % this.nbLines;
			int chosen_column = (chosen_id-1) / this.nbLines;
			
			//System.out.println(chosen_id+ " "+  chosen_line + " " + chosen_column);
			
			// chercher les murs ouvrables
			// mur de droite
			if (chosen_column < (this.nbColumns-1) && grid[chosen_line][chosen_column].getValue() != grid[chosen_line][chosen_column+1].getValue()) {
				candidateRight = true;
			}
			// Mur bas
			if (chosen_line < (this.nbLines-1) && grid[chosen_line][chosen_column].getValue() != grid[chosen_line+1][chosen_column].getValue()) {
				candidateDown = true;
			}
			
			//System.out.println(candidateRight+ " "+  candidateDown);
			
			if (candidateDown && candidateRight) {
				if (ToolBox.randomNumber(3) == 1) {
					candidateDown = false;
				}
				else {
					candidateRight = false;
				}
			}
			
			if (candidateDown && !candidateRight) {
				grid[chosen_line][chosen_column].setDown(false);
				numInf = Math.min(grid[chosen_line][chosen_column].getValue(), grid[chosen_line+1][chosen_column].getValue());
				numSup = Math.max(grid[chosen_line][chosen_column].getValue(), grid[chosen_line+1][chosen_column].getValue());
			}
			else if (!candidateDown && candidateRight) {
				grid[chosen_line][chosen_column].setRight(false);
				numInf = Math.min(grid[chosen_line][chosen_column].getValue(), grid[chosen_line][chosen_column+1].getValue());
				numSup = Math.max(grid[chosen_line][chosen_column].getValue(), grid[chosen_line][chosen_column+1].getValue());
			}
			
			for(int i = 0; i < this.nbLines; i++){
				for(int j = 0; j < this.nbColumns; j++){
					if (grid[i][j].getValue() == numSup){
						grid[i][j].setValue(numInf);
					}
				
				}
			}
			k++;
		}
	}	
	
	public int getNbLines(){
		return nbLines;
	}
	
	public int getNbColumns(){
		return nbColumns;
	}	
	
	public Box getBox(int a, int b){
		return grid[a][b] ;
	}
	
	public Box getIdBox(int id){
		if (id % nbLines == 0){			
			return grid[nbLines][id/nbLines];
		}
		//System.out.println(id + " " + id%nbLines + " " + id/nbLines);
		return grid[id%nbLines][(id/nbLines) + 1];

	}

}