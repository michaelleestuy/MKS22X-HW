public class QueenBoard{
    private int[][] board;
    private int solutionCount = -1;

    private boolean solved;

    public QueenBoard(int size){
	board = new int[size][size];
	solved = false;
    }

    public String toString(){
	String a = "";
	for(int i = 0; i < board.length; i++){
	    for(int j = 0; j < board.length; j++){
		String toadd = "_";
		if(board[i][j] == -1){
		    toadd = "Q";
		}
		a += "" + toadd + "  ";
	    }
	    a += "\n";
	}
	return a;
    }

    private void addQueen(int r, int c){
	board[r][c] = -1;
	for(int i = 0; i < board.length; i++){
	    if(i != r){
		board[i][c] = board[i][c] + 1;
	    }
	}
	
	for(int i = 0; i < board.length; i++){
	    if(i != c){
		board[r][i] = board[r][i] + 1;
	    }
	}

	for(int d = 1; r + d >= 0 && r + d < board.length && 
		c + d >= 0 && c + d < board.length; d++){
	    board[r + d][c + d] = board[r + d][c + d] + 1;
	}

	for(int d = 1; r - d >= 0 && r - d < board.length && 
		c + d >= 0 && c + d < board.length; d++){
	    board[r - d][c + d] = board[r - d][c + d] + 1;
	}

	for(int d = 1; r + d >= 0 && r + d < board.length && 
		c - d >= 0 && c - d < board.length; d++){
	    board[r + d][c - d] = board[r + d][c - d] + 1;
	}

	for(int d = 1; r - d >= 0 && r - d < board.length && 
		c - d >= 0 && c - d < board.length; d++){
	    board[r - d][c - d] = board[r - d][c - d] + 1;
	}

    }

    private void removeQueen(int r, int c){
	board[r][c] = 0;
	for(int i = 0; i < board.length; i++){
	    if(i != r){
		board[i][c] = board[i][c] - 1;
	    }
	}
	
	for(int i = 0; i < board.length; i++){
	    if(i != c){
		board[r][i] = board[r][i] - 1;
	    }
	}

	for(int d = 1; r + d >= 0 && r + d < board.length && 
		c + d >= 0 && c + d < board.length; d++){
	    board[r + d][c + d] = board[r + d][c + d] - 1;
	}

	for(int d = 1; r - d >= 0 && r - d < board.length && 
		c + d >= 0 && c + d < board.length; d++){
	    board[r - d][c + d] = board[r - d][c + d] - 1;
	}

	for(int d = 1; r + d >= 0 && r + d < board.length && 
		c - d >= 0 && c - d < board.length; d++){
	    board[r + d][c - d] = board[r + d][c - d] - 1;
	}

	for(int d = 1; r - d >= 0 && r - d < board.length && 
		c - d >= 0 && c - d < board.length; d++){
	    board[r - d][c - d] = board[r - d][c - d] - 1;
	}
    }

    public int getSolutionCount(){
	return solutionCount;
    }

    public void countSolutions(){
	board = new int[board.length][board.length];
	solutionCount = helper(0);
    }


    public void solve(){
        solveh(0);
    }

    private void solveh(int r){
	if(solved){
	    return;
	}
	if(r >= board.length){
	    solved = true;
	    return;
	}
	boolean empt = true;
	for(int i = 0; i < board.length; i++){
	    if(board[r][i] == 0){
		empt = false;
	    }
	}

	if(empt){
	    return;
	}

	for(int i = 0; i < board.length && !solved; i++){
	    if(board[r][i] == 0){
		addQueen(r, i);
		solveh(r + 1);
		if(!solved){
		    removeQueen(r, i);
		}
	    }
	}
	
    }


    private int helper(int r){
	if(r >= board.length){
	    return 1;
	}

	boolean empt = true;
	for(int i = 0; i < board.length; i++){
	    if(board[r][i] == 0){
		empt = false;
	    }
	}

	if(empt){
	    return 0;
	}

	int s = 0;

	for(int i = 0; i < board.length; i++){
	    if(board[r][i] == 0){
		addQueen(r, i);
		s += helper(r + 1);
		removeQueen(r, i);
	    }
	}

	return s;
	
    }


    public static void main(String[]args){


    }

}
