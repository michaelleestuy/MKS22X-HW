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

    private char whatIs(int r, int c, int dir){
	if(dir == 0)
	    return board.get(r - 1, c);
	if(dir == 1)
	    return board.get(r, c + 1);
	if(dir == 2)
	    return board.get(r + 1, c);
	if(dir == 3)
	    return board.get(r, c - 1);
	else
	    return '?';
    }
    
    public void solveTop(){
	Location l = front.next();
	if(isEnd(l)){
	    return;
	}
	r = l.getR();
	c = l.getC();
	board.set(r, c, '@')
    }
    
    public boolean isEnd(Location l){
	return l.getR() == board.getEnd().getR() && l.getC() == board.getEnd().getC();
    }

    
