import java.util.Random;

/**
 * The class <b>GameModel</b> holds the model, the state of the systems. 
 * It stores the following information:
 * - the state of all the ``dots'' on the board (mined or not, clicked
 * or not, number of neighbooring mines...)
 * - the size of the board
 * - the number of steps since the last reset
 *
 * The model provides all of this informations to the other classes trough 
 *  appropriate Getters. 
 * The controller can also update the model through Setters.
 * Finally, the model is also in charge of initializing the game
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */
public class GameModel {


     private int heightOfGame, numberOfMines, numberOfSteps, numberUncovered, widthOfGame;
	 private DotInfo[][] model;

    /**
     * Constructor to initialize the model to a given size of board.
     * 
     * @param width
     *            the width of the board
     * 
     * @param heigth
     *            the heigth of the board
     * 
     * @param numberOfMines
     *            the number of mines to hide in the board
     */
    public GameModel(int width, int heigth, int numberOfMines) {
		heightOfGame = heigth;
		widthOfGame = width;
		this.numberOfMines  = 0;
		numberUncovered = 0;
		model = new DotInfo[width][heigth];
		for(int i = 0; i < heightOfGame; i++){
			for(int j = 0; j < widthOfGame; j++){
				this.model[j][i] = new DotInfo(j,i);
			}
		}		
		while(this.numberOfMines < numberOfMines){
			int a = (int)(Math.floor(Math.random() * (widthOfGame)));
			int b = (int)(Math.floor(Math.random() * (heightOfGame)));
			if(model[a][b].isMined() == false){
				model[a][b].setMined();
				this.numberOfMines++;
				for(int i = -1; i < 2; i++){
					for(int j = -1; j < 2; j++){
						if(i != 0 || j != 0){
							try{
								model[a+j][b+i].setNeighbooringMines(model[a+j][b+i].getNeighbooringMines()+1);
							}catch(ArrayIndexOutOfBoundsException exception){
							}
						}
					}
				}
			}
		}
	}


 
    /**
     * Resets the model to (re)start a game. The previous game (if there is one)
     * is cleared up . 
     */
    public void reset(){
		int numberOfMines  = 0;
		numberUncovered = 0;
		numberOfSteps = 0;
		model = new DotInfo[widthOfGame][heightOfGame];
		for(int i = 0; i < heightOfGame; i++){
			for(int j = 0; j < widthOfGame; j++){
				model[j][i] = new DotInfo(j,i);
			}
		}		
		while(numberOfMines < this.numberOfMines){
			int a = (int)(Math.floor(Math.random() * (widthOfGame)));
			int b = (int)(Math.floor(Math.random() * (heightOfGame)));
			if(model[a][b].isMined() == false){
				model[a][b].setMined();
				numberOfMines++;
				for(int i = -1; i < 2; i++){
					for(int j = -1; j < 2; j++){
						if(i != 0 || j != 0){
							try{
								model[a+j][b+i].setNeighbooringMines(model[a+j][b+i].getNeighbooringMines()+1);
							}catch(ArrayIndexOutOfBoundsException exception){
							}
						}
					}
				}
			}
		}
    }


    /**
     * Getter method for the heigth of the game
     * 
     * @return the value of the attribute heigthOfGame
     */   
    public int getHeigth(){
		return heightOfGame;

    }

    /**
     * Getter method for the width of the game
     * 
     * @return the value of the attribute widthOfGame
     */   
    public int getWidth(){
		return widthOfGame;

    }



    /**
     * returns true if the dot at location (i,j) is mined, false otherwise
    * 
     * @param i
     *            the x coordinate of the dot
     * @param j
     *            the y coordinate of the dot
     * @return the status of the dot at location (i,j)
     */   
    public boolean isMined(int i, int j){
        
		return model[i][j].isMined();

    }

