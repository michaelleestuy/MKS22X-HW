public class MazeSolver{
    private Maze board;
    private boolean ani;
    
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
	
    }




}
