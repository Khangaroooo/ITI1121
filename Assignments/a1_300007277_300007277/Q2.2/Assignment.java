// Author: Khang Nguyen
// Student number: 300007277
// Course: ITI 1121-A
// Assignment: 1
// Question: 2.2
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
     * In this second method, we will select a plane at random.
     * 	1) we select a line z = ax + by + c, with a, b and c 
     * randomly selected between -100 and +100 
     * 	2) we add 5000 samples randomly selected on the plane
     * with x and y both randomly selected between 50 and 4000. 
     * For each sample we add a "noise" 
     * randomly selected between -20 and +20 (that is, for
     * each randomly selected x and y we add the sample 
     *[ (x,y), ax+by+c+noise).
     * where "noise" is randomly selected between -20 and 20
     *  4) we iterate gradient descent (find a number of iterations,
     * and a step alpha that seems to work, regularly printing
     * the target,  the current hypothesis and the current cost)
     */

	private static void randomPlane(){
		LinearRegression l = new LinearRegression(2, 5000);
		double a = Math.floor(Math.random()*201) - 100;
		double b = Math.floor(Math.random()*201) - 100;
		double c = Math.floor(Math.random()*201) - 100;
		for(int i = 0; i < 1000; i++){
			double x1 = Math.floor(Math.random()*3951) + 50;
			double x2 = Math.floor(Math.random()*3951) + 50;
			l.addSample(new double[]{x1, x2}, (a*x1 + b*x2 + c + Math.floor(Math.random()*41) -20));
		}
		for (int i = 0; i<20;i++){
			System.out.println("Current Hypotesis: "+l.currentHypothesis()+"\n Current cost: "+l.currentCost());
			l.gradientDescent(0.000000003, 2000);
		}
		System.out.println("Current Hypotesis: "+l.currentHypothesis()+"\n Current cost: "+l.currentCost());
	}


	public static void main(String[] args) {

		StudentInfo.display();

		System.out.println("randomPlane");
		randomPlane();



	}

}