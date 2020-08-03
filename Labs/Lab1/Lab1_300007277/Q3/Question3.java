public class Question3{
	 
	public static int[] theArray (int size){
		int[] theArray = new int[size];
		return theArray;
	  
	}
	 
	public static int theSquare(int i){
		return (i*i);
	}
	 
	public static void main(String[] args){
		int[] squared = theArray(13);
		for (int i =0; i < squared.length; i++){
			squared[i] = theSquare(i);
			System.out.println("The square of "+i+" is "+squared[i]);
		}
	}
}