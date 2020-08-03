/**
*Solve class is in charge of the algorithm and brute force method for solving the game, it uses
*Queues to complete these tasks.
*
*@author Khang Nguyen
*/
public class Solve{
	
	private static Cube[] c = new Cube[]{new Cube(new Color[]{Color.BLUE, Color.GREEN, Color.WHITE, Color.GREEN, Color.BLUE, Color.RED}),new Cube(new Color[]{Color.WHITE, Color.GREEN, Color.BLUE, Color.WHITE, Color.RED, Color.RED}), new Cube(new Color[]{Color.GREEN, Color.WHITE, Color.RED, Color.BLUE, Color.RED, Color.RED}), new Cube(new Color[]{Color.BLUE, Color.RED, Color.GREEN, Color.GREEN, Color.WHITE, Color.WHITE})};
	
	public static Queue<Solution> generateAndTest(){
		Queue<Solution> q = new LinkedQueue<Solution>();
		Solution sol = new Solution(c);
		
	/**
	*Uses the every single combination possible to complete the instant insanity game 
	*
	*
	*
	*
	*@return a Queue containing all solutions to the problem
	*
	*/
		while(c[0].hasNext() == true){
			c[0].next();
			while(c[1].hasNext() == true){
				c[1].next();
				while(c[2].hasNext() == true){
					c[2].next();
					while(c[3].hasNext() == true){
						c[3].next();
						Solution s = new Solution(c);
						if(s.isValid() == true){
							q.enqueue(s);
						}	
					}
					c[3].reset();
				}
				c[2].reset();
			}
			c[1].reset();
		}
		c[0].reset();
		System.out.println(sol.getNumberOfCalls());

		return q;
	}
	
	/**
	*Uses the breadth first search algorithm to complete the instant insanity game 
	*
	*
	*
	*
	*@return a Queue containing all solutions to the problem
	*
	*/
	public static Queue<Solution> BreadthFirstSearch(){
		Queue<Solution> solution = new LinkedQueue<Solution>();
		Solution sol = new Solution(new Cube[]{c[0]});
		sol.resetNumberOfCalls();
		Queue<Solution> open = new LinkedQueue<Solution>();
		while(c[0].hasNext() == true){
			c[0].next();
			Solution tmp = new Solution(new Cube[]{c[0]});
			open.enqueue(tmp);
		}
		while(!open.isEmpty()){
			Solution s = open.dequeue();
			while(c[s.size()].hasNext()){
				c[s.size()].next();
				if(s.isValid(c[s.size()])){
					Solution tmp = new Solution(s, c[s.size()]);
					if(tmp.size() == 4){
						solution.enqueue(tmp);
					}else{
						open.enqueue(tmp);
					}
				}
			}
			c[s.size()].reset();
		}
		System.out.println(sol.getNumberOfCalls());
		return solution;
	}
	/**
	*this is the class main and it is used to run both solutions to the instant insanity and print out the time it takes to run
	*
	*
	*@param String[] args which should be empty since it is not being used
	*
	*
	*/
	public static void main(String[] args){
		long start, stop;
		StudentInfo.display();
		
		System.out.println("generateAndTest:");
		start = System.currentTimeMillis();
		
		generateAndTest();
		
		stop = System.currentTimeMillis();
		System.out.println("Elapsed Time: "+(stop-start)+" milliseconds ");
		
		System.out.println("BreadthFirstSearch:");
		start = System.currentTimeMillis();
		
		BreadthFirstSearch();
		
		stop = System.currentTimeMillis();
		System.out.println("Elapsed Time: "+(stop-start)+" milliseconds ");
		
		
	}
	
}