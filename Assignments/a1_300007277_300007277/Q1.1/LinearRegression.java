// Author: Khang Nguyen
// Student number: 300007277
// Course: ITI 1121-A
// Assignment: 1
// Question: 1.1
/**
 * The class  <b>LinearRegression</b> implements gradient
 * descent with 1 variable.
 *
 * @author gvj (gvj@eecs.uottawa.ca)
 *
 */

public class LinearRegression {


	/** 
     * Number of samples (usually "m" in litterature) 
     */
	private int nbreOfSamples;


	/** 
     * the sample vector
     */
	private double[] samples;

	/** 
     * the samples target values
     */
	private double[] samplesValues;

	/** 
     * the current hypthesis function: theta0 + theta1 x
     */
	private double theta0, theta1;


	/** 
     * used to ensure that the object is ready
     */
	private int currentNbreOfSamples;



	/** 
     * counts how many iterations have been performed
     */
	private int iteration;


	/** 
     * Object's contructor. The constructor initializes the instance
     * variables. The starting hypthesis is y = 0;
     * 
     * 
     * @param m the number of samples that we will have
	 *
     */
 	public LinearRegression(int m){

 		this.nbreOfSamples = m;
		this.theta0 = 0;
		this.theta1 = 0;
		this.samples = new double[m];
		this.samplesValues = new double[m];
		this.currentNbreOfSamples = 0;

	}

	/** 
     * Adds a new sample to sample and to samplesValues. This
     * method must be iteratively called with all the samples
     * before the gradient descent can be started
     * 
     * @param x the new sample
     * @param y the corresponding expected value
     *
	 */
	public void addSample(double x, double y){
		this.samples[this.currentNbreOfSamples] = x;
		this.samplesValues[this.currentNbreOfSamples] = y;
		this.currentNbreOfSamples++;
	}

	/** 
     * Returns the current hypothesis for the value of the input
     * @param x the input for which we want the current hypothesis
     * 
	 * @return theta0 + theta1 x
	 */
	private double hypothesis(double x){
		return (this.theta0 + (this.theta1 * x));
	}

	/** 
     * Returns a string representation of hypthesis function
     * 
	 * @return the string "theta0 + theta1 x"
	 */
	public String currentHypothesis(){
		return (theta0+" + "+theta1+" x");
	}

	/** 
     * Returns the current cost
     * 
	 * @return the current value of the cost function
	 */
	public double currentCost(){
		double answer = 0;
		for (int i =0; i < this.nbreOfSamples; i++){
			double temp = (hypothesis(this.samples[i])-this.samplesValues[i]);
			answer = answer + (temp * temp);
		}
		answer = answer/this.nbreOfSamples;
		return answer;	
	}

	/** 
     * runs several iterations of the gradient descent algorithm
     * 
     * @param alpha the learning rate
     *
     * @param numberOfSteps how many iteration of the algorithm to run
     */
	public void gradientDescent(double alpha, int numberOfSteps) {
		
		for(int k = 0; k<numberOfSteps; k++){
			double temp0 = 0;
			double temp1 = 0;
			for (int i =0; i < this.nbreOfSamples; i++){
				temp0 = temp0 + ((this.theta0 + (this.theta1 * this.samples[i]))-this.samplesValues[i]);	
				temp1 = temp1 + this.samples[i] * ((this.theta0 + (this.theta1 * this.samples[i]))-this.samplesValues[i]);			
			}
			this.iteration++;
			this.theta0 = this.theta0 - (alpha * (temp0 * 2)/this.nbreOfSamples);
			this.theta1 = this.theta1 - (alpha * (temp1 * 2)/this.nbreOfSamples);
		}
		
	}



	/** 
     * Getter for theta0
     *
	 * @return theta0
	 */

	public double getTheta0(){
		return this.theta0;
	}

	/** 
     * Getter for theta1
     *
	 * @return theta1
	 */

	public double getTheta1(){
		return this.theta1;
	}

	/** 
     * Getter for samples
     *
	 * @return samples
	 */

	public double[] getSamples(){
		return this.samples;
	}

	/** 
     * Getter for getSamplesValues
     *
	 * @return getSamplesValues
	 */

	public double[] getSamplesValues(){
		return this.samplesValues;
	}

	/** 
     * Getter for iteration
     *
	 * @return iteration
	 */

	public int getIteration(){
		return this.iteration;
	}
}