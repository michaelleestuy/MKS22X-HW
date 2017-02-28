import java.util.*;

public class KnightBoard{
    private int[][] board;
    private boolean solved;

    private int[] r = {1, 1, -1, -1, 2, 2, -2, -2};
    private int[] c = {2, -2, 2, -2, 1, -1, 1, -1};

    private int[][] moves;

    public KnightBoard(int startingRows, int startingCols){
	board = new int[startingRows][startingCols];
	solved = false;
	moves = new int[startingRows][startingCols];
	for(int i = 0; i < startingRows; i++){
	    for(int k = 0; k < startingCols; k++){
		setup(i, k);
	    }
	}
    }

    private void setup(int row, int col){
	int asdf = 0;
	for(int i = 0; i < 8; i++){
	    if(row + r[i] >= 0 && row + r[i] < board.length &&
	       col + c[i] >= 0 && col + c[i] < board[row].length){
		asdf += 1;
	    }
	}
	moves[row][col] = asdf;
    }

    public String toString(){
	String a = "";

	for(int i = 0; i < board.length; i++){
	    for(int j = 0; j < board[0].length; j++){
		if(board[i][j] < 10){
		    a += "" + " " + board[i][j] + " ";
		}
		else{
		    a += "" + board[i][j] + " ";
		}
	    }
	    a += "\n";
	}

	return a;
    }
    
    public void solveFast(){
	for(int i = 0; i < board.length; i++){
	    for(int k = 0; k < board.length; k++){
		board[i][k] = 1;
		solveH(i, k, 2);
		if(!solved){
		    board[i][k] = 0;
		}
		if(solved){
		    return;
		}
	    }
	}
    }

    private void solveH(int row, int col, int level){
	if(solved){
	    return;
	}

	if(level > board.length * board[row].length){
	    solved = true;
	    return;
	}

        for(int i = 0; i < 8 && !solved; i++){
	    int m = findPath(row, col, i);
	    if(m == -1){
		return;
	    }
	    else{
		board[row + r[m]][col + c[m]] = level;
		updateMoves(row + r[m], col + c[m]);
		solveH(row + r[m], col + c[m], level + 1);
		if(!solved){
		    board[row + r[m]][col + c[m]] = 0;
		    revertMoves(row + r[m], col + c[m]);
		}
	    }
	}
	
    }

    private void updateMoves(int row, int col){
	for(int i = 0; i < 8; i++){
	    if(row + r[i] >= 0 && row + r[i] < board.length &&
	       col + c[i] >= 0 && col + c[i] < board[row].length){
		moves[row + r[i]][col + c[i]] = moves[row + r[i]][col + c[i]] - 1;
	    }
	}
    }

    private void revertMoves(int row, int col){
	for(int i = 0; i < 8; i++){
	    if(row + r[i] >= 0 && row + r[i] < board.length &&
	       col + c[i] >= 0 && col + c[i] < board[row].length){
		moves[row + r[i]][col + c[i]] = moves[row + r[i]][col + c[i]] + 1;
	    }
	}
    }

    private int findPath(int row, int col, int s){
        ArrayList<Integer> a1 = new ArrayList<Integer>();

	boolean valid = false;
	for(int i = 0; i < 8; i++){
	    if(row + r[i] >= 0 && row + r[i] < board.length &&
	       col + c[i] >= 0 && col + c[i] < board[row].length){
		if(board[row + r[i]][col + c[i]] == 0){
		    a1.add(moves[row + r[i]][col + c[i]]);
		    valid = true;
		}
		else{
		    a1.add(-1);
		}
	    }
	    else{
		a1.add(-1);
	    }
	}
	if(!valid){
	    return -1;
	}

	ArrayList<Integer> morder = new ArrayList<Integer>();

	for(int i = 0; i < 8; i++){
	    int lowest = 9;
	    for(int k : a1){
		if(k < lowest && k != -1){
		    lowest = k;
		}
	    }
	    if(lowest != 9){
		morder.add(a1.indexOf(lowest));
		a1.set(a1.indexOf(lowest), 9);
	    }
	}

	if(s >= morder.size()){
	    return -1;
	}

	if(morder.size() == 0){
	    return -1;
	}
	else{
	    return morder.get(s);
	}
    }

    public static void main(String[]args){
	KnightBoard a = new KnightBoard(20, 20);
	a.solveFast();
	System.out.println(a);
	
    }
    
}
