/**
*Solution is a data structure to store cubes. It represents a partial solution to the instant insanity problem. It portrays a pile
*of n cubes, where n is element of [1, 2, 3, 4].
*
*
*@author Khang Nguyen
*/
public class Solution{
	
	private int size;
	private static int numberOfCalls = 0;
	private Cube[] cubeCopy;
	/**
	*The constructor Solution(Cube[] cube) is used to create a new solution with specific cubes for its instant insanity game. The array specifies
	*the cubes in this solution.
	*
	*@param Cube[] cubes, Array of cubes in the game instant insanity for which you want the solution
	*/
	public Solution(Cube[] cubes){
		size = cubes.length;
		cubeCopy = new Cube[size];
		for(int i = 0; i < size; i++){
		cubeCopy[i] = cubes[i].copy();
		}
	}
	
	/**
	*The constructor Cube(Color[] faces) is used to create a new cube with specific colours for its faces. The array specifies
	*the colours in the following order: up, front, right, back, left, and down.
	*initializes this solution using the specified information. It receives a partial solution
	*and a cube. The new solution has the same elements, in the same order, as the solution designated by other.
	*
	*@param Solution other, Cube C. That is partial and a cube that will be added to the game to find the valid solutions
	*/
	public Solution(Solution other, Cube c){
		size = other.size()+1;
		cubeCopy = new Cube[size];
		for(int i = 0; i < other.size; i++){
			cubeCopy[i] = other.getCube(i);
		}
		cubeCopy[size-1] = c.copy();
	}
	/**
	*retrieves size of the cube
	*
	*
	*@return the number of cubes in the current solution
	*/
	public int size(){
		return size;
	}
	
	/**
	*retrieves a cube of the solution
	*
	*
	*@return a cube in the current solution
	*/
	public Cube getCube(int pos){
		return cubeCopy[pos];
	}
	
	/**
	*returns whether or not the current solution is valid.
	*checks each side of the stacks to see if each color is different
	*
	*@return boolean whether the current solution is valid or not
	*/
	public boolean isValid(){
		numberOfCalls++;
		boolean t = true;
		for(int i =0; i< size; i++){
			for(int j = i+1; j<size; j++){
				if (cubeCopy[j].getFront() == cubeCopy[i].getFront()||cubeCopy[j].getRight() == cubeCopy[i].getRight()||cubeCopy[j].getBack() == cubeCopy[i].getBack()||cubeCopy[j].getLeft() == cubeCopy[i].getLeft()){
					t = false;
				}
			}
		}
		return t;
	}
	/**
	*returns whether or not the current solution is valid.
	*checks each side of the stacks to see if each color is different
	*(creates new solution with the cube then does normal isvalid and then returns that)
	*
	*@param Cube next, Cube for which you want to add to the current solution
	*@return boolean whether the current solution is valid or not
	*/
	public boolean isValid(Cube next){
		Solution s = new Solution(this, next);	
		return s.isValid();
	}
	
	
	/**
	*retrieves the numberOfCalls for isValid
	*
	*
	*@return the numberOfcalls to isValid
	*/
	public int getNumberOfCalls(){
		return numberOfCalls;
	}
	
	/**
	*resets the numberOfCalls for isValid ie turns it to 0
	*
	*
	*
	*/
	public void resetNumberOfCalls(){
		numberOfCalls = 0;
	}
	
	/**
	*String representation of the solution
	*
	*
	*@return String representation of Solution
	*/
	public String toString(){
		String s = "";
		for(int i =0; i< size; i++){
		 s = s + cubeCopy[i].toString() + "\n";	
		}
		
		return s;
	}
}