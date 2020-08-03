import java.util.Scanner;

class LabExercice6{
	public static void main(String[] args){
		double[] grades = new double[10];
		for (int i = 0; i < 10; i++){
			System.out.print("Please Enter grade number "+(i+1)+": ");
			Scanner sc = new Scanner(System.in);
			grades[i] = sc.nextInt();
		}
		calculateAverage(grades);
		calculateMedian(grades);
		calculateNumberFailed(grades);
		calculateNumberPassed(grades);
	}
	
	public static void calculateAverage(double[] notes){
		double result;
		result = 0;
		for(int i = 0; i < notes.length; i++){
			result = result + notes[i];
			
		}
		result = (result/notes.length);
		System.out.println("Class average is "+result);
	}
	
	public static void calculateMedian(double[] notes){
		System.out.println("The median is"+(notes[4]+notes[5])/2);
	}
	
	public static void calculateNumberFailed(double[] notes){
		int result = 0;
		for(int i = 0; i < notes.length; i++){
			if (notes[i] < 50){
				result++;
			}
		}
		System.out.println("Number of failing grades is "+result);
	}
	
	public static void calculateNumberPassed(double[] notes){
		int result = 0;
		for(int i = 0; i < notes.length; i++){
			if (notes[i] >= 50){
				result++;
			}
		}
		System.out.println("Number of passing grades is "+result);
	}

}