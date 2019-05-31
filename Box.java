//classe de la cellule
public class Box {

	/**
	 * @param args
	 */

	// si down == true alors le mur du bas est présent, etc.
	private boolean down;
	private boolean right;
	private boolean up;
	private boolean left;
	private int id;
	private int value;
	
	public Box(boolean a, boolean b, boolean c, boolean d,int e, int f){
		 down = a;
		 right = b;
		 up = c;
		 left = d;
		 id = e;
		 value = f;
	}
	
	public void setDown (boolean a){
		down = a;
	}
	
	public void setValue (int a){
		value = a;
	}
	
	public void setRight (boolean a){
		right = a;
	}
	
	public boolean getDown(){
		return down;
	}
	
	public boolean getRight(){
		return right;
	}
	
	public boolean getUp(){
		return up;
	}
	
	public boolean getLeft(){
		return left;
	}
	
	public int getId(){
		return id;
	}
	
	public int getValue(){
		return value;
	}
}
	
