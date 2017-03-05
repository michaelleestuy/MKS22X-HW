import java.io.*;
import java.util.*;

public class Maze{
    
    private char[][]maze;
    private boolean animate;
    private int sr, sc, er, ec;
    private boolean solved;

    public Maze(String file) throws FileNotFoundException{
	try{
	    solved = false;
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
	catch(FileNotFoundException e){
	    System.out.println("Error: File not found. Please enter a valid path.");
	    System.exit(0);
	}
    }

    private void wait(int millis){
	try{
	    Thread.sleep(millis);
	}
	catch(InterruptedException e){
	    
	}
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

	if(animate){
	     System.out.println("\033[2J\033[1;1H" + this);
	     wait(20);
	}
	
	if(r == er && c == ec){
	    solved = true;
	    return;
	}

	if(solved)
	    return;

	if (maze[r][c] == '#')
	    return;
	if(!(r == sr && c == sc))
	    maze[r][c] = '@';
	
	
	ArrayList<Integer> vs = new ArrayList<Integer>();
	for(int i = 0; i < 4; i++){
	    if (whatIs(r, c, i) == ' ' || whatIs(r, c, i) == 'E')
		vs.add(i);
	}

	if(vs.size() == 0){
	    maze[r][c] = '.';
	    return; 
	}

	for(int i : vs){
	    if(!solved){
		if(i == 0)
		    solveH(r - 1, c);
		if(i == 1)
		    solveH(r, c + 1);
		if(i == 2)
		    solveH(r + 1, c);
		if(i == 3)
		    solveH(r, c - 1);
	    }
	}

	if(!solved)
	    maze[r][c] = '.';
	
    }

    public boolean solve(){
	solveH(sr, sc);
	return true;
    }

    public void setAnimate(boolean b){
	animate = b;
    }

    public void clearTerminal(){
	System.out.println("\033[2J\033[1;1H");
    }

    private boolean isAlone(int r, int c){
	int dir = -1;
	for(int i = 0; i < 4; i++){
	    if(whatIs(r, c, i) == ' ')
		dir = i;
	}
	return dir == -1;
    }

    public String toString(){
	String m = "";
	for(int i = 0; i < maze.length; i++){
	    for(int k = 0; k < maze[i].length; k++){
		m += maze[i][k] + "";
	    }
	    m += "\n";
	}
	return m;
    }

    /*
    public void display(){
	System.out.println("\033[2J\033[1;1H");
	for(int i = 0; i < maze.length; i++){
	    for(int k = 0; k < maze[i].length; k++){
		System.out.print(maze[i][k] + "");
	    }
	    System.out.println();
	}
    }
    */
    
    public static void main(String[]args) throws FileNotFoundException{
	Maze f = new Maze("data3.dat");
	
	f.setAnimate(true);
	f.solve();
	System.out.println(f);
      
    }
}
