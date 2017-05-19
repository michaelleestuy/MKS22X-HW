public class MazeSolver{
    private Maze board;
    private boolean ani;
    private Frontier front;
    
    public MazeSolver(String filename){
	this(filename, false);
    }

    public MazeSolver(String filename, boolean animate){
	ani = animate;
	board = new Maze(filename);
    }
    //0-depth first
    //1-breadth first
    //2-bestfirst
    //3-a*

    public void solve(){
	solve(1);
    }

    public void solve(int style){
	if(style == 0){
	    front = new FrontierStack();
	    solve(false);
	}
	if(style == 1){
	    front = new FrontierQueue();
	    solve(false);
	}
	if(style == 2){
	    front = new FrontierPriorityQueue();
	    solve(false);
	}
	else{
	    front = new FrontierPriorityQueue();
	    solve(true);
	}
    }

    public void solve(boolean b){

    }


}
