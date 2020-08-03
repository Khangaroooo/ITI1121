import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.*;


/**
 * The class <b>GameController</b> is the controller of the game. It is a listener
 * of the view, and has a method <b>play</b> which computes the next
 * step of the game, and  updates model and view.
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */


public class GameController implements ActionListener {

    private GameModel gameModel;
	private GameView gameView;

    /**
     * Constructor used for initializing the controller. It creates the game's view 
     * and the game's model instances
     * 
     * @param width
     *            the width of the board on which the game will be played
     * @param height
     *            the height of the board on which the game will be played
     * @param numberOfMines
     *            the number of mines hidden in the board
     */
    public GameController(int width, int height, int numberOfMines) {
		gameModel = new GameModel(width, height, numberOfMines);
		gameView = new GameView(gameModel, this);

    }


    /**
     * Callback used when the user clicks a button (reset or quit)
     *
     * @param e
     *            the ActionEvent
     */

    public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().contains("C")){
			int x = ((DotButton)e.getSource()).getColumn();
			int y = ((DotButton)e.getSource()).getRow();
			play(x,y);
		}else{
			if( e.getActionCommand().equals("reset")) {
				reset();
			}else{
				if( e.getActionCommand().equals("quit")) {
					System.exit(0);
				}
			}
		}
    }

    /**
     * resets the game
     */
    private void reset(){
		gameModel.reset();
		gameView.dispose();
		gameView = new GameView(gameModel, this);
    }

    /**
     * <b>play</b> is the method called when the user clicks on a square.
     * If that square is not already clicked, then it applies the logic
     * of the game to uncover that square, and possibly end the game if
     * that square was mined, or possibly uncover some other squares. 
     * It then checks if the game
     * is finished, and if so, congratulates the player, showing the number of
     * moves, and gives to options: start a new game, or exit
     * @param width
     *            the selected column
     * @param heigth
     *            the selected line
     */
    private void play(int width, int heigth){
		Object[] options = {"Quit", "Play Again"};
		if(gameModel.isCovered(width,heigth) == true){
			gameModel.step();
			gameModel.click(width,heigth);
			if(gameModel.isMined(width, heigth) == false){
				if(gameModel.getNeighbooringMines(width,heigth) != 0){
					gameModel.uncover(width, heigth);
				}else{
					clearZone(gameModel.get(width, heigth));
				}
				gameView.update();
			}else{
				gameModel.uncoverAll();
				gameView.update();
				int a = JOptionPane.showOptionDialog(null, "Ouch! You lost in "+gameModel.getNumberOfSteps()+" steps! Would you like to play again?", "Boom!", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				if(a == 0){
					System.exit(0);
				}else{
					reset();
				}
			}
			if(gameModel.isFinished() == true){
				int a = JOptionPane.showOptionDialog(null, "Congratulations, you won in "+gameModel.getNumberOfSteps()+" steps! Would you like to play again?", "Boom!", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				if(a == 0){
					System.exit(0);
				}else{
					reset();
				}
			}
		}
    }

   /**
     * <b>clearZone</b> is the method that computes which new dots should be ``uncovered'' 
     * when a new square with no mine in its neighborood has been selected
     * @param initialDot
     *      the DotInfo object corresponding to the selected DotButton that
     * had zero neighbouring mines
     */
	 @SuppressWarnings( "unchecked" )
    private void clearZone(DotInfo initialDot) {
		Object[] options = {"Quit", "Play Again"};
		GenericArrayStack g = new GenericArrayStack(gameModel.getHeigth()*gameModel.getWidth());
		g.push(initialDot);
		while(g.isEmpty() != true){
			initialDot = (DotInfo)g.pop();
			for(int i = -1; i < 2; i++){
				for(int j = -1; j < 2; j++){
					if(i != 0 || j != 0){
						try{
							if(gameModel.isCovered(initialDot.getX()+j, initialDot.getY()+i) == true){
								gameModel.uncover(initialDot.getX()+j, initialDot.getY()+i);
								if(gameModel.isBlank(initialDot.getX()+j, initialDot.getY()+i) == true){
								g.push(gameModel.get(initialDot.getX()+j, initialDot.getY()+i));
							}
							}
						}catch(ArrayIndexOutOfBoundsException exception){
						}
					}
				}
			}
		}
    }
 


}
