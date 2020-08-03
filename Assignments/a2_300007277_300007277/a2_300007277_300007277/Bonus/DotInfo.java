
/**
 * The class <b>DotInfo</b> is a simple helper class to store 
 * the state (e.g. clicked, mined, number of neighbooring mines...) 
 * at the dot position (x,y)
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */

public class DotInfo {

		private boolean covered = true;
		private boolean mined = false; 
		private boolean wasClicked = false;
		private boolean flagged = false;
		private int x, y;
		private int neighbooringMines = 0;

    /**
     * Constructor, used to initialize the instance variables
     * 
     * @param x
     *            the x coordinate
     * @param y
     *            the y coordinate
     */
    public DotInfo(int x, int y){

		this.x = x;
		this.y = y;

    }

    /**
     * Getter method for the attribute x.
     * 
     * @return the value of the attribute x
     */
    public int getX(){

		return x;

    }
    
    /**
     * Getter method for the attribute y.
     * 
     * @return the value of the attribute y
     */
    public int getY(){

		return y;

    }
    
 
    /**
     * Setter for mined
     */
    public void setMined() {

		mined = true;

    }

    /**
     * Getter for mined
     *
     * @return mined
     */
    public boolean isMined() {

		return mined;

    }


    /**
     * Setter for covered
     */
    public void uncover() {

		covered = false;

    }

    /**
     * Getter for covered
     *
     * @return covered
     */
    public boolean isCovered(){

		return covered;

    }



    /**
     * Setter for wasClicked
     */
    public void click() {

    wasClicked = true;

    }

	public void flag() {

    flagged = !flagged;

    }
	
	public boolean isFlagged() {

    return flagged;

    }

    /**
     * Getter for wasClicked
     *
     * @return wasClicked
     */
    public boolean hasBeenClicked() {

		return wasClicked;

    }


    /**
     * Setter for neighbooringMines
     *
     * @param neighbooringMines
     *          number of neighbooring mines
     */
    public void setNeighbooringMines(int neighbooringMines) {

		this.neighbooringMines = neighbooringMines;

    }

    /**
     * Get for neighbooringMines
     *
     * @return neighbooringMines
     */
    public int getNeighbooringMines() {

		return neighbooringMines;

    }

 }
