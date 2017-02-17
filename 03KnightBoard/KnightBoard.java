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






    public void solve(){
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

    public void solveH(int row, int col, int level){
	
	if(solved){
	    return;
	}


	if(level > board.length * board[row].length){
	    solved = true;
	    return;
	}
	

	
	for(int i = 0; i < 8 && !solved; i++){
	    if(row + r[i] >= 0 && row + r[i] < board.length &&
	       col + c[i] >= 0 && col + c[i] < board[row].length){
		if(board[row + r[i]][col + c[i]] == 0){
		    board[row + r[i]][col + c[i]] = level;
		    //	    attempt = true;
		    solveH(row + r[i], col + c[i], level + 1);
		    
		    if(!solved){
			board[row + r[i]][col + c[i]] = 0;
		    }
		}
	    }
	}

    }


    public static void main(String[]args){
	KnightBoard a = new KnightBoard(5, 6);
	a.solve();
	System.out.println(a);

    }



}
