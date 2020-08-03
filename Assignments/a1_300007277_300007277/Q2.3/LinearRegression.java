// Author: Khang Nguyen
// Student number: 300007277
// Course: ITI 1121-A
// Assignment: 1
// Question: 2.3
/**
 * The class  <b>LinearRegression</b> implements gradient
 * descent for multiple variables
 *
 * @author gvj (gvj@eecs.uottawa.ca)
 *
 */

public class LinearRegression{


	/** 
     * Number of features (usually "n" in litterature) 
     */
	private int nbreOfFeatures;

	/** 
     * Number of samples (usually "m" in litterature) 
     */
	private int nbreOfSamples;


	/** 
     * the nbreOfFeatures X nbreOfSamples Matrix of samples
     */
	private double[][] samplesMatrix;

	/** 
     * the nbreOfSamples Matrix of samples target values
     */
	private double[] samplesValues;

	/** 
     * the nbreOfFeatures Matrix theta of current hypthesis function
     */
	private double[] theta;


	/** 
     * number of samples received so far
     */
	private int currentNbreOfSamples;

	/** 
     * a place holder for theta during descent calculation
     */
	private double[] tempTheta;


	/** 
     * counts how many iterations have been performed
     */
	private int iteration;


	/** 
     * Object's contructor. The constructor initializes the instance
     * variables. The starting hypthesis is theta[i]=0.0 for all i
     * 
     * @param n the number of features that we will have
     * @param m the number of samples that we will have
	 *
     */
 	public LinearRegression(int n, int m){
		this.nbreOfFeatures = (n+1);
		this.nbreOfSamples = m;
		this.samplesMatrix = new double[this.nbreOfSamples][this.nbreOfFeatures];
		this.samplesValues = new double[this.nbreOfSamples];
		this.theta = new double[nbreOfFeatures];
		this.currentNbreOfSamples = 0;
		this.tempTheta = new double[this.nbreOfFeatures];
		this.iteration = 0;
		for(int i = 0; i < this.nbreOfFeatures; i++){
			this.theta[i] = 0;
		}

	}

	/** 
     * Add a new sample to samplesMatrix and samplesValues
     * 
     * @param x the vectors of samples
     * @param y the coresponding expected value
     *
	 */
	public void addSample(double[] x, double y){
		this.samplesMatrix[currentNbreOfSamples][0] = 1;
		for(int i = 1; i < this.nbreOfFeatures; i++){
			this.samplesMatrix[this.currentNbreOfSamples][i] = x[i-1];
		}
		this.samplesValues[this.currentNbreOfSamples] = y;
		this.currentNbreOfSamples++;
	}

	/** 
     * Returns the current hypothesis for the value of the input
     * @param x the input vector for which we want the current hypothesis
     * 
	 * @return h(x)
	 */

	private double hypothesis(double[] x){
		double a = 0;
		for(int i = 0; i < this.nbreOfFeatures; i++){
			a = a + (this.theta[i]*x[i]);
		}
		return a;
	}

	/** 
     * Returns a string representation of hypthesis function
     * 
	 * @return the string "theta0 x_0 + theta1 x_1 + .. thetan x_n"
	 */

	public String currentHypothesis(){
		String a = "";
		for(int i = 0; i < this.nbreOfFeatures; i++){
			a = a + (""+(this.theta[i]+"x_"+i+" "));
		}
		return a;
	}

	/** 
     * Returns the current cost
     * 
	 * @return the current value of the cost function
	 */

	public double currentCost(){
		double answer = 0;
		for (int i =0; i < this.nbreOfSamples; i++){
			double temp = (hypothesis(this.samplesMatrix[i]) - this.samplesValues[i]);
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
		for(int i = 0; i < numberOfSteps; i++){
			for(int jj = 0; jj < this.nbreOfFeatures; jj++){
				this.tempTheta[jj] = 0;
			}
			for(int j = 0; j < this.nbreOfFeatures; j++){
				for(int k = 0; k < this.nbreOfSamples; k++){
					this.tempTheta[j] = this.tempTheta[j] + (this.samplesMatrix[k][j] * (hypothesis(this.samplesMatrix[k]) - this.samplesValues[k]));					
				}
			}
			this.iteration++;
			for(int j = 0; j < this.nbreOfFeatures; j++){
				this.theta[j] = this.theta[j] - ((alpha * 2 * this.tempTheta[j])/this.nbreOfSamples);
			}
		}

	}


	/** 
     * Getter for theta
     *
	 * @return theta
	 */

	public double[] getTheta(){

		return this.theta;

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