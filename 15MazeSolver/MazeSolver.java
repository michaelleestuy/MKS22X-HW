public class MazeSolver{
    private Maze board;
    private boolean ani;
    private Frontier front;
    private boolean solved;
    
    public MazeSolver(String filename){
	this(filename, false);
    }

    public String toString(){
	return board.toString();
    }

    public MazeSolver(String filename, boolean animate){
	ani = animate;
	board = new Maze(filename);
	solved = false;
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
	int rs = board.getStart().getR();
	int cs = board.getStart().getC();
	int re = board.getEnd().getR();
	int ce = board.getEnd().getC();
	board.set(rs, cs, 'S');
	board.set(re, ce, 'E');
	solve(board.getStart(), b);
    }

    public void solve(Location l, boolean b){
	int r = l.getR();
	int c = l.getC();
	if(solved){
	    return;
	}
	if(board.get(r, c) == 'E'){
	    solved = true;
	    sweep(l);
	    return;
	}
	else{
	    board.set(r, c, '.');
	    System.out.println(board);
	    try{Thread.sleep(15);}
	    catch(InterruptedException e){}
	    System.out.println("\033[2J");
	    getSurrounding(l, b);
	    solve(front.next(),  b);
	}
    }

    public void getSurrounding(Location l, boolean b){
	int r = l.getR();
	int c = l.getC();
	if(board.get(r + 1, c) == ' ' || board.get(r + 1, c) == 'E'){
	    front.add(board.getLocation(r + 1, c, b, l));
	}
	if(board.get(r - 1, c) == ' ' || board.get(r - 1, c) == 'E'){
	    front.add(board.getLocation(r - 1, c, b, l));
	}
	if(board.get(r, c + 1) == ' ' || board.get(r, c + 1) == 'E'){
	    front.add(board.getLocation(r, c + 1, b, l));
	}
	if(board.get(r, c - 1) == ' ' || board.get(r, c - 1) == 'E'){
	    front.add(board.getLocation(r, c - 1, b, l));
	}
    }


    
    public boolean isEnd(Location l){
	return l.getR() == board.getEnd().getR() && l.getC() == board.getEnd().getC();
    }

    public void sweep(Location l){
	int r = l.getR();
	int c = l.getC();
	board.set(r, c, '@');
	if(l.getPrev() != null){
	    sweep(l.getPrev());
	}
    }

    


    public static void main(String[]args){
	Maze m = new Maze("data3.dat");
	System.out.println(m);
	MazeSolver mm = new MazeSolver("data3.dat");
	mm.solve(4);
	System.out.println(mm);
    }
    
}    