    /**
     * returns true if the dot  at location (i,j) has 
     * been clicked, false otherwise
     * 
     * @param i
     *            the x coordinate of the dot
     * @param j
     *            the y coordinate of the dot
     * @return the status of the dot at location (i,j)
     */   
    public boolean hasBeenClicked(int i, int j){
        
		return model[i][j].hasBeenClicked();

    }

  /**
     * returns true if the dot  at location (i,j) has zero mined 
     * neighboor, false otherwise
     * 
     * @param i
     *            the x coordinate of the dot
     * @param j
     *            the y coordinate of the dot
     * @return the status of the dot at location (i,j)
     */   
    public boolean isBlank(int i, int j){
        
		return (model[i][j].getNeighbooringMines() == 0);

    }
    /**
     * returns true if the dot is covered, false otherwise
    * 
     * @param i
     *            the x coordinate of the dot
     * @param j
     *            the y coordinate of the dot
     * @return the status of the dot at location (i,j)
     */   
    public boolean isCovered(int i, int j){
        
		return model[i][j].isCovered();

    }

    /**
     * returns the number of neighbooring mines os the dot  
     * at location (i,j)
     *
     * @param i
     *            the x coordinate of the dot
     * @param j
     *            the y coordinate of the dot
     * @return the number of neighbooring mines at location (i,j)
     */   
    public int getNeighbooringMines(int i, int j){ 
		return model[i][j].getNeighbooringMines();
    }


    /**
     * Sets the status of the dot at location (i,j) to uncovered
     * 
     * @param i
     *            the x coordinate of the dot
     * @param j
     *            the y coordinate of the dot
     */   
    public void uncover(int i, int j){        
		model[i][j].uncover();
		numberUncovered++;
    }

    /**
     * Sets the status of the dot at location (i,j) to clicked
     * 
     * @param i
     *            the x coordinate of the dot
     * @param j
     *            the y coordinate of the dot
     */   
    public void click(int i, int j){
        
		model[i][j].click();

    }
     /**
     * Uncover all remaining covered dot
     */   
    public void uncoverAll(){
        
		for(int i = 0; i < heightOfGame; i++){
			for(int j = 0; j < widthOfGame; j++){
				if(model[j][i].isCovered() == true){
					model[j][i].uncover();
				}
			}
		}

    }

 

    /**
     * Getter method for the current number of steps
     * 
     * @return the current number of steps
     */   
    public int getNumberOfSteps(){
        
		return numberOfSteps;

    }

  

    /**
     * Getter method for the model's dotInfo reference
     * at location (i,j)
     *
      * @param i
     *            the x coordinate of the dot
     * @param j
     *            the y coordinate of the dot
     *
     * @return model[i][j]
     */   
    public DotInfo get(int i, int j) {
        
    return model[i][j];

    }


   /**
     * The metod <b>step</b> updates the number of steps. It must be called 
     * once the model has been updated after the payer selected a new square.
     */
     public void step(){
        
		numberOfSteps++;

    }
 
   /**
     * The metod <b>isFinished</b> returns true iff the game is finished, that
     * is, all the nonmined dots are uncovered.
     *
     * @return true if the game is finished, false otherwise
     */
    public boolean isFinished(){
		return (numberUncovered + numberOfMines == (heightOfGame * widthOfGame));
    }


   /**
     * Builds a String representation of the model
     *
     * @return String representation of the model
     */
    public String toString(){
        String out = "";
		for(int i = 0; i < heightOfGame; i++){
			for(int j = 0; j < heightOfGame; j++){
				if(model[j][i].isCovered() == true){
					out = out + ("[ ]");
				}else{
					if(model[j][i].isMined() == true){
						out = out + ("[*]");
					}else{
						if(model[j][i].getNeighbooringMines() == 0){
							out = out + ("[ ]");
						}else{
							out = out + ("["+model[j][i].getNeighbooringMines()+"]");
						}
					}
				}
			}
			out = out + ("\n");
		}
		return out;
    }
}
