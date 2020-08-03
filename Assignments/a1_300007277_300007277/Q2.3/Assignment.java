// Author: Khang Nguyen
// Student number: 300007277
// Course: ITI 1121-A
// Assignment: 1
// Question: 2.3
/**
 * The class  <b>Assignment</b> is used to
 * test our LinearRegression class. 
 *
 * @author gvj (gvj@eecs.uottawa.ca)
 *
 */

public class Assignment {


	/** 
     * Random generator 
     */
	private static java.util.Random generator = new java.util.Random();

	/** 
     * In this third method, we will follow the same approach
     * that the one followed in the method  randomPlane, but
     * this time we will have a variable number of dimensions,
     * specified by the parameter "dimension". We will
     * create 5000 samples of "dimension" dimension, where each
     * dimension will be ranmly selected between  -100 and +100,
     * and a randomly selected noise between -20 and +20 will be
     * added to the result.We will then iterate gradient descent 
     * (find a number of iterations,
     * and a step alpha that seems to work, regularly printing
     * the target,  the current hypothesis and the current cost)
     *
     * @param dimension the number of features
     */
	private static void randomDimension(int dimension){
		LinearRegression l = new LinearRegression(dimension, 5000);
		double [] x = new double[dimension];
		double [] t = new double[dimension+1];
		double answer = Math.floor(Math.random()*101) - 100;
		for(int i = 0; i < (dimension); i++){
			t[i] = Math.floor(Math.random()*101) - 100;
		}
		for (int k = 0; k < 5000; k++){
			for(int i = 0; i < dimension; i++){
				x[i] = Math.floor(Math.random()*3951) + 50;
			}
			for(int i = 0; i < dimension; i++){
				answer = answer + x[i]*t[i];
			}
			l.addSample(x, (answer + Math.floor(Math.random()*41) - 20));
		}
		for (int i = 0; i<20;i++){
			System.out.println("Current Hypotesis: "+l.currentHypothesis()+"\n Current cost: "+l.currentCost());
			l.gradientDescent(0.000000003, 1000);
		}
		System.out.println("Current Hypotesis: "+l.currentHypothesis()+"\n Current cost: "+l.currentCost());
	}


	public static void main(String[] args) {

		StudentInfo.display();

		System.out.println("randomDimension");
		randomDimension(50);


	}

}