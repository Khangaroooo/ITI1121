import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * The class <b>GameView</b> provides the current view of the entire Game. It extends
 * <b>JFrame</b> and lays out a matrix of <b>DotButton</b> (the actual game) and 
 * two instances of JButton. The action listener for the buttons is the controller.
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */

public class GameView extends JFrame {

     private DotButton[][] board;
	 private GameModel gameModel;
	 private JLabel nbreOfStepsLabel;

    /**
     * Constructor used for initializing the Frame
     * 
     * @param gameModel
     *            the model of the game (already initialized)
     * @param gameController
     *            the controller
     */

    public GameView(GameModel gameModel, GameController gameController) {
		super("Minesweeper");
		this.gameModel = gameModel;
		JPanel p = new JPanel(new GridLayout(this.gameModel.getHeigth(), this.gameModel.getWidth()));
		JPanel p2 = new JPanel(new FlowLayout());
		JPanel pt = new JPanel(new BorderLayout());
		board = new DotButton[gameModel.getWidth()][gameModel.getHeigth()];
		setSize((gameModel.getWidth()*28),(gameModel.getHeigth()*28+75));
		JButton reset = new JButton("reset");
		JButton quit = new JButton("quit");
		nbreOfStepsLabel = new JLabel("Number of steps: 0");
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setLayout(new BorderLayout());
		for(int i = 0; i < gameModel.getHeigth(); i++){
			for(int j = 0; j < gameModel.getWidth(); j++){
				board[j][i] = new DotButton(j,i, 11);
				board[j][i].setActionCommand("C");
				board[j][i].addActionListener(gameController);
				p.add(board[j][i]);
			}
		}
		p2.add(nbreOfStepsLabel);
		p2.add(reset);
		reset.addActionListener(gameController);
		p2.add(quit);
		quit.addActionListener(gameController);
		add(pt);
		pt.add(p, BorderLayout.CENTER);
		pt.add(p2, BorderLayout.SOUTH);
		setVisible(true);
    }

    /**
     * update the status of the board's DotButton instances based 
     * on the current game model, then redraws the view
     */

    public void update(){
		for(int i = 0; i < gameModel.getHeigth(); i++){
			for(int j = 0; j < gameModel.getWidth(); j++){
				this.board[j][i].setIconNumber(getIcon(j,i));
			}
		}
		nbreOfStepsLabel.setText("Number of steps: "+gameModel.getNumberOfSteps());
    }

    /**
     * returns the icon value that must be used for a given dot 
     * in the game
     * 
     * @param i
     *            the x coordinate of the dot
     * @param j
     *            the y coordinate of the dot
     * @return the icon to use for the dot at location (i,j)
     */   
    private int getIcon(int i, int j){
		int x = 11;
		if(gameModel.isCovered(i,j) != true){
			if(gameModel.isMined(i,j) == true){
				if(gameModel.hasBeenClicked(i,j) == true){
					x =(10);
				}else{
					x = (9);
				}
			}else{
				if(gameModel.getNeighbooringMines(i,j) == 0){
				x = (0);
				}else{
					x = (gameModel.getNeighbooringMines(i,j));
				}
			}
		}
		return x;
	}
}
