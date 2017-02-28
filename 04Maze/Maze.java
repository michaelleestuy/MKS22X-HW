import java.io.*;
import java.util.*;

public class Maze{
    
    private char[][]maze;
    private boolean animate;
    private int sr, sc, er, ec;

    public Maze(String file) throws FileNotFoundException{	
	File infile = new File(file);
	Scanner inf = new Scanner(infile);
	String text = "";
	int lines = 0;
	while(inf.hasNextLine()){
	    text += inf.nextLine();
	    text += "\n";
	    lines += 1;
	}
	if(text.indexOf("S") != text.lastIndexOf("S") || 
	   text.indexOf("S") == -1 ||
	   text.indexOf("E") != text.lastIndexOf("E") ||
	   text.indexOf("E") == -1){
	    throw new FileNotFoundException("No S or E found in file");
	}
	int width = text.substring(0, text.indexOf("\n")).length();
	char[][] m = new char[lines][width];
	for(int i = 0; i < lines; i++){
	    for(int k = 0; k < width; k++){
		m[i][k] = text.charAt(i * (width + 1) + k);
		if(text.charAt(i * (width + 1) + k) == 'S'){
		    sr = i; sc = k;
		}
		if(text.charAt(i * (width + 1) + k) == 'E'){
		    er = i; ec = k;
		}
	    }
	}
	maze = m;
    }

    private char whatIs(int r, int c, int dir){
	if(dir == 0)
	    return maze[r - 1][c];
	if(dir == 1)
	    return maze[r][c + 1];
	if(dir == 2)
	    return maze[r + 1][c];
	if(dir == 3)
	    return maze[r][c - 1];
	else
	    return '?';
    }

    private void solveH(int r, int c){
	ArrayList<Integer> vs = new ArrayList<Integer>();
	for(int i = 0; i < 4; i++){
	    if (whatIs(r, c, i) == ' ')
		vs.add(i);
	}

	if(vs.size() == 0){
	    revert(r, c);
	    return; 
	}
    }

    public void display(){
	System.out.println("\033[2J\033[1;1H");
	for(int i = 0; i < maze.length; i++){
	    for(int k = 0; k < maze[i].length; k++){
		System.out.print(maze[i][k] + " ");
	    }
	    System.out.println();
	}
    }

    public static void main(String[]args) throws FileNotFoundException{
	Maze f = new Maze("data1.dat");
	f.display();
    }
}
