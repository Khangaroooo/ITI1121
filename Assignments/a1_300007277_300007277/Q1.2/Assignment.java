// Author: Khang Nguyen
// Student number: 300007277
// Course: ITI 1121-A
// Assignment: 1
// Question: 1.2
/**
 * The class  <b>Assignment</b> is used to
 * test our LinearRegression class. It uses the
 * provided class <b>Display</b> to show the results
 *
 * @author gvj (gvj@eecs.uottawa.ca)
 *
 */

import java.util.Random;
public class Assignment {


	/** 
     * Random generator 
     */
	private static java.util.Random generator = new java.util.Random();

		/** 
     * In this second method, we will select a line at random.
     * 	1) we select a line y = ax + b, with a randomly selected
     * between -100 and +100 and b randomly selected between 
     * -250 and +250
     * 	2) we add 500 samples randomly selected on the line
     * between -100 and +300. For each sample we add a "noise" 
     * randomly selected between -1000 and +1000 (that is, for
     * each randomly selected x, we add the sample (x, ax+b+noise).
     * where "noise" is randomly selected between -1000 and 1000
     *  3) We create an instance of Display
     *  4) we iterate gradient descent (find a number of iterations,
     * a number of updates to the instance of Display, and a 
     * step alpha that seems to work
     */
	private static void randomLine(){
		LinearRegression l = new LinearRegression(500);
		double a = Math.floor(Math.random()*201) - 100;
		double b = (Math.floor(Math.random()*501) - 250);
		for(int i = 0; i < 500; i++){
			double temp = (Math.random()*401) -100;
			l.addSample(temp, ((a * temp) + b - ((Math.random()*2001) - 1000)));
			
		}
		Display graph;
		graph = new Display(l);
		graph.setTarget(a,b);
		graph.update();
		for (int i = 1; i<=100;i++){
			System.out.println("Current Hypotesis: "+l.currentHypothesis()+"\n Current cost: "+l.currentCost()+"\n Aiming for: "+b+" + "+a+"x");
			graph.update();
			l.gradientDescent(0.000008, 200);
		}
		System.out.println("Current Hypotesis: "+l.currentHypothesis()+"\n Current cost: "+l.currentCost()+"\n Aiming for: "+b+" + "+a+"x");
		graph.update();
		
	}


	public static void main(String[] args) {

	    StudentInfo.display();

		System.out.println("randomLine");
		randomLine();

	}

}