/**
*Cube is a class consisting of 6 colors for each side
*
*
*@author Khang Nguyen
*/
public class Cube{
	private Color[] side = new Color[6];//{up, front right back left down}
	private Color[] colors;
	private static final int ORIENTATIONCAP = 24;
	private Color[][] ori = new Color[24][6];
	private int orientation;
	
	/**
	*The constructor Cube(Color[] faces) is used to create a new cube with specific colours for its faces. The array specifies
	*the colours in the following order: up, front, right, back, left, and down.
	*
	*@param Color[] faces, Array of colors in the sides for which you want the cube
	*/
	public Cube(Color[] faces){
		colors = new Color[faces.length];
		for(int i = 0; i < faces.length; i++){
			colors[i] = faces[i];
		}
		side[0] = faces[0];
		side[1] = faces[1];
		side[2] = faces[2];
		side[3] = faces[3];
		side[4] = faces[4];
		side[5] = faces[5];
		orientation = 0;
	}
	
	/**
	*The constructor Cube(Color[] faces) is used to create a new cube with specific colours for its faces. The array specifies
	*the colours in the following order: up, front, right, back, left, and down.
	*
	*@param Cube other, cube containing the sides that you want to deep copy
	*/
	public Cube(Cube other){
		Color[] colors = {other.getUp(), other.getFront(), other.getRight(), other.getBack(), other.getLeft(), other.getDown()};
		side[0] = colors[0];
		side[1] = colors[1];
		side[2] = colors[2];
		side[3] = colors[3];
		side[4] = colors[4];
		side[5] = colors[5];
		orientation = 0;
	}
	
	/**
	*String representation of the cube
	*
	*
	*@return String representation of the cube
	*/
	public String toString(){
		return("["+side[0]+", "+side[1]+", "+side[2]+", "+side[3]+", "+side[4]+", "+side[5]+"]");
	}
	
	/**
	*returns whether or not the current cube has a next orientation.
	*
	*
	*
	*@return boolean whether current cube has a next orientation or not
	*/
	public boolean hasNext(){
		return(orientation != ORIENTATIONCAP);
	}
	
	/**
	*rotates the cube depending on which rotation it is currently on.
	*also checks if the current orientation has ever been done since last reset
	*
	*
	*
	*/
	public void next() throws IllegalStateException{
		if(orientation == 0){
			identity();
		}else{
			if(orientation%4 != 0){
				rotate();
			}else{
				if(orientation == 12||orientation == 16){
					leftRoll();
				}else{
					rightRoll();
				}
			}
		}
		if(orientation > 1){
			boolean tmp = true;
			for(int i = 0; i < orientation-1; i++){
				for(int j = 0; j < side.length; j++){
					if(ori[i][j] != side[j]){
						tmp = false;
					}
				}
			}
			if(tmp == true){
				throw new IllegalStateException();
			}
		}
	}
	
	/**
	*resets the orientation to 0
	*
	*
	*/
	public void reset(){
		orientation = 0;
	}
	
	/**
	*creates a deep copy of the current cube
	*
	*@return Cube copy of current cube
	*/
	public Cube copy(){
		return new Cube(this);
	}
	
	/**
	*rotates the cube to the right around the top-bottom axis so that the left side is now facing front.
	*
	*
	*/
	private void rotate(){
		Color temp = side[1];
		side[1] = side[4];
		side[4] = side[3];
		side[3] = side[2];
		side[2] = temp;
		orientation++;
	}
	
	/**
	* rolls the cube to the right around the back-front axis so that the left side is now up.
	*
	*
	*/
	private void rightRoll(){
		Color temp = side[0];
		side[0] = side[4];
		side[4] = side[5];
		side[5] = side[2];
		side[2] = temp;
		orientation++;
	}
	
	/**
	* rolls the cube to the left around the back-front axis so that the right side is now up.
	*
	*
	*/
	private void leftRoll(){
		Color temp = side[0];
		side[0] = side[2];
		side[2] = side[5];
		side[5] = side[4];
		side[4] = temp;
		orientation++;
	}
	
	/**
	* returns all the faces to their original state (colours).
	*
	*
	*/
	private void identity(){
		side[0] = colors[0];
		side[1] = colors[1];
		side[2] = colors[2];
		side[3] = colors[3];
		side[4] = colors[4];
		side[5] = colors[5];
		orientation = 1;
	}
	
	/**
	*return Color of top side of the cube
	*
	*
	*@return Color of top side
	*/
	public Color getUp(){
		return side[0];
	}
	
	/**
	*return Color of front side of the cube
	*
	*
	*@return Color of front side
	*/
	public Color getFront(){
		return side[1];
	}
	
	/**
	*return Color of right side of the cube
	*
	*
	*@return Color of right side
	*/
	public Color getRight(){
		return side[2];
	}
	
	/**
	*return Color of back side of the cube
	*
	*
	*@return Color of back side
	*/
	public Color getBack(){
		return side[3];
	}
	
	/**
	*return Color of left side of the cube
	*
	*
	*@return Color of left side
	*/
	public Color getLeft(){
		return side[4];
	}
	
	/**
	*return Color of bottom side of the cube
	*
	*
	*@return Color of bottom side
	*/
	public Color getDown(){
		return side[5];
	}
	
	
}